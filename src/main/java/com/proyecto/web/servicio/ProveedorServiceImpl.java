package com.proyecto.web.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyecto.web.entidad.Proveedor;
import com.proyecto.web.repositorio.ProveedorRepositorio;
@Service
public class ProveedorServiceImpl implements IProveedor {

	@Autowired
	private ProveedorRepositorio data;
	
	@Override
	public List<Proveedor> BuscarTodos() {
		// TODO Auto-generated method stub
		return (List<Proveedor>)data.findAll();
	}


	

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
	}

	@Override
	public void guardar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		data.save(proveedor);
	}




	@Override
	public Proveedor BuscarPorId(Integer idproveedor) {
		// TODO Auto-generated method stub
		return data.findById(idproveedor).orElse(null);
	}

}
