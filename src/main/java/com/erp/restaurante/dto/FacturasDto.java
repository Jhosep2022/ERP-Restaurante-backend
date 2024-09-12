package com.erp.restaurante.dto;

import java.math.BigDecimal;
import java.util.Date;

public class FacturasDto {

    private Integer id;
    private Date fecha;
    private String estado;
    private BigDecimal total;
    private String numeroFactura;
    private String cuf;
    private Integer clienteId;
    private Integer detallePedidoId;

    // Constructor vacío
    public FacturasDto() {
    }

    // Constructor con parámetros
    public FacturasDto(Integer id, Date fecha, String estado, BigDecimal total, String numeroFactura, String cuf, Integer clienteId, Integer detallePedidoId) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.numeroFactura = numeroFactura;
        this.cuf = cuf;
        this.clienteId = clienteId;
        this.detallePedidoId = detallePedidoId;
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

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCuf() {
        return cuf;
    }

    public void setCuf(String cuf) {
        this.cuf = cuf;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getDetallePedidoId() {
        return detallePedidoId;
    }

    public void setDetallePedidoId(Integer detallePedidoId) {
        this.detallePedidoId = detallePedidoId;
    }
}
