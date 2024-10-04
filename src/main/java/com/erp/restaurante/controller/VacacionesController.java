package com.erp.restaurante.controller;

import com.erp.restaurante.dto.VacacionesDto;
import com.erp.restaurante.service.VacacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacaciones")
public class VacacionesController {

    @Autowired
    private VacacionesService vacacionesService;

    // Endpoint para obtener todas las vacaciones
    @GetMapping("/all")
    public ResponseEntity<List<VacacionesDto>> getAllVacaciones() {
        List<VacacionesDto> vacacionesList = vacacionesService.getAllVacaciones();
        return ResponseEntity.ok(vacacionesList);
    }

    // Endpoint para obtener vacaciones por ID
    @GetMapping("/{id}")
    public ResponseEntity<VacacionesDto> getVacacionesById(@PathVariable Integer id) {
        Optional<VacacionesDto> vacacionesDto = vacacionesService.getVacacionesById(id);
        return vacacionesDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear nuevas vacaciones
    @PostMapping("/create")
    public ResponseEntity<VacacionesDto> createVacaciones(@RequestBody VacacionesDto vacacionesDto) {
        VacacionesDto createdVacaciones = vacacionesService.createVacaciones(vacacionesDto);
        return ResponseEntity.ok(createdVacaciones);
    }

    // Endpoint para actualizar vacaciones existentes
    @PutMapping("/update/{id}")
    public ResponseEntity<VacacionesDto> updateVacaciones(@PathVariable Integer id, @RequestBody VacacionesDto updatedVacacionesDto) {
        Optional<VacacionesDto> updatedVacaciones = vacacionesService.updateVacaciones(id, updatedVacacionesDto);
        return updatedVacaciones.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar vacaciones por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVacaciones(@PathVariable Integer id) {
        vacacionesService.deleteVacaciones(id);
        return ResponseEntity.noContent().build();
    }
}
