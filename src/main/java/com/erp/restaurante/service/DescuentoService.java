package com.erp.restaurante.service;

import com.erp.restaurante.dto.DescuentoDto;
import com.erp.restaurante.entity.Descuento;
import com.erp.restaurante.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DescuentoService {

    @Autowired
    private DescuentoRepository descuentoRepository;

    // Convertir de Descuento a DescuentoDto
    private DescuentoDto convertToDto(Descuento descuento) {
        return new DescuentoDto(descuento.getId(), descuento.getTipoDescuento(),
                descuento.getMonto(), descuento.getFecha(), descuento.getJustificacion());
    }

    // Convertir de DescuentoDto a Descuento
    private Descuento convertToEntity(DescuentoDto dto) {
        return new Descuento(dto.getId(), dto.getTipoDescuento(),
                dto.getMonto(), dto.getFecha(), dto.getJustificacion());
    }

    public List<DescuentoDto> getAllDescuentos() {
        return descuentoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public DescuentoDto findById(Integer id) {
        Optional<Descuento> descuento = descuentoRepository.findById(id);
        return descuento.map(this::convertToDto).orElse(null);
    }

    public DescuentoDto createDescuento(DescuentoDto dto) {
        Descuento descuento = convertToEntity(dto);
        Descuento savedDescuento = descuentoRepository.save(descuento);
        return convertToDto(savedDescuento);
    }

    public DescuentoDto updateDescuento(Integer id, DescuentoDto dto) {
        Optional<Descuento> existingDescuento = descuentoRepository.findById(id);
        if (existingDescuento.isPresent()) {
            Descuento descuento = existingDescuento.get();
            descuento.setTipoDescuento(dto.getTipoDescuento());
            descuento.setMonto(dto.getMonto());
            descuento.setFecha(dto.getFecha());
            descuento.setJustificacion(dto.getJustificacion());
            return convertToDto(descuentoRepository.save(descuento));
        }
        return null;
    }

    public boolean deleteDescuento(Integer id) {
        Optional<Descuento> descuento = descuentoRepository.findById(id);
        if (descuento.isPresent()) {
            descuentoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
