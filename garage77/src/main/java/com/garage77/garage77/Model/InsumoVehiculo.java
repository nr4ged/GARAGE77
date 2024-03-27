package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "tb_insumo_vehiculo")
@Data
public class InsumoVehiculo {

    @Id

    @Column (name = "insumo_vehiculo_id")
    private int insumoVehiculoId;

    @Column (name = "vehiculo_placa")
    private String placa;

    @Column (name = "insumo_id")
    private int insumoId;

    @Column (name = "insumo_precio")
    private double insumoPrecio;

    @Column (name = "servicio_id")
    private int servicioId;  
    
}
