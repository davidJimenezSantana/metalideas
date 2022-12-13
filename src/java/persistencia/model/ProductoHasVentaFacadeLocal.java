/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.model;

import java.util.List;
import javax.ejb.Local;
import persistencia.ProductoHasVenta;

/**
 *
 * @author david
 */
@Local
public interface ProductoHasVentaFacadeLocal {

    void create(ProductoHasVenta productoHasVenta);

    void edit(ProductoHasVenta productoHasVenta);

    void remove(ProductoHasVenta productoHasVenta);

    ProductoHasVenta find(Object id);

    List<ProductoHasVenta> findAll();

    List<ProductoHasVenta> findRange(int[] range);

    int count();
    
}
