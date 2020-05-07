/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David Parra
 */
@Entity
@Table(name = "terreno")
@NamedQueries({
    @NamedQuery(name = "Terreno.findAll", query = "SELECT t FROM Terreno t"),
    @NamedQuery(name = "Terreno.findByCultivoTerreno", query = "SELECT t FROM Terreno t WHERE t.cultivoTerreno = :cultivoTerreno"),
    @NamedQuery(name = "Terreno.findByUbicacionTerreno", query = "SELECT t FROM Terreno t WHERE t.ubicacionTerreno = :ubicacionTerreno")})
public class Terreno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cultivo_terreno")
    private Integer cultivoTerreno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ubicacion_terreno")
    private int ubicacionTerreno;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "suelo_terreno")
    private String sueloTerreno;
    @JoinTable(name = "terreno_cultivo", joinColumns = {
        @JoinColumn(name = "cultivo_terreno1", referencedColumnName = "cultivo_terreno")}, inverseJoinColumns = {
        @JoinColumn(name = "tama\u00f1o_cultivo1", referencedColumnName = "tama\u00f1o_cultivo")})
    @ManyToMany
    private List<Cultivo> cultivoList;
    @JoinColumn(name = "nombre_usuario2", referencedColumnName = "nombre_usuario")
    @ManyToOne(optional = false)
    private Usuario_1 nombreUsuario2;

    public Terreno() {
    }

    public Terreno(Integer cultivoTerreno) {
        this.cultivoTerreno = cultivoTerreno;
    }

    public Terreno(Integer cultivoTerreno, int ubicacionTerreno, String sueloTerreno) {
        this.cultivoTerreno = cultivoTerreno;
        this.ubicacionTerreno = ubicacionTerreno;
        this.sueloTerreno = sueloTerreno;
    }

    public Integer getCultivoTerreno() {
        return cultivoTerreno;
    }

    public void setCultivoTerreno(Integer cultivoTerreno) {
        this.cultivoTerreno = cultivoTerreno;
    }

    public int getUbicacionTerreno() {
        return ubicacionTerreno;
    }

    public void setUbicacionTerreno(int ubicacionTerreno) {
        this.ubicacionTerreno = ubicacionTerreno;
    }

    public String getSueloTerreno() {
        return sueloTerreno;
    }

    public void setSueloTerreno(String sueloTerreno) {
        this.sueloTerreno = sueloTerreno;
    }

    public List<Cultivo> getCultivoList() {
        return cultivoList;
    }

    public void setCultivoList(List<Cultivo> cultivoList) {
        this.cultivoList = cultivoList;
    }

    public Usuario_1 getNombreUsuario2() {
        return nombreUsuario2;
    }

    public void setNombreUsuario2(Usuario_1 nombreUsuario2) {
        this.nombreUsuario2 = nombreUsuario2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cultivoTerreno != null ? cultivoTerreno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terreno)) {
            return false;
        }
        Terreno other = (Terreno) object;
        if ((this.cultivoTerreno == null && other.cultivoTerreno != null) || (this.cultivoTerreno != null && !this.cultivoTerreno.equals(other.cultivoTerreno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Terreno[ cultivoTerreno=" + cultivoTerreno + " ]";
    }
    
}
