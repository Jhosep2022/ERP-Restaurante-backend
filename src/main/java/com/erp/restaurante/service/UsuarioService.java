package com.erp.restaurante.service;

import com.erp.restaurante.dto.UsuariosDto;
import com.erp.restaurante.entity.Roles;
import com.erp.restaurante.entity.Sucursal;
import com.erp.restaurante.entity.Usuarios;
import com.erp.restaurante.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private SucursalService sucursalService;

    public UsuariosDto save(UsuariosDto usuarioDto) {
        Usuarios usuario = new Usuarios();
        usuario.setEmpCode(usuarioDto.getEmpCode());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setCorreo(usuarioDto.getCorreo());
        usuario.setPassword(usuarioDto.getPassword());
        usuario.setEstado(usuarioDto.isEstado());

        if (usuarioDto.getRolesId() != null) {
            Roles roles = new Roles();
            roles.setId(usuarioDto.getRolesId());
            usuario.setRolesId(roles);
        }

        if (usuarioDto.getSucursalId() != null) {
            Sucursal sucursal = sucursalService.findById(usuarioDto.getSucursalId());
            if (sucursal == null) {
                throw new RuntimeException("Sucursal no encontrada con el ID: " + usuarioDto.getSucursalId());
            }
            usuario.setSucursalId(sucursal);
        }

        Usuarios savedUsuario = usuariosRepository.save(usuario);
        usuarioDto.setId(savedUsuario.getId());
        return usuarioDto;
    }

    public List<UsuariosDto> getAllUsuarios() {
        List<Usuarios> usuarios = usuariosRepository.findAll();
        return usuarios.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public UsuariosDto findById(Integer id) {
        Usuarios usuario = usuariosRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapToDto(usuario);
    }

    public UsuariosDto findByCorreo(String correo) {
        Usuarios usuario = usuariosRepository.findByCorreo(correo);
        return usuario != null ? mapToDto(usuario) : null;
    }

    public UsuariosDto findByEmpCode(String empCode) {
        Usuarios usuario = usuariosRepository.findByEmpCode(empCode);
        return usuario != null ? mapToDto(usuario) : null;
    }

    public UsuariosDto update(Integer id, UsuariosDto usuarioDto) {
        Usuarios usuarioExistente = usuariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioExistente.setNombre(usuarioDto.getNombre());
        usuarioExistente.setPrimerApellido(usuarioDto.getPrimerApellido());
        usuarioExistente.setCorreo(usuarioDto.getCorreo());
        usuarioExistente.setPassword(usuarioDto.getPassword());
        usuarioExistente.setEstado(usuarioDto.isEstado());
        usuarioExistente.setTelefono(usuarioDto.getTelefono());
        usuarioExistente.setDireccion(usuarioDto.getDireccion());
        usuarioExistente.setEdad(usuarioDto.getEdad());
        usuarioExistente.setFechaIngreso(usuarioDto.getFechaIngreso());

        if (usuarioDto.getSucursalId() != null) {
            Sucursal sucursal = sucursalService.findById(usuarioDto.getSucursalId());
            if (sucursal == null) {
                throw new RuntimeException("Sucursal no encontrada con el ID: " + usuarioDto.getSucursalId());
            }
            usuarioExistente.setSucursalId(sucursal);
        }

        Usuarios updatedUsuario = usuariosRepository.save(usuarioExistente);
        return mapToDto(updatedUsuario);
    }

    public void delete(Integer id) {
        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuariosRepository.delete(usuario);
    }

    private UsuariosDto mapToDto(Usuarios usuario) {
        UsuariosDto usuarioDto = new UsuariosDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setEmpCode(usuario.getEmpCode());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setCorreo(usuario.getCorreo());
        usuarioDto.setPassword(usuario.getPassword());
        usuarioDto.setEstado(usuario.isEstado());
        usuarioDto.setTelefono(usuario.getTelefono());
        usuarioDto.setDireccion(usuario.getDireccion());
        usuarioDto.setEdad(usuario.getEdad());
        usuarioDto.setSucursalId(usuario.getSucursalId() != null ? usuario.getSucursalId().getId() : null);
        return usuarioDto;
    }
}
