/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import persistencia.ComprobanteDePago;
import persistencia.EstadVenta;
import persistencia.MetodoPago;
import persistencia.Usuario;
import persistencia.Venta;
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
    
    
    
    public ventas() {        
        
    }

    public UsuarioFacadeLocal getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacadeLocal usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public MetodoPagoFacadeLocal getMetodoPagoFacade() {
        return metodoPagoFacade;
    }

    public void setMetodoPagoFacade(MetodoPagoFacadeLocal metodoPagoFacade) {
        this.metodoPagoFacade = metodoPagoFacade;
    }

    public ComprobanteDePagoFacadeLocal getComprobanteDePagoFacade() {
        return comprobanteDePagoFacade;
    }

    public void setComprobanteDePagoFacade(ComprobanteDePagoFacadeLocal comprobanteDePagoFacade) {
        this.comprobanteDePagoFacade = comprobanteDePagoFacade;
    }

    public EstadVentaFacadeLocal getEstadVentaFacade() {
        return estadVentaFacade;
    }

    public void setEstadVentaFacade(EstadVentaFacadeLocal estadVentaFacade) {
        this.estadVentaFacade = estadVentaFacade;
    }

    public VentaFacadeLocal getVentaFacade() {
        return ventaFacade;
    }

    public void setVentaFacade(VentaFacadeLocal ventaFacade) {
        this.ventaFacade = ventaFacade;
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
    
    
    
}
