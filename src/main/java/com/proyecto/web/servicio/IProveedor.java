package com.proyecto.web.servicio;

import java.util.List;
import java.util.Optional;

import com.proyecto.web.entidad.Proveedor;

public interface IProveedor {
	public List<Proveedor>BuscarTodos();
	public Proveedor BuscarPorId(Integer idproveedor);
	public void guardar(Proveedor proveedor);
	public void eliminar(Integer id);
}
