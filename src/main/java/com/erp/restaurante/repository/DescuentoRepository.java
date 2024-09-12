package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescuentoRepository extends JpaRepository<Descuento, Integer> {
}
