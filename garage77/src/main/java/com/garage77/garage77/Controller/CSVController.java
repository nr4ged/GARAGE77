package com.garage77.garage77.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.garage77.garage77.Model.CSV;
import com.garage77.garage77.Model.Cliente;
import com.garage77.garage77.Model.Insumo;
import com.garage77.garage77.Model.InsumoVehiculo;
import com.garage77.garage77.Model.Servicio;
import com.garage77.garage77.Model.Vehiculo;

import com.garage77.garage77.Repository.IClienteRepository;
import com.garage77.garage77.Repository.IServicioRepository;
import com.garage77.garage77.Repository.IVehiculoRepository;
import com.garage77.garage77.Repository.InsumoRepository;
import com.garage77.garage77.Repository.InsumoVehiculoRepository;


@Controller
public class CSVController {

	@Autowired
	private IClienteRepository repoCli;
	@Autowired
	private IVehiculoRepository repoVehi;
	@Autowired
	private InsumoRepository repoInsu;
	@Autowired
	private InsumoVehiculoRepository repoInVe;
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


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		
		Cliente cliente = new Cliente();
		cliente.setClienteNombre(csv.getNombreCliente());
		cliente.setClienteTelefono(csv.getTelefonoCliente());
		cliente.setClienteDni(csv.getDniCliente());

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca(csv.getPlaca());
		vehiculo.setAñoVehiculo(csv.getAñoVehiculo());
		vehiculo.setKmActual(csv.getKmActual());
		vehiculo.setKmAprox(csv.getKmAprox());
		vehiculo.setMarca(csv.getMarca());
		vehiculo.setModelo(csv.getModelo());
		
		Servicio servicio = new Servicio();
		LocalDateTime fechaHoraRecep = LocalDateTime.parse(csv.getServicioHoraRecep(), formatter);
		servicio.setServicioHoraRecep(fechaHoraRecep);
		LocalDateTime fechaHoraEntrega = LocalDateTime.parse(csv.getServicioHoraEntrega(), formatter);
		servicio.setServicioHoraEntrega(fechaHoraEntrega);
		servicio.setServicioTotal(csv.getServicioTotal());

		InsumoVehiculo insumoVehiculo = new InsumoVehiculo();
		insumoVehiculo.setPlaca(csv.getPlaca());
		insumoVehiculo.setInsumoPrecio(csv.getInsumoPrecio());

		Insumo insumo = new Insumo();
		insumo.setInsumoId(csv.getInsumoId());
		insumo.setInsumoDescripcion(csv.getInsumoDescripcion());
		insumo.setInsumoPrecio(csv.getInsumoPrecio());

        // Verificar si ya existe un cliente con el mismo código
          if (repoCli.existsById(csv.getIdCliente())){
               model.addAttribute("mensaje", "El código de Cliente ya existe");
            	   } else {
					try {
						Cliente newcliente = repoCli.save(cliente);
						vehiculo.setClienteId(newcliente.getClienteId());
						
						Vehiculo nuevoVehiculo = repoVehi.save(vehiculo);
				
						Servicio nuevoServicio = repoServ.save(servicio);
				
						// Asignar el ID del nuevo insumo a insumoVehiculo
						insumoVehiculo.setInsumoId(insumo.getInsumoId());
						insumoVehiculo.setPlaca(nuevoVehiculo.getPlaca());
						insumoVehiculo.setServicioId(nuevoServicio.getServicioId());
				
						// Guardar insumoVehiculo en el repositorio
						InsumoVehiculo nuevoIV = repoInVe.save(insumoVehiculo);
				
						model.addAttribute("mensaje", "Cliente registrado correctamente");
					} catch (Exception e) {
						model.addAttribute("mensaje", "Error al registrar al Cliente");
						e.printStackTrace();
					}
            	        }
         }
		 
		 return "PgCSV";
	}


	// @GetMapping("/LsCliente/listado")
    // public String lista(Model model) {
    //     model.addAttribute("lstClientes", repoCli.findAll());
    //     model.addAttribute("cliente", new Cliente());
    //     return "LsCliente"; // Esto se espera que sea el nombre de tu archivo HTML (vista)
    // }

	@GetMapping("/PgCSV/listadoInsumos")
	public String mostrarInsumos(Model model) {
		List<Insumo> listaInsumos = repoInsu.findAll();
		model.addAttribute("insumos", listaInsumos);
		return "PgCSV";
	}
}