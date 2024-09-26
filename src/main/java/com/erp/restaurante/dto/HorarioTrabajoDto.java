package com.erp.restaurante.dto;

import java.util.Date;

public class HorarioTrabajoDto {

    private Integer id;
    private String diaSemana;
    private Date horaEntradaEsperada;
    private Date horaSalidaEsperada;
    private Integer usuariosId;

    public HorarioTrabajoDto() {
    }

    public HorarioTrabajoDto(Integer id, String diaSemana, Date horaEntradaEsperada, Date horaSalidaEsperada, Integer usuariosId) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaEntradaEsperada = horaEntradaEsperada;
        this.horaSalidaEsperada = horaSalidaEsperada;
        this.usuariosId = usuariosId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getHoraEntradaEsperada() {
        return horaEntradaEsperada;
    }

    public void setHoraEntradaEsperada(Date horaEntradaEsperada) {
        this.horaEntradaEsperada = horaEntradaEsperada;
    }

    public Date getHoraSalidaEsperada() {
        return horaSalidaEsperada;
    }

    public void setHoraSalidaEsperada(Date horaSalidaEsperada) {
        this.horaSalidaEsperada = horaSalidaEsperada;
    }

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }
}
