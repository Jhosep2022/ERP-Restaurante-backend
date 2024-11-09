package com.erp.restaurante.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PermisosRol> permisosRoles;

    @OneToMany(mappedBy = "rolesId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Usuarios> usuariosCollection;

    public Roles() {}

    public Roles(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<PermisosRol> getPermisosRoles() {
        return permisosRoles;
    }

    public void setPermisosRoles(Set<PermisosRol> permisosRoles) {
        this.permisosRoles = permisosRoles;
    }

    public Set<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Set<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }
}
