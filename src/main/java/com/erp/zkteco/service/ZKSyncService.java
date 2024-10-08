package com.erp.zkteco.service;

import com.erp.restaurante.dto.RolesDto;
import com.erp.restaurante.dto.UsuariosDto;
import com.erp.restaurante.entity.Registroentradasalida;
import com.erp.restaurante.entity.Sucursal;
import com.erp.restaurante.entity.Usuarios;
import com.erp.restaurante.repository.RegistroentradasalidaRepository;
import com.erp.restaurante.service.RolesService;
import com.erp.restaurante.service.SucursalService;
import com.erp.restaurante.service.UsuarioService;
import com.erp.zkteco.entity.IclockTransaction;
import com.erp.zkteco.entity.PersonnelEmployee;
import com.erp.zkteco.repository.IclockTransactionRepository;
import com.erp.zkteco.repository.PersonnelEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private IclockTransactionRepository iclockTransactionRepository;

    @Autowired
    private RegistroentradasalidaRepository registroentradasalidaRepository;

    // Método para sincronización global de ZKTeco con ERP (empleados y transacciones)
    public void syncFromZK() {
        syncEmployees(); // Sincroniza los empleados
        syncTransactions(); // Sincroniza las transacciones
    }

    // Método para sincronizar empleados
    private void syncEmployees() {
        // Obtener todos los empleados desde la base de datos de ZKTeco
        List<PersonnelEmployee> zkEmployees = personnelEmployeeRepository.findAll();

        // Iterar a través de cada empleado y sincronizar con ERP
        for (PersonnelEmployee zkEmployee : zkEmployees) {
            // Verificar si el Usuario ya existe por empCode
            UsuariosDto existingUsuario = usuarioService.findByEmpCode(zkEmployee.getEmpCode());

            if (existingUsuario != null) {
                // Si el usuario existe, lo actualizamos
                updateExistingUser(existingUsuario, zkEmployee);
            } else {
                // Si el usuario no existe, lo creamos
                createNewUser(zkEmployee);
            }
        }
    }

    // Método para sincronizar transacciones de IclockTransaction a RegistroEntradaSalida
    private void syncTransactions() {
        // Obtener todas las transacciones desde la base de datos ZKTeco
        List<IclockTransaction> iclockTransactions = iclockTransactionRepository.findAll();

        // Iterar a través de cada transacción para sincronizarla con el sistema ERP
        for (IclockTransaction transaction : iclockTransactions) {
            // Buscar el usuario en ERP utilizando el empCode de la transacción
            UsuariosDto usuarioDto = usuarioService.findByEmpCode(transaction.getEmpCode());

            if (usuarioDto != null) {
                // Verificar si la transacción ya existe en RegistroEntradaSalida antes de crear un nuevo registro
                boolean exists = registroentradasalidaRepository.existsByFechaAndHoraMarcadaAndUsuario_Id(
                        transaction.getPunchTime().toLocalDate(),
                        transaction.getPunchTime().toLocalTime(),
                        usuarioDto.getId().longValue() // Usar Long directamente para evitar conversión
                );

                if (!exists) {
                    // Si la transacción no existe, crear un nuevo registro de entrada/salida
                    Registroentradasalida registro = new Registroentradasalida();
                    registro.setFecha(transaction.getPunchTime().toLocalDate()); // Asignar la fecha de punchTime
                    registro.setHoraMarcada(transaction.getPunchTime().toLocalTime()); // Asignar la hora de punchTime
                    registro.setTipoMarcado(transaction.getVerifyType()); // Asignar el tipo de marcado con verifyType
                    registro.setRetraso(false); // Establecer retraso como false por defecto

                    // Asignar el usuario correspondiente de la entidad `Usuarios` usando el ID del DTO
                    Optional<Usuarios> usuarioOpt = usuarioService.findEntityById(usuarioDto.getId());
                    usuarioOpt.ifPresent(registro::setUsuario);

                    // Guardar la transacción en RegistroEntradaSalida
                    registroentradasalidaRepository.save(registro);
                    System.out.println("Sincronizado registro para usuario: " + usuarioDto.getNombre());
                } else {
                    System.out.println("Transacción duplicada para el usuario: " + usuarioDto.getNombre() + " con fecha y hora: " + transaction.getPunchTime());
                }
            } else {
                System.out.println("Usuario con empCode " + transaction.getEmpCode() + " no encontrado en ERP.");
            }
        }
    }

    // Método para crear un nuevo usuario basado en un empleado de ZKTeco
    private void createNewUser(PersonnelEmployee zkEmployee) {
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
