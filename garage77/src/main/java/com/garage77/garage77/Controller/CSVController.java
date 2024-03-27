package com.garage77.garage77.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garage77.garage77.Model.*;
import com.garage77.garage77.Repository.*;

@Controller
@RequestMapping("/PgCSV")
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
	
	@GetMapping
	public String mostrarEntidades(Model model) 
	{
		List<Insumo> listaInsumos = repoInsu.findAll();
		model.addAttribute("insumos", listaInsumos);
		
		return ("PgCSV");
	}

	@PostMapping("/PgRegistrarTodo")
	public String registrarCSV(@ModelAttribute CSV csv, @RequestParam(value = "action", required = false) String action,
			Model model) {

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
			insumoVehiculo.setInsumoId(csv.getInsumoId());
			insumoVehiculo.setInsumoPrecio(csv.getInsumoPrecio());

			Insumo insumo = new Insumo();
			insumo.setInsumoId(csv.getInsumoId());
			insumo.setInsumoDescripcion(csv.getInsumoDescripcion());
			insumo.setInsumoPrecio(csv.getInsumoPrecio());

			// Verificar si ya existe un cliente con el mismo código
			if (repoCli.existsById(csv.getIdCliente())) {
				model.addAttribute("mensaje", "El código de Cliente ya existe");
			} else {
				try {
					Cliente newcliente = repoCli.save(cliente);

					vehiculo.setClienteId(newcliente.getClienteId());
					repoVehi.save(vehiculo);

					Servicio nuevoServicio = repoServ.save(servicio);
					insumoVehiculo.setServicioId(nuevoServicio.getServicioId());

					repoInVe.save(insumoVehiculo).toString();
					
					
					System.out.print("ESTO RESULTO : " + insumoVehiculo.getInsumoId());
					
					model.addAttribute("mensaje", "Cliente registrado correctamente");
				} catch (Exception e) {
					System.out.print("ESTO NO RESULTO : " + insumoVehiculo);
				}
			}
		}

		return "PgCSV";
	}

}
