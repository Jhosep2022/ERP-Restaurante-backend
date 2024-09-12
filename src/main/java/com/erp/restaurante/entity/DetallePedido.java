package com.erp.restaurante.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import jakarta.persistence.*;


@Entity
@Table(name = "detalle_pedido", catalog = "ERPRestuaranteDB", schema = "public")
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d"),
    @NamedQuery(name = "DetallePedido.findById", query = "SELECT d FROM DetallePedido d WHERE d.id = :id"),
    @NamedQuery(name = "DetallePedido.findByCantidad", query = "SELECT d FROM DetallePedido d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetallePedido.findByPrecioUnitario", query = "SELECT d FROM DetallePedido d WHERE d.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "DetallePedido.findBySubTotal", query = "SELECT d FROM DetallePedido d WHERE d.subTotal = :subTotal")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
    @Basic(optional = false)
    @Column(name = "sub_total")
    private BigDecimal subTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detallePedidoId")
    private Collection<Facturas> facturasCollection;
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pedido pedidoId;
    @JoinColumn(name = "ventas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ventas ventasId;

    public DetallePedido() {
    }

    public DetallePedido(Integer id) {
        this.id = id;
    }

    public DetallePedido(Integer id, int cantidad, BigDecimal precioUnitario, BigDecimal subTotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Collection<Facturas> getFacturasCollection() {
        return facturasCollection;
    }

    public void setFacturasCollection(Collection<Facturas> facturasCollection) {
        this.facturasCollection = facturasCollection;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Ventas getVentasId() {
        return ventasId;
    }

    public void setVentasId(Ventas ventasId) {
        this.ventasId = ventasId;
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
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.DetallePedido[ id=" + id + " ]";
    }
    
}
