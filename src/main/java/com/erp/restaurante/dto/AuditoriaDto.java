package com.erp.restaurante.dto;

import java.util.Date;

public class AuditoriaDto {

    private Integer id;
    private String tabla;
    private String accion;
    private Date fecfhaHora;
    private String detalle;
    private int registroId;
    private Integer usuariosId;

    // Constructor vacío
    public AuditoriaDto() {
    }

    // Constructor con parámetros

    public AuditoriaDto(Integer id, String tabla, String accion, Date fecfhaHora, String detalle, int registroId, Integer usuariosId) {
        this.id = id;
        this.tabla = tabla;
        this.accion = accion;
        this.fecfhaHora = fecfhaHora;
        this.detalle = detalle;
        this.registroId = registroId;
        this.usuariosId = usuariosId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecfhaHora() {
        return fecfhaHora;
    }

    public void setFecfhaHora(Date fecfhaHora) {
        this.fecfhaHora = fecfhaHora;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getRegistroId() {
        return registroId;
    }

    public void setRegistroId(int registroId) {
        this.registroId = registroId;
    }

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }
}
