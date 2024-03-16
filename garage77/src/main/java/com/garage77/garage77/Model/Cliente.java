package com.garage77.garage77.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente {

    @Id
    private String cod_cliente;
    private String nombre_cliente;
    private String telefono_cliente;
    private String dni_cliente;
    private String hora_recep_cliente;
    private String hora_entreg_cliente;


    @Override
    public String toString() {
        return "Cliente [cod_cliente=" + cod_cliente + ", nombre_cliente=" + nombre_cliente + ", telefono_cliente="
                + telefono_cliente + ", dni_cliente=" + dni_cliente + ", hora_recep_cliente=" + hora_recep_cliente
                + ", hora_entreg_cliente=" + hora_entreg_cliente + "]";
    }
    
}
