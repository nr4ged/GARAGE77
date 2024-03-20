package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_insumo")
@Data
public class Insumo {

    @Id
    @Column (name = "cod_insumo")
    private String codInsumo;
    @Column (name = "des_insumo")
    private String desInsumo;
    
}
