/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.entidades.ProductoHasVenta;

/**
 *
 * @author david
 */
@Stateless
public class ProductoHasVentaFacade extends AbstractFacade<ProductoHasVenta> implements ProductoHasVentaFacadeLocal {

    @PersistenceContext(unitName = "MetalideasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoHasVentaFacade() {
        super(ProductoHasVenta.class);
    }
    
}
