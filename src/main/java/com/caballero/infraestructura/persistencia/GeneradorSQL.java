package com.caballero.infraestructura.persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class GeneradorSQL {
	
	private List<DatoSQL> datos;
	private String tabla;
	
	public GeneradorSQL(String tabla) {
		this.tabla = tabla;
		datos = new ArrayList<DatoSQL>();
	}
	
	public void agregar(String nombre, Integer dato) {
		datos.add(new DatoSQL(nombre, dato));
	}

	public void agregar(String nombre, String dato) {
		datos.add(new DatoSQL(nombre, dato));
	}

	public void agregar(String nombre, Date dato) {
		datos.add(new DatoSQL(nombre, dato));
	}
	
	public void agregar(String nombre, Boolean dato) {
		datos.add(new DatoSQL(nombre, dato));
	}
	
	public String getID() {
		String ret = null;
		for (DatoSQL datoSQL : datos) {
			if (datoSQL.getNombre().equals("ID")) {
				ret = datoSQL.getDato();
				break;
			}
		}
		return ret;
	}
	
	public String generarInsert() {
		String campos = "";
		String valores = "";
		
		for (DatoSQL datoSQL : datos) {
			
			if (datoSQL.getNombre().equals("ID"))
				continue;
			
			if (!campos.equals(""))
				campos += ", ";
			campos += datoSQL.getNombre();
			
			if (!valores.equals(""))
				valores += ", ";
			valores += datoSQL.getDato();
		}
		return "INSERT INTO " + tabla + "(" + campos + ") VALUES (" + valores + ");";
	}

	public String generarUpdate() {
		String condicion = "ID = " + getID();
		String valores = "";
		
		for (DatoSQL datoSQL : datos) {
			
			if (datoSQL.getNombre().equals("ID"))
				continue;
			
			if (!valores.equals(""))
				valores += ", ";
			valores += datoSQL.getNombre() + " = " + datoSQL.getDato();
		}
		
		return "UPDATE " + tabla + " SET " + valores + "  WHERE (" + condicion + ");";
	}

	public String generarDelete() {
		String condicion = "ID = " + getID();
		return "DELETE FROM " + tabla + " WHERE (" + condicion + ");";
	}

}