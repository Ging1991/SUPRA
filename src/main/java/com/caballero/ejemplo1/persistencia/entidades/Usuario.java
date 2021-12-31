package com.caballero.ejemplo1.persistencia.entidades;

public class Usuario {
	
	private Integer ID;
	private String nombre, clave;
	
	public Usuario(Integer ID, String nombre, String clave) {
		this.ID = ID;
		this.nombre = nombre;
		this.clave = clave;
	}

	public Integer getID() {
		return ID;
	}

	public void setId(Integer ID) {
		this.ID = ID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}