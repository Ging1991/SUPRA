package com.caballero.infraestructura.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class Tabla<Entidad> extends JTable {
	
	private static final long serialVersionUID = 1L;
	protected String[] columnas;
	private DefaultTableModel modelo;
	private List<Entidad> entidades;

	public Tabla(List<Entidad> entidades, String[] columnas) {
		this.columnas = columnas;
		modelo = new DefaultTableModel(null, columnas);
		setModel(modelo);
		recargar(entidades);
	}	
	
	public void recargar(List<Entidad> entidades) {
		this.entidades = entidades;
		modelo.setRowCount(0);
		modelo.setColumnCount(0);
		modelo.setColumnIdentifiers(columnas);
/*
		for (Cargo elemento : cargos) {
			Object[] fila = {
					Formato.fallecido(elemento),
					Formato.servicio(elemento),
					elemento.getPagado() ? "Si" : "No",
					elemento.getObservaciones()
				};
			modelo.addRow(fila);
		}
		*/
	}
	
	public List<Entidad> obtenerSeleccion() {
		List<Entidad> registros = new ArrayList<Entidad>();
		int[] indices = getSelectedRows();

		for (int indice : indices) {
			int registro = convertRowIndexToModel(indice);
			registros.add(entidades.get(registro));
		}

		return registros;		
	}

	public abstract Object[] generarFila(Entidad e);
	
}