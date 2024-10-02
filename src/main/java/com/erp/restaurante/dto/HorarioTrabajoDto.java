package com.erp.restaurante.dto;

import java.io.Serializable;
import java.util.Date;

public class HorarioTrabajoDto implements Serializable {

    private Integer id;
    private Date diaSemana;
    private Integer usuariosId;
    private Integer turnoId;
    private String usuarioNombre; // Para incluir el nombre del usuario
    private String turnoNombre;   // Para incluir el nombre del turno

    public HorarioTrabajoDto() {
    }

    public HorarioTrabajoDto(Integer id, Date diaSemana, Integer usuariosId, Integer turnoId, String usuarioNombre, String turnoNombre) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.usuariosId = usuariosId;
        this.turnoId = turnoId;
        this.usuarioNombre = usuarioNombre;
        this.turnoNombre = turnoNombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Date diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }

    public Integer getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Integer turnoId) {
        this.turnoId = turnoId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getTurnoNombre() {
        return turnoNombre;
    }

    public void setTurnoNombre(String turnoNombre) {
        this.turnoNombre = turnoNombre;
    }
}
