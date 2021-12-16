package com.caballero.infraestructura.persistencia;

import java.sql.Date;

public class DatoSQL {
	
	private String nombre;
	private TipoDato tipo;
	private Integer datoEntero;
	private String datoCadena;
	private Date datoFecha;
	private Boolean datoBooleano;
	
	public DatoSQL(String nombre, Integer datoEntero) {
		this.nombre = nombre;
		this.datoEntero = datoEntero;
		this.tipo = TipoDato.ENTERO;
	}

	public DatoSQL(String nombre, String datoCadena) {
		this.nombre = nombre;
		this.datoCadena = datoCadena;
		this.tipo = TipoDato.CADENA;
	}
	
	public DatoSQL(String nombre, Date datoFecha) {
		this.nombre = nombre;
		this.datoFecha = datoFecha;
		this.tipo = TipoDato.FECHA;
	}

	public DatoSQL(String nombre, Boolean datoBooleano) {
		this.nombre = nombre;
		this.datoBooleano = datoBooleano;
		this.tipo = TipoDato.BOOLEANO;
	}
	
	// Devuelve el dato como cadena para una consulta SQL
	// Para las cadenas se devuelve entre ' '
	public String getDato() {
		if (tipo == TipoDato.CADENA)
			return String.format("'%s'", datoCadena);
		if (tipo == TipoDato.FECHA)
			return String.format("'%s'", datoFecha.toString());
		if (tipo == TipoDato.ENTERO)
			return datoEntero.toString();
		if (tipo == TipoDato.BOOLEANO)
			return datoBooleano.toString();
		return "";	
	}

	public String getNombre() {
		return nombre;
	}
	
}