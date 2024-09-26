/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
@Entity
@Table(name = "horariostrabajo")
@NamedQueries({
    @NamedQuery(name = "Horariostrabajo.findAll", query = "SELECT h FROM Horariostrabajo h"),
    @NamedQuery(name = "Horariostrabajo.findById", query = "SELECT h FROM Horariostrabajo h WHERE h.id = :id"),
    @NamedQuery(name = "Horariostrabajo.findByDiaSemana", query = "SELECT h FROM Horariostrabajo h WHERE h.diaSemana = :diaSemana"),
    @NamedQuery(name = "Horariostrabajo.findByHoraEntradaEsperada", query = "SELECT h FROM Horariostrabajo h WHERE h.horaEntradaEsperada = :horaEntradaEsperada"),
    @NamedQuery(name = "Horariostrabajo.findByHoraSalidaEsperada", query = "SELECT h FROM Horariostrabajo h WHERE h.horaSalidaEsperada = :horaSalidaEsperada")})
public class Horariostrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dia_semana")
    private String diaSemana;
    @Basic(optional = false)
    @Column(name = "hora_entrada_esperada")
    @Temporal(TemporalType.TIME)
    private Date horaEntradaEsperada;
    @Basic(optional = false)
    @Column(name = "hora_salida_esperada")
    @Temporal(TemporalType.TIME)
    private Date horaSalidaEsperada;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuariosId;

    public Horariostrabajo() {
    }

    public Horariostrabajo(Integer id) {
        this.id = id;
    }

    public Horariostrabajo(Integer id, String diaSemana, Date horaEntradaEsperada, Date horaSalidaEsperada) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaEntradaEsperada = horaEntradaEsperada;
        this.horaSalidaEsperada = horaSalidaEsperada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getHoraEntradaEsperada() {
        return horaEntradaEsperada;
    }

    public void setHoraEntradaEsperada(Date horaEntradaEsperada) {
        this.horaEntradaEsperada = horaEntradaEsperada;
    }

    public Date getHoraSalidaEsperada() {
        return horaSalidaEsperada;
    }

    public void setHoraSalidaEsperada(Date horaSalidaEsperada) {
        this.horaSalidaEsperada = horaSalidaEsperada;
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
        if (!(object instanceof Horariostrabajo)) {
            return false;
        }
        Horariostrabajo other = (Horariostrabajo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Horariostrabajo[ id=" + id + " ]";
    }
    
}
