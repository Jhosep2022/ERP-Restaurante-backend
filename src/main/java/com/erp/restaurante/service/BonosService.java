package com.erp.restaurante.service;

import com.erp.restaurante.dto.BonosDto;
import com.erp.restaurante.entity.Bonos;
import com.erp.restaurante.repository.BonosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BonosService {

    @Autowired
    private BonosRepository bonosRepository;

    // Obtener todos los bonos
    public List<BonosDto> getAllBonos() {
        List<Bonos> bonosList = bonosRepository.findAll();
        return bonosList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    // Obtener bono por ID
    public Optional<BonosDto> getBonosById(Integer id) {
        return bonosRepository.findById(id).map(this::convertEntityToDto);
    }

    // Crear un nuevo bono
    public BonosDto createBonos(BonosDto bonosDto) {
        Bonos bonos = new Bonos();
        bonos.setNombre(bonosDto.getNombre());
        bonos.setMonto(bonosDto.getMonto());
        Bonos savedBono = bonosRepository.save(bonos);
        return convertEntityToDto(savedBono);
    }

    // Actualizar un bono existente
    public Optional<BonosDto> updateBonos(Integer id, BonosDto bonosDto) {
        return bonosRepository.findById(id).map(bonos -> {
            bonos.setNombre(bonosDto.getNombre());
            bonos.setMonto(bonosDto.getMonto());
            Bonos updatedBono = bonosRepository.save(bonos);
            return convertEntityToDto(updatedBono);
        });
    }

    // Eliminar un bono por ID
    public void deleteBonos(Integer id) {
        bonosRepository.deleteById(id);
    }

    // Método para convertir la entidad Bonos a BonosDto
    private BonosDto convertEntityToDto(Bonos bonos) {
        return new BonosDto(
                bonos.getId(),
                bonos.getNombre(),
                bonos.getMonto()
        );
    }

    // Método para convertir el DTO a la entidad Bonos (si lo necesitas)
    private Bonos convertDtoToEntity(BonosDto bonosDto) {
        return new Bonos(
                bonosDto.getId(),
                bonosDto.getNombre(),
                bonosDto.getMonto()
        );
    }
}
