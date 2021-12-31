package com.caballero.supra.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PresionarEnterListener implements KeyListener {
	private ActionListener accion;
	
	public PresionarEnterListener(ActionListener accion) {
		this.accion = accion;
	}
	
	public void keyPressed(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			accion.actionPerformed(new ActionEvent(new Object(), 0, ""));
	}

}