package com.erp.restaurante.dto;

import java.util.Date;

public class UsuariosDto {

    private Integer id;
    private String empCode; // Nuevo campo empCode
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String password;
    private Date fechaIngreso;
    private boolean estado;
    private String direccion;
    private Date edad;
    private String telefono;
    private Integer rolesId;
    private Integer sucursalId;

    public UsuariosDto() {
    }

    public UsuariosDto(Integer id, String empCode, String nombre, String primerApellido, String segundoApellido, String correo, String password, Date fechaIngreso, boolean estado, String direccion, Date edad, String telefono, Integer rolesId, Integer sucursalId) {
        this.id = id;
        this.empCode = empCode; // Asignar empCode en el constructor
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.password = password;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
        this.rolesId = rolesId;
        this.sucursalId = sucursalId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode; // Getter para empCode
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode; // Setter para empCode
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getEdad() {
        return edad;
    }

    public void setEdad(Date edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
