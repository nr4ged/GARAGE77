package com.garage77.garage77.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage77.garage77.Model.Insumo;

public interface InsumoRepository extends JpaRepository
<Insumo, String>{
    
}
