package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "registroentradasalida")
public class Registroentradasalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora_entrada")
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;
    @Basic(optional = false)
    @Column(name = "hora_salida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Basic(optional = false)
    @Column(name = "retraso")
    private boolean retraso;
    @JoinColumn(name = "empleados_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleadosId;

    public Registroentradasalida() {
    }

    public Registroentradasalida(Integer id) {
        this.id = id;
    }

    public Registroentradasalida(Integer id, Date fecha, Date horaEntrada, Date horaSalida, boolean retraso) {
        this.id = id;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.retraso = retraso;
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

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public boolean getRetraso() {
        return retraso;
    }

    public void setRetraso(boolean retraso) {
        this.retraso = retraso;
    }

    public Empleado getEmpleadosId() {
        return empleadosId;
    }

    public void setEmpleadosId(Empleado empleadosId) {
        this.empleadosId = empleadosId;
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
        if (!(object instanceof Registroentradasalida)) {
            return false;
        }
        Registroentradasalida other = (Registroentradasalida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Registroentradasalida[ id=" + id + " ]";
    }
    
}
