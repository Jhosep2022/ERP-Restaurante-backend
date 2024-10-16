package com.erp.restaurante.controller;

import com.erp.restaurante.dto.DescuentoDto;
import com.erp.restaurante.service.DescuentoService;
import com.erp.restaurante.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descuentos")
public class DescuentoController {

    @Autowired
    private DescuentoService descuentoService;

    @Autowired
    private JwtUtil jwtUtil;

    // Obtener todos los descuentos
    @GetMapping("/all")
    public ResponseEntity<List<DescuentoDto>> getAllDescuentos(@RequestHeader("Authorization") String token) {
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        List<DescuentoDto> descuentos = descuentoService.getAllDescuentos();
        return ResponseEntity.ok(descuentos);
    }

    // Obtener un descuento por ID
    @GetMapping("/{id}")
    public ResponseEntity<DescuentoDto> getDescuentoById(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        DescuentoDto descuento = descuentoService.findById(id);
        if (descuento != null) {
            return ResponseEntity.ok(descuento);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear un nuevo descuento
    @PostMapping
    public ResponseEntity<DescuentoDto> createDescuento(
            @RequestBody DescuentoDto dto,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        DescuentoDto savedDescuento = descuentoService.createDescuento(dto);
        return ResponseEntity.ok(savedDescuento);
    }

    // Actualizar un descuento existente
    @PutMapping("/{id}")
    public ResponseEntity<DescuentoDto> updateDescuento(
            @PathVariable Integer id,
            @RequestBody DescuentoDto dto,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        DescuentoDto updatedDescuento = descuentoService.updateDescuento(id, dto);
        if (updatedDescuento != null) {
            return ResponseEntity.ok(updatedDescuento);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un descuento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDescuento(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        boolean deleted = descuentoService.deleteDescuento(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
