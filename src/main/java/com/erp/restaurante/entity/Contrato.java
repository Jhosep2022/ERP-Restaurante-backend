/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
@Entity
@Table(name = "contrato")
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findById", query = "SELECT c FROM Contrato c WHERE c.id = :id"),
    @NamedQuery(name = "Contrato.findByFechaInicio", query = "SELECT c FROM Contrato c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Contrato.findByFechaConclusion", query = "SELECT c FROM Contrato c WHERE c.fechaConclusion = :fechaConclusion"),
    @NamedQuery(name = "Contrato.findByFechaContrato", query = "SELECT c FROM Contrato c WHERE c.fechaContrato = :fechaContrato"),
    @NamedQuery(name = "Contrato.findByIdentificador", query = "SELECT c FROM Contrato c WHERE c.identificador = :identificador")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_conclusion")
    @Temporal(TemporalType.DATE)
    private Date fechaConclusion;
    @Basic(optional = false)
    @Column(name = "fecha_contrato")
    @Temporal(TemporalType.DATE)
    private Date fechaContrato;
    @Basic(optional = false)
    @Column(name = "identificador")
    private int identificador;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuariosId;

    public Contrato() {
    }

    public Contrato(Integer id) {
        this.id = id;
    }

    public Contrato(Integer id, Date fechaInicio, Date fechaConclusion, Date fechaContrato, int identificador) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaConclusion = fechaConclusion;
        this.fechaContrato = fechaContrato;
        this.identificador = identificador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaConclusion() {
        return fechaConclusion;
    }

    public void setFechaConclusion(Date fechaConclusion) {
        this.fechaConclusion = fechaConclusion;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Contrato[ id=" + id + " ]";
    }
    
}
