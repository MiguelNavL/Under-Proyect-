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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author David Parra
 */
@Entity
@Table(name = "cultivo")
@NamedQueries({
    @NamedQuery(name = "Cultivo.findAll", query = "SELECT c FROM Cultivo c"),
    @NamedQuery(name = "Cultivo.findByTama\u00f1oCultivo", query = "SELECT c FROM Cultivo c WHERE c.tama\u00f1oCultivo = :tama\u00f1oCultivo"),
    @NamedQuery(name = "Cultivo.findByPlantaCultivo", query = "SELECT c FROM Cultivo c WHERE c.plantaCultivo = :plantaCultivo")})
public class Cultivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tama\u00f1o_cultivo")
    private Integer tamañoCultivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planta_cultivo")
    private int plantaCultivo;
    @ManyToMany(mappedBy = "cultivoList")
    private List<Terreno> terrenoList;
    @ManyToMany(mappedBy = "cultivoList")
    private List<Aditivo> aditivoList;
    @ManyToMany(mappedBy = "cultivoList")
    private List<Planta> plantaList;

    public Cultivo() {
    }

    public Cultivo(Integer tamañoCultivo) {
        this.tamañoCultivo = tamañoCultivo;
    }

    public Cultivo(Integer tamañoCultivo, int plantaCultivo) {
        this.tamañoCultivo = tamañoCultivo;
        this.plantaCultivo = plantaCultivo;
    }

    public Integer getTamañoCultivo() {
        return tamañoCultivo;
    }

    public void setTamañoCultivo(Integer tamañoCultivo) {
        this.tamañoCultivo = tamañoCultivo;
    }

    public int getPlantaCultivo() {
        return plantaCultivo;
    }

    public void setPlantaCultivo(int plantaCultivo) {
        this.plantaCultivo = plantaCultivo;
    }

    public List<Terreno> getTerrenoList() {
        return terrenoList;
    }

    public void setTerrenoList(List<Terreno> terrenoList) {
        this.terrenoList = terrenoList;
    }

    public List<Aditivo> getAditivoList() {
        return aditivoList;
    }

    public void setAditivoList(List<Aditivo> aditivoList) {
        this.aditivoList = aditivoList;
    }

    public List<Planta> getPlantaList() {
        return plantaList;
    }

    public void setPlantaList(List<Planta> plantaList) {
        this.plantaList = plantaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tamañoCultivo != null ? tamañoCultivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cultivo)) {
            return false;
        }
        Cultivo other = (Cultivo) object;
        if ((this.tamañoCultivo == null && other.tamañoCultivo != null) || (this.tamañoCultivo != null && !this.tamañoCultivo.equals(other.tamañoCultivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cultivo[ tama\u00f1oCultivo=" + tamañoCultivo + " ]";
    }
    
}
