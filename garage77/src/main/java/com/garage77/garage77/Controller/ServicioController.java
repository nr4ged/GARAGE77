package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garage77.garage77.Model.Cliente;
import com.garage77.garage77.Model.Insumo;
import com.garage77.garage77.Model.Servicio;
import com.garage77.garage77.Model.Vehiculo;
import com.garage77.garage77.Repository.IServicioRepository;


@Controller
public class ServicioController {
    
    @Autowired
    private IServicioRepository repoServ;

    // //CARGARPAGINA!!
	//  @GetMapping("/PgCliente")
	//  public String cargarPgCliente(Model model) {
    //     model.addAttribute("servicio", new Servicio());
	// 	model.addAttribute("insumos", new Insumo());
    //     model.addAttribute("cliente", new Cliente());
	// 	model.addAttribute("vehiculo", new Vehiculo());
	//      return "PgCliente";
	//  }

	//  @GetMapping("/LsClientes")
	//  public String cargarLsClientes() {
	     
	//      return "LsClientes";
	//  }

    //  @PostMapping("/PgCliente")
    //  public String registrarServicio(@ModelAttribute Servicio servicio, @RequestParam(value = "action", required = false) String action, Model model) {
    //      if ("registrar".equals(action)) {
    //     // Verificar si ya existe un cliente con el mismo código
    //       if (repoServ.existsById(servicio.getCodServicio())) {
    //            model.addAttribute("mensaje", "El código de Servicio ya existe");
    //         	   } else {
    //         	        try {
    //         	        	repoServ.save(servicio);
    //         	            model.addAttribute("mensaje", "Servicio registrado correctamente");
    //         	       } catch (Exception e) {
    //         	            model.addAttribute("mensaje", "Error al registrar al Servicio");
    //         	            }
    //         	        }
    //      }else if ("actualizar".equals(action)) {
 	//         try {
 	//         	repoServ.save(servicio);
 	//             model.addAttribute("mensaje", "Servicio actualizado correctamente");
 	        
 	//         } catch (Exception e) {
 	//             model.addAttribute("mensaje", "Error al actualizar el Servicio");
 	        
 	//     }
    //      }else if ("eliminar".equals(action)) {
    //     	    if (servicio.getCodServicio().isBlank()) {
    //  	        model.addAttribute("mensaje", "El campo Código de Servicio debe estar lleno");
    //  	    } else {
    //  	        if (repoServ.existsById(servicio.getCodServicio())) {
    //  	            try {
    //  	            	repoServ.deleteById(servicio.getCodServicio());
    //  	                model.addAttribute("mensaje", "Servicio eliminado correctamente");
    //  	            } catch (Exception e) {
    //  	                model.addAttribute("mensaje", "Error al eliminar el Servicio");
    //  	            }
    //  	        } else {
    //  	            model.addAttribute("mensaje", "El código de Servicio no existe");
    //  	        }
    //  	    }
    //  	}
    //  	   model.addAttribute("lstServicio", repoServ.findAll());
    //         return "PgCliente";
    //     }






	// //  @GetMapping("/PgCliente/editar/{nombre}")
	// //     public String editarCliente(@PathVariable("Nombre") String Nombre, Model model) {
	// //         Servicio servicio = repoCli.findById(Nombre).orElse(null);
	// //         model.addAttribute("cliente", cliente);
	// //         model.addAttribute("lstCliente", repoCli.findAll());
	// //         return "PgCliente";
	// //     }

	//  //CREAR UN CONTROLLER PARA GENERARE EL LISTADO EN LA PAGINA
	//  @GetMapping("/PgCliente/listado")
	//  public String generarLista(Model model) {
	// 	 model.addAttribute("lstServicio", repoServ.findAll());
	// 	 model.addAttribute("servicio", new Servicio());
	// 	 return ("PgCliente");
	//  } 
}
