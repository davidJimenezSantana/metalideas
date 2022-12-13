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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private int precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_compra")
    private int precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "producto_has_registro_movimientos", joinColumns = {
        @JoinColumn(name = "producto_cod", referencedColumnName = "idproducto")}, inverseJoinColumns = {
        @JoinColumn(name = "registro_movimientos_idregistro_movimientos", referencedColumnName = "idregistro_movimientos")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<RegistroMovimientos> registroMovimientosList;
    @JoinTable(name = "proveedor_has_producto", joinColumns = {
        @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")}, inverseJoinColumns = {
        @JoinColumn(name = "proveedor_idproveedor", referencedColumnName = "idproveedor")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Proveedor> proveedorList;
    @JoinColumn(name = "marca_idmarca", referencedColumnName = "idmarca")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Marca marcaIdmarca;
    @JoinColumn(name = "tipo_idtipo", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria tipoIdtipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<ProductoHasVenta> productoHasVentaList;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Integer idproducto, String nombre, int precioVenta, int precioCompra, int cantidad, String descripcion) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<RegistroMovimientos> getRegistroMovimientosList() {
        return registroMovimientosList;
    }

    public void setRegistroMovimientosList(List<RegistroMovimientos> registroMovimientosList) {
        this.registroMovimientosList = registroMovimientosList;
    }

    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    public Marca getMarcaIdmarca() {
        return marcaIdmarca;
    }

    public void setMarcaIdmarca(Marca marcaIdmarca) {
        this.marcaIdmarca = marcaIdmarca;
    }

    public Categoria getTipoIdtipo() {
        return tipoIdtipo;
    }

    public void setTipoIdtipo(Categoria tipoIdtipo) {
        this.tipoIdtipo = tipoIdtipo;
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
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
