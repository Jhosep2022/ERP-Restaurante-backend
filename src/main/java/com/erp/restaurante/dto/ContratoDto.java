package com.erp.restaurante.dto;

import java.util.Date;

public class ContratoDto {

    private Integer id;
    private Date fechaInicio;
    private Date fechaConclusion;
    private Date fechaContrato;
    private int identificador;

    // Constructor vacío
    public ContratoDto() {
    }

    // Constructor con parámetros
    public ContratoDto(Integer id, Date fechaInicio, Date fechaConclusion, Date fechaContrato, int identificador) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaConclusion = fechaConclusion;
        this.fechaContrato = fechaContrato;
        this.identificador = identificador;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaConclusion() {
        return fechaConclusion;
    }

    public void setFechaConclusion(Date fechaConclusion) {
        this.fechaConclusion = fechaConclusion;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
}
