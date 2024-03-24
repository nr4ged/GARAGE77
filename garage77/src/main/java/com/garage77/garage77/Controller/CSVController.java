package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

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
public class CSVController {

	@Autowired
	private IClienteRepository repoCli;
	@Autowired
	private IVehiculoRepository repoVehi;
	@Autowired
	private InsumoRepository repoInsu;

	@Autowired
	private IServicioRepository repoServ;
 
	

//CARGARPAGINA!!
	//  @GetMapping("/PgCSV")
	//  public String cargarPgCliente(Model model) {
	// 	model.addAttribute("cliente", new Cliente());
	// 	model.addAttribute("vehiculo", new Vehiculo());
	// 	model.addAttribute("insumo", new Insumo());
	// 	model.addAttribute("servicio", new Servicio());
	// 	model.addAttribute("csv", new CSV());
	// 	model.addAttribute("lstClientes", repoCli.findAll());
	// 	model.addAttribute("lstInsumos", repoInsu.findAll());
	//      return "PgCSV";
	//  }

	 @PostMapping("/PgCSV")
     public String registrarCSV(@ModelAttribute CSV csv, @RequestParam(value = "action", required = false) String action, Model model) {
         if ("registrar".equals(action)) {

		Cliente cliente = new Cliente();
		cliente.setNombre(csv.getNombreCliente());
		cliente.setTelefono(csv.getTelefonoCliente());
		cliente.setDni(csv.getDniCliente());
		cliente.setHoraRecep(csv.getHoraRecep());
		cliente.setHoraEntrega(csv.getHoraEntrega());
		cliente.setFecha(csv.getFechaCliente());

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca(csv.getPlaca());
		vehiculo.setAñoVehiculo(csv.getAñoVehiculo());
		vehiculo.setKmActual(csv.getKmActual());
		vehiculo.setKmAprox(csv.getKmAprox());
		vehiculo.setMarca(csv.getMarca());
		vehiculo.setModelo(csv.getModelo());
		
		Servicio servicio = new Servicio();
		servicio.setCodServicio(csv.getCodServicio());
		servicio.setNombre(csv.getNombreCliente());
		servicio.setTelefono(csv.getTelefonoCliente());
		servicio.setPlaca(csv.getPlaca());
		servicio.setAñoVehiculo(csv.getAñoVehiculo());

		// Insumo insumo = new Insumo();
		// insumo.setCodInsumo(csv.getCodInsumo());
		// insumo.setDesInsumo(csv.getDesInsumo());

        // Verificar si ya existe un cliente con el mismo código
          if (repoVehi.existsById(csv.getPlaca())){
               model.addAttribute("mensaje", "El código de Cliente ya existe");
            	   } else {
            	        try {
            	        	repoVehi.save(vehiculo);
							repoCli.save(cliente);
							repoServ.save(servicio);
            	            model.addAttribute("mensaje", "Cliente registrado correctamente");
            	       } catch (Exception e) {
            	            model.addAttribute("mensaje", "Error al registrar al Cliente");
            	            }
            	        }
         }

		 return "PgCSV";
	}



	//  @PostMapping("/PgCliente")
    //  public String registrarCliente(@ModelAttribute Cliente cliente, @RequestParam(value = "action", required = false) String action, Model model) {
    //      if ("registrar".equals(action)) {

    //     // Verificar si ya existe un cliente con el mismo código
    //       if (repoCli.existsById(cliente.getNombre())) {
    //            model.addAttribute("mensaje", "El código de Cliente ya existe");
    //         	   } else {
    //         	        try {
    //         	        	repoCli.save(cliente);
    //         	            model.addAttribute("mensaje", "Cliente registrado correctamente");
    //         	       } catch (Exception e) {
    //         	            model.addAttribute("mensaje", "Error al registrar al Cliente");
    //         	            }
    //         	        }
    //      }else if ("actualizar".equals(action)) {
 	//         try {
 	//         	repoCli.save(cliente);
 	//             model.addAttribute("mensaje", "Cliente actualizado correctamente");
 	        
 	//         } catch (Exception e) {
 	//             model.addAttribute("mensaje", "Error al actualizar el Cliente");
 	        
 	//     }
    //      }else if ("eliminar".equals(action)) {
    //     	    if (cliente.getNombre().isBlank()) {
    //  	        model.addAttribute("mensaje", "El campo Código de Usuario debe estar lleno");
    //  	    } else {
    //  	        if (repoCli.existsById(cliente.getNombre())) {
    //  	            try {
    //  	            	repoCli.deleteById(cliente.getNombre());
    //  	                model.addAttribute("mensaje", "Cliente eliminado correctamente");
    //  	            } catch (Exception e) {
    //  	                model.addAttribute("mensaje", "Error al eliminar el Cliente");
    //  	            }
    //  	        } else {
    //  	            model.addAttribute("mensaje", "El código de cliente no existe");
    //  	        }
    //  	    }
    //  	}
    //  	   model.addAttribute("lstCliente", repoCli.findAll());
    //         return "PgCliente";
    //     }
	//  @GetMapping("/PgCliente/editar/{nombre}")
	//     public String editarCliente(@PathVariable("Nombre") String Nombre, Model model) {
	//         Cliente cliente = repoCli.findById(Nombre).orElse(null);
	//         model.addAttribute("cliente", cliente);
	//         model.addAttribute("lstCliente", repoCli.findAll());
	//         return "PgCliente";
	//     }

	// @GetMapping("/LsCliente/listado")
    // public String lista(Model model) {
    //     model.addAttribute("lstClientes", repoCli.findAll());
    //     model.addAttribute("cliente", new Cliente());
    //     return "LsCliente"; // Esto se espera que sea el nombre de tu archivo HTML (vista)
    // }

	 @GetMapping("/PgCSV/listado")
	 public String generarLista(Model model) {
	 model.addAttribute("lstInsumos", repoInsu.findAll());
	 model.addAttribute("insumos", new Insumo());
	 return ("PgCSV");
	  } 
}