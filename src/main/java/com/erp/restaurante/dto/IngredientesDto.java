package com.erp.restaurante.dto;

public class IngredientesDto {

    private Integer id;
    private String nombreIngrediente;
    private int descripcion;
    private int stockActual;

    // Constructor vacío
    public IngredientesDto() {
    }

    // Constructor con parámetros
    public IngredientesDto(Integer id, String nombreIngrediente, int descripcion, int stockActual) {
        this.id = id;
        this.nombreIngrediente = nombreIngrediente;
        this.descripcion = descripcion;
        this.stockActual = stockActual;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
}
