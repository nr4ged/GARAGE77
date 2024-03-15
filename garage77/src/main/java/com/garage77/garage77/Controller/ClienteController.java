package com.garage77.garage77.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
 
//CARGARPAGINA!!
	 @GetMapping("/PgCliente")
	 public String cargarPgCliente() {
	     
	     return "PgCliente";
	 }
}