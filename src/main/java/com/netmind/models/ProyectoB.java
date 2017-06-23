package com.netmind.models;

import java.util.Date;

public class ProyectoB {

	private int idProyecto;
	private String nombreProyecto;
	private String descProyecto;
	private Date fechaFinProyecto;
	private boolean estado;
	
	//Constructor
	public ProyectoB(int idProyecto, String nombreProyecto, String descProyecto, Date fechaFinProyecto, boolean estado) {
		super();
		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
		this.descProyecto = descProyecto;
		this.fechaFinProyecto = fechaFinProyecto;
		this.estado = estado;
	}

	//getters and setters
	public int getIdProyecto() {
		return idProyecto;
	}


	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}


	public String getNombreProyecto() {
		return nombreProyecto;
	}


	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}


	public String getDescProyecto() {
		return descProyecto;
	}


	public void setDescProyecto(String descProyecto) {
		this.descProyecto = descProyecto;
	}


	public Date getFechaFinProyecto() {
		return fechaFinProyecto;
	}


	public void setFechaFinProyecto(Date fechaFinProyecto) {
		this.fechaFinProyecto = fechaFinProyecto;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}	
}
