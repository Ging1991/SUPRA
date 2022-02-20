package com.caballero.ejemplo1.negocios.validador;

import com.caballero.ejemplo1.persistencia.entidades.Usuario;
import com.caballero.supra.negocios.ValidadorEntidad;

public class ValidadorUsuario extends ValidadorEntidad {
	
	public static void validar(Usuario usuario) throws Exception {
		if (textoVacio(usuario.getNombre()))
			throw new Exception("El nombre de usuario no puede estar vacio.");
	}

}