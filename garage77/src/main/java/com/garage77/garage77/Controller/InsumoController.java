package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.garage77.garage77.Model.Insumo;
import com.garage77.garage77.Repository.InsumoRepository;

public class InsumoController {
    
     @Autowired
	private InsumoRepository repoInsu;


	@GetMapping("/LsInsumos")
	public String cargarPgCliente(Model model) {
		model.addAttribute("insumo", new Insumo());
		model.addAttribute("lstInsumos", repoInsu.findAll());
		
		
		return "LsInsumos";
	}
	

	//CREAR UN CONTROLLER PARA GENERARE EL LISTADO EN LA PAGINA
	@GetMapping("/LsInsumos/listado")
	public String generarLista(Model model) {
		model.addAttribute("lstInsumos", repoInsu.findAll());
		model.addAttribute("insumo", new Insumo());
		return ("LsInsumos");
	} 
}
