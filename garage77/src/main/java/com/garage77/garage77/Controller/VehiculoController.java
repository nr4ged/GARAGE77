package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.garage77.garage77.Model.Vehiculo;

import com.garage77.garage77.Repository.IVehiculoRepository;

public class VehiculoController {
    
     @Autowired
	private IVehiculoRepository repoVehi;


	@GetMapping("/LsVehiculos")
	public String cargarPgCliente(Model model) {
		model.addAttribute("vehiculo", new Vehiculo());
		model.addAttribute("lstVehiculos", repoVehi.findAll());
		
		
		return "LsVehiculos";
	}
	

	//CREAR UN CONTROLLER PARA GENERARE EL LISTADO EN LA PAGINA
	@GetMapping("/LsVehiculos/listado")
	public String generarLista(Model model) {
		model.addAttribute("lstVehiculos", repoVehi.findAll());
		model.addAttribute("vehiculo", new Vehiculo());
		return ("LsVehiculos");
	} 
}
