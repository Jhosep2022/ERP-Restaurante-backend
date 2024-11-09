package com.erp.restaurante.controller;

import com.erp.restaurante.dto.PermisosRolDto;
import com.erp.restaurante.service.PermisosRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos-rol")
public class PermisosRolController {

    @Autowired
    private PermisosRolService permisosRolService;

    @GetMapping("/all")
    public ResponseEntity<List<PermisosRolDto>> getAllPermisosRoles() {
        List<PermisosRolDto> permisosRoles = permisosRolService.getAllPermisosRoles();
        return ResponseEntity.ok(permisosRoles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermisosRolDto> getPermisosRolById(@PathVariable Integer id) {
        PermisosRolDto permisosRol = permisosRolService.getPermisosRolById(id);
        return permisosRol != null ? ResponseEntity.ok(permisosRol) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PermisosRolDto> createPermisosRol(@RequestBody PermisosRolDto permisosRolDto) {
        PermisosRolDto createdPermisosRol = permisosRolService.createPermisosRol(permisosRolDto);
        return createdPermisosRol != null ? ResponseEntity.ok(createdPermisosRol) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermisosRolDto> updatePermisosRol(@PathVariable Integer id, @RequestBody PermisosRolDto permisosRolDto) {
        PermisosRolDto updatedPermisosRol = permisosRolService.updatePermisosRol(id, permisosRolDto);
        return updatedPermisosRol != null ? ResponseEntity.ok(updatedPermisosRol) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermisosRol(@PathVariable Integer id) {
        boolean deleted = permisosRolService.deletePermisosRol(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
