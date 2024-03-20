package com.garage77.garage77.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage77.garage77.Model.Vehiculo;

public interface IVehiculoRepository extends JpaRepository
<Vehiculo, String>{
    
}
