package com.erp.restaurante.service;

import com.erp.restaurante.dto.HistorialSalariosDto;
import com.erp.restaurante.entity.Descuento;
import com.erp.restaurante.entity.Historialsalarios;
import com.erp.restaurante.entity.Usuarios;
import com.erp.restaurante.repository.DescuentoRepository;
import com.erp.restaurante.repository.HistorialSalariosRepository;
import com.erp.restaurante.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistorialSalariosService {

    @Autowired
    private HistorialSalariosRepository historialSalariosRepository;

    @Autowired
    private DescuentoRepository descuentoRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Método para convertir entidad a DTO
    private HistorialSalariosDto mapToDto(Historialsalarios historialSalarios) {
        return new HistorialSalariosDto(
                historialSalarios.getId(),
                historialSalarios.getSalario(),
                historialSalarios.getFechapago(),
                historialSalarios.getDescuentoId() != null ? historialSalarios.getDescuentoId().getId() : null,
                historialSalarios.getUsuariosId() != null ? historialSalarios.getUsuariosId().getId() : null
        );
    }

    // Método para convertir DTO a entidad
    private Historialsalarios mapToEntity(HistorialSalariosDto dto) {
        Historialsalarios historialSalarios = new Historialsalarios();
        historialSalarios.setId(dto.getId());
        historialSalarios.setSalario(dto.getSalario());
        historialSalarios.setFechapago(dto.getFechapago());

        if (dto.getDescuentoId() != null) {
            Descuento descuento = descuentoRepository.findById(dto.getDescuentoId())
                    .orElseThrow(() -> new RuntimeException("Descuento no encontrado con el ID: " + dto.getDescuentoId()));
            historialSalarios.setDescuentoId(descuento);
        }

        if (dto.getUsuariosId() != null) {
            Usuarios usuario = usuariosRepository.findById(dto.getUsuariosId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + dto.getUsuariosId()));
            historialSalarios.setUsuariosId(usuario);
        }

        return historialSalarios;
    }

    public List<HistorialSalariosDto> getAllHistorialSalarios() {
        return historialSalariosRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public HistorialSalariosDto findById(Integer id) {
        Historialsalarios historialSalarios = historialSalariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial de salarios no encontrado con el ID: " + id));
        return mapToDto(historialSalarios);
    }

    public HistorialSalariosDto save(HistorialSalariosDto dto) {
        Historialsalarios historialSalarios = mapToEntity(dto);
        historialSalarios = historialSalariosRepository.save(historialSalarios);
        return mapToDto(historialSalarios);
    }

    public HistorialSalariosDto update(Integer id, HistorialSalariosDto dto) {
        Historialsalarios historialSalarios = historialSalariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial de salarios no encontrado con el ID: " + id));

        historialSalarios.setSalario(dto.getSalario());
        historialSalarios.setFechapago(dto.getFechapago());

        if (dto.getDescuentoId() != null) {
            Descuento descuento = descuentoRepository.findById(dto.getDescuentoId())
                    .orElseThrow(() -> new RuntimeException("Descuento no encontrado con el ID: " + dto.getDescuentoId()));
            historialSalarios.setDescuentoId(descuento);
        }

        if (dto.getUsuariosId() != null) {
            Usuarios usuario = usuariosRepository.findById(dto.getUsuariosId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + dto.getUsuariosId()));
            historialSalarios.setUsuariosId(usuario);
        }

        historialSalarios = historialSalariosRepository.save(historialSalarios);
        return mapToDto(historialSalarios);
    }

    public void delete(Integer id) {
        Historialsalarios historialSalarios = historialSalariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial de salarios no encontrado con el ID: " + id));
        historialSalariosRepository.delete(historialSalarios);
    }
}
