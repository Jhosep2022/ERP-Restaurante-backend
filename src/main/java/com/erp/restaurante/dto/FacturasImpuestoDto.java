package com.erp.restaurante.dto;

import java.math.BigDecimal;

public class FacturasImpuestoDto {

    private Integer id;
    private BigDecimal monto;
    private Integer facturasId;
    private Integer impuestoId;

    // Constructor vacío
    public FacturasImpuestoDto() {
    }

    // Constructor con parámetros
    public FacturasImpuestoDto(Integer id, BigDecimal monto, Integer facturasId, Integer impuestoId) {
        this.id = id;
        this.monto = monto;
        this.facturasId = facturasId;
        this.impuestoId = impuestoId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Integer getFacturasId() {
        return facturasId;
    }

    public void setFacturasId(Integer facturasId) {
        this.facturasId = facturasId;
    }

    public Integer getImpuestoId() {
        return impuestoId;
    }

    public void setImpuestoId(Integer impuestoId) {
        this.impuestoId = impuestoId;
    }
}
