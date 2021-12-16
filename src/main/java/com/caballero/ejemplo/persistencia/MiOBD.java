package com.caballero.ejemplo.persistencia;

import com.caballero.infraestructura.persistencia.OBD;

public abstract class MiOBD<Entidad> extends OBD<Entidad> {
	
	public MiOBD(String tabla, String campos, String campoClave) {
		super("config.properties", tabla, campos, campoClave);
	}

}