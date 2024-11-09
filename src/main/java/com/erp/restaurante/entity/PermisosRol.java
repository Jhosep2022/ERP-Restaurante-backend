package com.erp.restaurante.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Permisos_Rol")
public class PermisosRol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Permisos_Roles_ID", nullable = false)
    private Integer permisosRolesId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Roles_id", nullable = false)
    private Roles rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Permisos_Id", nullable = false)
    private Permisos permiso;

    public PermisosRol() {}

    public PermisosRol(Roles rol, Permisos permiso) {
        this.rol = rol;
        this.permiso = permiso;
    }

    // Getters y Setters
    public Integer getPermisosRolesId() {
        return permisosRolesId;
    }

    public void setPermisosRolesId(Integer permisosRolesId) {
        this.permisosRolesId = permisosRolesId;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Permisos getPermiso() {
        return permiso;
    }

    public void setPermiso(Permisos permiso) {
        this.permiso = permiso;
    }
}
