package com.netmind.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import com.netmind.models.Compra;
import com.netmind.models.Maquillaje;
import com.netmind.models.TareaB;

public final class TareaDAOImpl extends TareaDAO {
	private static Logger logger = Logger.getLogger("CompraDAOImpl");

	private static TareaDAOImpl instance = null;

	public static TareaDAOImpl getInstance() {
		if (instance == null) {
			instance = new TareaDAOImpl();
		}
		return instance;
	}

	@Override
	public TareaB getTarea(int cid) {
		TareaB compraADevolver = null;

		try {
			Connection conn = this.datasource.getConnection();
			// ordenes sql
			String sql = "SELECT c.* FROM compra c WHERE c.cid=? LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cid);
			
			UsuarioDAO uDAO=(UsuarioDAO)UsuarioDAOImpl.getInstance();
			ProyectoDAO pDAO=(ProyectoDAO)ProyectoDAOImpl.getInstance();

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				compraADevolver = new TareaB(rs.getInt("idTarea"), 
						rs.getString("nombreTarea"), 
						rs.getString("nombreTarea"), 
						rs.getString("responsable"),
						rs.getInt("usuariosImp"));
			}

			pstm.close();
			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			compraADevolver = null;
		}

		return compraADevolver;
	}

	@Override
	public boolean insertTarea(TareaB nuevaTarea) {
		boolean exito = false;

		try {

			Connection conn = this.datasource.getConnection();

			try {
				conn.setAutoCommit(false);

				// INSERTAR EN COMPRA
				String sql = "INSERT INTO compra VALUES(NULL,?,?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, nuevaTarea.getUsuario().getUid());
				pstm.setInt(2, nuevaTarea.getCosmetico().getMid());
				pstm.setInt(3, nuevaTarea.getCantidad());

				SimpleDateFormat sdfr = new SimpleDateFormat("yyyyMMdd");
				pstm.setString(4, sdfr.format(nuevaTarea.getFecha()));

				int rows = pstm.executeUpdate();

				pstm.close();

				// ACTUALIZAR SALDO DE USUARIO
				sql = "UPDATE usuario u SET u.saldo=u.saldo-? WHERE u.uid=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, nuevaTarea.getCosmetico().getPrecio() * nuevaTarea.getCantidad());
				pstm.setInt(2, nuevaTarea.getUsuario().getUid());
				rows = pstm.executeUpdate();

				pstm.close();

				// ACTUALIZAR EXISTENCIAS DE MAQUILLAJE
				sql = "UPDATE maquillaje m SET m.existencias=m.existencias-? WHERE m.mid=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, nuevaTarea.getCantidad());
				pstm.setInt(2, nuevaTarea.getCosmetico().getMid());
				rows = pstm.executeUpdate();

				pstm.close();

				conn.commit();

				conn.close();

				logger.info("Inserción exitosa");
				exito = rows > 0 ? true : false;

			} catch (Exception e) {
				conn.rollback();
				logger.severe("Transacción fallida:" + e.getMessage());
				exito = false;
			}

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e.getMessage());
			exito = false;
		}

		return exito;
	}

}
