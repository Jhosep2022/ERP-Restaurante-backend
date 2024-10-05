package com.erp.restaurante.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "RegistroEntradaSalida")
public class Registroentradasalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_marcada", nullable = false)
    private LocalTime horaMarcada;

    @Column(name = "tipo_marcado", nullable = false)
    private Integer tipoMarcado;

    @Column(name = "retraso", nullable = false)
    private Boolean retraso;

    @ManyToOne
    @JoinColumn(name = "Usuarios_id", referencedColumnName = "id", nullable = false)
    private Usuarios usuario; // <-- Aquí la propiedad debe coincidir con "mappedBy" en Usuarios

    public Registroentradasalida() {}

    public Registroentradasalida(Long id, LocalDate fecha, LocalTime horaMarcada, Integer tipoMarcado, Boolean retraso, Usuarios usuario) {
        this.id = id;
        this.fecha = fecha;
        this.horaMarcada = horaMarcada;
        this.tipoMarcado = tipoMarcado;
        this.retraso = retraso;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraMarcada() {
        return horaMarcada;
    }

    public void setHoraMarcada(LocalTime horaMarcada) {
        this.horaMarcada = horaMarcada;
    }

    public Integer getTipoMarcado() {
        return tipoMarcado;
    }

    public void setTipoMarcado(Integer tipoMarcado) {
        this.tipoMarcado = tipoMarcado;
    }

    public Boolean getRetraso() {
        return retraso;
    }

    public void setRetraso(Boolean retraso) {
        this.retraso = retraso;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
