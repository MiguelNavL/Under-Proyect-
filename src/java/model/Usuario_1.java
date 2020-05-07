/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David Parra
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario_1.findAll", query = "SELECT u FROM Usuario_1 u"),
    @NamedQuery(name = "Usuario_1.findByNombreUsuario", query = "SELECT u FROM Usuario_1 u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuario_1.findByContrase\u00f1aUsuario", query = "SELECT u FROM Usuario_1 u WHERE u.contrase\u00f1aUsuario = :contrase\u00f1aUsuario"),
    @NamedQuery(name = "Usuario_1.findByTerrenoUsuario", query = "SELECT u FROM Usuario_1 u WHERE u.terrenoUsuario = :terrenoUsuario"),
    @NamedQuery(name = "Usuario_1.findByPresupuestoUsuario", query = "SELECT u FROM Usuario_1 u WHERE u.presupuestoUsuario = :presupuestoUsuario")})
public class Usuario_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contrase\u00f1a_usuario")
    private String contraseñaUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "terreno_usuario")
    private int terrenoUsuario;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "correo_usuario")
    private String correoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presupuesto_usuario")
    private int presupuestoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreUsuario1")
    private List<Cuenta> cuentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreUsuario2")
    private List<Terreno> terrenoList;

    public Usuario_1() {
    }

    public Usuario_1(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario_1(String nombreUsuario, String contraseñaUsuario, int terrenoUsuario, String correoUsuario, int presupuestoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
        this.terrenoUsuario = terrenoUsuario;
        this.correoUsuario = correoUsuario;
        this.presupuestoUsuario = presupuestoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public int getTerrenoUsuario() {
        return terrenoUsuario;
    }

    public void setTerrenoUsuario(int terrenoUsuario) {
        this.terrenoUsuario = terrenoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getPresupuestoUsuario() {
        return presupuestoUsuario;
    }

    public void setPresupuestoUsuario(int presupuestoUsuario) {
        this.presupuestoUsuario = presupuestoUsuario;
    }

    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    public List<Terreno> getTerrenoList() {
        return terrenoList;
    }

    public void setTerrenoList(List<Terreno> terrenoList) {
        this.terrenoList = terrenoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario_1)) {
            return false;
        }
        Usuario_1 other = (Usuario_1) object;
        if ((this.nombreUsuario == null && other.nombreUsuario != null) || (this.nombreUsuario != null && !this.nombreUsuario.equals(other.nombreUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario_1[ nombreUsuario=" + nombreUsuario + " ]";
    }
    
}
