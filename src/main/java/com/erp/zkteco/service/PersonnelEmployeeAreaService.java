package com.erp.zkteco.service;

import com.erp.zkteco.dto.PersonnelEmployeeAreaDto;
import com.erp.zkteco.entity.PersonnelEmployeeArea;
import com.erp.zkteco.repository.PersonnelEmployeeAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonnelEmployeeAreaService {

    @Autowired
    private PersonnelEmployeeAreaRepository personnelEmployeeAreaRepository;

    // Método para obtener todas las conexiones
    public List<PersonnelEmployeeAreaDto> getAllPersonnelEmployeeAreas() {
        List<PersonnelEmployeeArea> employeeAreas = personnelEmployeeAreaRepository.findAll();
        return employeeAreas.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Método para convertir entity a DTO
    private PersonnelEmployeeAreaDto convertToDto(PersonnelEmployeeArea employeeArea) {
        return new PersonnelEmployeeAreaDto(
                employeeArea.getId(),
                employeeArea.getEmployeeId(),
                employeeArea.getAreaId()
        );
    }
}
