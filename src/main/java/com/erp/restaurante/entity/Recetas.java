package com.erp.restaurante.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "recetas")
public class Recetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cantidad_ingrediente")
    private int cantidadIngrediente;
    @JoinColumn(name = "ingredientes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingredientes ingredientesId;
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto productoId;

    public Recetas() {
    }

    public Recetas(Integer id) {
        this.id = id;
    }

    public Recetas(Integer id, int cantidadIngrediente) {
        this.id = id;
        this.cantidadIngrediente = cantidadIngrediente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidadIngrediente() {
        return cantidadIngrediente;
    }

    public void setCantidadIngrediente(int cantidadIngrediente) {
        this.cantidadIngrediente = cantidadIngrediente;
    }

    public Ingredientes getIngredientesId() {
        return ingredientesId;
    }

    public void setIngredientesId(Ingredientes ingredientesId) {
        this.ingredientesId = ingredientesId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
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
        if (!(object instanceof Recetas)) {
            return false;
        }
        Recetas other = (Recetas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.restaurante.entity.Recetas[ id=" + id + " ]";
    }
    
}
