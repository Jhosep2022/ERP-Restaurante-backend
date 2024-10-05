package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Registroentradasalida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface RegistroentradasalidaRepository extends JpaRepository<Registroentradasalida, Integer> {
    boolean existsByFechaAndHoraMarcadaAndUsuario_Id(LocalDate fecha, LocalTime horaMarcada, Long usuarioId);
}
