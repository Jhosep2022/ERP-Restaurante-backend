package com.erp.restaurante.dto;

import java.math.BigDecimal;

public class ImpuestoDto {

    private Integer id;
    private String nombre;
    private BigDecimal porcentaje;

    // Constructor vacío
    public ImpuestoDto() {
    }

    // Constructor con parámetros
    public ImpuestoDto(Integer id, String nombre, BigDecimal porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
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

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
}
