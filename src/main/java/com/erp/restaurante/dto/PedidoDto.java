package com.erp.restaurante.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PedidoDto {

    private Integer id;
    private Date fecha;
    private String estado;
    private BigDecimal total;
    private Integer clienteId;

    // Constructor vacío
    public PedidoDto() {
    }

    // Constructor con parámetros
    public PedidoDto(Integer id, Date fecha, String estado, BigDecimal total, Integer clienteId) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.clienteId = clienteId;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
