package com.erp.restaurante.service;

import com.erp.restaurante.config.JwtUtil;
import com.erp.restaurante.config.PasswordUtil;
import com.erp.restaurante.dto.AuthResponseDto;
import com.erp.restaurante.dto.UsuariosDto;
import com.erp.restaurante.entity.Roles;
import com.erp.restaurante.entity.Sucursal;
import com.erp.restaurante.entity.Usuarios;
import com.erp.restaurante.repository.UsuariosRepository;
import com.erp.zkteco.entity.PersonnelEmployee;
import com.erp.zkteco.repository.PersonnelEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private PersonnelEmployeeRepository personnelEmployeeRepository;

    @Autowired
    private RolesService rolesService;

    @Autowired
    private JwtUtil jwtUtil;

    // Método para autenticar al usuario utilizando correo y contraseña
    public AuthResponseDto authenticate(String correo, String password) {
        Usuarios usuario = usuariosRepository.findByCorreo(correo);
        if (usuario == null || !PasswordUtil.verifyPassword(password, usuario.getPassword())) {
            throw new RuntimeException("Correo o contraseña incorrectos");
        }

        UsuariosDto usuarioDto = mapToDto(usuario);
        String token = jwtUtil.generateToken(usuarioDto);

        return new AuthResponseDto(usuarioDto, token);
    }

    // Método para generar el siguiente empCode
    private synchronized String generateNextEmpCode() {
        Optional<Integer> maxEmpCodeOpt = usuariosRepository.findMaxEmpCode();
        Integer nextEmpCode = maxEmpCodeOpt.orElse(0) + 1;
        return nextEmpCode.toString();
    }

    // Método para registrar un nuevo usuario
    public UsuariosDto save(UsuariosDto usuarioDto) {
        // Validar y obtener el rol del usuario
        Roles rol = rolesService.findById(usuarioDto.getRolesId());
        if (rol == null) {
            throw new RuntimeException("Rol no encontrado con el ID: " + usuarioDto.getRolesId());
        }

        // Validar y obtener la sucursal del usuario
        Sucursal sucursal = sucursalService.findById(usuarioDto.getSucursalId());
        if (sucursal == null) {
            throw new RuntimeException("Sucursal no encontrada con el ID: " + usuarioDto.getSucursalId());
        }

        // Generar el siguiente empCode
        String nuevoEmpCode = generateNextEmpCode();

        // Crear y guardar la entidad Usuarios
        Usuarios usuario = new Usuarios();
        usuario.setEmpCode(nuevoEmpCode);
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setPrimerApellido(usuarioDto.getPrimerApellido());
        usuario.setSegundoApellido(usuarioDto.getSegundoApellido());
        usuario.setCorreo(usuarioDto.getCorreo());

        // Encriptar la contraseña antes de guardarla en la base de datos
        String encodedPassword = PasswordUtil.encryptPassword(usuarioDto.getPassword());
        usuario.setPassword(encodedPassword);

        usuario.setFechaIngreso(new Date());
        usuario.setEstado(true);
        usuario.setDireccion(usuarioDto.getDireccion());
        usuario.setEdad(usuarioDto.getEdad());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setRolesId(rol); // Asignar rol
        usuario.setSucursalId(sucursal); // Asignar sucursal
        usuario = usuariosRepository.save(usuario);

        // Crear y guardar la entidad PersonnelEmployee en la tabla de biométrico
        PersonnelEmployee personnelEmployee = new PersonnelEmployee();
        personnelEmployee.setEmpCode(nuevoEmpCode);
        personnelEmployee.setFirstName(usuario.getNombre());
        personnelEmployee.setLastName(usuario.getPrimerApellido() + " " + usuario.getSegundoApellido());
        personnelEmployee.setNickname(usuario.getNombre());
        personnelEmployee.setCreateTime(new Date());
        personnelEmployee.setStatus(0); // Estado inicial en 0
        personnelEmployee.setSelfPassword(usuario.getPassword());
        personnelEmployee.setBirthday(usuario.getEdad()); // Edad, se mantiene como Date en la entidad
        personnelEmployee.setAddress(usuario.getDireccion());
        personnelEmployee.setContactTel(usuario.getTelefono());
        personnelEmployee.setMobile(usuario.getTelefono());
        personnelEmployee.setEnablePayroll(true);  // Usar Boolean
        personnelEmployee.setAppStatus((short) 0);  // Convertir a Short
        personnelEmployee.setAppRole((short) 1);  // Convertir a Short
        personnelEmployee.setDevPrivilege(0); // Convertir a Integer
        personnelEmployee.setEmail(usuario.getCorreo());
        personnelEmployee.setHireDate(new Date());
        personnelEmployee.setEmpCodeDigit(Long.parseLong(nuevoEmpCode)); // Convertir a Long
        personnelEmployee.setActive(true);  // Usar Boolean
        personnelEmployee.setLeaveGroup(0);
        personnelEmployee.setDepartmentId(1L); // Valor por defecto como Long
        personnelEmployee.setCompanyId(1L); // Valor por defecto como Long
        personnelEmployee.setVerifyMode(0);

        // Guardar la entidad PersonnelEmployee
        personnelEmployee = personnelEmployeeRepository.save(personnelEmployee);

        // Actualizar el DTO con el ID generado para ambas tablas
        usuarioDto.setId(usuario.getId());
        usuarioDto.setEmpCode(nuevoEmpCode);

        return usuarioDto;
    }

    // Método para obtener todos los usuarios
    public List<UsuariosDto> getAllUsuarios() {
        List<Usuarios> usuarios = usuariosRepository.findByEstado(true);
        return usuarios.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public UsuariosDto findById(Integer id) {
        Usuarios usuario = usuariosRepository.findById(id)
                .filter(Usuarios::isEstado) // Solo usuarios con estado "true"
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapToDto(usuario);
    }

    public Optional<Usuarios> findEntityById(Integer id) {
        return usuariosRepository.findById(id);
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

        // Encriptar la contraseña nuevamente si se ha cambiado
        if (!usuarioExistente.getPassword().equals(usuarioDto.getPassword())) {
            String encodedPassword = PasswordUtil.encryptPassword(usuarioDto.getPassword());
            usuarioExistente.setPassword(encodedPassword);
        }

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
        usuario.setEstado(false);
        usuariosRepository.save(usuario);
    }

    // Método para convertir entidad a DTO
    private UsuariosDto mapToDto(Usuarios usuario) {
        UsuariosDto usuarioDto = new UsuariosDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setEmpCode(usuario.getEmpCode());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setPrimerApellido(usuario.getPrimerApellido());
        usuarioDto.setSegundoApellido(usuario.getSegundoApellido());
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
