package com.erp.zkteco.controller;

import com.erp.zkteco.dto.PersonnelPositionDto;
import com.erp.zkteco.service.PersonnelPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personnel-positions")
public class PersonnelPositionController {

    @Autowired
    private PersonnelPositionService personnelPositionService;

    // Endpoint para obtener todas las posiciones
    @GetMapping
    public List<PersonnelPositionDto> getAllPersonnelPositions() {
        return personnelPositionService.getAllPersonnelPositions();
    }
}
