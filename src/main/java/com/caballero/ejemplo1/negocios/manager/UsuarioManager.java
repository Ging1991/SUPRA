package com.caballero.ejemplo1.negocios.manager;

import com.caballero.ejemplo1.persistencia.FabricaOBD;
import com.caballero.ejemplo1.persistencia.entidades.Usuario;
import com.caballero.ejemplo1.persistencia.interfaces.UsuarioOBD;

public class UsuarioManager {
	
	public static void guardar(Usuario usuario) throws Exception {
		if (usuario.getNombre().equals(""))
			throw new Exception("El usuarios no puede tener nombre vacio");
		
		UsuarioOBD obd = FabricaOBD.crearUsuarioOBD();
		obd.insert(usuario);		
	}

	public static void actualizar(Usuario usuario) throws Exception {
		if (usuario.getNombre().equals(""))
			throw new Exception("El usuarios no puede tener nombre vacio");
		
		UsuarioOBD obd = FabricaOBD.crearUsuarioOBD();
		obd.update(usuario);	
	}

}