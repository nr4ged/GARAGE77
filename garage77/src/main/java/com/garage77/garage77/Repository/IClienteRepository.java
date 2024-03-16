package com.garage77.garage77.Repository;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;


import com.garage77.garage77.Model.Cliente;

public interface IClienteRepository extends JpaRepository <Cliente, String>{

}
