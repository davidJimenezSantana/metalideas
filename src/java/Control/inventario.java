/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.naming.NamingException;
import persistencia.entidades.Categoria;
import persistencia.entidades.Marca;
import persistencia.entidades.Producto;
import persistencia.model.CategoriaFacadeLocal;
import persistencia.model.MarcaFacadeLocal;
import persistencia.model.ProductoFacadeLocal;

/**
 *
 * @author david
 */


@Named(value = "inventario")
@SessionScoped
public class inventario implements Serializable {

    @EJB
    private MarcaFacadeLocal marcaFacade;

    @EJB
    private CategoriaFacadeLocal categoriaFacade;

    @EJB
    private ProductoFacadeLocal productoFacade;
    
    String marcaAux;
    String CataAux;

    Producto producto = new Producto();
    Marca marca = new Marca();
    Categoria categoria = new Categoria();

    public inventario() {
    }

    public MarcaFacadeLocal getMarcaFacade() {
        return marcaFacade;
    }

    public void setMarcaFacade(MarcaFacadeLocal marcaFacade) {
        this.marcaFacade = marcaFacade;
    }

    public CategoriaFacadeLocal getCategoriaFacade() {
        return categoriaFacade;
    }

    public void setCategoriaFacade(CategoriaFacadeLocal categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    public ProductoFacadeLocal getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacadeLocal productoFacade) {
        this.productoFacade = productoFacade;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
    public String getMarcaAux() {
        return marcaAux;
    }

    public void setMarcaAux(String marcaAux) {
        this.marcaAux = marcaAux;
    }

    public String getCataAux() {
        return CataAux;
    }

    public void setCataAux(String CataAux) {
        this.CataAux = CataAux;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void agregar() throws NamingException, Exception {       
        
        iniciarProducto();        
        productoFacade.create(this.producto);
        this.producto = new Producto();
    }

    public void editar() throws NamingException, Exception {
        
       iniciarProducto();
       productoFacade.edit(producto);
       this.producto = new Producto();
    }

    public void borrar(int id) throws NamingException, Exception {
        
        producto = productoFacade.find(id);
        
        productoFacade.remove(producto);        
        this.producto = new Producto();
    }
    
    private void iniciarProducto(){
        
        this.marca = marcaFacade.find(Integer.valueOf(this.marcaAux));
        this.categoria = categoriaFacade.find(Integer.valueOf(this.CataAux));
        
        this.producto.setMarcaIdmarca(marca);
        this.producto.setTipoIdtipo(categoria);
    }

    
    
    

}
