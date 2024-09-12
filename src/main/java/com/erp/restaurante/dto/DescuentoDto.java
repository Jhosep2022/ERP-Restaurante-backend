package com.erp.restaurante.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DescuentoDto {

    private Integer id;
    private String tipoDescuento;
    private BigDecimal monto;
    private Date fecha;
    private String justificacion;
    private Integer empleadoId;

    // Constructor vacío
    public DescuentoDto() {
    }

    // Constructor con parámetros
    public DescuentoDto(Integer id, String tipoDescuento, BigDecimal monto, Date fecha, String justificacion, Integer empleadoId) {
        this.id = id;
        this.tipoDescuento = tipoDescuento;
        this.monto = monto;
        this.fecha = fecha;
        this.justificacion = justificacion;
        this.empleadoId = empleadoId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
}