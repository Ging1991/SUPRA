package com.caballero.supra.negocios;

public abstract class ValidadorEntidad {
	
	public static boolean formatoCorreo(String correo) {
		return correo.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
	}
	
	public static boolean formatoNumero(String texto) {
		return texto.matches("[0-9]+");
	}

	public static boolean formatoLetra(String texto) {
		return texto.matches("[a-zA-Z�-�\\u00f1\\u00d1]+");
	}

	public static boolean formatoLetraEspacio(String texto) {
		return texto.matches("[a-zA-Z�-�\\u00f1\\u00d1\\s]+");
	}
	
	public static boolean formatoNumeroLetraEspacio(String texto) {
		return texto.matches("[a-zA-Z�-�0-9\\u00f1\\u00d1\\s]+");
	}
	
	public static boolean formatoNumeroLetra(String texto) {
		return texto.matches("[a-zA-Z�-�0-9\\u00f1\\u00d1]+");
	}

	public static boolean textoVacio(String texto) {
		return (texto == null) || texto.equals("");
	}
	
}