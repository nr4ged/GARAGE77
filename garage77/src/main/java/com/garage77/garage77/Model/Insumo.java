package com.garage77.garage77.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_insumo")
@Data
public class Insumo {

    @Id
    private String codInsumo;

    private String desInsumo;
    
}
