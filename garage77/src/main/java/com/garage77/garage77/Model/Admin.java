package com.garage77.garage77.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_admin")
@Data
public class Admin {
    
    @Id
    private String codAdmin;
    private String nombreAdmin;
    private String apellidoAdmin;
    private String telefonoAdmin;
    private String dniAdmin;

    @Override
    public String toString() {
        return "Admin [codAdmin=" + codAdmin + ", nombreAdmin=" + nombreAdmin + ", apellidoAdmin=" + apellidoAdmin
                + ", telefonoAdmin=" + telefonoAdmin + ", dniAdmin=" + dniAdmin + "]";
    }

}
