package com.proyecto.web.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.web.entidad.Proveedor;
import com.proyecto.web.servicio.IProveedor;

@Controller
@RequestMapping
public class ProveedorController {
	@Autowired
	private IProveedor service;
	
	@RequestMapping(value="/listarproveedor",method = RequestMethod.GET)
	public String listar(Model modelp) {
		List<Proveedor>proveedor=service.BuscarTodos();
		modelp.addAttribute("proveedor",proveedor);
		modelp.addAttribute("titulo","Listado de proveedores");
		return "/views/proveedor/listarproveedor";
	}
	
	@GetMapping("/create")
	public String crear() {
		return "frmCrear";
	}
	
	@RequestMapping(value = "/crearproveedor",method = RequestMethod.GET)
	public String crear(Model modelp) {
		modelp.addAttribute("proveedor", new Proveedor());
		modelp.addAttribute("titulo","Agregar Proveedor");
		return "/views/proveedor/crearproveedor";
	}	
	
	@PostMapping("/guardarproveedor")
	public String guardar(@Validated Proveedor p, Model modelp ) {
		service.guardar(p);
		return "redirect:/listarproveedor";
	}
	
	
	
	
	@GetMapping("/editarproveedor/{id}")
	public String Editar(@PathVariable("id") Integer idproveedor, Model model,HttpSession request,HttpSession response) {
		
		Proveedor proveedor=service.BuscarPorId(idproveedor);
	
		
		model.addAttribute("titulo", "Editar proveedor");
		model.addAttribute("proveedor", proveedor);
		
		
		
		return "/views/proveedor/crearproveedor";
		
	}
	
	@GetMapping("/eliminarproveedor/{id}")
	public String eliminar(Model modelp,@PathVariable int id) {
		service.eliminar(id);
		
		return "redirect:/listarproveedor";
	}
}
