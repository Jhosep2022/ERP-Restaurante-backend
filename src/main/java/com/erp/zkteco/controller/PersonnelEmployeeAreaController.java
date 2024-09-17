package com.erp.zkteco.controller;

import com.erp.zkteco.dto.PersonnelEmployeeAreaDto;
import com.erp.zkteco.service.PersonnelEmployeeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personnel-employee-areas")
public class PersonnelEmployeeAreaController {

    @Autowired
    private PersonnelEmployeeAreaService personnelEmployeeAreaService;

    // Endpoint para obtener todas las conexiones de empleado y área
    @GetMapping
    public List<PersonnelEmployeeAreaDto> getAllPersonnelEmployeeAreas() {
        return personnelEmployeeAreaService.getAllPersonnelEmployeeAreas();
    }
}
