/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.model;

import java.util.List;
import javax.ejb.Local;
import persistencia.entidades.ComprobanteDePago;

/**
 *
 * @author david
 */
@Local
public interface ComprobanteDePagoFacadeLocal {

    void create(ComprobanteDePago comprobanteDePago);

    void edit(ComprobanteDePago comprobanteDePago);

    void remove(ComprobanteDePago comprobanteDePago);

    ComprobanteDePago find(Object id);

    List<ComprobanteDePago> findAll();

    List<ComprobanteDePago> findRange(int[] range);

    int count();
    
}
