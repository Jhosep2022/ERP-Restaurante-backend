package com.erp.restaurante.entity;

import java.io.Serializable;
import jakarta.persistence.*;


@Table(name = "bonos_empleados", catalog = "ERPRestuaranteDB", schema = "public")

public class BonosEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "bonos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bonos bonosId;
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleadoId;

    public BonosEmpleados() {
    }

    public BonosEmpleados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bonos getBonosId() {
        return bonosId;
    }

    public void setBonosId(Bonos bonosId) {
        this.bonosId = bonosId;
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
        if (!(object instanceof BonosEmpleados)) {
            return false;
        }
        BonosEmpleados other = (BonosEmpleados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.BonosEmpleados[ id=" + id + " ]";
    }
    
}
