package com.netmind.db;

import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO2 {
	private static Logger logger = Logger.getLogger("DAO");

	public DataSource datasource;

	protected DAO2() {
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env"); 
			this.datasource = (DataSource)envContext.lookup("jdbc/bananadb");
		}catch (Exception e) {
			logger.info("Error al instanciar Datasource!!!!");
			e.printStackTrace();
		}

	}
}
