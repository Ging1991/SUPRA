package com.caballero.supra.vista.entrada;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import com.caballero.supra.vista.PanelHorizontal;

public class EntradaLista<Entidad> extends PanelHorizontal {
	private static final long serialVersionUID = 1L;
	private JComboBox<Entidad> lista;
	private JLabel label;
	
	public EntradaLista (String texto, Dimension dimTexto, Dimension dimEntrada) {
		label = new JLabel(texto);
		label.setMaximumSize(dimTexto);
		label.setMinimumSize(dimTexto);
		label.setPreferredSize(dimTexto);
		add(label);
		
		lista = new JComboBox<Entidad>();
		lista.setMaximumSize(dimEntrada);
		lista.setMinimumSize(dimEntrada);
		lista.setPreferredSize(dimEntrada);
		add(lista);
	}
	
	public void bloquear(boolean bloquear) {
		label.setEnabled(bloquear);
		lista.setEnabled(bloquear);
	}

	public JComboBox<Entidad> getComboBox() {
		return lista;
	}

}