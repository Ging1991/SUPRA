package com.caballero.supra.vista;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelVertical extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public PanelVertical() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
}