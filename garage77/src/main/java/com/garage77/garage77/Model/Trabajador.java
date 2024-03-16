package com.garage77.garage77.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_trabajador")
@Data
public class Trabajador {
    
    @Id
    private String codTrabajador;
    private String nombreTrabajador;
    private String apellidoTrabajador;
    private String telefonoTrabajador;
    private String dniTrabajador;

    @Override
    public String toString() {
        return "Trabajador [codTrabajador=" + codTrabajador + ", nombreTrabajador=" + nombreTrabajador
                + ", apellidoTrabajador=" + apellidoTrabajador + ", telefonoTrabajador=" + telefonoTrabajador
                + ", dniTrabajador=" + dniTrabajador + "]";
    }

}
