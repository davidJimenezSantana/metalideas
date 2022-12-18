/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.model;

import java.util.List;
import javax.ejb.Local;
import persistencia.entidades.RegistroMovimientos;

/**
 *
 * @author david
 */
@Local
public interface RegistroMovimientosFacadeLocal {

    void create(RegistroMovimientos registroMovimientos);

    void edit(RegistroMovimientos registroMovimientos);

    void remove(RegistroMovimientos registroMovimientos);

    RegistroMovimientos find(Object id);

    List<RegistroMovimientos> findAll();

    List<RegistroMovimientos> findRange(int[] range);

    int count();
    
}
