package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpuestoRepository extends JpaRepository<Impuesto, Integer> {
}
