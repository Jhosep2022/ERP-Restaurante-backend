package com.erp.restaurante.controller;

import com.erp.restaurante.dto.BonosDto;
import com.erp.restaurante.service.BonosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bonos")
public class BonosController {

    @Autowired
    private BonosService bonosService;

    // Endpoint para obtener todos los bonos
    @GetMapping("/all")
    public ResponseEntity<List<BonosDto>> getAllBonos() {
        List<BonosDto> bonosList = bonosService.getAllBonos();
        return ResponseEntity.ok(bonosList);
    }

    // Endpoint para obtener un bono por ID
    @GetMapping("/{id}")
    public ResponseEntity<BonosDto> getBonosById(@PathVariable Integer id) {
        Optional<BonosDto> bonosDto = bonosService.getBonosById(id);
        return bonosDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo bono
    @PostMapping("/create")
    public ResponseEntity<BonosDto> createBonos(@RequestBody BonosDto bonosDto) {
        BonosDto createdBono = bonosService.createBonos(bonosDto);
        return ResponseEntity.ok(createdBono);
    }

    // Endpoint para actualizar un bono existente
    @PutMapping("/update/{id}")
    public ResponseEntity<BonosDto> updateBonos(@PathVariable Integer id, @RequestBody BonosDto bonosDto) {
        Optional<BonosDto> updatedBono = bonosService.updateBonos(id, bonosDto);
        return updatedBono.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un bono por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBonos(@PathVariable Integer id) {
        bonosService.deleteBonos(id);
        return ResponseEntity.noContent().build();
    }
}
