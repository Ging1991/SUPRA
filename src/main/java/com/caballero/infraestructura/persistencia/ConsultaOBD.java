package com.caballero.infraestructura.persistencia;

import java.util.List;

public interface ConsultaOBD<Entidad> {
	
	public void insert(Entidad entidad);

	public void update(Entidad entidad);
	
	public void delete(Entidad entidad);
	
	public List<Entidad> select();
	
	public Entidad selectByID(Integer ID);
	
	public Entidad selectByIDSegundo(String clave);

	public Entidad selectByIDSegundo(Integer clave);

}