package com.erp.restaurante.dto;

import java.util.Date;

public class EmpleadoDto {

    private Integer id;
    private Date fechaIngreso;
    private Integer contratoId;

    // Constructor vacío
    public EmpleadoDto() {
    }

    // Constructor con parámetros
    public EmpleadoDto(Integer id, Date fechaIngreso, Integer contratoId) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.contratoId = contratoId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getContratoId() {
        return contratoId;
    }

    public void setContratoId(Integer contratoId) {
        this.contratoId = contratoId;
    }
}
