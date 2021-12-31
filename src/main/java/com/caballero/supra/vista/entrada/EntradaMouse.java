package com.caballero.supra.vista.entrada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EntradaMouse implements MouseListener {
	private ActionListener accion;
	
	public EntradaMouse(ActionListener accion) {
		this.accion = accion;
	}
	
	public void mouseClicked(MouseEvent e) {
		accion.actionPerformed(new ActionEvent(new Object(), 0, ""));
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

}