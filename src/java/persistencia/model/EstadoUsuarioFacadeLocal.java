/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.model;

import java.util.List;
import javax.ejb.Local;
import persistencia.entidades.EstadoUsuario;

/**
 *
 * @author david
 */
@Local
public interface EstadoUsuarioFacadeLocal {

    void create(EstadoUsuario estadoUsuario);

    void edit(EstadoUsuario estadoUsuario);

    void remove(EstadoUsuario estadoUsuario);

    EstadoUsuario find(Object id);

    List<EstadoUsuario> findAll();

    List<EstadoUsuario> findRange(int[] range);

    int count();
    
}
