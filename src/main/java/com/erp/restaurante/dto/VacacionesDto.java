package com.erp.restaurante.dto;

import java.util.Date;

public class VacacionesDto {

    private Integer id;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean aprobacion;
    private Integer empleadoId;

    // Constructor vacío
    public VacacionesDto() {
    }

    // Constructor con parámetros
    public VacacionesDto(Integer id, Date fechaInicio, Date fechaFin, boolean aprobacion, Integer empleadoId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.aprobacion = aprobacion;
        this.empleadoId = empleadoId;
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

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(boolean aprobacion) {
        this.aprobacion = aprobacion;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
}
