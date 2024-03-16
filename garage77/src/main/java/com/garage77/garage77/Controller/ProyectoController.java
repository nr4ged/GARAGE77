package com.garage77.garage77.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProyectoController {

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



    }