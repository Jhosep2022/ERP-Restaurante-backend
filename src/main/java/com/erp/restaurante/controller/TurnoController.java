package com.erp.restaurante.controller;

import com.erp.restaurante.entity.Turno;
import com.erp.restaurante.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    // Obtener todos los turnos
    @GetMapping("/all")
    public ResponseEntity<List<Turno>> getAllTurnos() {
        List<Turno> turnos = turnoService.getAllTurnos();
        return ResponseEntity.ok(turnos);
    }

    // Obtener un turno por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Turno> getTurnoById(@PathVariable Integer id) {
        Optional<Turno> turno = turnoService.getTurnoById(id);
        return turno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo turno (POST)
    @PostMapping
    public ResponseEntity<Turno> createTurno(@RequestBody Turno turno) {
        Turno savedTurno = turnoService.createTurno(turno);
        return ResponseEntity.ok(savedTurno);
    }

    // Actualizar un turno existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Turno> updateTurno(@PathVariable Integer id, @RequestBody Turno updatedTurno) {
        Optional<Turno> turno = turnoService.updateTurno(id, updatedTurno);
        return turno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un turno por su ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurno(@PathVariable Integer id) {
        Optional<Turno> turno = turnoService.getTurnoById(id);
        if (turno.isPresent()) {
            turnoService.deleteTurno(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
