package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;



import com.garage77.garage77.Model.Cliente;
import com.garage77.garage77.Repository.IClienteRepository;


@Controller
public class ClienteController {

	@Autowired
	private IClienteRepository repoCli;
 
//CARGARPAGINA!!
	 @GetMapping("/PgCliente")
	 public String cargarPgCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstCliente", repoCli.findAll());
	     return "PgCliente";
	 }

	 @GetMapping("/LsClientes")
	 public String cargarLsClientes() {
	     
	     return "LsClientes";
	 }

	 @PostMapping("/PgCliente")
     public String registrarCliente(@ModelAttribute Cliente cliente, @RequestParam(value = "action", required = false) String action, Model model) {
         if ("registrar".equals(action)) {
        // Verificar si ya existe un cliente con el mismo código
          if (repoCli.existsById(cliente.getCod_cliente())) {
               model.addAttribute("mensaje", "El código de Cliente ya existe");
            	   } else {
            	        try {
            	        	repoCli.save(cliente);
            	            model.addAttribute("mensaje", "Cliente registrado correctamente");
            	       } catch (Exception e) {
            	            model.addAttribute("mensaje", "Error al registrar al Cliente");
            	            }
            	        }
         }else if ("actualizar".equals(action)) {
 	        try {
 	        	repoCli.save(cliente);
 	            model.addAttribute("mensaje", "Cliente actualizado correctamente");
 	        
 	        } catch (Exception e) {
 	            model.addAttribute("mensaje", "Error al actualizar el Cliente");
 	        
 	    }
         }else if ("eliminar".equals(action)) {
        	    if (cliente.getCod_cliente().isBlank()) {
     	        model.addAttribute("mensaje", "El campo Código de Usuario debe estar lleno");
     	    } else {
     	        if (repoCli.existsById(cliente.getCod_cliente())) {
     	            try {
     	            	repoCli.deleteById(cliente.getCod_cliente());
     	                model.addAttribute("mensaje", "Cliente eliminado correctamente");
     	            } catch (Exception e) {
     	                model.addAttribute("mensaje", "Error al eliminar el Cliente");
     	            }
     	        } else {
     	            model.addAttribute("mensaje", "El código de cliente no existe");
     	        }
     	    }
     	}
     	   model.addAttribute("lstCliente", repoCli.findAll());
            return "PgCliente";
        }
	 @GetMapping("/PgCliente/editar/{cod_cliente}")
	    public String editarCliente(@PathVariable("cod_cliente") String cod_cliente, Model model) {
	        Cliente cliente = repoCli.findById(cod_cliente).orElse(null);
	        model.addAttribute("cliente", cliente);
	        model.addAttribute("lstCliente", repoCli.findAll());
	        return "PgCliente";
	    }

	 //CREAR UN CONTROLLER PARA GENERARE EL LISTADO EN LA PAGINA
	 @GetMapping("/PgCliente/listado")
	 public String generarLista(Model model) {
		 model.addAttribute("lstCliente", repoCli.findAll());
		 model.addAttribute("cliente", new Cliente());
		 return ("PgCliente");
	 } 
}