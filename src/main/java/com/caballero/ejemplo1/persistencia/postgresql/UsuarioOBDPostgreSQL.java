package com.caballero.ejemplo1.persistencia.postgresql;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.caballero.ejemplo1.persistencia.MiOBD;
import com.caballero.ejemplo1.persistencia.entidades.Usuario;
import com.caballero.ejemplo1.persistencia.interfaces.UsuarioOBD;
import com.caballero.supra.persistencia.GeneradorSQL;

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