package com.proyecto.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.repositorio.VentasRepositorio;
import com.proyecto.web.entidad.*;

@Service
public class VentasServiceImpl implements IVentas{

	@Autowired
	private VentasRepositorio ventasRepositorio;
	
	
	@Override
	public List<Ventas>listarTodos(){
		return(List<Ventas>)ventasRepositorio.findAll();
		
	}
	@Override
	public void guardar(Ventas ventas) {
		ventasRepositorio.save(ventas);
	}
	
	@Override
	public Ventas buscarPorId(Integer idventa) {
		Ventas ven1 = new Ventas();
		Ventas ven = ventasRepositorio.findById(idventa).orElse(ven1);
		return ven;
	}
	
	
	@Override
	public void eliminar(Integer idventa) {
		ventasRepositorio.deleteById(idventa);
	}
}

