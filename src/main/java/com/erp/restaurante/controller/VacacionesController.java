package com.erp.restaurante.controller;

import com.erp.restaurante.config.JwtUtil;
import com.erp.restaurante.dto.ResponseDto;
import com.erp.restaurante.dto.VacacionesDto;
import com.erp.restaurante.service.VacacionesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/vacaciones")
public class VacacionesController {

    private static final Logger logger = LoggerFactory.getLogger(VacacionesController.class);
    private final VacacionesService vacacionesService;
    private final JwtUtil jwtUtil;

    @Autowired
    public VacacionesController(VacacionesService vacacionesService, JwtUtil jwtUtil) {
        this.vacacionesService = vacacionesService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/crear")
    public ResponseEntity<ResponseDto<VacacionesDto>> crearVacaciones(
            @RequestBody VacacionesDto vacacionesDto,
            @RequestHeader("Authorization") String token) {

        // Extraer el token de la cabecera y verificarlo
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        // Validar el token antes de permitir la creación
        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            logger.warn("Token inválido o usuario no autorizado para crear vacaciones");
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        logger.info("Usuario autorizado para crear vacaciones: {}", username);
        VacacionesDto nuevaVacacion = vacacionesService.createVacaciones(vacacionesDto);
        return ResponseEntity.ok(new ResponseDto<>(true, "Vacaciones creadas exitosamente", nuevaVacacion));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<VacacionesDto>>> obtenerTodasLasVacaciones(
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            logger.warn("Token inválido o usuario no autorizado para obtener vacaciones");
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        logger.info("Usuario autorizado para obtener vacaciones: {}", username);
        List<VacacionesDto> vacaciones = vacacionesService.getAllVacaciones();
        return ResponseEntity.ok(new ResponseDto<>(true, "Vacaciones obtenidas exitosamente", vacaciones));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<VacacionesDto>> obtenerVacacionesPorId(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            logger.warn("Token inválido o usuario no autorizado para obtener vacaciones");
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        logger.info("Usuario autorizado para obtener vacaciones con ID: {}", id);
        VacacionesDto vacaciones = vacacionesService.getVacacionesById(id)
                .orElseThrow(() -> new RuntimeException("Vacaciones no encontradas"));
        return ResponseEntity.ok(new ResponseDto<>(true, "Vacaciones obtenidas exitosamente", vacaciones));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ResponseDto<VacacionesDto>> actualizarVacaciones(
            @PathVariable Integer id,
            @RequestBody VacacionesDto vacacionesDto,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            logger.warn("Token inválido o usuario no autorizado para actualizar vacaciones");
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        logger.info("Usuario autorizado para actualizar vacaciones con ID: {}", id);
        VacacionesDto vacacionActualizada = vacacionesService.updateVacaciones(id, vacacionesDto)
                .orElseThrow(() -> new RuntimeException("Vacaciones no encontradas"));
        return ResponseEntity.ok(new ResponseDto<>(true, "Vacaciones actualizadas exitosamente", vacacionActualizada));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ResponseDto<Void>> eliminarVacaciones(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            logger.warn("Token inválido o usuario no autorizado para eliminar vacaciones");
            return ResponseEntity.status(401)
                    .body(new ResponseDto<>(false, "Token inválido o usuario no autorizado", null));
        }

        logger.info("Usuario autorizado para eliminar vacaciones con ID: {}", id);
        vacacionesService.deleteVacaciones(id);
        return ResponseEntity.ok(new ResponseDto<>(true, "Vacaciones eliminadas exitosamente", null));
    }
}
