package com.erp.restaurante.service;

import com.erp.restaurante.entity.Sucursal;
import com.erp.restaurante.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> getAllSucursales() {
        return sucursalRepository.findAll();
    }

    public Sucursal findById(Integer id) {
        return sucursalRepository.findById(id).orElse(null);
    }

    public Sucursal createSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal updateSucursal(Integer id, Sucursal updatedSucursal) {
        Optional<Sucursal> existingSucursal = sucursalRepository.findById(id);
        if (existingSucursal.isPresent()) {
            Sucursal sucursal = existingSucursal.get();
            sucursal.setNombre(updatedSucursal.getNombre());
            sucursal.setDireccion(updatedSucursal.getDireccion());
            return sucursalRepository.save(sucursal);
        }
        return null;
    }

    public boolean deleteSucursal(Integer id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        if (sucursal.isPresent()) {
            sucursalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Sucursal findSucursalByNombre(String nombre) {
        return sucursalRepository.findByNombre(nombre);
    }
}
