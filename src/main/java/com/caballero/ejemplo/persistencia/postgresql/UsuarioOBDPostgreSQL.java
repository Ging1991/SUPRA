package com.caballero.ejemplo.persistencia.postgresql;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.caballero.ejemplo.persistencia.MiOBD;
import com.caballero.ejemplo.persistencia.entidades.Usuario;
import com.caballero.ejemplo.persistencia.interfaces.UsuarioOBD;
import com.caballero.infraestructura.persistencia.GeneradorSQL;

public class UsuarioOBDPostgreSQL extends MiOBD<Usuario> implements UsuarioOBD {
	
	public UsuarioOBDPostgreSQL() {
		super("app_usuarios", "nombre, clave", "nombre");
	}

	@Override
	public Usuario generar(ResultSet resultados) throws SQLException {
		return new Usuario(
				resultados.getInt("ID"),
				resultados.getString("nombre"),
				resultados.getString("clave")
			);
		
	}

	@Override
	protected GeneradorSQL getGenerador(Usuario e) {
		GeneradorSQL sql = new GeneradorSQL(tabla);
		sql.agregar("ID", e.getID());
		sql.agregar("nombre", e.getNombre());
		sql.agregar("clave", e.getClave());
		return sql;
	}

}