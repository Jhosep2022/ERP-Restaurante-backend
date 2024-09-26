/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.restaurante.entity;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.*;
@Entity
@Table(name = "ingredientes")
@NamedQueries({
    @NamedQuery(name = "Ingredientes.findAll", query = "SELECT i FROM Ingredientes i"),
    @NamedQuery(name = "Ingredientes.findById", query = "SELECT i FROM Ingredientes i WHERE i.id = :id"),
    @NamedQuery(name = "Ingredientes.findByNombreIngrediente", query = "SELECT i FROM Ingredientes i WHERE i.nombreIngrediente = :nombreIngrediente"),
    @NamedQuery(name = "Ingredientes.findByDescripcion", query = "SELECT i FROM Ingredientes i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Ingredientes.findByStockActual", query = "SELECT i FROM Ingredientes i WHERE i.stockActual = :stockActual")})
public class Ingredientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_ingrediente")
    private String nombreIngrediente;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private int descripcion;
    @Basic(optional = false)
    @Column(name = "stock_actual")
    private int stockActual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredientesId", fetch = FetchType.LAZY)
    private Collection<Recetas> recetasCollection;

    public Ingredientes() {
    }

    public Ingredientes(Integer id) {
        this.id = id;
    }

    public Ingredientes(Integer id, String nombreIngrediente, int descripcion, int stockActual) {
        this.id = id;
        this.nombreIngrediente = nombreIngrediente;
        this.descripcion = descripcion;
        this.stockActual = stockActual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public Collection<Recetas> getRecetasCollection() {
        return recetasCollection;
    }

    public void setRecetasCollection(Collection<Recetas> recetasCollection) {
        this.recetasCollection = recetasCollection;
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
        if (!(object instanceof Ingredientes)) {
            return false;
        }
        Ingredientes other = (Ingredientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Ingredientes[ id=" + id + " ]";
    }
    
}
