package com.proyecto.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.entidad.Platos;
import com.proyecto.web.repositorio.PlatosRepositorio;



@Service
public class PlatosServiceImpl implements IPlatos{
	
	@Autowired
	private PlatosRepositorio platosRepositorio;
	
	@Override
	public List<Platos>listarTodos(){
		//
		return (List<Platos>)platosRepositorio.findAll();
		}
}
	


