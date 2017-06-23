package com.netmind.db;

import java.util.List;

import com.netmind.models.ProyectoB;


public abstract class ProyectoDAO extends DAO {
	public abstract ProyectoB getProyecto(int idProyecto);
	public abstract List<ProyectoB> getUserProyecto(int uid);
	public abstract List<ProyectoB> getProyecto();
	//public abstract boolean insertProyecto(ProyetoB miProyecto);
	//public abstract boolean updateProyecto(ProyetoB miProyecto);
}
