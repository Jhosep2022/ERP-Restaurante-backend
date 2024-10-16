package com.erp.restaurante.controller;

import com.erp.restaurante.dto.HistorialSalariosDto;
import com.erp.restaurante.dto.ResponseDto;
import com.erp.restaurante.service.HistorialSalariosService;
import com.erp.restaurante.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historialsalarios")
public class HistorialSalariosController {

    @Autowired
    private HistorialSalariosService historialSalariosService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/all")
    public ResponseEntity<ResponseDto<List<HistorialSalariosDto>>> getAllHistorialSalarios(
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        List<HistorialSalariosDto> historialSalarios = historialSalariosService.getAllHistorialSalarios();
        return ResponseEntity.ok(new ResponseDto<>(true, "Lista de historial de salarios obtenida con éxito", historialSalarios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<HistorialSalariosDto>> getHistorialSalarioById(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        HistorialSalariosDto historialSalarios = historialSalariosService.findById(id);
        return ResponseEntity.ok(new ResponseDto<>(true, "Historial de salario encontrado", historialSalarios));
    }

    @PostMapping
    public ResponseEntity<ResponseDto<HistorialSalariosDto>> createHistorialSalario(
            @RequestBody HistorialSalariosDto dto,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        HistorialSalariosDto createdHistorialSalario = historialSalariosService.save(dto);
        return ResponseEntity.ok(new ResponseDto<>(true, "Historial de salario creado con éxito", createdHistorialSalario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<HistorialSalariosDto>> updateHistorialSalario(
            @PathVariable Integer id,
            @RequestBody HistorialSalariosDto dto,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        HistorialSalariosDto updatedHistorialSalario = historialSalariosService.update(id, dto);
        return ResponseEntity.ok(new ResponseDto<>(true, "Historial de salario actualizado con éxito", updatedHistorialSalario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteHistorialSalario(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        historialSalariosService.delete(id);
        return ResponseEntity.ok(new ResponseDto<>(true, "Historial de salario eliminado con éxito", null));
    }
}
