package com.erp.restaurante.service;

import com.erp.restaurante.entity.Sucursal;
import com.erp.restaurante.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public Sucursal findSucursalByNombre(String nombre) {
        return sucursalRepository.findByNombre(nombre);
    }

    // **Agregar el método findById aquí**
    public Sucursal findById(Integer id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        return sucursal.orElse(null); // Retorna la sucursal si existe, de lo contrario, retorna null
    }
}
