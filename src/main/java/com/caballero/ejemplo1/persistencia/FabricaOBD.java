package com.caballero.ejemplo1.persistencia;

import com.caballero.ejemplo1.persistencia.interfaces.UsuarioOBD;
import com.caballero.ejemplo1.persistencia.postgresql.UsuarioOBDPostgreSQL;

public class FabricaOBD {
	
	public static UsuarioOBD crearUsuarioOBD() {
		return new UsuarioOBDPostgreSQL();
	}

}