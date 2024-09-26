package com.erp.restaurante.dto;

import java.util.Date;

public class VacacionesDto {

    private Integer id;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean aprobacion;
    private Integer usuariosId;

    public VacacionesDto() {
    }

    public VacacionesDto(Integer id, Date fechaInicio, Date fechaFin, boolean aprobacion, Integer usuariosId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.aprobacion = aprobacion;
        this.usuariosId = usuariosId;
    }

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

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }
}
