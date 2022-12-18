/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import persistencia.entidades.Correo;
import persistencia.entidades.EstadoUsuario;
import persistencia.entidades.Rol;
import persistencia.entidades.Usuario;
import persistencia.model.CorreoFacadeLocal;
import persistencia.model.EstadoUsuarioFacadeLocal;
import persistencia.model.RolFacadeLocal;
import persistencia.model.UsuarioFacadeLocal;

/**
 *
 * @author david
 */
@Named(value = "usuario")
@SessionScoped
public class usuario implements Serializable {

    //
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    @EJB
    private RolFacadeLocal rolFacade;

    @EJB
    private EstadoUsuarioFacadeLocal estadoUsuarioFacade;

    @EJB
    private CorreoFacadeLocal correoFacade;

    HttpSession sesion = null;

    private Correo correo = new Correo();
    private EstadoUsuario estadoUsuario = new EstadoUsuario();
    private Rol rol = new Rol();
    private Usuario usuario = new Usuario();

    private String estadoUsuarioAux;
    private String rolAux;

    public usuario() {
    }

    public UsuarioFacadeLocal getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacadeLocal usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public RolFacadeLocal getRolFacade() {
        return rolFacade;
    }

    public void setRolFacade(RolFacadeLocal rolFacade) {
        this.rolFacade = rolFacade;
    }

    public EstadoUsuarioFacadeLocal getEstadoUsuarioFacade() {
        return estadoUsuarioFacade;
    }

    public void setEstadoUsuarioFacade(EstadoUsuarioFacadeLocal estadoUsuarioFacade) {
        this.estadoUsuarioFacade = estadoUsuarioFacade;
    }

    public CorreoFacadeLocal getCorreoFacade() {
        return correoFacade;
    }

    public void setCorreoFacade(CorreoFacadeLocal correoFacade) {
        this.correoFacade = correoFacade;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    public String getEstadoUsuarioAux() {
        return estadoUsuarioAux;
    }

    public void setEstadoUsuarioAux(String estadoUsuarioAux) {
        this.estadoUsuarioAux = estadoUsuarioAux;
    }

    public String getRolAux() {
        return rolAux;
    }

    public void setRolAux(String rolAux) {
        this.rolAux = rolAux;
    }

    public String validarLogin() {

        String direccion = "";
        this.usuario = this.usuarioFacade.ingresar(correo.getDireccionCorreo(), usuario.getClave());

        if (usuario != null) {

            direccion = "Bienvenida";

        } else {
            direccion = "index";
        }
        System.out.println(direccion);
        return direccion;
    }

    public List<Rol> findAllRoles() {
        return this.rolFacade.findAll();
    }

    public List<EstadoUsuario> findAllEstados() {
        return this.estadoUsuarioFacade.findAll();
    }

    public void editar() {
        iniciarUsuario();
        usuarioFacade.edit(usuario);
    }

    public void borrar() {
        this.usuarioFacade.remove(this.usuario);
    }

    public void iniciarUsuario() {

        this.rol = this.rolFacade.find(Integer.parseInt(this.rolAux));
        this.estadoUsuario = this.estadoUsuarioFacade.find(Integer.parseInt(this.estadoUsuarioAux));

        this.usuario.setEstadoUsuarioIdestadoCliente(estadoUsuario);
        this.usuario.setRolIdrol(rol);
    }
}
