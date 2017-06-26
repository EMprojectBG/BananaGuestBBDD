package com.netmind.db;

public class DAOFactory {
	
	private static DAOFactory instance = null;
			
	public static DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
	}

	public Object getDAO(String daoType) {
		switch (daoType) {
		case "UsuarioB":
			return (Object) UsuarioDAOImpl.getInstance();
		case "ProyectoB":
			return (Object) ProyectoDAOImpl.getInstance();
		case "TareaB":
			return (Object) TareaDAOImpl.getInstance();
		default:
			return null;
		}
	}
}
