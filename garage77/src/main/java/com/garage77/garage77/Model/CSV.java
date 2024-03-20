package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CSV {

    
    private String nombreCliente;
    private String telefonoCliente;
    private String dniCliente;
    private String horaRecep;
    private String horaEntrega;
    private String fechaCliente;
    
    // private String codInsumo;
    // private String desInsumo;
    
    private String placa;
    private String añoVehiculo;
    private String kmActual;
    private String kmAprox;
    private String marca;
    private String modelo;

}
