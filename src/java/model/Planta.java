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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "planta")
@NamedQueries({
    @NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p"),
    @NamedQuery(name = "Planta.findByAditivoPlanta", query = "SELECT p FROM Planta p WHERE p.aditivoPlanta = :aditivoPlanta")})
public class Planta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "aditivo_planta")
    private Integer aditivoPlanta;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "fichaTecnica_planta")
    private String fichaTecnicaplanta;
    @JoinTable(name = "cultivo_planta", joinColumns = {
        @JoinColumn(name = "aditivo_planta1", referencedColumnName = "aditivo_planta")}, inverseJoinColumns = {
        @JoinColumn(name = "tama\u00f1o_cultivo3", referencedColumnName = "tama\u00f1o_cultivo")})
    @ManyToMany
    private List<Cultivo> cultivoList;

    public Planta() {
    }

    public Planta(Integer aditivoPlanta) {
        this.aditivoPlanta = aditivoPlanta;
    }

    public Planta(Integer aditivoPlanta, String fichaTecnicaplanta) {
        this.aditivoPlanta = aditivoPlanta;
        this.fichaTecnicaplanta = fichaTecnicaplanta;
    }

    public Integer getAditivoPlanta() {
        return aditivoPlanta;
    }

    public void setAditivoPlanta(Integer aditivoPlanta) {
        this.aditivoPlanta = aditivoPlanta;
    }

    public String getFichaTecnicaplanta() {
        return fichaTecnicaplanta;
    }

    public void setFichaTecnicaplanta(String fichaTecnicaplanta) {
        this.fichaTecnicaplanta = fichaTecnicaplanta;
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
        hash += (aditivoPlanta != null ? aditivoPlanta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planta)) {
            return false;
        }
        Planta other = (Planta) object;
        if ((this.aditivoPlanta == null && other.aditivoPlanta != null) || (this.aditivoPlanta != null && !this.aditivoPlanta.equals(other.aditivoPlanta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Planta[ aditivoPlanta=" + aditivoPlanta + " ]";
    }
    
}
