package com.erp.restaurante.service;

import com.erp.restaurante.dto.RolesDto;
import com.erp.restaurante.entity.Roles;
import com.erp.restaurante.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public RolesDto save(RolesDto rolesDto) {
        Roles roles = new Roles();
        roles.setNombre(rolesDto.getNombre());
        Roles savedRoles = rolesRepository.save(roles);
        rolesDto.setId(savedRoles.getId());
        return rolesDto;
    }

    public RolesDto findByNombre(String nombre) {
        Roles rol = rolesRepository.findByNombre(nombre);
        return rol != null ? mapToDto(rol) : null;
    }

    private RolesDto mapToDto(Roles rol) {
        RolesDto rolesDto = new RolesDto();
        rolesDto.setId(rol.getId());
        rolesDto.setNombre(rol.getNombre());
        return rolesDto;
    }

    public Roles findById(Integer id) {
        return rolesRepository.findById(id).orElse(null);
    }

    public Optional<RolesDto> findDtoById(Integer id) {
        Optional<Roles> roles = rolesRepository.findById(id);
        return roles.map(this::mapToDto);
    }

    public List<RolesDto> getAllRoles() {
        List<Roles> rolesList = rolesRepository.findAll();
        return rolesList.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // Método para actualizar un rol existente
    public Optional<RolesDto> update(Integer id, RolesDto rolesDto) {
        Optional<Roles> existingRoles = rolesRepository.findById(id);
        if (existingRoles.isPresent()) {
            Roles roles = existingRoles.get();
            roles.setNombre(rolesDto.getNombre());
            Roles updatedRoles = rolesRepository.save(roles);
            return Optional.of(mapToDto(updatedRoles));
        }
        return Optional.empty();
    }

    // Método para eliminar un rol por ID
    public void delete(Integer id) {
        rolesRepository.deleteById(id);
    }

}
