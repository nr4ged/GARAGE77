package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_vehiculo")
@Data

public class Vehiculo {

    @Id
    @Column (name = "vehiculo_placa")
    private String placa;
    @Column (name = "vehiculo_año")
    //INTEGER AÑO
    private int añoVehiculo;
    @Column (name = "vehiculo_km_actual")
    //Double 
    private double kmActual;
    @Column (name = "vehiculo_km_aprox")
    //Double 
    private double kmAprox;
    @Column (name = "vehiculo_marca")
    private String marca;
    @Column (name = "vehiculo_modelo")
    private String modelo;
    @Column(name = "cliente_id")
    private int clienteId;
    
}
