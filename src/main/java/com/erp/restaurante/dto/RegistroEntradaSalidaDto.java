package com.erp.restaurante.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroEntradaSalidaDto {

    private Long id;
    private LocalDate fecha;
    private LocalTime horaMarcada;
    private Integer tipoMarcado;
    private Boolean retraso;
    private Long usuarioId;

    // Constructor
    public RegistroEntradaSalidaDto(Long id, LocalDate fecha, LocalTime horaMarcada, Integer tipoMarcado, Boolean retraso, Long usuarioId) {
        this.id = id;
        this.fecha = fecha;
        this.horaMarcada = horaMarcada;
        this.tipoMarcado = tipoMarcado;
        this.retraso = retraso;
        this.usuarioId = usuarioId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraMarcada() {
        return horaMarcada;
    }

    public void setHoraMarcada(LocalTime horaMarcada) {
        this.horaMarcada = horaMarcada;
    }

    public Integer getTipoMarcado() {
        return tipoMarcado;
    }

    public void setTipoMarcado(Integer tipoMarcado) {
        this.tipoMarcado = tipoMarcado;
    }

    public Boolean getRetraso() {
        return retraso;
    }

    public void setRetraso(Boolean retraso) {
        this.retraso = retraso;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
