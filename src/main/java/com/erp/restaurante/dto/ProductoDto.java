package com.erp.restaurante.dto;

import java.math.BigDecimal;

public class ProductoDto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer categoriaId;
    private Integer sucursalId;

    // Constructor vacío
    public ProductoDto() {
    }

    // Constructor con parámetros
    public ProductoDto(Integer id, String nombre, String descripcion, BigDecimal precio, Integer categoriaId, Integer sucursalId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoriaId = categoriaId;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }
}
