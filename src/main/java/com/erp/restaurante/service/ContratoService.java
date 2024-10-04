package com.erp.restaurante.service;

import com.erp.restaurante.dto.ContratoDto;
import com.erp.restaurante.entity.Contrato;
import com.erp.restaurante.entity.Usuarios;
import com.erp.restaurante.repository.ContratoRepository;
import com.erp.restaurante.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Transactional
    public List<ContratoDto> getAllContratos() {
        return contratoRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Transactional
    public Optional<ContratoDto> getContratoById(Integer id) {
        return contratoRepository.findById(id).map(this::convertEntityToDto);
    }

    @Transactional
    public ContratoDto createContrato(ContratoDto contratoDto) {
        Contrato contrato = new Contrato();
        contrato.setFechaInicio(contratoDto.getFechaInicio());
        contrato.setFechaConclusion(contratoDto.getFechaConclusion());
        contrato.setFechaContrato(contratoDto.getFechaContrato());
        contrato.setIdentificador(contratoDto.getIdentificador());

        Optional<Usuarios> usuario = usuariosRepository.findById(contratoDto.getUsuariosId());
        usuario.ifPresent(contrato::setUsuariosId);

        Contrato savedContrato = contratoRepository.save(contrato);
        return convertEntityToDto(savedContrato);
    }

    @Transactional
    public Optional<ContratoDto> updateContrato(Integer id, ContratoDto contratoDto) {
        return contratoRepository.findById(id).map(contrato -> {
            contrato.setFechaInicio(contratoDto.getFechaInicio());
            contrato.setFechaConclusion(contratoDto.getFechaConclusion());
            contrato.setFechaContrato(contratoDto.getFechaContrato());
            contrato.setIdentificador(contratoDto.getIdentificador());

            Optional<Usuarios> usuario = usuariosRepository.findById(contratoDto.getUsuariosId());
            usuario.ifPresent(contrato::setUsuariosId);

            Contrato updatedContrato = contratoRepository.save(contrato);
            return convertEntityToDto(updatedContrato);
        });
    }

    @Transactional
    public void deleteContrato(Integer id) {
        contratoRepository.deleteById(id);
    }

    private ContratoDto convertEntityToDto(Contrato contrato) {
        return new ContratoDto(
                contrato.getId(),
                contrato.getFechaInicio(),
                contrato.getFechaConclusion(),
                contrato.getFechaContrato(),
                contrato.getIdentificador(),
                contrato.getUsuariosId() != null ? contrato.getUsuariosId().getId() : null
        );
    }
}
