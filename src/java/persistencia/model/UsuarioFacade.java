package persistencia.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import persistencia.Correo;
import persistencia.Usuario;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

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
