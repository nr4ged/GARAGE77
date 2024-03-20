package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.garage77.garage77.Model.Cliente;
import com.garage77.garage77.Repository.IClienteRepository;

public class ClienteController {
    
    @Autowired
	private IClienteRepository repoCli;


	@GetMapping("/LsClientes")
	public String cargarPgCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstClientes", repoCli.findAll());
		
		
		return "LsClientes";
	}
	

	//CREAR UN CONTROLLER PARA GENERARE EL LISTADO EN LA PAGINA
	@GetMapping("/LsClientes/listado")
	public String generarLista(Model model) {
		model.addAttribute("lstClientes", repoCli.findAll());
		model.addAttribute("cliente", new Cliente());
		return ("LsClientes");
	} 


	//  @GetMapping("/LsClientes")
	//  public String cargarLsCliente() {
	     
	//      return "LsClientes";
	//  }

	//  @PostMapping("/LsClientes")
    // public String registrarCliente(@ModelAttribute Cliente cliente, @RequestParam(value = "action", required = false) String action, Model model) {
    //       if ("registrar".equals(action)) {
    //        if (repoCli.existsById(cliente.getNombre())) {
    //             model.addAttribute("mensaje", "El código de Cliente ya existe");
    //          	   } else {
    //          	        try {
    //          	        	repoCli.save(cliente);
    //          	            model.addAttribute("mensaje", "Cliente registrado correctamente");
    //          	       } catch (Exception e) {
    //          	            model.addAttribute("mensaje", "Error al registrar al Cliente");
    //        	            }
    //         	        }
    //       }else if ("actualizar".equals(action)) {
    //      try {
 	//          	repoCli.save(cliente);
 	//              model.addAttribute("mensaje", "Cliente actualizado correctamente");
 	        
 	//          } catch (Exception e) {
 	//             model.addAttribute("mensaje", "Error al actualizar el Cliente");
 	        
 	//      }
    //       }else if ("eliminar".equals(action)) {
    //    	    if (cliente.getNombre().isBlank()) {
    //  	        model.addAttribute("mensaje", "El campo Código de Usuario debe estar lleno");
    //   	    } else {
    //   	        if (repoCli.existsById(cliente.getNombre())) {
    //   	            try {
    //   	            	repoCli.deleteById(cliente.getNombre());
    //   	                model.addAttribute("mensaje", "Cliente eliminado correctamente");
    //   	            } catch (Exception e) {
    //   	                model.addAttribute("mensaje", "Error al eliminar el Cliente");
    //   	            }
    //  	        } else {
  	//             model.addAttribute("mensaje", "El código de cliente no existe");
    // 	        }
    //  	    }
    // 	}
    //   	   model.addAttribute("lstCliente", repoCli.findAll());
    //          return "PgCliente";
    //     }

    
}
