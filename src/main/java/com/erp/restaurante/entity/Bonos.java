package com.erp.restaurante.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "bonos")
@NamedQueries({
        @NamedQuery(name = "Bonos.findAll", query = "SELECT b FROM Bonos b"),
        @NamedQuery(name = "Bonos.findById", query = "SELECT b FROM Bonos b WHERE b.id = :id"),
        @NamedQuery(name = "Bonos.findByNombre", query = "SELECT b FROM Bonos b WHERE b.nombre = :nombre"),
        @NamedQuery(name = "Bonos.findByMonto", query = "SELECT b FROM Bonos b WHERE b.monto = :monto")})
public class Bonos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Indica que el ID se genera automáticamente.
    @Column(name = "id", updatable = false, nullable = false)  // updatable = false y nullable = false aseguran que no se pueda cambiar el ID manualmente.
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nombre", length = 10, nullable = false)  // Se especifica una longitud máxima de 10 caracteres para nombre
    private String nombre;

    @Basic(optional = false)
    @Column(name = "monto", precision = 10, scale = 2, nullable = false)  // Configuración para el monto con precisión y escala
    private BigDecimal monto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonosId", fetch = FetchType.LAZY)
    private Collection<BonosEmpleados> bonosEmpleadosCollection;

    // Constructor vacío
    public Bonos() {
    }

    // Constructor con parámetros
    public Bonos(Integer id, String nombre, BigDecimal monto) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
    }

    // Getters y setters
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
        if (!(object instanceof Bonos)) {
            return false;
        }
        Bonos other = (Bonos) object;
        return this.id != null && this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Bonos[ id=" + id + " ]";
    }
}
