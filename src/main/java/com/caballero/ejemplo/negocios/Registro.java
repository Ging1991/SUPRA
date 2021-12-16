package com.caballero.ejemplo.negocios;

import com.caballero.ejemplo.negocios.manager.UsuarioManager;
import com.caballero.ejemplo.persistencia.entidades.Usuario;

public class Registro {
	
	public static void registrar(String nombre, String clave) throws Exception {
		Usuario usuario = new Usuario(-1, nombre, clave);
		UsuarioManager.guardar(usuario);
	}

}