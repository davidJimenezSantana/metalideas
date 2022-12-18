/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.NamingException;
import persistencia.entidades.ComprobanteDePago;
import persistencia.entidades.EstadVenta;
import persistencia.entidades.MetodoPago;
import persistencia.entidades.Usuario;
import persistencia.entidades.Venta;
import persistencia.model.ComprobanteDePagoFacade;
import persistencia.model.ComprobanteDePagoFacadeLocal;
import persistencia.model.EstadVentaFacade;
import persistencia.model.EstadVentaFacadeLocal;
import persistencia.model.MetodoPagoFacade;
import persistencia.model.MetodoPagoFacadeLocal;
import persistencia.model.UsuarioFacade;
import persistencia.model.UsuarioFacadeLocal;
import persistencia.model.VentaFacade;
import persistencia.model.VentaFacadeLocal;

@Named(value = "ventas")
@SessionScoped
public class ventas implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    @EJB
    private MetodoPagoFacadeLocal metodoPagoFacade;

    @EJB
    private ComprobanteDePagoFacadeLocal comprobanteDePagoFacade;

    @EJB
    private EstadVentaFacadeLocal estadVentaFacade;
    @EJB
    private VentaFacadeLocal ventaFacade;

    //instancias de venta
    private Venta venta = new Venta();

    //instancias de estado_venta
    private EstadVenta estadoVenta = new EstadVenta();

    //instancias de comprobante de pago
    private ComprobanteDePago comprobante = new ComprobanteDePago();

    //instancias de metodo de pago
    private MetodoPago metodoPago = new MetodoPago();

    //instancias de metodo de usuario
    private Usuario usuario = new Usuario();

    String idestadoVenta = "";
    String idcomprobante = "";
    String idmetodoPago = "";
    String idusuario = "";

    public ventas() {

    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public EstadVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public ComprobanteDePago getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteDePago comprobante) {
        this.comprobante = comprobante;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdestadoVenta() {
        return idestadoVenta;
    }

    public void setIdestadoVenta(String idestadoVenta) {
        this.idestadoVenta = idestadoVenta;
    }

    public String getIdcomprobante() {
        return idcomprobante;
    }

    public void setIdcomprobante(String idcomprobante) {
        this.idcomprobante = idcomprobante;
    }

    public String getIdmetodoPago() {
        return idmetodoPago;
    }

    public void setIdmetodoPago(String idmetodoPago) {
        this.idmetodoPago = idmetodoPago;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public List<Venta> findAllVentas() {
        Date fecha = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaTexto = formatter.format(fecha);
        System.out.println(fechaTexto);
        return this.ventaFacade.findAll();
    }

    public List<EstadVenta> findAllEstados() {
        return this.estadVentaFacade.findAll();
    }

    public List<MetodoPago> findAllMetodosPago() {
        return this.metodoPagoFacade.findAll();
    }

    public List<Usuario> findAllUsuario() {
        return this.usuarioFacade.findAll();
    }

    public void cargarDatos() {

        Venta v = ventaFacade.find(this.venta.getIdventa());
        this.venta.setFecha(v.getFecha());
        this.venta.setTotal(v.getTotal());
        this.comprobante = this.comprobanteDePagoFacade.find(Integer.valueOf(this.idcomprobante));
        this.estadoVenta = this.estadVentaFacade.find(Integer.valueOf(this.idestadoVenta));
        this.metodoPago = this.metodoPagoFacade.find(Integer.valueOf(this.idmetodoPago));
        this.usuario = this.usuarioFacade.find(Integer.valueOf(this.idusuario));

        this.venta.setEstadoIdestado(estadoVenta);
        this.venta.setComprobanteDePagoIdcomprobanteDePago(comprobante);
        this.venta.setMetodoPagoIdmetodoPago(metodoPago);
        this.venta.setUsuarioIdusuario(usuario);

    }

    public void asociarDatos() {
        
        this.estadoVenta = this.estadVentaFacade.find(Integer.valueOf(this.idestadoVenta));
        this.metodoPago = this.metodoPagoFacade.find(Integer.valueOf(this.idmetodoPago));
        this.usuario = this.usuarioFacade.find(Integer.valueOf(this.idusuario));

        this.venta.setEstadoIdestado(estadoVenta);
        this.venta.setMetodoPagoIdmetodoPago(metodoPago);
        this.venta.setUsuarioIdusuario(usuario);
        this.venta.setFecha(this.comprobante.getFecha());      
        this.venta.setComprobanteDePagoIdcomprobanteDePago(this.comprobante);

    }

    public void agregar() throws NamingException, Exception {
        agregarComprobante();
        asociarDatos();
        ventaFacade.create(this.venta);
        this.venta = new Venta();
        this.comprobante = new ComprobanteDePago();
    }

    public void agregarComprobante() throws NamingException, Exception {

        Date fecha = new Date();
        this.comprobante.setFecha(fecha);
        this.comprobante.setHora(fecha);
        this.comprobante.setTotal(this.venta.getTotal());
        
        this.comprobanteDePagoFacade.create(comprobante);
    }

    public void editar() throws NamingException, Exception {
        cargarDatos();
        this.ventaFacade.edit(venta);
        this.venta = new Venta();
    }

    public void borrar(int id) throws NamingException, Exception {

        venta = ventaFacade.find(id);       
        ventaFacade.remove(venta);
        this.venta = new Venta();
    }

}
