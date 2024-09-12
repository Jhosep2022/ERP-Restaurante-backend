package com.erp.restaurante.dto;

public class CategoriaDto {

    private Integer id;
    private String nombre;

    // Constructor vacío
    public CategoriaDto() {
    }

    // Constructor con parámetros
    public CategoriaDto(Integer id, String nombre) {
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
}
