package com.erp.zkteco.service;

import com.erp.zkteco.dto.PersonnelAreaDto;
import com.erp.zkteco.entity.PersonnelArea;
import com.erp.zkteco.repository.PersonnelAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonnelAreaService {

    @Autowired
    private PersonnelAreaRepository personnelAreaRepository;

    // Método para obtener todas las áreas
    public List<PersonnelAreaDto> getAllPersonnelAreas() {
        List<PersonnelArea> areas = personnelAreaRepository.findAll();
        return areas.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // Método para convertir de Entity a DTO
    private PersonnelAreaDto convertToDto(PersonnelArea personnelArea) {
        return new PersonnelAreaDto(
                personnelArea.getId(),
                personnelArea.getAreaCode(),
                personnelArea.getAreaName(),
                personnelArea.getIsDefault(),
                personnelArea.getParentAreaId(),
                personnelArea.getCompanyId(),
                personnelArea.getDeviceCount(),
                personnelArea.getEmployeeCount()
        );
    }
}
