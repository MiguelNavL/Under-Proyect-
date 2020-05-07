/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author David Parra
 */
@Entity
@Table(name = "cuenta")
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByTipoCuenta", query = "SELECT c FROM Cuenta c WHERE c.tipoCuenta = :tipoCuenta")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_cuenta")
    private Integer tipoCuenta;
    @JoinColumn(name = "nombre_usuario1", referencedColumnName = "nombre_usuario")
    @ManyToOne(optional = false)
    private Usuario_1 nombreUsuario1;

    public Cuenta() {
    }

    public Cuenta(Integer tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Integer getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(Integer tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Usuario_1 getNombreUsuario1() {
        return nombreUsuario1;
    }

    public void setNombreUsuario1(Usuario_1 nombreUsuario1) {
        this.nombreUsuario1 = nombreUsuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCuenta != null ? tipoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.tipoCuenta == null && other.tipoCuenta != null) || (this.tipoCuenta != null && !this.tipoCuenta.equals(other.tipoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cuenta[ tipoCuenta=" + tipoCuenta + " ]";
    }
    
}
