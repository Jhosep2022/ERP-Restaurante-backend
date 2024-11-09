package com.erp.restaurante.service;

import com.erp.restaurante.dto.RegistroEntradaSalidaDto;
import com.erp.restaurante.entity.Registroentradasalida;
import com.erp.restaurante.repository.RegistroentradasalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroEntradasSalidaService {

    @Autowired
    private RegistroentradasalidaRepository registroEntradaSalidaRepository;

    public List<RegistroEntradaSalidaDto> getAllRegistros() {
        return registroEntradaSalidaRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<RegistroEntradaSalidaDto> getRegistrosByUsuarioId(Long usuarioId) {
        return registroEntradaSalidaRepository.findByUsuarioId(usuarioId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<RegistroEntradaSalidaDto> getRegistrosByFecha(LocalDate fecha) {
        return registroEntradaSalidaRepository.findByFecha(fecha).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<RegistroEntradaSalidaDto> getRegistrosByHoraMarcada(LocalTime horaMarcada) {
        return registroEntradaSalidaRepository.findByHoraMarcada(horaMarcada).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private RegistroEntradaSalidaDto convertToDto(Registroentradasalida registro) {
        return new RegistroEntradaSalidaDto(
                registro.getId(),
                registro.getFecha(),
                registro.getHoraMarcada(),
                registro.getTipoMarcado(),
                registro.getRetraso(),
                registro.getUsuario().getId() != null ? registro.getUsuario().getId().longValue() : null
        );
    }
}
