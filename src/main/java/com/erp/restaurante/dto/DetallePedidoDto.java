package com.erp.restaurante.dto;

import java.math.BigDecimal;

public class DetallePedidoDto {

    private Integer id;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subTotal;
    private Integer pedidoId;
    private Integer ventasId;

    // Constructor vacío
    public DetallePedidoDto() {
    }

    // Constructor con parámetros
    public DetallePedidoDto(Integer id, int cantidad, BigDecimal precioUnitario, BigDecimal subTotal, Integer pedidoId, Integer ventasId) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.pedidoId = pedidoId;
        this.ventasId = ventasId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getVentasId() {
        return ventasId;
    }

    public void setVentasId(Integer ventasId) {
        this.ventasId = ventasId;
    }
}
