package com.erp.restaurante.service;

import com.erp.restaurante.dto.PermisosDto;
import com.erp.restaurante.entity.Permisos;
import com.erp.restaurante.repository.PermisosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermisosService {

    @Autowired
    private PermisosRepository permisosRepository;

    // Obtener todos los permisos
    public List<PermisosDto> obtenerTodos() {
        return permisosRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Obtener permiso por ID
    public PermisosDto obtenerPorId(Integer id) {
        Optional<Permisos> permiso = permisosRepository.findById(id);
        return permiso.map(this::convertToDto).orElse(null);
    }

    // Guardar nuevo permiso
    public PermisosDto guardar(PermisosDto permisosDto) {
        Permisos permiso = convertToEntity(permisosDto);
        return convertToDto(permisosRepository.save(permiso));
    }

    // Actualizar permiso
    public PermisosDto actualizar(Integer id, PermisosDto permisosDto) {
        Optional<Permisos> permisoExistente = permisosRepository.findById(id);
        if (permisoExistente.isPresent()) {
            Permisos permiso = permisoExistente.get();
            permiso.setNombre(permisosDto.getNombre());
            return convertToDto(permisosRepository.save(permiso));
        }
        return null;
    }

    // Eliminar permiso
    public void eliminar(Integer id) {
        permisosRepository.deleteById(id);
    }

    // Convertir Entidad a DTO
    private PermisosDto convertToDto(Permisos permiso) {
        return new PermisosDto(permiso.getId(), permiso.getNombre());
    }

    // Convertir DTO a Entidad
    private Permisos convertToEntity(PermisosDto permisosDto) {
        return new Permisos(permisosDto.getId(), permisosDto.getNombre());
    }
}
