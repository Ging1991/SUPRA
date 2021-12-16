package com.caballero.infraestructura.vista;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public abstract class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Ventana(String titulo, int ancho, int alto) {
		setTitle(titulo);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, ancho, alto);
		setLocationRelativeTo(null);
		mostrar();
	}
	
	public Ventana(String titulo) {
		setTitle(titulo);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);
		mostrar();
	}

	public void ocultar() {
		setVisible(false);
	}
	
	public void deshabilitar() {
		setEnabled(false);
	}
	
	public void mostrar() {
		setVisible(true);
		setEnabled(true);
	}
	
	public void compactar() {
		pack();
		setLocationRelativeTo(null);
	}
	
	public PanelVertical crearPanelPrincipal() {
		PanelVertical panel = new PanelVertical();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		return panel;
	}
	
}