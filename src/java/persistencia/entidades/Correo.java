/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Entity
@Table(name = "correo")
@NamedQueries({
    @NamedQuery(name = "Correo.findAll", query = "SELECT c FROM Correo c")})
public class Correo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcorreo")
    private Integer idcorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "direccion_correo")
    private String direccionCorreo;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdusuario;

    public Correo() {
    }

    public Correo(Integer idcorreo) {
        this.idcorreo = idcorreo;
    }

    public Correo(Integer idcorreo, String direccionCorreo) {
        this.idcorreo = idcorreo;
        this.direccionCorreo = direccionCorreo;
    }

    public Integer getIdcorreo() {
        return idcorreo;
    }

    public void setIdcorreo(Integer idcorreo) {
        this.idcorreo = idcorreo;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcorreo != null ? idcorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correo)) {
            return false;
        }
        Correo other = (Correo) object;
        if ((this.idcorreo == null && other.idcorreo != null) || (this.idcorreo != null && !this.idcorreo.equals(other.idcorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Correo[ idcorreo=" + idcorreo + " ]";
    }
    
}
