package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Horariostrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariostrabajoRepository extends JpaRepository<Horariostrabajo, Integer> {
    // Puedes agregar métodos adicionales si es necesario, como búsqueda por día de la semana, usuario, etc.
}
