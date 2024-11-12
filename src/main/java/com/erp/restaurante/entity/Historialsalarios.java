package com.erp.restaurante.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "historialsalarios")
public class Historialsalarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "salario")
    private BigDecimal salario;

    @Basic(optional = false)
    @Column(name = "fechapago")
    private LocalDate fechapago; // Cambiado a LocalDate

    @JoinColumn(name = "descuento_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Descuento descuentoId;

    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuariosId;

    public Historialsalarios() {
    }

    public Historialsalarios(Integer id, BigDecimal salario, LocalDate fechapago, Descuento descuentoId, Usuarios usuariosId) {
        this.id = id;
        this.salario = salario;
        this.fechapago = fechapago;
        this.descuentoId = descuentoId;
        this.usuariosId = usuariosId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getFechapago() {
        return fechapago;
    }

    public void setFechapago(LocalDate fechapago) {
        this.fechapago = fechapago;
    }

    public Descuento getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(Descuento descuentoId) {
        this.descuentoId = descuentoId;
    }

    public Usuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuarios usuariosId) {
        this.usuariosId = usuariosId;
    }
}
