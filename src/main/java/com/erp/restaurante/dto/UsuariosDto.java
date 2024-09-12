package com.erp.restaurante.dto;

public class UsuariosDto {

    private Integer id;
    private String nombre;
    private String correo;
    private String password;
    private boolean estado;
    private Integer empleadoId;
    private Integer personaId;
    private Integer rolesId;
    private Integer sucursalId;

    // Constructor vacío
    public UsuariosDto() {
    }

    // Constructor con parámetros
    public UsuariosDto(Integer id, String nombre, String correo, String password, boolean estado, Integer empleadoId, Integer personaId, Integer rolesId, Integer sucursalId) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.empleadoId = empleadoId;
        this.personaId = personaId;
        this.rolesId = rolesId;
        this.sucursalId = sucursalId;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }
}
