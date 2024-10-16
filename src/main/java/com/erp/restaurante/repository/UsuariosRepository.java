package com.erp.restaurante.repository;

import com.erp.restaurante.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    Usuarios findByCorreo(String correo);
    Usuarios findByEmpCode(String empCode);

    @Query("SELECT COALESCE(MAX(CAST(u.empCode AS int)), 0) FROM Usuarios u")
    Optional<Integer> findMaxEmpCode();

    // Nuevo método para filtrar por estado
    List<Usuarios> findByEstado(boolean estado);
}
