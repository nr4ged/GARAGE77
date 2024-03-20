package com.garage77.garage77.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage77.garage77.Model.Servicio;

public interface IServicioRepository extends JpaRepository
<Servicio, String>{
    
}
