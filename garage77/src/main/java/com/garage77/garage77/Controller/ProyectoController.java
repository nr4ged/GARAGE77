package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.garage77.garage77.Model.Cliente;

import com.garage77.garage77.Repository.IClienteRepository;
import com.garage77.garage77.Repository.IVehiculoRepository;

@Controller
public class ProyectoController {

	@Autowired
	private IClienteRepository repoCli;

	@Autowired
	private IVehiculoRepository repoVehi;
	
		@GetMapping("/Login")
		public String cargarLogin() {
			return "Login";
		}

		@GetMapping("/Index")
			public String cargarIndex() {
			return "Index";
		}

		@GetMapping("/Listados")
		public String cargarListados() {
			return "Listados";
		}

		@GetMapping("/LsInsumos")
		public String cargarInsumos() {
			return "LsInsumos";
		}

		@GetMapping("/LsServicio")
		public String cargarServicios() {
			return "LsServicio";
		}

		@GetMapping("/LsClientes")
		public String cargarPgCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstClientes", repoCli.findAll());
		
		
		return "LsClientes";
	}

	@GetMapping("/LsVehiculos")
		public String cargarLsVehiculos(Model model) {
			model.addAttribute("vehiculo", new Cliente());
			model.addAttribute("lstVehiculos", repoVehi.findAll());
			return "LsVehiculos";
		}

    }