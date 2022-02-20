package com.caballero.ejemplo1.negocios.manager;

import java.util.List;

import com.caballero.ejemplo1.negocios.validador.ValidadorUsuario;
import com.caballero.ejemplo1.persistencia.FabricaOBD;
import com.caballero.ejemplo1.persistencia.entidades.Usuario;
import com.caballero.ejemplo1.persistencia.interfaces.UsuarioOBD;

public class UsuarioManager {
	
	public static void guardar(Usuario usuario) throws Exception {
		ValidadorUsuario.validar(usuario);
		
		UsuarioOBD obd = FabricaOBD.crearUsuarioOBD();
		obd.insert(usuario);		
	}

	public static void actualizar(Usuario usuario) throws Exception {
		ValidadorUsuario.validar(usuario);
		
		UsuarioOBD obd = FabricaOBD.crearUsuarioOBD();
		obd.update(usuario);	
	}
	
	public static List<Usuario> traer() {
		UsuarioOBD obd = FabricaOBD.crearUsuarioOBD();
		return obd.select();
	}

}