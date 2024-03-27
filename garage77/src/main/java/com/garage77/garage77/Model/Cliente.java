package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data

public class Cliente {

    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;
    @Column(name = "cliente_nombre")
    private String clienteNombre;
    @Column(name = "cliente_telefono")
    private String clienteTelefono;
    @Column(name = "cliente_dni")
    private String clienteDni;


       
}
