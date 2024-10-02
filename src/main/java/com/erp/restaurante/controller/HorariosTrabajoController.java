package com.erp.restaurante.controller;

import com.erp.restaurante.dto.HorarioTrabajoDto;
import com.erp.restaurante.service.HorariosTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horariostrabajo")
public class HorariosTrabajoController {

    @Autowired
    private HorariosTrabajoService horariosTrabajoService;

    // Endpoint para obtener todos los horarios
    @GetMapping("/all")
    public ResponseEntity<List<HorarioTrabajoDto>> getAllHorariosTrabajo() {
        return ResponseEntity.ok(horariosTrabajoService.getAllHorariosTrabajo());
    }

    // Endpoint para obtener un horario por ID
    @GetMapping("/{id}")
    public ResponseEntity<HorarioTrabajoDto> getHorarioTrabajoById(@PathVariable Integer id) {
        Optional<HorarioTrabajoDto> horarioDto = horariosTrabajoService.getHorarioTrabajoById(id);
        return horarioDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo horario
    @PostMapping("/create")
    public ResponseEntity<HorarioTrabajoDto> createHorarioTrabajo(@RequestBody HorarioTrabajoDto horariostrabajoDto) {
        return ResponseEntity.ok(horariosTrabajoService.createHorarioTrabajo(horariostrabajoDto));
    }

    // Endpoint para actualizar un horario existente
    @PutMapping("/update/{id}")
    public ResponseEntity<HorarioTrabajoDto> updateHorarioTrabajo(@PathVariable Integer id, @RequestBody HorarioTrabajoDto updatedHorarioTrabajoDto) {
        Optional<HorarioTrabajoDto> updatedHorario = horariosTrabajoService.updateHorarioTrabajo(id, updatedHorarioTrabajoDto);
        return updatedHorario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un horario por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHorarioTrabajo(@PathVariable Integer id) {
        horariosTrabajoService.deleteHorarioTrabajo(id);
        return ResponseEntity.noContent().build();
    }
}
