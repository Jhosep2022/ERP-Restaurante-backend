package com.erp.zkteco.service;

import com.erp.zkteco.dto.PersonnelDepartmentDto;
import com.erp.zkteco.entity.PersonnelDepartment;
import com.erp.zkteco.repository.PersonnelDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonnelDepartmentService {

    @Autowired
    private PersonnelDepartmentRepository personnelDepartmentRepository;

    // Método para obtener todos los departamentos de personal
    public List<PersonnelDepartmentDto> getAllPersonnelDepartments() {
        List<PersonnelDepartment> departments = personnelDepartmentRepository.findAll();
        return departments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Método para convertir la entidad a DTO
    private PersonnelDepartmentDto convertToDto(PersonnelDepartment department) {
        return new PersonnelDepartmentDto(
                department.getId(),
                department.getDeptCode(),
                department.getDeptName(),
                department.getIsDefault(),
                department.getParentDeptId(),
                department.getDeptManagerId(),
                department.getCompanyId()
        );
    }
}
