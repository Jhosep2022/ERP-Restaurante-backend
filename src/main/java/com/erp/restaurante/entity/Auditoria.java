package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "tabla")
    private String tabla;

    @Basic(optional = false)
    @Column(name = "accion")
    private String accion;

    @Basic(optional = false)
    @Column(name = "fecfha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecfhaHora;

    @Basic(optional = false)
    @Lob
    @Column(name = "cambios")
    private String cambios; // Cambiado de Object a String

    @Basic(optional = false)
    @Column(name = "detalle")
    private String detalle;

    @Basic(optional = false)
    @Column(name = "registro_id")
    private int registroId;

    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuariosId;

    public Auditoria() {
    }

    public Auditoria(Integer id, String tabla, String accion, Date fecfhaHora, String cambios, String detalle, int registroId) {
        this.id = id;
        this.tabla = tabla;
        this.accion = accion;
        this.fecfhaHora = fecfhaHora;
        this.cambios = cambios;
        this.detalle = detalle;
        this.registroId = registroId;
    }

    // Getters y Setters
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

    public String getCambios() {
        return cambios;
    }

    public void setCambios(String cambios) {
        this.cambios = cambios;
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

    public Usuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuarios usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Auditoria[ id=" + id + " ]";
    }
}
