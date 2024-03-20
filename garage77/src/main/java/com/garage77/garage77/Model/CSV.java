package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CSV {

    
    private String nombreCliente;
    
    private String codigoServicio;
    
    private String placa;

}
