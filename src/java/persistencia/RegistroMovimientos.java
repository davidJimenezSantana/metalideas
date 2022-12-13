/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "registro_movimientos")
@NamedQueries({
    @NamedQuery(name = "RegistroMovimientos.findAll", query = "SELECT r FROM RegistroMovimientos r")})
public class RegistroMovimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro_movimientos")
    private Integer idregistroMovimientos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_movimiento")
    private int fechaMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_prod")
    private int cantidadProd;
    @ManyToMany(mappedBy = "registroMovimientosList", fetch = FetchType.LAZY)
    private List<Producto> productoList;
    @JoinColumn(name = "tipo_movimiento_idtipo_movimiento", referencedColumnName = "idtipo_movimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMovimiento tipoMovimientoIdtipoMovimiento;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdusuario;

    public RegistroMovimientos() {
    }

    public RegistroMovimientos(Integer idregistroMovimientos) {
        this.idregistroMovimientos = idregistroMovimientos;
    }

    public RegistroMovimientos(Integer idregistroMovimientos, String detalle, int fechaMovimiento, int cantidadProd) {
        this.idregistroMovimientos = idregistroMovimientos;
        this.detalle = detalle;
        this.fechaMovimiento = fechaMovimiento;
        this.cantidadProd = cantidadProd;
    }

    public Integer getIdregistroMovimientos() {
        return idregistroMovimientos;
    }

    public void setIdregistroMovimientos(Integer idregistroMovimientos) {
        this.idregistroMovimientos = idregistroMovimientos;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(int fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public TipoMovimiento getTipoMovimientoIdtipoMovimiento() {
        return tipoMovimientoIdtipoMovimiento;
    }

    public void setTipoMovimientoIdtipoMovimiento(TipoMovimiento tipoMovimientoIdtipoMovimiento) {
        this.tipoMovimientoIdtipoMovimiento = tipoMovimientoIdtipoMovimiento;
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
        hash += (idregistroMovimientos != null ? idregistroMovimientos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroMovimientos)) {
            return false;
        }
        RegistroMovimientos other = (RegistroMovimientos) object;
        if ((this.idregistroMovimientos == null && other.idregistroMovimientos != null) || (this.idregistroMovimientos != null && !this.idregistroMovimientos.equals(other.idregistroMovimientos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.RegistroMovimientos[ idregistroMovimientos=" + idregistroMovimientos + " ]";
    }
    
}
