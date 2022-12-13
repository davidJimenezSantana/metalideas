/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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

/**
 *
 * @author david
 */
@Entity
@Table(name = "telefono_proveedor")
@NamedQueries({
    @NamedQuery(name = "TelefonoProveedor.findAll", query = "SELECT t FROM TelefonoProveedor t")})
public class TelefonoProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtelefono")
    private Integer idtelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @JoinColumn(name = "proveedor_idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor proveedorIdproveedor;

    public TelefonoProveedor() {
    }

    public TelefonoProveedor(Integer idtelefono) {
        this.idtelefono = idtelefono;
    }

    public TelefonoProveedor(Integer idtelefono, int numero) {
        this.idtelefono = idtelefono;
        this.numero = numero;
    }

    public Integer getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(Integer idtelefono) {
        this.idtelefono = idtelefono;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Proveedor getProveedorIdproveedor() {
        return proveedorIdproveedor;
    }

    public void setProveedorIdproveedor(Proveedor proveedorIdproveedor) {
        this.proveedorIdproveedor = proveedorIdproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtelefono != null ? idtelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoProveedor)) {
            return false;
        }
        TelefonoProveedor other = (TelefonoProveedor) object;
        if ((this.idtelefono == null && other.idtelefono != null) || (this.idtelefono != null && !this.idtelefono.equals(other.idtelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TelefonoProveedor[ idtelefono=" + idtelefono + " ]";
    }
    
}
