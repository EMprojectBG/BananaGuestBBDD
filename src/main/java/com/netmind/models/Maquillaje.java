package com.netmind.models;

public class Maquillaje {
	
	private int mid;
	private String codigo;
	private String marca;
	private String tipo;
	private int precio;
	private int existencias;
	
	public Maquillaje(int mid, String codigo, String marca, String tipo, int precio, int existencias) {
		super();
		this.mid = mid;
		this.codigo = codigo;
		this.marca = marca;
		this.tipo = tipo;
		this.precio = precio;
		this.existencias = existencias;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	
	
}
