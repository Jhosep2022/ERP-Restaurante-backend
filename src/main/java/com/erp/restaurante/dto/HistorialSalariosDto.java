package com.erp.restaurante.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HistorialSalariosDto {

    private Integer id;
    private BigDecimal salario;
    private LocalDate fechapago;
    private Integer descuentoId;
    private Integer usuariosId;

    public HistorialSalariosDto() {
    }

    public HistorialSalariosDto(Integer id, BigDecimal salario, LocalDate fechapago, Integer descuentoId, Integer usuariosId) {
        this.id = id;
        this.salario = salario;
        this.fechapago = fechapago;
        this.descuentoId = descuentoId;
        this.usuariosId = usuariosId;
    }

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

    public LocalDate getFechapago() {
        return fechapago;
    }

    public void setFechapago(LocalDate fechapago) {
        this.fechapago = fechapago;
    }

    public Integer getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(Integer descuentoId) {
        this.descuentoId = descuentoId;
    }

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }
}
