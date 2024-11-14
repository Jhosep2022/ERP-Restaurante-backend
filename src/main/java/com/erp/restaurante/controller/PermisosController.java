package com.erp.restaurante.controller;

import com.erp.restaurante.dto.PermisosDto;
import com.erp.restaurante.service.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisosController {

    @Autowired
    private PermisosService permisosService;

    // Obtener todos los permisos
    @GetMapping
    public ResponseEntity<List<PermisosDto>> obtenerTodos() {
        return ResponseEntity.ok(permisosService.obtenerTodos());
    }

    // Obtener permiso por ID
    @GetMapping("/{id}")
    public ResponseEntity<PermisosDto> obtenerPorId(@PathVariable Integer id) {
        PermisosDto permiso = permisosService.obtenerPorId(id);
        return permiso != null ? ResponseEntity.ok(permiso) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo permiso
    @PostMapping
    public ResponseEntity<PermisosDto> crear(@RequestBody PermisosDto permisosDto) {
        PermisosDto nuevoPermiso = permisosService.guardar(permisosDto);
        return ResponseEntity.ok(nuevoPermiso);
    }

    // Actualizar un permiso existente
    @PutMapping("/{id}")
    public ResponseEntity<PermisosDto> actualizar(@PathVariable Integer id, @RequestBody PermisosDto permisosDto) {
        PermisosDto permisoActualizado = permisosService.actualizar(id, permisosDto);
        return permisoActualizado != null ? ResponseEntity.ok(permisoActualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar un permiso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        permisosService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
