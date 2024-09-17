package com.erp.zkteco.controller;

import com.erp.zkteco.dto.PersonnelEmployeeDto;
import com.erp.zkteco.service.PersonnelEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personnel-employees")
public class PersonnelEmployeeController {

    @Autowired
    private PersonnelEmployeeService personnelEmployeeService;

    // Endpoint para obtener todos los empleados
    @GetMapping
    public List<PersonnelEmployeeDto> getAllEmployees() {
        return personnelEmployeeService.getAllEmployees();
    }
}
