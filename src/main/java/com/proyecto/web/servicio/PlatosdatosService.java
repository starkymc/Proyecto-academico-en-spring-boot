package com.proyecto.web.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.web.entidad.Platos;
import com.proyecto.web.repositorio.PlatosdatosRepositorio;
@Service
public class PlatosdatosService implements IPlatosdatos {

	@Autowired
	private PlatosdatosRepositorio data;
	
	@Autowired
	private IPlatosdatos service;

	@Override
	public List<Platos> BuscarTodos() {
		// TODO Auto-generated method stub
		return (List<Platos>)data.findAll();
	}

	@Override
	public Optional<Platos> BuscarPorId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int guardar(Platos c) {
		// TODO Auto-generated method stub
		int p=0;
		Platos platos = data.save(c);
		if(platos.equals(null)) {
			p=1;
		}
		return 0;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
	}
	
	
	
	
	

}
