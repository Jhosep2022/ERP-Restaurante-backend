package com.erp.zkteco.controller;

import com.erp.zkteco.dto.PersonnelAreaDto;
import com.erp.zkteco.service.PersonnelAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personnel-areas")
public class PersonnelAreaController {

    private static final Logger logger = LoggerFactory.getLogger(PersonnelAreaController.class);

    @Autowired
    private PersonnelAreaService personnelAreaService;

    // Endpoint para obtener todas las áreas
    @GetMapping
    public List<PersonnelAreaDto> getAllPersonnelAreas() {
        logger.info("Recibida solicitud para obtener todas las áreas.");
        List<PersonnelAreaDto> areas = personnelAreaService.getAllPersonnelAreas();
        logger.info("Retornando {} áreas encontradas.", areas.size());
        return areas;
    }
}
