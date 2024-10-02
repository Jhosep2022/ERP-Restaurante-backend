package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "horariostrabajo")
public class Horariostrabajo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "dia_semana")
    @Temporal(TemporalType.DATE)
    private Date diaSemana;

    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuariosId;

    @JoinColumn(name = "turno_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Turno turnoId;

    public Horariostrabajo() {
    }

    public Horariostrabajo(Integer id, Date diaSemana, Usuarios usuariosId, Turno turnoId) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.usuariosId = usuariosId;
        this.turnoId = turnoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Date diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Usuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuarios usuariosId) {
        this.usuariosId = usuariosId;
    }

    public Turno getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Turno turnoId) {
        this.turnoId = turnoId;
    }
}
