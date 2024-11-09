package com.erp.restaurante.repository;

import com.erp.restaurante.entity.PermisosRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermisosRolRepository extends JpaRepository<PermisosRol, Integer> {
    boolean existsByRolIdAndPermisoId(Integer rolId, Integer permisoId);
    List<PermisosRol> findByRolId(Integer rolId);
    List<PermisosRol> findByPermisoId(Integer permisoId);
}
