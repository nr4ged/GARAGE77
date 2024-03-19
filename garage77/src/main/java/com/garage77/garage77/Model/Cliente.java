package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente {

    @Id
    @Column(name = "nombre_cliente")
    private String nombre;
    @Column(name = "telefono_cliente")
    private String telefono;
    @Column(name = "dni_cliente")
    private String dni;
    @Column(name = "hora_recep_cliente")
    private String horaRecep;
    @Column(name = "hora_entreg_cliente")
    private String horaEntrega;
    @Column(name = "fecha_cliente")
    private String fecha;
    
    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", telefono=" + telefono + ", dni=" + dni + ", horaRecep=" + horaRecep
                + ", horaEntrega=" + horaEntrega + ", fecha=" + fecha + "]";
    }

   
}
