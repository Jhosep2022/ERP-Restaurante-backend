package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientesRepository extends JpaRepository<Ingredientes, Integer> {
}
