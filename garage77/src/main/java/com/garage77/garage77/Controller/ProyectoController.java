package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.garage77.garage77.Model.CSV;
import com.garage77.garage77.Model.Cliente;
import com.garage77.garage77.Model.Insumo;
import com.garage77.garage77.Model.Servicio;
import com.garage77.garage77.Model.Vehiculo;
import com.garage77.garage77.Repository.IClienteRepository;
import com.garage77.garage77.Repository.IServicioRepository;
import com.garage77.garage77.Repository.IVehiculoRepository;
import com.garage77.garage77.Repository.InsumoRepository;

@Controller
public class ProyectoController {

	@Autowired
	private IClienteRepository repoCli;
	@Autowired
	private IVehiculoRepository repoVehi;
	@Autowired
	private InsumoRepository repoInsu;
	@Autowired
	private IServicioRepository repoServ;
	
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

		@GetMapping("/PgCSV")
			public String cargarPgCSV(Model model) {

				   model.addAttribute("cliente", new Cliente());
				   model.addAttribute("vehiculo", new Vehiculo());
				   model.addAttribute("insumo", new Insumo());
				   model.addAttribute("servicio", new Servicio());
				   model.addAttribute("csv", new CSV());
				   model.addAttribute("lstClientes", repoCli.findAll());
				   model.addAttribute("lstInsumos", repoInsu.findAll());

			return "PgCSV";
		}


		@GetMapping("/LsClientes")
		public String cargarPgCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstClientes", repoCli.findAll());
		
		
		return "LsClientes";
	}

	@GetMapping("/LsVehiculos")
		public String cargarLsVehiculos(Model model) {
			model.addAttribute("vehiculo", new Vehiculo());
			model.addAttribute("lstVehiculos", repoVehi.findAll());
			return "LsVehiculos";
		}

		@GetMapping("/LsInsumos")
		public String cargarLsInsumos(Model model) {
			model.addAttribute("insumo", new Insumo());
			model.addAttribute("lstInsumos", repoInsu.findAll());
			return "LsInsumos";
		}

		@GetMapping("/LsServicio")
		public String cargarLsServicios(Model model) {
			model.addAttribute("servicio", new Servicio());
			model.addAttribute("lstServicios", repoServ.findAll());
			return "LsServicio";
		}
}