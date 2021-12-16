package com.caballero.infraestructura.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.caballero.infraestructura.general.Configuracion;

public abstract class OBD <Entidad> {
	
	public String tabla;
	public String campos;
	public String campoClave;
	protected String driver;
	protected String cadenaConexion;
	protected String usuarioBD;
	protected String passwordBD;
	
	public OBD(String credenciales, String tabla, String campos, String campoClave) {
		this.tabla = tabla;
		this.campos = campos;
		this.campoClave = campoClave;
		Configuracion configuracion = new Configuracion(System.getProperty("user.dir")+"\\"+credenciales);
		
		driver = configuracion.leer("driver");
		cadenaConexion = configuracion.leer("cadenaConexion");
		usuarioBD = configuracion.leer("usuarioBD");
		passwordBD = configuracion.leer("passwordBD");
	}
		
	public void ejecutarSQL(String SQL) {
		try {
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);
			Statement sentencia = conexion.createStatement ();
			sentencia.executeUpdate(SQL);		
			sentencia.close();
			conexion.close();
			
		} catch(Exception e) {
			System.out.println("       ERROR: " + SQL);
			e.printStackTrace();
		}
		
	}

	public List<Entidad> select(String SQL) {
		List<Entidad> ret = new ArrayList<Entidad>();
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(SQL);			

			while (resultados.next())
				ret.add(generar(resultados));

			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println("       ERROR: " + SQL);
			e.printStackTrace();
		}
			
		return ret;		
	}

	// Devuelve un unico elemento de clase [entidad] extraido de los resultados
	public abstract Entidad generar(ResultSet resultados) throws SQLException;
	
	protected abstract GeneradorSQL getGenerador(Entidad e);

	// Metodos SQL estandar
	public void insert(Entidad e) {
		GeneradorSQL sql = getGenerador(e);
		String consulta = sql.generarInsert();
		ejecutarSQL(consulta);
	}

	// Metodos SQL estandar
	public void update(Entidad e) {
		GeneradorSQL sql = getGenerador(e);
		String consulta = sql.generarUpdate();
		ejecutarSQL(consulta);
	}

	// Metodos SQL estandar
	public void delete(Entidad e) {
		GeneradorSQL sql = getGenerador(e);
		String consulta = sql.generarDelete();
		ejecutarSQL(consulta);
	}
		
	public List<Entidad> select() {
		String comandoSQL = "select ID, " + campos + " from " + tabla + ";";
		return select(comandoSQL);
	}
	
	public List<Entidad> selectByCondicion(String condicion) {
		String comandoSQL = "select ID, " + campos + " from " + tabla + " where ("+condicion+");";
		return select(comandoSQL);
	}
	
	public Entidad selectUnicoByCondicion(String condicion) {
		List<Entidad> lista = selectByCondicion(condicion);
		if (lista.size() > 0)
			return lista.get(0);
		return null;
	}
	
	public Entidad selectByID(Integer ID) {
		String condicion = "ID = " + ID;
		return selectUnicoByCondicion(condicion);
	}

	public Entidad selectByIDSegundo(String clave) {
		String condicion = campoClave + " = '" + clave + "'";
		return selectUnicoByCondicion(condicion);
	}
	
	public Entidad selectByIDSegundo(Integer clave) {
		String condicion = campoClave + " = " + clave;
		return selectUnicoByCondicion(condicion);
	}
	
}