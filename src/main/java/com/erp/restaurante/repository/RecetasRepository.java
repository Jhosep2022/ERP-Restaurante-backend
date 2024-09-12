package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Recetas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetasRepository extends JpaRepository<Recetas, Integer> {
}
