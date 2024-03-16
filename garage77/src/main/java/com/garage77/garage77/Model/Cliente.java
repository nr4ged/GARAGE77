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
    private String codCliente;
    private String nombreCliente;
    private String telefonoCliente;
    private String dniCliente;
    private String horaRecepCliente;
    private String horaEntregCliente;
    
    @Override
    public String toString() {
        return "Cliente [codCliente=" + codCliente + ", nombreCliente=" + nombreCliente + ", telefonoCliente="
                + telefonoCliente + ", dniCliente=" + dniCliente + ", horaRecepCliente=" + horaRecepCliente
                + ", horaEntregCliente=" + horaEntregCliente + "]";
    }


}
