package com.caballero.ejemplo1.persistencia;

import com.caballero.supra.persistencia.OBD;

public abstract class MiOBD<Entidad> extends OBD<Entidad> {
	
	public MiOBD(String tabla, String campos, String campoClave) {
		super("config.properties", tabla, campos, campoClave);
	}

}