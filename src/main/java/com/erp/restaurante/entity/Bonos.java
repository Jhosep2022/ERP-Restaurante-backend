package com.erp.restaurante.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import jakarta.persistence.*;


@Entity
@Table(name = "bonos")

public class Bonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "monto")
    private BigDecimal monto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonosId")
    private Collection<BonosEmpleados> bonosEmpleadosCollection;

    public Bonos() {
    }

    public Bonos(Integer id) {
        this.id = id;
    }

    public Bonos(Integer id, String nombre, BigDecimal monto) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Collection<BonosEmpleados> getBonosEmpleadosCollection() {
        return bonosEmpleadosCollection;
    }

    public void setBonosEmpleadosCollection(Collection<BonosEmpleados> bonosEmpleadosCollection) {
        this.bonosEmpleadosCollection = bonosEmpleadosCollection;
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
        if (!(object instanceof Bonos)) {
            return false;
        }
        Bonos other = (Bonos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Bonos[ id=" + id + " ]";
    }
    
}
