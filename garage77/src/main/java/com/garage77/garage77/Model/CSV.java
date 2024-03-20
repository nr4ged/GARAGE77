package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
public class CSV {
    
    private String nombreCliente;
    private String telefonoCliente;
    private String dniCliente;
    private String horaRecep;
    private String horaEntrega;
    private String fechaCliente;


    private String placa;
    private String añoVehiculo;
    private String kmActual;
    private String kmAprox;
    private String marca;
    private String modelo;

    private String codInsumo;
    private String desInsumo;

    private String codServicio;

}
