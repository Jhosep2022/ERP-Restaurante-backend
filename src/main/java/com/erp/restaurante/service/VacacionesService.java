package com.erp.restaurante.service;

import com.erp.restaurante.dto.VacacionesDto;
import com.erp.restaurante.entity.Usuarios;
import com.erp.restaurante.entity.Vacaciones;
import com.erp.restaurante.repository.UsuariosRepository;
import com.erp.restaurante.repository.VacacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VacacionesService {

    @Autowired
    private VacacionesRepository vacacionesRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Obtener todas las vacaciones
    public List<VacacionesDto> getAllVacaciones() {
        List<Vacaciones> vacaciones = vacacionesRepository.findAll();
        return vacaciones.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    // Obtener vacaciones por ID
    public Optional<VacacionesDto> getVacacionesById(Integer id) {
        return vacacionesRepository.findById(id).map(this::convertEntityToDto);
    }

    // Crear vacaciones
    public VacacionesDto createVacaciones(VacacionesDto vacacionesDto) {
        Vacaciones vacaciones = new Vacaciones();
        vacaciones.setFechaInicio(vacacionesDto.getFechaInicio());
        vacaciones.setFechaFin(vacacionesDto.getFechaFin());
        vacaciones.setAprobacion(vacacionesDto.isAprobacion());

        // Buscar el usuario relacionado por su ID
        Optional<Usuarios> usuario = usuariosRepository.findById(vacacionesDto.getUsuariosId());
        if (usuario.isPresent()) {
            vacaciones.setUsuariosId(usuario.get());
            Vacaciones savedVacaciones = vacacionesRepository.save(vacaciones);
            return convertEntityToDto(savedVacaciones);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
    }

    // Actualizar vacaciones por ID
    public Optional<VacacionesDto> updateVacaciones(Integer id, VacacionesDto updatedVacacionesDto) {
        return vacacionesRepository.findById(id).map(vacaciones -> {
            vacaciones.setFechaInicio(updatedVacacionesDto.getFechaInicio());
            vacaciones.setFechaFin(updatedVacacionesDto.getFechaFin());
            vacaciones.setAprobacion(updatedVacacionesDto.isAprobacion());

            // Buscar y actualizar el usuario relacionado si es necesario
            Optional<Usuarios> usuario = usuariosRepository.findById(updatedVacacionesDto.getUsuariosId());
            if (usuario.isPresent()) {
                vacaciones.setUsuariosId(usuario.get());
                Vacaciones updatedVacaciones = vacacionesRepository.save(vacaciones);
                return convertEntityToDto(updatedVacaciones);
            } else {
                throw new IllegalArgumentException("Usuario no encontrado");
            }
        });
    }

    // Eliminar vacaciones por ID
    public void deleteVacaciones(Integer id) {
        vacacionesRepository.deleteById(id);
    }

    // Método para convertir la entidad Vacaciones a VacacionesDto
    private VacacionesDto convertEntityToDto(Vacaciones vacaciones) {
        return new VacacionesDto(
                vacaciones.getId(),
                vacaciones.getFechaInicio(),
                vacaciones.getFechaFin(),
                vacaciones.getAprobacion(),
                vacaciones.getUsuariosId() != null ? vacaciones.getUsuariosId().getId() : null
        );
    }
}
