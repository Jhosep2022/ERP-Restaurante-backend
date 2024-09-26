package com.erp.zkteco.service;

import com.erp.restaurante.entity.Sucursal;
import com.erp.restaurante.service.SucursalService;
import com.erp.zkteco.entity.PersonnelEmployee;
import com.erp.zkteco.repository.PersonnelEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erp.restaurante.dto.UsuariosDto;
import com.erp.restaurante.dto.RolesDto;
import com.erp.restaurante.service.UsuarioService;
import com.erp.restaurante.service.RolesService;

import java.util.List;

@Service
public class ZKSyncService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolesService rolesService;

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private PersonnelEmployeeRepository personnelEmployeeRepository;

    public void syncFromZK() {
        // Obtener todos los empleados desde la base de datos de ZKTeco
        List<PersonnelEmployee> zkEmployees = personnelEmployeeRepository.findAll();

        // Iterar a través de cada empleado y sincronizar con ERP
        for (PersonnelEmployee zkEmployee : zkEmployees) {
            // 1. Verificar si el Usuario ya existe por empCode
            UsuariosDto existingUsuario = usuarioService.findByEmpCode(zkEmployee.getEmpCode());

            if (existingUsuario != null) {
                // Si el usuario existe, lo actualizamos
                System.out.println("Actualizando usuario existente: " + zkEmployee.getFirstName());
                updateExistingUser(existingUsuario, zkEmployee);
            } else {
                // Si el usuario no existe, lo creamos
                System.out.println("Creando nuevo usuario: " + zkEmployee.getFirstName());
                UsuariosDto usuarioDto = new UsuariosDto();
                usuarioDto.setEmpCode(zkEmployee.getEmpCode()); // Asignar empCode
                usuarioDto.setNombre(zkEmployee.getFirstName());
                usuarioDto.setPrimerApellido(zkEmployee.getLastName());
                usuarioDto.setCorreo(zkEmployee.getEmail());
                usuarioDto.setPassword(zkEmployee.getSelfPassword());
                usuarioDto.setTelefono(zkEmployee.getMobile());
                usuarioDto.setDireccion(zkEmployee.getAddress());
                usuarioDto.setEdad(zkEmployee.getBirthday());
                usuarioDto.setFechaIngreso(zkEmployee.getHireDate());
                usuarioDto.setEstado(true);

                // Asignar rol
                RolesDto existingRole = rolesService.findByNombre("Empleado");
                if (existingRole == null) {
                    RolesDto rolesDto = new RolesDto();
                    rolesDto.setNombre("Empleado");
                    rolesDto = rolesService.save(rolesDto);
                    usuarioDto.setRolesId(rolesDto.getId());
                } else {
                    usuarioDto.setRolesId(existingRole.getId());
                }

                // Asignar sucursal
                Sucursal sucursalPorDefecto = sucursalService.findSucursalByNombre("Sucursal 1");
                if (sucursalPorDefecto != null) {
                    usuarioDto.setSucursalId(sucursalPorDefecto.getId());
                } else {
                    throw new RuntimeException("Sucursal por defecto no encontrada");
                }

                usuarioService.save(usuarioDto);
            }
        }
    }

    // Método para actualizar un usuario existente
    private void updateExistingUser(UsuariosDto existingUsuario, PersonnelEmployee zkEmployee) {
        existingUsuario.setNombre(zkEmployee.getFirstName());
        existingUsuario.setPrimerApellido(zkEmployee.getLastName());
        existingUsuario.setTelefono(zkEmployee.getMobile());
        existingUsuario.setDireccion(zkEmployee.getAddress());
        existingUsuario.setEdad(zkEmployee.getBirthday());
        existingUsuario.setFechaIngreso(zkEmployee.getHireDate());

        usuarioService.update(existingUsuario.getId(), existingUsuario);
    }
}
