package com.caballero.ejemplo1.vista;

import java.util.List;

import com.caballero.ejemplo1.persistencia.entidades.Usuario;
import com.caballero.supra.vista.Tabla;

public class TablaUsuarios extends Tabla<Usuario>{

	private static final long serialVersionUID = 1L;
	
	private static String[] columnas = {"Nombre", "Clave"};

	public TablaUsuarios(List<Usuario> entidades) {
		super(entidades, columnas);
	}

	@Override
	public Object[] generarFila(Usuario e) {
		Object[] fila = {
				e.getNombre(),
				e.getClave()
		};
		return fila;
	}

}