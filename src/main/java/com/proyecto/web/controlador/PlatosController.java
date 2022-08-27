package com.proyecto.web.controlador;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.web.entidad.Platos;
import com.proyecto.web.servicio.IPlatosdatos;


@Controller
@RequestMapping
public class PlatosController {
	@Autowired
	private IPlatosdatos service;
	
	@RequestMapping(value="/listarplatos",method = RequestMethod.GET)
	public String listar(Model modelp) {
		List<Platos>platos=service.BuscarTodos();
		modelp.addAttribute("platos",platos);
		modelp.addAttribute("titulo","Listado de platos");
		return "/views/platos/listarplatos";
	}
	
	@RequestMapping(value = "/crearplatos",method = RequestMethod.GET)
	public String crear(Model modelp) {
		modelp.addAttribute("platos", new Platos());
		modelp.addAttribute("titulo","Agregar Plato");
		return "/views/platos/crearplatos";
	}	
	
	@PostMapping("/guardarplatos")
	public String guardar(@Validated Platos p, Model modelp) {
		service.guardar(p);
		return "redirect:/listarplatos";
	}



	
	@GetMapping("/editarplatos/{id}")
	public String editar(@PathVariable int id, Model modelp) {
		Optional<Platos>platos=service.BuscarPorId(id);
		modelp.addAttribute("platos",platos);
		modelp.addAttribute("titulo","Editar Plato");
		return "/views/platos/editarplatos";
	}
	
	@GetMapping("/eliminarplatos/{id}")
	public String eliminar(Model modelp,@PathVariable int id) {
		service.eliminar(id);
		
		return "redirect:/listarplatos";
	}
	
	
	
	//EDITAR POR PLATO ID CARTAS
	@RequestMapping(value="/editarplatosporcarta",method = RequestMethod.GET)
	public String editarplatosporcarta(Model modelp) {
		return "/views/platos/editarplatosporcarta";
	}
	
}
