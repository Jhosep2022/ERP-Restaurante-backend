package com.erp.restaurante.controller;

import com.erp.restaurante.dto.AuditoriaDto;
import com.erp.restaurante.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditorias")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    // Obtener todas las auditorías
    @GetMapping
    public ResponseEntity<List<AuditoriaDto>> getAllAuditorias() {
        List<AuditoriaDto> auditorias = auditoriaService.findAll();
        return ResponseEntity.ok(auditorias);
    }

    // Obtener una auditoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<AuditoriaDto> getAuditoriaById(@PathVariable Integer id) {
        AuditoriaDto auditoria = auditoriaService.findById(id);
        if (auditoria != null) {
            return ResponseEntity.ok(auditoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva auditoría
    @PostMapping
    public ResponseEntity<AuditoriaDto> createAuditoria(@RequestBody AuditoriaDto auditoriaDto) {
        AuditoriaDto createdAuditoria = auditoriaService.create(auditoriaDto);
        return ResponseEntity.ok(createdAuditoria);
    }

    // Actualizar una auditoría existente
    @PutMapping("/{id}")
    public ResponseEntity<AuditoriaDto> updateAuditoria(@PathVariable Integer id, @RequestBody AuditoriaDto auditoriaDto) {
        AuditoriaDto updatedAuditoria = auditoriaService.update(id, auditoriaDto);
        if (updatedAuditoria != null) {
            return ResponseEntity.ok(updatedAuditoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una auditoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditoria(@PathVariable Integer id) {
        auditoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
