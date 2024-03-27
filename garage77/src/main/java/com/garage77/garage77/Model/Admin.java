package com.garage77.garage77.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "tb_admin")
@Data
public class Admin 

{
	
	@Id
	@Column (name = "admin_usuario")
	private String adminUsu;
	@Column (name = "admin_contrasena")
	private String adminContra;
	@Column (name = "admin_nombre")
	private String adminNombre;
	@Column (name = "admin_apellido")
	private String adminApellido;

    @Override
    public String toString() {
        return "Admin [adminUsu=" + adminUsu + ", adminContra=" + adminContra + ", adminNombre=" + adminNombre
                + ", adminApellido=" + adminApellido + "]";
    }

}
