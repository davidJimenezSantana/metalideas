/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.model;

import java.util.List;
import javax.ejb.Local;
import persistencia.EstadVenta;

/**
 *
 * @author david
 */
@Local
public interface EstadVentaFacadeLocal {

    void create(EstadVenta estadVenta);

    void edit(EstadVenta estadVenta);

    void remove(EstadVenta estadVenta);

    EstadVenta find(Object id);

    List<EstadVenta> findAll();

    List<EstadVenta> findRange(int[] range);

    int count();
    
}
