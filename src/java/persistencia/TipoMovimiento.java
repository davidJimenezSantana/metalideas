/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
@Table(name = "tipo_movimiento")
@NamedQueries({
    @NamedQuery(name = "TipoMovimiento.findAll", query = "SELECT t FROM TipoMovimiento t")})
public class TipoMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_movimiento")
    private Integer idtipoMovimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre_movimiento")
    private String nombreMovimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMovimientoIdtipoMovimiento", fetch = FetchType.LAZY)
    private List<RegistroMovimientos> registroMovimientosList;

    public TipoMovimiento() {
    }

    public TipoMovimiento(Integer idtipoMovimiento) {
        this.idtipoMovimiento = idtipoMovimiento;
    }

    public TipoMovimiento(Integer idtipoMovimiento, String nombreMovimiento) {
        this.idtipoMovimiento = idtipoMovimiento;
        this.nombreMovimiento = nombreMovimiento;
    }

    public Integer getIdtipoMovimiento() {
        return idtipoMovimiento;
    }

    public void setIdtipoMovimiento(Integer idtipoMovimiento) {
        this.idtipoMovimiento = idtipoMovimiento;
    }

    public String getNombreMovimiento() {
        return nombreMovimiento;
    }

    public void setNombreMovimiento(String nombreMovimiento) {
        this.nombreMovimiento = nombreMovimiento;
    }

    public List<RegistroMovimientos> getRegistroMovimientosList() {
        return registroMovimientosList;
    }

    public void setRegistroMovimientosList(List<RegistroMovimientos> registroMovimientosList) {
        this.registroMovimientosList = registroMovimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoMovimiento != null ? idtipoMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovimiento)) {
            return false;
        }
        TipoMovimiento other = (TipoMovimiento) object;
        if ((this.idtipoMovimiento == null && other.idtipoMovimiento != null) || (this.idtipoMovimiento != null && !this.idtipoMovimiento.equals(other.idtipoMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TipoMovimiento[ idtipoMovimiento=" + idtipoMovimiento + " ]";
    }
    
}
