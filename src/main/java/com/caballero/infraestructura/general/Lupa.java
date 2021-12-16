package com.caballero.infraestructura.general;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lupa {

	public static void mostrar(Object objeto) {
		
		String clase = objeto.getClass().getName();
		String ret = "";
		
        try {
            Field[] campos = Class.forName(clase).getDeclaredFields();
            
        	for (Field campo : campos) {
        		campo.setAccessible(true);
        		Object propiedad = campo.get(objeto);
        		if (!ret.equals(""))
        			ret += ", ";
        		ret+= campo.getName() + ": " + propiedad;
        	}
        	
        	System.out.println(clase+"["+ret+"]");
            
        } catch (Exception e) {
            System.err.println("Hubo un error:" + e.getMessage());
        }
		
	}
	
	public static void mostrarCompleto(Object objeto) {
		
		String clase = objeto.getClass().getName();
		String ret = "";
		
        try {
            Field[] campos = extraerCampos(objeto);
            
        	for (Field campo : campos) {
        		campo.setAccessible(true);
        		Object propiedad = campo.get(objeto);
        		if (!ret.equals(""))
        			ret += ", ";
        		ret+= campo.getName() + ": " + propiedad;
        	}
        	
        	System.out.println(clase+"["+ret+"]");
            
        } catch (Exception e) {
            System.err.println("Hubo un error:" + e.getMessage());
        }
		
	}
	
	private static Field[] extraerCampos (Object objeto) throws Exception{
		List<Field> lista = new ArrayList<Field>();
		String nombre = objeto.getClass().getName();
		Field[] arreglo = Class.forName(nombre).getDeclaredFields();
		Collections.addAll(lista, arreglo);
		@SuppressWarnings("rawtypes")
		Class padre = objeto.getClass().getSuperclass();
		
		while(padre != null) {
			nombre = padre.getName();
			arreglo = Class.forName(nombre).getDeclaredFields();
			Collections.addAll(lista, arreglo);
			padre = padre.getSuperclass();
		}
		
		Field[] ret = lista.toArray(new Field[0]);
		return ret;
	}

}