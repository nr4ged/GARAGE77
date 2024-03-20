package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_vehiculo")
@Data

public class Vehiculo {

    @Id
    @Column (name = "placa_vehiculo")
    private String placa;
    @Column (name = "año_vehiculo")
    private String añoVehiculo;
    @Column (name = "km_actual_vehiculo")
    private String kmActual;
    @Column (name = "km_aprox_vehiculo")
    private String kmAprox;
    private String marca;
    private String modelo;

    @Column(name = "nombre_cliente")
    private String nombre;
    
}
