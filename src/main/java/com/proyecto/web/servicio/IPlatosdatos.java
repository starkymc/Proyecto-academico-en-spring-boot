package com.proyecto.web.servicio;

import java.util.List;
import java.util.Optional;

import com.proyecto.web.entidad.Platos;
import com.proyecto.web.entidad.Ventas;
import com.proyecto.web.repositorio.PlatosRepositorio;

public interface IPlatosdatos {
	
	/*public List<Platos>listarTodos();
	public void guardar(Platos pltos);
	public Platos buscarPorId(Integer idplato);
	public void eliminar(Integer idplato);
	void eliminar(int idplato);*/
	
	
	public List<Platos>BuscarTodos();
	public Optional<Platos>BuscarPorId(int id);
	public int guardar(Platos c);
	public void eliminar(int id);

	
	
}
