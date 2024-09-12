package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "auditoria", catalog = "ERPRestuaranteDB", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a"),
    @NamedQuery(name = "Auditoria.findById", query = "SELECT a FROM Auditoria a WHERE a.id = :id"),
    @NamedQuery(name = "Auditoria.findByTabla", query = "SELECT a FROM Auditoria a WHERE a.tabla = :tabla"),
    @NamedQuery(name = "Auditoria.findByAccion", query = "SELECT a FROM Auditoria a WHERE a.accion = :accion"),
    @NamedQuery(name = "Auditoria.findByFecfhaHora", query = "SELECT a FROM Auditoria a WHERE a.fecfhaHora = :fecfhaHora"),
    @NamedQuery(name = "Auditoria.findByDetalle", query = "SELECT a FROM Auditoria a WHERE a.detalle = :detalle"),
    @NamedQuery(name = "Auditoria.findByRegistroId", query = "SELECT a FROM Auditoria a WHERE a.registroId = :registroId")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tabla")
    private String tabla;
    @Basic(optional = false)
    @Column(name = "accion")
    private String accion;
    @Basic(optional = false)
    @Column(name = "fecfha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecfhaHora;
    @Basic(optional = false)
    @Lob
    @Column(name = "cambios")
    private Object cambios;
    @Basic(optional = false)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @Column(name = "registro_id")
    private int registroId;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuariosId;

    public Auditoria() {
    }

    public Auditoria(Integer id) {
        this.id = id;
    }

    public Auditoria(Integer id, String tabla, String accion, Date fecfhaHora, Object cambios, String detalle, int registroId) {
        this.id = id;
        this.tabla = tabla;
        this.accion = accion;
        this.fecfhaHora = fecfhaHora;
        this.cambios = cambios;
        this.detalle = detalle;
        this.registroId = registroId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecfhaHora() {
        return fecfhaHora;
    }

    public void setFecfhaHora(Date fecfhaHora) {
        this.fecfhaHora = fecfhaHora;
    }

    public Object getCambios() {
        return cambios;
    }

    public void setCambios(Object cambios) {
        this.cambios = cambios;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getRegistroId() {
        return registroId;
    }

    public void setRegistroId(int registroId) {
        this.registroId = registroId;
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
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Auditoria[ id=" + id + " ]";
    }
    
}
