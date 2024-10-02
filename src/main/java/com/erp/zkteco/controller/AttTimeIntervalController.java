package com.erp.zkteco.controller;

import com.erp.zkteco.entity.AttTimeInterval;
import com.erp.zkteco.service.AttTimeIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/timeintervals")
public class AttTimeIntervalController {

    @Autowired
    private AttTimeIntervalService attTimeIntervalService;

    // Endpoint para obtener todos los registros de AttTimeInterval
    @GetMapping("/all")
    public ResponseEntity<List<AttTimeInterval>> getAllTimeIntervals() {
        List<AttTimeInterval> timeIntervals = attTimeIntervalService.getAllTimeIntervals();
        return ResponseEntity.ok(timeIntervals);
    }

    // Endpoint para obtener un AttTimeInterval por su ID
    @GetMapping("/{id}")
    public ResponseEntity<AttTimeInterval> getTimeIntervalById(@PathVariable Long id) {  // Cambiado a Long
        Optional<AttTimeInterval> timeInterval = attTimeIntervalService.getTimeIntervalById(id);
        return timeInterval.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para obtener AttTimeIntervals por alias
    @GetMapping("/alias/{alias}")
    public ResponseEntity<List<AttTimeInterval>> getTimeIntervalsByAlias(@PathVariable String alias) {
        List<AttTimeInterval> timeIntervals = attTimeIntervalService.getTimeIntervalsByAlias(alias);
        if (timeIntervals.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(timeIntervals);
    }

    // Endpoint para obtener AttTimeIntervals por companyId
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<AttTimeInterval>> getTimeIntervalsByCompanyId(@PathVariable Long companyId) {  // Cambiado a Long
        List<AttTimeInterval> timeIntervals = attTimeIntervalService.getTimeIntervalsByCompanyId(companyId);
        if (timeIntervals.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(timeIntervals);
    }

    // Endpoint para crear un nuevo AttTimeInterval (POST)
    @PostMapping
    public ResponseEntity<AttTimeInterval> createTimeInterval(@RequestBody AttTimeInterval timeInterval) {
        AttTimeInterval savedTimeInterval = attTimeIntervalService.createTimeInterval(timeInterval);
        return ResponseEntity.ok(savedTimeInterval);
    }

    // Endpoint para actualizar un AttTimeInterval existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<AttTimeInterval> updateTimeInterval(@PathVariable Long id, @RequestBody AttTimeInterval updatedTimeInterval) {  // Cambiado a Long
        Optional<AttTimeInterval> timeInterval = attTimeIntervalService.updateTimeInterval(id, updatedTimeInterval);
        return timeInterval.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un AttTimeInterval por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeInterval(@PathVariable Long id) {  // Cambiado a Long
        Optional<AttTimeInterval> timeInterval = attTimeIntervalService.getTimeIntervalById(id);
        if (timeInterval.isPresent()) {
            attTimeIntervalService.deleteTimeInterval(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
