/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Entity
@Table(name = "metodo_pago")
@NamedQueries({
    @NamedQuery(name = "MetodoPago.findAll", query = "SELECT m FROM MetodoPago m")})
public class MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmetodo_pago")
    private Integer idmetodoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "usuario_has_metodo_pago", joinColumns = {
        @JoinColumn(name = "metodo_pago_idmetodo_pago", referencedColumnName = "idmetodo_pago")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metodoPagoIdmetodoPago", fetch = FetchType.LAZY)
    private List<Venta> ventaList;

    public MetodoPago() {
    }

    public MetodoPago(Integer idmetodoPago) {
        this.idmetodoPago = idmetodoPago;
    }

    public MetodoPago(Integer idmetodoPago, String nombre) {
        this.idmetodoPago = idmetodoPago;
        this.nombre = nombre;
    }

    public Integer getIdmetodoPago() {
        return idmetodoPago;
    }

    public void setIdmetodoPago(Integer idmetodoPago) {
        this.idmetodoPago = idmetodoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmetodoPago != null ? idmetodoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodoPago)) {
            return false;
        }
        MetodoPago other = (MetodoPago) object;
        if ((this.idmetodoPago == null && other.idmetodoPago != null) || (this.idmetodoPago != null && !this.idmetodoPago.equals(other.idmetodoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.MetodoPago[ idmetodoPago=" + idmetodoPago + " ]";
    }
    
}
