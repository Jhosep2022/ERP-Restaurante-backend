package com.erp.restaurante.controller;

import com.erp.restaurante.config.JwtUtil;
import com.erp.restaurante.entity.Sucursal;
import com.erp.restaurante.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private JwtUtil jwtUtil;

    // Obtener todas las sucursales
    @GetMapping("/all")
    public ResponseEntity<List<Sucursal>> getAllSucursales(@RequestHeader("Authorization") String token) {
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();  // Retornar 401 Unauthorized si el token no es válido
        }

        List<Sucursal> sucursales = sucursalService.getAllSucursales();
        return ResponseEntity.ok(sucursales);
    }

    // Obtener una sucursal por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursalById(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        Sucursal sucursal = sucursalService.findById(id);
        if (sucursal != null) {
            return ResponseEntity.ok(sucursal);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva sucursal
    @PostMapping
    public ResponseEntity<Sucursal> createSucursal(
            @RequestBody Sucursal sucursal,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        Sucursal savedSucursal = sucursalService.createSucursal(sucursal);
        return ResponseEntity.ok(savedSucursal);
    }

    // Actualizar una sucursal existente
    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> updateSucursal(
            @PathVariable Integer id,
            @RequestBody Sucursal updatedSucursal,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        Sucursal sucursal = sucursalService.updateSucursal(id, updatedSucursal);
        if (sucursal != null) {
            return ResponseEntity.ok(sucursal);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar una sucursal por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        boolean deleted = sucursalService.deleteSucursal(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
