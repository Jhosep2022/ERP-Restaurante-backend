package com.erp.restaurante.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import jakarta.persistence.*;

@Entity
@Table(name = "impuesto", catalog = "ERPRestuaranteDB", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Impuesto.findAll", query = "SELECT i FROM Impuesto i"),
    @NamedQuery(name = "Impuesto.findById", query = "SELECT i FROM Impuesto i WHERE i.id = :id"),
    @NamedQuery(name = "Impuesto.findByNombre", query = "SELECT i FROM Impuesto i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Impuesto.findByPorcentaje", query = "SELECT i FROM Impuesto i WHERE i.porcentaje = :porcentaje")})
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "porcentaje")
    private BigDecimal porcentaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "impuestoId")
    private Collection<FacturasImpuesto> facturasImpuestoCollection;

    public Impuesto() {
    }

    public Impuesto(Integer id) {
        this.id = id;
    }

    public Impuesto(Integer id, String nombre, BigDecimal porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
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

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Collection<FacturasImpuesto> getFacturasImpuestoCollection() {
        return facturasImpuestoCollection;
    }

    public void setFacturasImpuestoCollection(Collection<FacturasImpuesto> facturasImpuestoCollection) {
        this.facturasImpuestoCollection = facturasImpuestoCollection;
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
        if (!(object instanceof Impuesto)) {
            return false;
        }
        Impuesto other = (Impuesto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Impuesto[ id=" + id + " ]";
    }
    
}
