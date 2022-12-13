/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Embeddable
public class ProductoHasVentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "producto_cod")
    private int productoCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_idventa")
    private int ventaIdventa;

    public ProductoHasVentaPK() {
    }

    public ProductoHasVentaPK(int productoCod, int ventaIdventa) {
        this.productoCod = productoCod;
        this.ventaIdventa = ventaIdventa;
    }

    public int getProductoCod() {
        return productoCod;
    }

    public void setProductoCod(int productoCod) {
        this.productoCod = productoCod;
    }

    public int getVentaIdventa() {
        return ventaIdventa;
    }

    public void setVentaIdventa(int ventaIdventa) {
        this.ventaIdventa = ventaIdventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productoCod;
        hash += (int) ventaIdventa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoHasVentaPK)) {
            return false;
        }
        ProductoHasVentaPK other = (ProductoHasVentaPK) object;
        if (this.productoCod != other.productoCod) {
            return false;
        }
        if (this.ventaIdventa != other.ventaIdventa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.ProductoHasVentaPK[ productoCod=" + productoCod + ", ventaIdventa=" + ventaIdventa + " ]";
    }
    
}
