package com.erp.restaurante.controller;

import com.erp.restaurante.config.JwtUtil;
import com.erp.restaurante.dto.RolesDto;
import com.erp.restaurante.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @Autowired
    private JwtUtil jwtUtil;

    // Endpoint para obtener todos los roles
    @GetMapping("/all")
    public ResponseEntity<List<RolesDto>> getAllRoles(@RequestHeader("Authorization") String token) {
        // Validar el token JWT antes de proceder
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        List<RolesDto> rolesList = rolesService.getAllRoles();
        return ResponseEntity.ok(rolesList);
    }

    // Endpoint para obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<RolesDto> getRolesById(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        // Validar el token JWT
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        Optional<RolesDto> rolesDto = rolesService.findDtoById(id);
        return rolesDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo rol
    @PostMapping("/create")
    public ResponseEntity<RolesDto> createRoles(
            @RequestBody RolesDto rolesDto,
            @RequestHeader("Authorization") String token) {

        // Validar el token JWT
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        RolesDto createdRole = rolesService.save(rolesDto);
        return ResponseEntity.ok(createdRole);
    }

    // Endpoint para actualizar un rol existente
    @PutMapping("/update/{id}")
    public ResponseEntity<RolesDto> updateRoles(
            @PathVariable Integer id,
            @RequestBody RolesDto rolesDto,
            @RequestHeader("Authorization") String token) {

        // Validar el token JWT
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        Optional<RolesDto> updatedRole = rolesService.update(id, rolesDto);
        return updatedRole.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un rol por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRoles(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token) {

        // Validar el token JWT
        String extractedToken = token.replace("Bearer ", "");
        String username = jwtUtil.extractUsername(extractedToken);

        if (username == null || !jwtUtil.validateToken(extractedToken, username)) {
            return ResponseEntity.status(401).build();
        }

        rolesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
