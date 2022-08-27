package com.proyecto.web.servicio;

import java.util.List;

import com.proyecto.web.entidad.Ventas;



public interface IVentas {
	
	public List<Ventas>listarTodos();
	public void guardar(Ventas ventas);
	public Ventas buscarPorId(Integer idventa);
	public void eliminar(Integer idventa);

}
