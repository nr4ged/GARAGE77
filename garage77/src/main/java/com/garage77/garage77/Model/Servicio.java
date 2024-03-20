package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_servicios")
@Data

public class Servicio {

    @Id
    private String codServicio;

    private String codInsumo;
    
    private String desInsumo;

    @Column(name = "nombre_cliente")
    private String nombre;
    
    private String placaVehiculo;

    private String Marca;

    private String Modelo;
    
}
