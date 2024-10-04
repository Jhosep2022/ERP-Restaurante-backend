/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.restaurante.entity;

import java.io.Serializable;
import jakarta.persistence.*;
@Entity
@Table(name = "bonos_empleados")
@NamedQueries({
    @NamedQuery(name = "BonosEmpleados.findAll", query = "SELECT b FROM BonosEmpleados b"),
    @NamedQuery(name = "BonosEmpleados.findById", query = "SELECT b FROM BonosEmpleados b WHERE b.id = :id")})
public class BonosEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "bonos_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Bonos bonosId;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuariosId;

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

    public Usuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuarios usuariosId) {
        this.usuariosId = usuariosId;
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
