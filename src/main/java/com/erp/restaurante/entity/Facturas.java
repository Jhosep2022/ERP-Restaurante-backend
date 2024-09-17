package com.erp.restaurante.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "facturas")
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @Column(name = "numero_factura")
    private String numeroFactura;
    @Basic(optional = false)
    @Column(name = "cuf")
    private String cuf;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @JoinColumn(name = "detalle_pedido_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DetallePedido detallePedidoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturasId")
    private Collection<FacturasImpuesto> facturasImpuestoCollection;

    public Facturas() {
    }

    public Facturas(Integer id) {
        this.id = id;
    }

    public Facturas(Integer id, Date fecha, String estado, BigDecimal total, String numeroFactura, String cuf) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.numeroFactura = numeroFactura;
        this.cuf = cuf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCuf() {
        return cuf;
    }

    public void setCuf(String cuf) {
        this.cuf = cuf;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public DetallePedido getDetallePedidoId() {
        return detallePedidoId;
    }

    public void setDetallePedidoId(DetallePedido detallePedidoId) {
        this.detallePedidoId = detallePedidoId;
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
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Facturas[ id=" + id + " ]";
    }
    
}
