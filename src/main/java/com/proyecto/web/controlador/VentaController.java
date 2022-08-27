package com.proyecto.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.web.entidad.Platos;
import com.proyecto.web.entidad.Ventas;
import com.proyecto.web.servicio.IPlatos;
import com.proyecto.web.servicio.IVentas;






@Controller
@RequestMapping("/")
public class VentaController {

	@Autowired
	private IVentas service;
	
	@Autowired
	private IPlatos platosService;
	
	
	@RequestMapping(value = "/listar",method = RequestMethod.GET)
	public String listarventas(Model model) {
		List<Ventas>listadoVentas = service.listarTodos();
		

		model.addAttribute("titulo","Listado de ventas");
		model.addAttribute("ventas",listadoVentas);
		
		return "/views/ventas/listar";
	}
	
	
	@RequestMapping(value = "/crear",method = RequestMethod.GET)
	public String crear(Model model) {
		Ventas ventas = new Ventas();
		
		List<Platos> listadoPlatos =platosService .listarTodos();
		
		model.addAttribute("titulo","Agregar Venta");
		model.addAttribute("ventas",ventas);
		model.addAttribute("lstPlatos",listadoPlatos);	
		
		
		return "/views/ventas/crear";
	}	
	
	@PostMapping(value = "/save")
	public String Guardar(@ModelAttribute Ventas ventas) {
		
		service.guardar(ventas);
		return "redirect:/listar";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Integer idVenta, Model model) {
		Ventas ventas = service.buscarPorId(idVenta);
		
		List<Platos> listadoPlatos = platosService.listarTodos();
		
		model.addAttribute("titulo","Editar Pago");
		model.addAttribute("ventas",ventas);
		model.addAttribute("lstPlatos",listadoPlatos);	
		
		return "/views/ventas/editar";
	}	
	
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idVenta) {

		service.eliminar(idVenta);
		return "redirect:/listar";
	}
	
	@GetMapping("/verventa/{id}")
	public String verventa(@PathVariable("id") Integer idCliente, Model model) {
		Ventas ventas = service.buscarPorId(idCliente);
		
		List<Platos> listadoPlatos = platosService.listarTodos();
		
		model.addAttribute("titulo","Detalle de pago");
		model.addAttribute("ventas",ventas);
	
		model.addAttribute("lstProducto",listadoPlatos);	
		
		return "/views/ventas/verventa";
	}	
	
}