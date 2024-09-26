package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

    Sucursal findByNombre(String nombre);

}

