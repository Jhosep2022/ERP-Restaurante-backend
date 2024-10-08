package com.erp.restaurante.controller;

import com.erp.restaurante.config.JwtUtil;
import com.erp.restaurante.dto.HorarioTrabajoDto;
import com.erp.restaurante.service.HorariosTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horariostrabajo")
public class HorariosTrabajoController {

    @Autowired
    private HorariosTrabajoService horariosTrabajoService;

    @Autowired
    private JwtUtil jwtUtil;

    // Endpoint para obtener todos los horarios
    @GetMapping("/all")
    public ResponseEntity<List<HorarioTrabajoDto>> getAllHorariosTrabajo(@RequestHeader("Authorization") String token) {
        // Validar el token JWT antes de proceder
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build(); // Retornar 401 Unauthorized si el token no es válido
        }

        return ResponseEntity.ok(horariosTrabajoService.getAllHorariosTrabajo());
    }

    // Endpoint para obtener un horario por ID
    @GetMapping("/{id}")
    public ResponseEntity<HorarioTrabajoDto> getHorarioTrabajoById(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        // Validar el token JWT antes de proceder
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build(); // Retornar 401 Unauthorized si el token no es válido
        }

        Optional<HorarioTrabajoDto> horarioDto = horariosTrabajoService.getHorarioTrabajoById(id);
        return horarioDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo horario con validación de token JWT
    @PostMapping("/create")
    public ResponseEntity<HorarioTrabajoDto> createHorarioTrabajo(
            @RequestBody HorarioTrabajoDto horariostrabajoDto,
            @RequestHeader("Authorization") String token) {

        // Validar el token JWT antes de proceder
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build(); // Retornar 401 Unauthorized si el token no es válido
        }

        return ResponseEntity.ok(horariosTrabajoService.createHorarioTrabajo(horariostrabajoDto));
    }

    // Endpoint para actualizar un horario existente
    @PutMapping("/update/{id}")
    public ResponseEntity<HorarioTrabajoDto> updateHorarioTrabajo(
            @PathVariable Integer id,
            @RequestBody HorarioTrabajoDto updatedHorarioTrabajoDto,
            @RequestHeader("Authorization") String token) {

        // Validar el token JWT antes de proceder
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build(); // Retornar 401 Unauthorized si el token no es válido
        }

        Optional<HorarioTrabajoDto> updatedHorario = horariosTrabajoService.updateHorarioTrabajo(id, updatedHorarioTrabajoDto);
        return updatedHorario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un horario por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHorarioTrabajo(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        // Validar el token JWT antes de proceder
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build(); // Retornar 401 Unauthorized si el token no es válido
        }

        horariosTrabajoService.deleteHorarioTrabajo(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para obtener horarios por fecha
    @GetMapping("/byFecha")
    public ResponseEntity<List<HorarioTrabajoDto>> getHorariosTrabajoByFecha(
            @RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
            @RequestHeader("Authorization") String token) {

        // Validar el token JWT antes de proceder
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build(); // Retornar 401 Unauthorized si el token no es válido
        }

        List<HorarioTrabajoDto> horarios = horariosTrabajoService.getHorariosTrabajoByFecha(fecha);
        return ResponseEntity.ok(horarios);
    }
}
