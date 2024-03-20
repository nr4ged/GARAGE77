package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.garage77.garage77.Model.Cliente;

import com.garage77.garage77.Repository.IClienteRepository;

@Controller
public class ProyectoController {

	@Autowired
	private IClienteRepository repoCli;
	
		@GetMapping("/Login")
		public String cargarLogin() {
			return "Login";
		}

		@GetMapping("/Index")
		public String cargarIndex() {
			return "Index";
		}

		@GetMapping("/LsVehiculos")
		public String cargarLsVehiculos() {
			return "LsVehiculos";
		}

		@GetMapping("/Listados")
		public String cargarListados() {
			return "Listados";
		}

		@GetMapping("/LsInsumos")
		public String cargarInsumos() {
			return "LsInsumos";
		}

		@GetMapping("/LsClientes")
		public String cargarPgCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstClientes", repoCli.findAll());
		
		
		return "LsClientes";
	}

    }