package com.caballero.ejemplo1.vista;

import com.caballero.ejemplo1.negocios.manager.UsuarioManager;

public class ControladorUsuario {
	
	public ControladorUsuario() {
		VentanaUsuario ventana = new VentanaUsuario("Usuarios");
		ventana.actualizar(UsuarioManager.traer());
	}

}