package com.erp.restaurante.controller;

import com.erp.restaurante.config.JwtUtil;
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

    @Autowired
    private JwtUtil jwtUtil;

    // Obtener todos los turnos
    @GetMapping("/all")
    public ResponseEntity<List<Turno>> getAllTurnos(@RequestHeader("Authorization") String token) {
        // Extraer el token y validar
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();  // Retornar 401 Unauthorized si el token no es válido
        }

        List<Turno> turnos = turnoService.getAllTurnos();
        return ResponseEntity.ok(turnos);
    }

    // Obtener un turno por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Turno> getTurnoById(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        // Extraer el token y validar
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();  // Retornar 401 Unauthorized si el token no es válido
        }

        Optional<Turno> turno = turnoService.getTurnoById(id);
        return turno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo turno (POST)
    @PostMapping
    public ResponseEntity<Turno> createTurno(
            @RequestBody Turno turno,
            @RequestHeader("Authorization") String token) {

        // Extraer el token y validar
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();  // Retornar 401 Unauthorized si el token no es válido
        }

        Turno savedTurno = turnoService.createTurno(turno);
        return ResponseEntity.ok(savedTurno);
    }

    // Actualizar un turno existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Turno> updateTurno(
            @PathVariable Integer id,
            @RequestBody Turno updatedTurno,
            @RequestHeader("Authorization") String token) {

        // Extraer el token y validar
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();  // Retornar 401 Unauthorized si el token no es válido
        }

        Optional<Turno> turno = turnoService.updateTurno(id, updatedTurno);
        return turno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un turno por su ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurno(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        // Extraer el token y validar
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();  // Retornar 401 Unauthorized si el token no es válido
        }

        Optional<Turno> turno = turnoService.getTurnoById(id);
        if (turno.isPresent()) {
            turnoService.deleteTurno(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
