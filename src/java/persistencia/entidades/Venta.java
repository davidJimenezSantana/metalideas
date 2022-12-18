/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Entity
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idventa")
    private Integer idventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @Size(max = 25)
    @Column(name = "destino")
    private String destino;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "comprobante_de_pago_idcomprobante_de_pago", referencedColumnName = "idcomprobante_de_pago")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ComprobanteDePago comprobanteDePagoIdcomprobanteDePago;
    @JoinColumn(name = "estado_idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadVenta estadoIdestado;
    @JoinColumn(name = "metodo_pago_idmetodo_pago", referencedColumnName = "idmetodo_pago")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MetodoPago metodoPagoIdmetodoPago;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.LAZY)
    private List<ProductoHasVenta> productoHasVentaList;

    public Venta() {
    }

    public Venta(Integer idventa) {
        this.idventa = idventa;
    }

    public Venta(Integer idventa, int total) {
        this.idventa = idventa;
        this.total = total;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ComprobanteDePago getComprobanteDePagoIdcomprobanteDePago() {
        return comprobanteDePagoIdcomprobanteDePago;
    }

    public void setComprobanteDePagoIdcomprobanteDePago(ComprobanteDePago comprobanteDePagoIdcomprobanteDePago) {
        this.comprobanteDePagoIdcomprobanteDePago = comprobanteDePagoIdcomprobanteDePago;
    }

    public EstadVenta getEstadoIdestado() {
        return estadoIdestado;
    }

    public void setEstadoIdestado(EstadVenta estadoIdestado) {
        this.estadoIdestado = estadoIdestado;
    }

    public MetodoPago getMetodoPagoIdmetodoPago() {
        return metodoPagoIdmetodoPago;
    }

    public void setMetodoPagoIdmetodoPago(MetodoPago metodoPagoIdmetodoPago) {
        this.metodoPagoIdmetodoPago = metodoPagoIdmetodoPago;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public List<ProductoHasVenta> getProductoHasVentaList() {
        return productoHasVentaList;
    }

    public void setProductoHasVentaList(List<ProductoHasVenta> productoHasVentaList) {
        this.productoHasVentaList = productoHasVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Venta[ idventa=" + idventa + " ]";
    }
    
}
