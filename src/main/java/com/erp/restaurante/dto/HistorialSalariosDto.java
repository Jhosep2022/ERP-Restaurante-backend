package com.erp.restaurante.dto;

import java.math.BigDecimal;

public class HistorialSalariosDto {

    private Integer id;
    private BigDecimal salario;
    private int fechapago;
    private Integer descuentoId;
    private Integer empleadoId;

    // Constructor vacío
    public HistorialSalariosDto() {
    }

    // Constructor con parámetros
    public HistorialSalariosDto(Integer id, BigDecimal salario, int fechapago, Integer descuentoId, Integer empleadoId) {
        this.id = id;
        this.salario = salario;
        this.fechapago = fechapago;
        this.descuentoId = descuentoId;
        this.empleadoId = empleadoId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public int getFechapago() {
        return fechapago;
    }

    public void setFechapago(int fechapago) {
        this.fechapago = fechapago;
    }

    public Integer getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(Integer descuentoId) {
        this.descuentoId = descuentoId;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
}
