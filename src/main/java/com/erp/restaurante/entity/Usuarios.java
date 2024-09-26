package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "emp_code", unique = true, nullable = false) // Campo único para emp_code
    private String empCode;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = true)
    @Column(name = "primer_apellido", nullable = true)
    private String primerApellido;

    @Basic(optional = true)
    @Column(name = "segundo_apellido", nullable = true)
    private String segundoApellido;

    @Basic(optional = true)
    @Column(name = "correo", nullable = true)
    private String correo;

    @Basic(optional = true)
    @Column(name = "password", nullable = true)
    private String password;

    @Basic(optional = true)
    @Column(name = "fecha_ingreso",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Basic(optional = true)
    @Column(name = "estado", nullable = false)
    private boolean estado = true;

    @Basic(optional = true)
    @Column(name = "direccion", nullable = true)
    private String direccion;

    @Basic(optional = true)
    @Column(name = "edad", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date edad;

    @Basic(optional = true)
    @Column(name = "telefono",nullable = true)
    private String telefono;

    // Relaciones y colecciones
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosId", fetch = FetchType.LAZY)
    private Collection<Historialsalarios> historialsalariosCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosId", fetch = FetchType.LAZY)
    private Collection<Contrato> contratoCollection;

    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Roles rolesId;

    @JoinColumn(name = "sucursal_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal sucursalId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosId", fetch = FetchType.LAZY)
    private Collection<Registroentradasalida> registroentradasalidaCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosId", fetch = FetchType.LAZY)
    private Collection<BonosEmpleados> bonosEmpleadosCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosId", fetch = FetchType.LAZY)
    private Collection<Horariostrabajo> horariostrabajoCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosId", fetch = FetchType.LAZY)
    private Collection<Vacaciones> vacacionesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosId", fetch = FetchType.LAZY)
    private Collection<Auditoria> auditoriaCollection;

    public Usuarios() {}

    public Usuarios(Integer id, String nombre, String primerApellido, String segundoApellido, String correo, String password, Date fechaIngreso, boolean estado, String direccion, Date edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.password = password;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
    }

    public Usuarios(Integer id, String empCode, String nombre, String primerApellido, String segundoApellido, String correo, String password, Date fechaIngreso, boolean estado, String direccion, Date edad, String telefono, Collection<Historialsalarios> historialsalariosCollection, Collection<Contrato> contratoCollection, Roles rolesId, Sucursal sucursalId, Collection<Registroentradasalida> registroentradasalidaCollection, Collection<BonosEmpleados> bonosEmpleadosCollection, Collection<Horariostrabajo> horariostrabajoCollection, Collection<Vacaciones> vacacionesCollection, Collection<Auditoria> auditoriaCollection) {
        this.id = id;
        this.empCode = empCode;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.password = password;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
        this.historialsalariosCollection = historialsalariosCollection;
        this.contratoCollection = contratoCollection;
        this.rolesId = rolesId;
        this.sucursalId = sucursalId;
        this.registroentradasalidaCollection = registroentradasalidaCollection;
        this.bonosEmpleadosCollection = bonosEmpleadosCollection;
        this.horariostrabajoCollection = horariostrabajoCollection;
        this.vacacionesCollection = vacacionesCollection;
        this.auditoriaCollection = auditoriaCollection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getEdad() {
        return edad;
    }

    public void setEdad(Date edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Collection<Historialsalarios> getHistorialsalariosCollection() {
        return historialsalariosCollection;
    }

    public void setHistorialsalariosCollection(Collection<Historialsalarios> historialsalariosCollection) {
        this.historialsalariosCollection = historialsalariosCollection;
    }

    public Collection<Contrato> getContratoCollection() {
        return contratoCollection;
    }

    public void setContratoCollection(Collection<Contrato> contratoCollection) {
        this.contratoCollection = contratoCollection;
    }

    public Roles getRolesId() {
        return rolesId;
    }

    public void setRolesId(Roles rolesId) {
        this.rolesId = rolesId;
    }

    public Sucursal getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Sucursal sucursalId) {
        this.sucursalId = sucursalId;
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

    public Collection<Horariostrabajo> getHorariostrabajoCollection() {
        return horariostrabajoCollection;
    }

    public void setHorariostrabajoCollection(Collection<Horariostrabajo> horariostrabajoCollection) {
        this.horariostrabajoCollection = horariostrabajoCollection;
    }

    public Collection<Vacaciones> getVacacionesCollection() {
        return vacacionesCollection;
    }

    public void setVacacionesCollection(Collection<Vacaciones> vacacionesCollection) {
        this.vacacionesCollection = vacacionesCollection;
    }

    public Collection<Auditoria> getAuditoriaCollection() {
        return auditoriaCollection;
    }

    public void setAuditoriaCollection(Collection<Auditoria> auditoriaCollection) {
        this.auditoriaCollection = auditoriaCollection;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", empCode='" + empCode + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", estado=" + estado +
                ", direccion='" + direccion + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", historialsalariosCollection=" + historialsalariosCollection +
                ", contratoCollection=" + contratoCollection +
                ", rolesId=" + rolesId +
                ", sucursalId=" + sucursalId +
                ", registroentradasalidaCollection=" + registroentradasalidaCollection +
                ", bonosEmpleadosCollection=" + bonosEmpleadosCollection +
                ", horariostrabajoCollection=" + horariostrabajoCollection +
                ", vacacionesCollection=" + vacacionesCollection +
                ", auditoriaCollection=" + auditoriaCollection +
                '}';
    }
}
