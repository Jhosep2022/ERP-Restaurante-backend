package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Vacaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacacionesRepository extends JpaRepository<Vacaciones, Integer> {
}
