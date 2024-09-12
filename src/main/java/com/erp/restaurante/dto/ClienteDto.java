package com.erp.restaurante.dto;

public class ClienteDto {

    private Integer id;
    private String nombre;
    private String correo;
    private String telefono;
    private String nit;

    // Constructor vacío
    public ClienteDto() {
    }

    // Constructor con parámetros
    public ClienteDto(Integer id, String nombre, String correo, String telefono, String nit) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.nit = nit;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
