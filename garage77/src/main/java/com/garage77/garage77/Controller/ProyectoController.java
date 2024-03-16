package com.garage77.garage77.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProyectoController {

		@GetMapping("/Login")
		public String cargarLogin() {
			return "Login";
		}

		@GetMapping("/Inicio")
		public String cargarInicio() {
			return "Inicio";
		}

		@GetMapping("/Index")
		public String cargarIndex() {
			return "Index";
		}

    }