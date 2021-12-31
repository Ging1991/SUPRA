package com.caballero.ejemplo1.negocios;

import com.caballero.ejemplo1.negocios.manager.UsuarioManager;
import com.caballero.ejemplo1.persistencia.entidades.Usuario;

public class Registro {
	
	public static void registrar(String nombre, String clave) throws Exception {
		Usuario usuario = new Usuario(-1, nombre, clave);
		UsuarioManager.guardar(usuario);
	}

}