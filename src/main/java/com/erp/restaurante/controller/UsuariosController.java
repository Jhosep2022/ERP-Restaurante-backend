package com.erp.restaurante.controller;

import com.erp.restaurante.dto.ResponseDto;
import com.erp.restaurante.dto.UsuariosDto;
import com.erp.restaurante.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ResponseDto<UsuariosDto>> createUsuario(@RequestBody UsuariosDto usuarioDto) {
        logger.info("Creando un nuevo usuario con el nombre: {}", usuarioDto.getNombre());
        UsuariosDto createdUsuario = usuarioService.save(usuarioDto);
        logger.info("Usuario creado con ID: {}", createdUsuario.getId());

        return ResponseEntity.ok(new ResponseDto<>(true, "Usuario creado con éxito", createdUsuario));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<UsuariosDto>>> getAllUsuarios() {
        logger.info("Obteniendo la lista de todos los usuarios");
        List<UsuariosDto> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(new ResponseDto<>(true, "Lista de usuarios obtenida con éxito", usuarios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<UsuariosDto>> getUsuarioById(@PathVariable Integer id) {
        logger.info("Buscando el usuario con ID: {}", id);
        UsuariosDto usuario = usuarioService.findById(id);
        if (usuario != null) {
            logger.info("Usuario encontrado: {}", usuario.getNombre());
            return ResponseEntity.ok(new ResponseDto<>(true, "Usuario encontrado", usuario));
        } else {
            logger.warn("Usuario con ID: {} no encontrado", id);
            return ResponseEntity.ok(new ResponseDto<>(false, "Usuario no encontrado", null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<UsuariosDto>> updateUsuario(@PathVariable Integer id, @RequestBody UsuariosDto usuarioDto) {
        logger.info("Actualizando el usuario con ID: {}", id);
        UsuariosDto updatedUsuario = usuarioService.update(id, usuarioDto);
        logger.info("Usuario actualizado con éxito: {}", updatedUsuario.getNombre());
        return ResponseEntity.ok(new ResponseDto<>(true, "Usuario actualizado con éxito", updatedUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteUsuario(@PathVariable Integer id) {
        logger.info("Eliminando el usuario con ID: {}", id);
        usuarioService.delete(id);
        logger.info("Usuario con ID: {} eliminado con éxito", id);
        return ResponseEntity.ok(new ResponseDto<>(true, "Usuario eliminado con éxito", null));
    }
}
