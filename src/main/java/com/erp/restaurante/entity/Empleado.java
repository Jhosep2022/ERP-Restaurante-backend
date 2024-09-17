package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private Collection<Historialsalarios> historialsalariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private Collection<Usuarios> usuariosCollection;
    @JoinColumn(name = "contrato_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contrato contratoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private Collection<Horariostrabajo> horariostrabajoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private Collection<Descuento> descuentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadosId")
    private Collection<Registroentradasalida> registroentradasalidaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private Collection<BonosEmpleados> bonosEmpleadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private Collection<Vacaciones> vacacionesCollection;

    public Empleado() {
    }

    public Empleado(Integer id) {
        this.id = id;
    }

    public Empleado(Integer id, Date fechaIngreso) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Collection<Historialsalarios> getHistorialsalariosCollection() {
        return historialsalariosCollection;
    }

    public void setHistorialsalariosCollection(Collection<Historialsalarios> historialsalariosCollection) {
        this.historialsalariosCollection = historialsalariosCollection;
    }

    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Contrato getContratoId() {
        return contratoId;
    }

    public void setContratoId(Contrato contratoId) {
        this.contratoId = contratoId;
    }

    public Collection<Horariostrabajo> getHorariostrabajoCollection() {
        return horariostrabajoCollection;
    }

    public void setHorariostrabajoCollection(Collection<Horariostrabajo> horariostrabajoCollection) {
        this.horariostrabajoCollection = horariostrabajoCollection;
    }

    public Collection<Descuento> getDescuentoCollection() {
        return descuentoCollection;
    }

    public void setDescuentoCollection(Collection<Descuento> descuentoCollection) {
        this.descuentoCollection = descuentoCollection;
    }

    public Collection<Registroentradasalida> getRegistroentradasalidaCollection() {
        return registroentradasalidaCollection;
    }

    public void setRegistroentradasalidaCollection(Collection<Registroentradasalida> registroentradasalidaCollection) {
        this.registroentradasalidaCollection = registroentradasalidaCollection;
    }

    public Collection<BonosEmpleados> getBonosEmpleadosCollection() {
        return bonosEmpleadosCollection;
    }

    public void setBonosEmpleadosCollection(Collection<BonosEmpleados> bonosEmpleadosCollection) {
        this.bonosEmpleadosCollection = bonosEmpleadosCollection;
    }

    public Collection<Vacaciones> getVacacionesCollection() {
        return vacacionesCollection;
    }

    public void setVacacionesCollection(Collection<Vacaciones> vacacionesCollection) {
        this.vacacionesCollection = vacacionesCollection;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Empleado[ id=" + id + " ]";
    }
    
}
