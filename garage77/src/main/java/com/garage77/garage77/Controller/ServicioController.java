package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.garage77.garage77.Model.Servicio;
import com.garage77.garage77.Repository.IServicioRepository;

public class ServicioController {
    
    @Autowired
	private IServicioRepository repoServ;


	@GetMapping("/LsServicio")
	public String cargarPgCliente(Model model) {
		model.addAttribute("servicio", new Servicio());
		model.addAttribute("lstServicios", repoServ.findAll());
		
		
		return "LsServicio";
	}
	

	//CREAR UN CONTROLLER PARA GENERARE EL LISTADO EN LA PAGINA
	@GetMapping("/LsServicio/listado")
	public String generarLista(Model model) {
		model.addAttribute("lstServicios", repoServ.findAll());
		model.addAttribute("servicio", new Servicio());
		return ("LsServicio");
	} 

}
