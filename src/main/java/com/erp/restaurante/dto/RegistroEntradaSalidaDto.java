package com.erp.restaurante.dto;

import java.util.Date;

public class RegistroEntradaSalidaDto {

    private Integer id;
    private Date fecha;
    private Date horaEntrada;
    private Date horaSalida;
    private boolean retraso;
    private Integer empleadosId;

    // Constructor vacío
    public RegistroEntradaSalidaDto() {
    }

    // Constructor con parámetros
    public RegistroEntradaSalidaDto(Integer id, Date fecha, Date horaEntrada, Date horaSalida, boolean retraso, Integer empleadosId) {
        this.id = id;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.retraso = retraso;
        this.empleadosId = empleadosId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public boolean isRetraso() {
        return retraso;
    }

    public void setRetraso(boolean retraso) {
        this.retraso = retraso;
    }

    public Integer getEmpleadosId() {
        return empleadosId;
    }

    public void setEmpleadosId(Integer empleadosId) {
        this.empleadosId = empleadosId;
    }
}
