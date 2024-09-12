package com.erp.restaurante.dto;

import java.util.Date;

public class VentasDto {

    private Integer id;
    private int cantidad;
    private Date fecha;
    private Integer productoId;
    private Integer sucursalId;

    // Constructor vacío
    public VentasDto() {
    }

    // Constructor con parámetros
    public VentasDto(Integer id, int cantidad, Date fecha, Integer productoId, Integer sucursalId) {
        this.id = id;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.productoId = productoId;
        this.sucursalId = sucursalId;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }
}
