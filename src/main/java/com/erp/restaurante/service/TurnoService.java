package com.erp.restaurante.service;

import com.erp.restaurante.entity.Turno;
import com.erp.restaurante.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    // Obtener todos los turnos
    public List<Turno> getAllTurnos() {
        return turnoRepository.findAll();
    }

    // Obtener un turno por ID
    public Optional<Turno> getTurnoById(Integer id) {
        return turnoRepository.findById(id);
    }

    // Crear un nuevo turno
    public Turno createTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    // Actualizar un turno existente
    public Optional<Turno> updateTurno(Integer id, Turno updatedTurno) {
        return turnoRepository.findById(id).map(turno -> {
            turno.setNombre(updatedTurno.getNombre());
            turno.setDescripcion(updatedTurno.getDescripcion());
            turno.setHoraInicio(updatedTurno.getHoraInicio());
            turno.setHoraFin(updatedTurno.getHoraFin());
            turno.setDia(updatedTurno.getDia());
            return turnoRepository.save(turno);
        });
    }

    // Eliminar un turno
    public void deleteTurno(Integer id) {
        turnoRepository.deleteById(id);
    }
}
