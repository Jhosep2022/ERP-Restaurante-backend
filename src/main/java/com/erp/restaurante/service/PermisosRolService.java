package com.erp.restaurante.service;

import com.erp.restaurante.dto.PermisosRolDto;
import com.erp.restaurante.entity.PermisosRol;
import com.erp.restaurante.entity.Permisos;
import com.erp.restaurante.entity.Roles;
import com.erp.restaurante.repository.PermisosRepository;
import com.erp.restaurante.repository.PermisosRolRepository;
import com.erp.restaurante.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermisosRolService {

    @Autowired
    private PermisosRolRepository permisosRolRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PermisosRepository permisosRepository;

    public List<PermisosRolDto> getAllPermisosRoles() {
        return permisosRolRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PermisosRolDto getPermisosRolById(Integer id) {
        Optional<PermisosRol> permisosRol = permisosRolRepository.findById(id);
        return permisosRol.map(this::convertToDto).orElse(null);
    }

    public PermisosRolDto createPermisosRol(PermisosRolDto permisosRolDto) {
        Roles rol = rolesRepository.findById(permisosRolDto.getRolId()).orElse(null);
        Permisos permiso = permisosRepository.findById(permisosRolDto.getPermisoId()).orElse(null);

        if (rol != null && permiso != null) {
            PermisosRol permisosRol = new PermisosRol();
            permisosRol.setRol(rol);
            permisosRol.setPermiso(permiso);
            permisosRol.setStatus(permisosRolDto.getStatus()); // Set status
            permisosRol = permisosRolRepository.save(permisosRol);
            return convertToDto(permisosRol);
        }
        return null;
    }

    public PermisosRolDto updatePermisosRol(Integer id, PermisosRolDto permisosRolDto) {
        Optional<PermisosRol> permisosRolOptional = permisosRolRepository.findById(id);
        if (permisosRolOptional.isPresent()) {
            PermisosRol permisosRol = permisosRolOptional.get();
            Roles rol = rolesRepository.findById(permisosRolDto.getRolId()).orElse(null);
            Permisos permiso = permisosRepository.findById(permisosRolDto.getPermisoId()).orElse(null);

            if (rol != null && permiso != null) {
                permisosRol.setRol(rol);
                permisosRol.setPermiso(permiso);
                permisosRol.setStatus(permisosRolDto.getStatus()); // Set status
                permisosRol = permisosRolRepository.save(permisosRol);
                return convertToDto(permisosRol);
            }
        }
        return null;
    }

    public boolean deletePermisosRol(Integer id) {
        if (permisosRolRepository.existsById(id)) {
            permisosRolRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private PermisosRolDto convertToDto(PermisosRol permisosRol) {
        return new PermisosRolDto(
                permisosRol.getPermisosRolesId(),
                permisosRol.getRol().getId(),
                permisosRol.getPermiso().getId(),
                permisosRol.getStatus()
        );
    }
}
