package com.caballero.ejemplo.persistencia;

import com.caballero.ejemplo.persistencia.interfaces.UsuarioOBD;
import com.caballero.ejemplo.persistencia.postgresql.UsuarioOBDPostgreSQL;

public class FabricaOBD {
	
	public static UsuarioOBD crearUsuarioOBD() {
		return new UsuarioOBDPostgreSQL();
	}

}