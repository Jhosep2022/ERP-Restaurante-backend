package com.erp.restaurante.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "descuento", catalog = "ERPRestuaranteDB", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d"),
    @NamedQuery(name = "Descuento.findById", query = "SELECT d FROM Descuento d WHERE d.id = :id"),
    @NamedQuery(name = "Descuento.findByTipoDescuento", query = "SELECT d FROM Descuento d WHERE d.tipoDescuento = :tipoDescuento"),
    @NamedQuery(name = "Descuento.findByMonto", query = "SELECT d FROM Descuento d WHERE d.monto = :monto"),
    @NamedQuery(name = "Descuento.findByFecha", query = "SELECT d FROM Descuento d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Descuento.findByJustificacion", query = "SELECT d FROM Descuento d WHERE d.justificacion = :justificacion")})
public class Descuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo_descuento")
    private String tipoDescuento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "justificacion")
    private String justificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descuentoId")
    private Collection<Historialsalarios> historialsalariosCollection;
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleadoId;

    public Descuento() {
    }

    public Descuento(Integer id) {
        this.id = id;
    }

    public Descuento(Integer id, String tipoDescuento, BigDecimal monto, Date fecha, String justificacion) {
        this.id = id;
        this.tipoDescuento = tipoDescuento;
        this.monto = monto;
        this.fecha = fecha;
        this.justificacion = justificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public Collection<Historialsalarios> getHistorialsalariosCollection() {
        return historialsalariosCollection;
    }

    public void setHistorialsalariosCollection(Collection<Historialsalarios> historialsalariosCollection) {
        this.historialsalariosCollection = historialsalariosCollection;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
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
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Descuento[ id=" + id + " ]";
    }
    
}
