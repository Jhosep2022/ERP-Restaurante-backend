package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturasRepository extends JpaRepository<Facturas, Integer> {
}
