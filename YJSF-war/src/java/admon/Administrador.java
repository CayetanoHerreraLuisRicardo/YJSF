/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admon;

import dao.NotaventaFacade;
import dao.ProductoFacade;
import dao.VentaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Producto;

/**
 *
 * @author Richy
 */
@ManagedBean
@SessionScoped
public class Administrador {
    @EJB
    private NotaventaFacade notaventaFacade;
    @EJB
    private VentaFacade ventaFacade;
    @EJB
    private ProductoFacade productoFacade;

///////////////////////////////////////////////////***PRODUCTOS***//////////////////////////////////////////////////////////////
    
////////////atributos PRODUCTO////////////////////////////////
    private Producto producto;
    int[] arregloP;
    private List<Producto> productos;
    private String [] desProds;
    private String desProd;
    private int [] idsp;
    private int idp;
    private int totalregistros;
    public String crearProducto(){
        producto=new Producto();
        return "agregarProducto";
    }
    public String buscar(){
        producto=null;
        return "buscarProducto";
    }
    ////////////////GET AN SET producto////////////////////////////
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto p) {
        this.producto = p;
    }
    ///////////// GUARDAR producto-obtener el id sig /////////////
    public String guardarProducto(){
        producto.setIdProducto(getCalcularMayorProducto());
        this.productoFacade.create(this.producto);
        return "index";
    }
    public int [] getIdsProductos(){
        productos=productoFacade.findAll();
        arregloP=new int[productoFacade.count()];
        int a=0;
        for(Producto p:productos){
                arregloP[a]=p.getIdProducto();
                a++;
        }
        return arregloP;
    }
    public int getCalcularMayorProducto() { 
        int [] a=getIdsProductos();
        int resultado = a[0]; 
        for(int i=0; i<a.length; i++) { 
            if(a[i] > resultado) { 
                resultado = a[i]; 
            } 
        } 
        return resultado+1;
    }
    ///////////// LISTAR productos/////////////
    public List<Producto> getProductos(){
        return this.productoFacade.findAll();
    }
    //////////// ELIMINAR producto////////////////////
    public String eliminarProducto(Producto i) {
        productoFacade.remove(i);
        return "listarProductos";
    }
    public String eliminaProducto(){
        productoFacade.remove(producto);
        return "buscarProducto";
    }
    //////////// EDITAR producto////////////////////
    public String editarId(Object i) {
        producto=productoFacade.find(i);
        return "editarProducto";
    }
    public String editaProducto(){
        productoFacade.edit(producto);
        return "buscarProducto";
    }
    public String editarProducto(){
        this.productoFacade.edit(producto);
        return "listarProductos";
    }
    /////////LISTAR combo nombres-productos ///////////////////////////
    public String getProductoDescripcion() {
        return desProd;
    }
    public void setProductoDescripcion(String desProd) {
        this.desProd = desProd;
    }     
    public String[] getProductoDescripciones(){
        productos=productoFacade.findAll();
        desProds = new String[productoFacade.count()];
        int a=0;
        for(Producto p:productos){
            desProds[a]=p.getDescripcion();
            a++;
        }
        return desProds;
    }
    public String presentaProductos() {
        String [] a=getProductoDescripciones();
        for(int b=0;b< a.length;b++){
            if(a[b].equalsIgnoreCase(desProd)){
                producto = productos.get(b);
            }
        }
        return "buscarProducto";
    }
    public int contarProductos(){
        totalregistros=productoFacade.count();
        return totalregistros;
    }  
    public Administrador() {
    }
    
}
