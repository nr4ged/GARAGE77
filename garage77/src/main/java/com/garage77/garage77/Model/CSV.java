package com.garage77.garage77.Model;


import lombok.Data;


@Data
public class CSV {
    
    //Cliente
    private int idCliente;
    private String nombreCliente;
    private String telefonoCliente;
    private String dniCliente;
    //Vehiculo
    private String placa;
    private int añoVehiculo;
    private double kmActual;
    private double kmAprox;
    private String marca;
    private String modelo;

    //Servicio
    private int servicioId;
    private String servicioHoraRecep;
    private String servicioHoraEntrega;
    private double servicioTotal;

    //InsumoVehiculo
    private int insumoVehiculoId;
    //Insumo
    private int insumoId;
    private String insumoDescripcion;
    private double insumoPrecio;
}
