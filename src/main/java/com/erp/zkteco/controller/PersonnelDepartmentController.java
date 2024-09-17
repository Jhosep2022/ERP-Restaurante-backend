package com.erp.zkteco.controller;

import com.erp.zkteco.dto.PersonnelDepartmentDto;
import com.erp.zkteco.service.PersonnelDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personnel-departments")
public class PersonnelDepartmentController {

    @Autowired
    private PersonnelDepartmentService personnelDepartmentService;

    // Endpoint para obtener todos los departamentos de personal
    @GetMapping
    public List<PersonnelDepartmentDto> getAllPersonnelDepartments() {
        return personnelDepartmentService.getAllPersonnelDepartments();
    }
}
