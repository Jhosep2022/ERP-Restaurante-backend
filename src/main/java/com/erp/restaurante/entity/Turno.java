package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "turno")
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;

    @Basic(optional = false)
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;

    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;

    // Añadir @JsonIgnore para evitar el problema de inicialización perezosa
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turnoId", fetch = FetchType.LAZY)
    @JsonIgnore // Evita la serialización de la colección
    private Collection<Horariostrabajo> horariostrabajoCollection;

    // Constructores, getters y setters
    public Turno() {
    }

    public Turno(Integer id, String nombre, String descripcion, Date horaInicio, Date horaFin, String dia) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.dia = dia;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Collection<Horariostrabajo> getHorariostrabajoCollection() {
        return horariostrabajoCollection;
    }

    public void setHorariostrabajoCollection(Collection<Horariostrabajo> horariostrabajoCollection) {
        this.horariostrabajoCollection = horariostrabajoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Turno[ id=" + id + " ]";
    }
}
