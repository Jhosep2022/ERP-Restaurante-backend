package com.erp.restaurante.service;

import com.erp.restaurante.dto.RolesDto;
import com.erp.restaurante.entity.Roles;
import com.erp.restaurante.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
