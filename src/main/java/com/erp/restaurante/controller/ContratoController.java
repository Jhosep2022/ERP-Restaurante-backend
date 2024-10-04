package com.erp.restaurante.controller;

import com.erp.restaurante.dto.ContratoDto;
import com.erp.restaurante.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    // Endpoint para obtener todos los contratos
    @GetMapping("/all")
    public ResponseEntity<List<ContratoDto>> getAllContratos() {
        return ResponseEntity.ok(contratoService.getAllContratos());
    }

    // Endpoint para obtener un contrato por ID
    @GetMapping("/{id}")
    public ResponseEntity<ContratoDto> getContratoById(@PathVariable Integer id) {
        Optional<ContratoDto> contratoDto = contratoService.getContratoById(id);
        return contratoDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo contrato
    @PostMapping("/create")
    public ResponseEntity<ContratoDto> createContrato(@RequestBody ContratoDto contratoDto) {
        return ResponseEntity.ok(contratoService.createContrato(contratoDto));
    }

    // Endpoint para actualizar un contrato existente
    @PutMapping("/update/{id}")
    public ResponseEntity<ContratoDto> updateContrato(@PathVariable Integer id, @RequestBody ContratoDto contratoDto) {
        Optional<ContratoDto> updatedContrato = contratoService.updateContrato(id, contratoDto);
        return updatedContrato.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un contrato por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable Integer id) {
        contratoService.deleteContrato(id);
        return ResponseEntity.noContent().build();
    }
}
