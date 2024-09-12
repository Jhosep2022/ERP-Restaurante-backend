package com.erp.restaurante.dto;

public class BonosEmpleadosDto {

    private Integer id;
    private Integer bonosId;
    private Integer empleadoId;

    // Constructor vacío
    public BonosEmpleadosDto() {
    }

    // Constructor con parámetros
    public BonosEmpleadosDto(Integer id, Integer bonosId, Integer empleadoId) {
        this.id = id;
        this.bonosId = bonosId;
        this.empleadoId = empleadoId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBonosId() {
        return bonosId;
    }

    public void setBonosId(Integer bonosId) {
        this.bonosId = bonosId;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
}
