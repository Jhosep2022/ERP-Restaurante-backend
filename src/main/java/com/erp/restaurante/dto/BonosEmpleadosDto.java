package com.erp.restaurante.dto;

public class BonosEmpleadosDto {

    private Integer id;
    private Integer bonosId;
    private Integer usuariosId;

    public BonosEmpleadosDto() {
    }

    public BonosEmpleadosDto(Integer id, Integer bonosId, Integer usuariosId) {
        this.id = id;
        this.bonosId = bonosId;
        this.usuariosId = usuariosId;
    }

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

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }
}
