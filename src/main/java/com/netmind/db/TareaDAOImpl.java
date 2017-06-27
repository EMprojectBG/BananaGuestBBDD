package com.netmind.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


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
	public List <TareaB> getTarea(int idProyecto) {
		List<TareaB> tareasADevolver = new ArrayList<TareaB>();

		try {
			Connection conn = this.datasource.getConnection();

			String sql = "SELECT t.* FROM tareab t WHERE t.idProyecto=? LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idProyecto);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				tareasADevolver.add (new TareaB(rs.getInt("idTarea"), 
						rs.getString("nombreTarea"), 
						rs.getString("nombreTarea"), 
						rs.getString("responsable"),
						rs.getInt("usuariosImp")));
			}

			pstm.close();
			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			tareasADevolver = null;
		}

		return tareasADevolver;
	}

}
