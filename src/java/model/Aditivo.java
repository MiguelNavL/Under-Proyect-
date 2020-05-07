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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author David Parra
 */
@Entity
@Table(name = "aditivo")
@NamedQueries({
    @NamedQuery(name = "Aditivo.findAll", query = "SELECT a FROM Aditivo a"),
    @NamedQuery(name = "Aditivo.findByCantidadAditivo", query = "SELECT a FROM Aditivo a WHERE a.cantidadAditivo = :cantidadAditivo")})
public class Aditivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cantidad_aditivo")
    private Integer cantidadAditivo;
    @JoinTable(name = "cultivo_aditivo", joinColumns = {
        @JoinColumn(name = "cantidad_aditivo1", referencedColumnName = "cantidad_aditivo")}, inverseJoinColumns = {
        @JoinColumn(name = "tama\u00f1o_cultivo2", referencedColumnName = "tama\u00f1o_cultivo")})
    @ManyToMany
    private List<Cultivo> cultivoList;

    public Aditivo() {
    }

    public Aditivo(Integer cantidadAditivo) {
        this.cantidadAditivo = cantidadAditivo;
    }

    public Integer getCantidadAditivo() {
        return cantidadAditivo;
    }

    public void setCantidadAditivo(Integer cantidadAditivo) {
        this.cantidadAditivo = cantidadAditivo;
    }

    public List<Cultivo> getCultivoList() {
        return cultivoList;
    }

    public void setCultivoList(List<Cultivo> cultivoList) {
        this.cultivoList = cultivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantidadAditivo != null ? cantidadAditivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aditivo)) {
            return false;
        }
        Aditivo other = (Aditivo) object;
        if ((this.cantidadAditivo == null && other.cantidadAditivo != null) || (this.cantidadAditivo != null && !this.cantidadAditivo.equals(other.cantidadAditivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aditivo[ cantidadAditivo=" + cantidadAditivo + " ]";
    }
    
}
