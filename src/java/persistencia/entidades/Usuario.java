/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "clave")
    private String clave;
    @ManyToMany(mappedBy = "usuarioList", fetch = FetchType.LAZY)
    private List<MetodoPago> metodoPagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario", fetch = FetchType.LAZY)
    private List<RegistroMovimientos> registroMovimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario", fetch = FetchType.LAZY)
    private List<Movil> movilList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario", fetch = FetchType.LAZY)
    private List<Direccion> direccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario", fetch = FetchType.LAZY)
    private List<Correo> correoList;
    @JoinColumn(name = "estado_usuario_idestado_cliente", referencedColumnName = "idestado_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoUsuario estadoUsuarioIdestadoCliente;
    @JoinColumn(name = "rol_idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol rolIdrol;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String nombre, String apellido, String clave) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<MetodoPago> getMetodoPagoList() {
        return metodoPagoList;
    }

    public void setMetodoPagoList(List<MetodoPago> metodoPagoList) {
        this.metodoPagoList = metodoPagoList;
    }

    public List<RegistroMovimientos> getRegistroMovimientosList() {
        return registroMovimientosList;
    }

    public void setRegistroMovimientosList(List<RegistroMovimientos> registroMovimientosList) {
        this.registroMovimientosList = registroMovimientosList;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public List<Movil> getMovilList() {
        return movilList;
    }

    public void setMovilList(List<Movil> movilList) {
        this.movilList = movilList;
    }

    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public List<Correo> getCorreoList() {
        return correoList;
    }

    public void setCorreoList(List<Correo> correoList) {
        this.correoList = correoList;
    }

    public EstadoUsuario getEstadoUsuarioIdestadoCliente() {
        return estadoUsuarioIdestadoCliente;
    }

    public void setEstadoUsuarioIdestadoCliente(EstadoUsuario estadoUsuarioIdestadoCliente) {
        this.estadoUsuarioIdestadoCliente = estadoUsuarioIdestadoCliente;
    }

    public Rol getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(Rol rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Usuario[ idusuario=" + idusuario + " ]";
    }
    
    
    
}
