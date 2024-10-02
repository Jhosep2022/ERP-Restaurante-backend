package com.erp.restaurante.service;

import com.erp.restaurante.dto.HorarioTrabajoDto;
import com.erp.restaurante.entity.Horariostrabajo;
import com.erp.restaurante.entity.Turno;
import com.erp.restaurante.entity.Usuarios;
import com.erp.restaurante.repository.HorariostrabajoRepository;
import com.erp.restaurante.repository.TurnoRepository;
import com.erp.restaurante.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HorariosTrabajoService {

    @Autowired
    private HorariostrabajoRepository horariostrabajoRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TurnoRepository turnoRepository;

    // Método para obtener todos los horarios con conversión a DTO
    @Transactional
    public List<HorarioTrabajoDto> getAllHorariosTrabajo() {
        List<Horariostrabajo> horarios = horariostrabajoRepository.findAll();
        return horarios.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    // Método para convertir la entidad Horariostrabajo a HorarioTrabajoDto

    private HorarioTrabajoDto convertEntityToDto(Horariostrabajo horario) {
        HorarioTrabajoDto dto = new HorarioTrabajoDto();
        dto.setId(horario.getId());
        dto.setDiaSemana(horario.getDiaSemana());
        dto.setUsuariosId(horario.getUsuariosId() != null ? horario.getUsuariosId().getId() : null);
        dto.setTurnoId(horario.getTurnoId() != null ? horario.getTurnoId().getId() : null);
        dto.setUsuarioNombre(horario.getUsuariosId() != null ? horario.getUsuariosId().getNombre() : null);
        dto.setTurnoNombre(horario.getTurnoId() != null ? horario.getTurnoId().getNombre() : null);
        return dto;
    }
    @Transactional
    public Optional<HorarioTrabajoDto> getHorarioTrabajoById(Integer id) {
        return horariostrabajoRepository.findById(id).map(this::convertEntityToDto);
    }

    public HorarioTrabajoDto createHorarioTrabajo(HorarioTrabajoDto horariostrabajoDto) {
        // Convertir el DTO en la entidad
        Horariostrabajo horariostrabajo = new Horariostrabajo();
        horariostrabajo.setDiaSemana(horariostrabajoDto.getDiaSemana());

        // Obtener las entidades relacionadas (Usuarios y Turno) a partir de sus IDs
        Optional<Usuarios> usuario = usuariosRepository.findById(horariostrabajoDto.getUsuariosId());
        Optional<Turno> turno = turnoRepository.findById(horariostrabajoDto.getTurnoId());

        if (usuario.isPresent() && turno.isPresent()) {
            horariostrabajo.setUsuariosId(usuario.get());
            horariostrabajo.setTurnoId(turno.get());
            Horariostrabajo savedHorario = horariostrabajoRepository.save(horariostrabajo);
            return convertEntityToDto(savedHorario);
        } else {
            throw new IllegalArgumentException("Usuario o Turno no encontrado");
        }
    }

    public Optional<HorarioTrabajoDto> updateHorarioTrabajo(Integer id, HorarioTrabajoDto updatedHorarioTrabajoDto) {
        return horariostrabajoRepository.findById(id).map(horariostrabajo -> {
            horariostrabajo.setDiaSemana(updatedHorarioTrabajoDto.getDiaSemana());

            Optional<Usuarios> usuario = usuariosRepository.findById(updatedHorarioTrabajoDto.getUsuariosId());
            Optional<Turno> turno = turnoRepository.findById(updatedHorarioTrabajoDto.getTurnoId());

            if (usuario.isPresent() && turno.isPresent()) {
                horariostrabajo.setUsuariosId(usuario.get());
                horariostrabajo.setTurnoId(turno.get());
                Horariostrabajo updatedHorario = horariostrabajoRepository.save(horariostrabajo);
                return convertEntityToDto(updatedHorario);
            } else {
                throw new IllegalArgumentException("Usuario o Turno no encontrado");
            }
        });
    }

    public void deleteHorarioTrabajo(Integer id) {
        horariostrabajoRepository.deleteById(id);
    }
}
