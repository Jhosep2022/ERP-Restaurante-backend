package com.erp.restaurante.controller;

import com.erp.restaurante.config.JwtUtil;
import com.erp.restaurante.dto.RegistroEntradaSalidaDto;
import com.erp.restaurante.service.RegistroEntradasSalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegistroEntradaSalidaController {

    @Autowired
    private RegistroEntradasSalidaService registroEntradasSalidaService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/all")
    public ResponseEntity<List<RegistroEntradaSalidaDto>> getAllRegistros(@RequestHeader("Authorization") String token) {
        if (!isValidToken(token)) return ResponseEntity.status(401).build();

        List<RegistroEntradaSalidaDto> registros = registroEntradasSalidaService.getAllRegistros();
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<RegistroEntradaSalidaDto>> getRegistrosByUsuarioId(
            @PathVariable Long usuarioId,
            @RequestHeader("Authorization") String token) {

        if (!isValidToken(token)) return ResponseEntity.status(401).build();

        List<RegistroEntradaSalidaDto> registros = registroEntradasSalidaService.getRegistrosByUsuarioId(usuarioId);
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<RegistroEntradaSalidaDto>> getRegistrosByFecha(
            @PathVariable LocalDate fecha,
            @RequestHeader("Authorization") String token) {

        if (!isValidToken(token)) return ResponseEntity.status(401).build();

        List<RegistroEntradaSalidaDto> registros = registroEntradasSalidaService.getRegistrosByFecha(fecha);
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/hora/{horaMarcada}")
    public ResponseEntity<List<RegistroEntradaSalidaDto>> getRegistrosByHoraMarcada(
            @PathVariable LocalTime horaMarcada,
            @RequestHeader("Authorization") String token) {

        if (!isValidToken(token)) return ResponseEntity.status(401).build();

        List<RegistroEntradaSalidaDto> registros = registroEntradasSalidaService.getRegistrosByHoraMarcada(horaMarcada);
        return ResponseEntity.ok(registros);
    }

    private boolean isValidToken(String token) {
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);
        return username != null && jwtUtil.validateToken(extractedToken, username);
    }
}
