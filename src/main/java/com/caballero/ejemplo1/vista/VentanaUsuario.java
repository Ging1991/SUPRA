package com.caballero.ejemplo1.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.caballero.ejemplo1.persistencia.entidades.Usuario;
import com.caballero.supra.vista.PanelVertical;
import com.caballero.supra.vista.Ventana;

public class VentanaUsuario extends Ventana {
	
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
		compactar();
	}
	
	public void actualizar(List<Usuario> usuarios) {
		tabla.recargar(usuarios);
	}

}