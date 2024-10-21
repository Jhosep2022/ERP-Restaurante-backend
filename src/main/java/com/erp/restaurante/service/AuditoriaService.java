package com.erp.restaurante.service;

import com.erp.restaurante.dto.AuditoriaDto;
import com.erp.restaurante.entity.Auditoria;
import com.erp.restaurante.entity.Usuarios;
import com.erp.restaurante.repository.AuditoriaRepository;
import com.erp.restaurante.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Método para obtener todas las auditorías
    public List<AuditoriaDto> findAll() {
        List<Auditoria> auditorias = auditoriaRepository.findAll();
        return auditorias.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // Método para obtener una auditoría por ID
    public AuditoriaDto findById(Integer id) {
        Optional<Auditoria> auditoria = auditoriaRepository.findById(id);
        return auditoria.map(this::convertToDto).orElse(null);
    }

    // Método para crear una nueva auditoría
    public AuditoriaDto create(AuditoriaDto auditoriaDto) {
        Auditoria auditoria = convertToEntity(auditoriaDto);

        // Busca el usuario por ID y asigna la entidad correspondiente
        if (auditoriaDto.getUsuariosId() != null) {
            Optional<Usuarios> usuario = usuariosRepository.findById(auditoriaDto.getUsuariosId());
            usuario.ifPresent(auditoria::setUsuariosId);
        }

        Auditoria savedAuditoria = auditoriaRepository.save(auditoria);
        return convertToDto(savedAuditoria);
    }

    // Método para actualizar una auditoría existente
    public AuditoriaDto update(Integer id, AuditoriaDto auditoriaDto) {
        Optional<Auditoria> optionalAuditoria = auditoriaRepository.findById(id);
        if (optionalAuditoria.isPresent()) {
            Auditoria auditoria = optionalAuditoria.get();
            auditoria.setTabla(auditoriaDto.getTabla());
            auditoria.setAccion(auditoriaDto.getAccion());
            auditoria.setFecfhaHora(auditoriaDto.getFecfhaHora());
            auditoria.setDetalle(auditoriaDto.getDetalle());
            auditoria.setRegistroId(auditoriaDto.getRegistroId());

            // Verifica y asigna el usuario correcto
            if (auditoriaDto.getUsuariosId() != null) {
                Optional<Usuarios> usuario = usuariosRepository.findById(auditoriaDto.getUsuariosId());
                usuario.ifPresent(auditoria::setUsuariosId);
            }

            Auditoria updatedAuditoria = auditoriaRepository.save(auditoria);
            return convertToDto(updatedAuditoria);
        }
        return null;
    }

    // Método para eliminar una auditoría
    public void delete(Integer id) {
        auditoriaRepository.deleteById(id);
    }

    // Método para convertir una entidad Auditoria a un DTO
    private AuditoriaDto convertToDto(Auditoria auditoria) {
        return new AuditoriaDto(
                auditoria.getId(),
                auditoria.getTabla(),
                auditoria.getAccion(),
                auditoria.getFecfhaHora(),
                auditoria.getDetalle(),
                auditoria.getRegistroId(),
                auditoria.getUsuariosId() != null ? auditoria.getUsuariosId().getId() : null
        );
    }

    // Método para convertir un DTO a una entidad Auditoria
    private Auditoria convertToEntity(AuditoriaDto auditoriaDto) {
        Auditoria auditoria = new Auditoria();
        auditoria.setTabla(auditoriaDto.getTabla());
        auditoria.setAccion(auditoriaDto.getAccion());
        auditoria.setFecfhaHora(auditoriaDto.getFecfhaHora());
        auditoria.setDetalle(auditoriaDto.getDetalle());
        auditoria.setRegistroId(auditoriaDto.getRegistroId());
        return auditoria;
    }
}
