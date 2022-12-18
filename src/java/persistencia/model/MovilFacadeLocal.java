/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.model;

import java.util.List;
import javax.ejb.Local;
import persistencia.entidades.Movil;

/**
 *
 * @author david
 */
@Local
public interface MovilFacadeLocal {

    void create(Movil movil);

    void edit(Movil movil);

    void remove(Movil movil);

    Movil find(Object id);

    List<Movil> findAll();

    List<Movil> findRange(int[] range);

    int count();
    
}
