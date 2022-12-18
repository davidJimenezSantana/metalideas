package persistencia.model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Validation;
import javax.validation.*;
import javax.validation.ValidatorFactory;
import persistencia.entidades.Correo;
import persistencia.entidades.Usuario;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    private static void addErrorMessage(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PersistenceContext(unitName = "MetalideasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    
    @Override
    public Usuario ingresar(String dircorreo, String password) {

        Usuario usuario = new Usuario();
        Correo correo = new Correo();
        List resultados;

        String sql = "SELECT c FROM Correo c WHERE c.direccionCorreo = :dircorreo";
        Query query = em.createQuery(sql);
        query.setParameter("dircorreo", dircorreo);

        resultados = query.getResultList();

        if (!resultados.isEmpty()) {

            correo = (Correo) resultados.get(0);
            usuario = correo.getUsuarioIdusuario();

            if (password.equals(usuario.getClave())) {
                return usuario;
            } else {
                usuario = null;
                return usuario;
            }
        } else {
            usuario = null;
            return usuario;
        }

    }

}
