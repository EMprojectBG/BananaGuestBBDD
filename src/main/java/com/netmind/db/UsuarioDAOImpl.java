package com.netmind.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import com.netmind.models.UsuarioB;

public final class UsuarioBBDAOImpl extends UsuarioBDAO {
	private static Logger logger = Logger.getLogger("UsuarioBBDAOImpl");
	
	private static UsuarioBBDAOImpl instance = null;

	public static UsuarioBBDAOImpl getInstance() {
		if (instance == null) {
			instance = new UsuarioBBDAOImpl();
		}
		return instance;
	}
	
	@Override
	public UsuarioB getUsuarioB(String email, String password) {
		UsuarioB UsuarioBADevolver = null;

		try {
			Connection conn = datasource.getConnection();
			// ordenes sql
			String sql = "SELECT u.* FROM UsuarioB u WHERE u.email=? AND password=? LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, pass);

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				UsuarioBADevolver = new UsuarioB(rs.getInt("uid"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("email"), rs.getString("coquetitud"), rs.getDouble("saldo"), "",
						rs.getDate("nacimiento"), rs.getInt("activo"));
			}

			pstm.close();
			conn.close();

			logger.info("Conexi�n exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexi�n de BBDD:" + e);
			UsuarioBADevolver = null;
		}

		return UsuarioBADevolver;
	}


	@Override
	public UsuarioB getUsuarioB(int uid) {
		UsuarioB UsuarioBADevolver = null;

		try {
			Connection conn = datasource.getConnection();
			// ordenes sql
			String sql = "SELECT u.* FROM UsuarioB u WHERE u.uid=?LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				UsuarioBADevolver = new UsuarioB(rs.getInt("uid"), 
						rs.getString("nombre"), 
						rs.getString("apellido"),
						rs.getString("email"), 
						rs.getString("password"),
						rs.getInt("activo"));
			}

			pstm.close();
			conn.close();

			logger.info("Conexi�n exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexi�n de BBDD:" + e);
			UsuarioBADevolver = null;
		}

		return UsuarioBADevolver;
	}

}
