package com.erp.restaurante.dto;

public class RecetasDto {

    private Integer id;
    private int cantidadIngrediente;
    private Integer ingredientesId;
    private Integer productoId;

    // Constructor vacío
    public RecetasDto() {
    }

    // Constructor con parámetros
    public RecetasDto(Integer id, int cantidadIngrediente, Integer ingredientesId, Integer productoId) {
        this.id = id;
        this.cantidadIngrediente = cantidadIngrediente;
        this.ingredientesId = ingredientesId;
        this.productoId = productoId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidadIngrediente() {
        return cantidadIngrediente;
    }

    public void setCantidadIngrediente(int cantidadIngrediente) {
        this.cantidadIngrediente = cantidadIngrediente;
    }

    public Integer getIngredientesId() {
        return ingredientesId;
    }

    public void setIngredientesId(Integer ingredientesId) {
        this.ingredientesId = ingredientesId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
}
