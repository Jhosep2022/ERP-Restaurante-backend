package com.erp.zkteco.service;

import com.erp.zkteco.dto.PersonnelPositionDto;
import com.erp.zkteco.entity.PersonnelPosition;
import com.erp.zkteco.repository.PersonnelPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonnelPositionService {

    @Autowired
    private PersonnelPositionRepository personnelPositionRepository;

    // Método para obtener todas las posiciones
    public List<PersonnelPositionDto> getAllPersonnelPositions() {
        List<PersonnelPosition> positions = personnelPositionRepository.findAll();
        return positions.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // Convertir entidad a DTO
    private PersonnelPositionDto convertToDto(PersonnelPosition position) {
        return new PersonnelPositionDto(
                position.getId(),
                position.getPositionCode(),
                position.getPositionName(),
                position.getIsDefault(),
                position.getParentPositionId(),
                position.getCompanyId()
        );
    }
}
