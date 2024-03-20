package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_servicios")
@Data
public class Servicio {
    

    @Id
    @Column(name = "cod_servicio")
    private String codServicio;

    @Column(name = "nombre_cliente")
    private String nombre;
    @Column(name = "telefono_cliente")
    private String telefono;
    // @Column(name = "dni_cliente")
    // private String dni;
    // @Column(name = "hora_recep_cliente")
    // private String horaRecep;
    // @Column(name = "hora_entreg_cliente")
    // private String horaEntrega;
    // @Column(name = "fecha_cliente")
    // private String fecha;

    // @ManyToOne
	// @JoinColumn(name = "nombre", insertable = false, updatable = false)
	// private Cliente objCliente;

    @Column (name = "placa_vehiculo")
    private String placa;
    @Column (name = "año_vehiculo")
    private String añoVehiculo;

    // @ManyToOne
	// @JoinColumn(name = "placa", insertable = false, updatable = false)
	// private Vehiculo objVehiculo;


    // @Column (name = "km_actual_vehiculo")
    // private String kmActual;
    // @Column (name = "km_aprox_vehiculo")
    // private String kmAprox;
    // private String marca;
    // private String modelo;
}
