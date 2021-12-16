package com.caballero.ejemplo.vista;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.caballero.ejemplo.persistencia.entidades.Usuario;
import com.caballero.infraestructura.vista.PanelVertical;
import com.caballero.infraestructura.vista.Ventana;

public class VentanaUsuario extends Ventana{
	private TablaUsuarios tabla;

	private static final long serialVersionUID = 1L;

	public VentanaUsuario(String titulo) {
		super(titulo, 500, 500);
		
		tabla = new TablaUsuarios(new ArrayList<Usuario>());
		JScrollPane panelTabla = new JScrollPane(tabla);

		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);		
		panelPrincipal.add(panelTabla);
	}

}