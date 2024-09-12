package com.erp.restaurante.dto;

import java.math.BigDecimal;

public class BonosDto {

    private Integer id;
    private String nombre;
    private BigDecimal monto;

    // Constructor vacío
    public BonosDto() {
    }

    // Constructor con parámetros
    public BonosDto(Integer id, String nombre, BigDecimal monto) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
