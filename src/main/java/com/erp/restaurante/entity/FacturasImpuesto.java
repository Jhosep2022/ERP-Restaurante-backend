package com.erp.restaurante.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "facturas_impuesto", catalog = "ERPRestuaranteDB", schema = "public")
@NamedQueries({
    @NamedQuery(name = "FacturasImpuesto.findAll", query = "SELECT f FROM FacturasImpuesto f"),
    @NamedQuery(name = "FacturasImpuesto.findById", query = "SELECT f FROM FacturasImpuesto f WHERE f.id = :id"),
    @NamedQuery(name = "FacturasImpuesto.findByMonto", query = "SELECT f FROM FacturasImpuesto f WHERE f.monto = :monto")})
public class FacturasImpuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "monto")
    private BigDecimal monto;
    @JoinColumn(name = "facturas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Facturas facturasId;
    @JoinColumn(name = "impuesto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Impuesto impuestoId;

    public FacturasImpuesto() {
    }

    public FacturasImpuesto(Integer id) {
        this.id = id;
    }

    public FacturasImpuesto(Integer id, BigDecimal monto) {
        this.id = id;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Facturas getFacturasId() {
        return facturasId;
    }

    public void setFacturasId(Facturas facturasId) {
        this.facturasId = facturasId;
    }

    public Impuesto getImpuestoId() {
        return impuestoId;
    }

    public void setImpuestoId(Impuesto impuestoId) {
        this.impuestoId = impuestoId;
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
        if (!(object instanceof FacturasImpuesto)) {
            return false;
        }
        FacturasImpuesto other = (FacturasImpuesto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.FacturasImpuesto[ id=" + id + " ]";
    }
    
}
