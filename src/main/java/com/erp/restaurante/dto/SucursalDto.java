package com.erp.restaurante.dto;

public class SucursalDto {

    private Integer id;
    private String nombre;
    private String direccion;

    // Constructor vacío
    public SucursalDto() {}

    // Constructor con parámetros
    public SucursalDto(Integer id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
