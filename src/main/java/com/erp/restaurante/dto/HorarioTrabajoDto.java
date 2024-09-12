package com.erp.restaurante.dto;

import java.util.Date;

public class HorarioTrabajoDto {

    private Integer id;
    private String diaSemana;
    private Date horaEntradaEsperada;
    private Date horaSalidaEsperada;
    private Integer empleadoId;

    // Constructor vacío
    public HorarioTrabajoDto() {
    }

    // Constructor con parámetros
    public HorarioTrabajoDto(Integer id, String diaSemana, Date horaEntradaEsperada, Date horaSalidaEsperada, Integer empleadoId) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaEntradaEsperada = horaEntradaEsperada;
        this.horaSalidaEsperada = horaSalidaEsperada;
        this.empleadoId = empleadoId;
    }

    // Getters y Setters
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

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
}
