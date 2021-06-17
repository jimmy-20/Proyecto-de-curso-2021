/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.Connection.FileConnection;
import Backend.Idao.IdaoActions;
import Pojo.DetalleCompraFactura;
import Pojo.DetalleCompra;
import Pojo.Inventario;
import Pojo.Proveedor;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class FilesCompras extends FileConnection implements IdaoActions<DetalleCompraFactura,DetalleCompra,Proveedor>{
    private final int SIZE_DETALLE = 357;
    private final int SIZE_FACTURA = 226;
    private final int SIZE_PROVEEDORES = 76;
    private final int SIZE_INVENTARIO = 196;
    private Calendar c;

    private Gson gson;
    
    /**
     *Constructor que instancia y crea los flujos hacia los archivos de compra
     **/
    public FilesCompras() {
        super(new File("headerCompra.dat"),new File("Detalle de compra.dat"),new File("Detalle de factura.dat"),
                new File("Proveedores.dat"), new File("Inventario.dat"));
        gson = new Gson();
    }

    /**
     * Este método funciona al momento guardad el detalle de compra y factura al registarse una compra
     * archivos
     * @param t Detalle de factura a agregar
     * @param dt Detalle de compra a agregar
     * @param p
     * @exception IOException Si ocurre un fallo en los flujos de bytes
     **/
    @Override
    public void add(DetalleCompraFactura t,DetalleCompra dt, Proveedor p) { // Detalle de factura, Detalle de compra
        try {
            if ( (t == null) || (dt == null) ){
                return;
            }
            getRandomConection().getRafH().seek(0);
            
            int n = getRandomConection().getRafH().readInt(); //Nª de registros;
            int k = getRandomConection().getRafH().readInt(); //id
            
            long posD = k*SIZE_DETALLE;
            long posF = k*SIZE_FACTURA;
            long posP = k*SIZE_PROVEEDORES;

            
            //Se colocan los punteros en sus respectivos archivos
            getRandomConection().getRafDetalle().seek(posD);
            getRandomConection().getRafFactura().seek(posF);
            
            getRandomConection().getRafDetalle().writeUTF(gson.toJson(dt)); //Se crea el archivo del detalle de compra
            getRandomConection().getRafFactura().writeUTF(gson.toJson(t)); //Se crea e archivo del detalle de factura
            validationProveedor(p, posP);
            
            getRandomConection().getRafH().seek(0);
            getRandomConection().getRafH().writeInt(++n);
            getRandomConection().getRafH().writeInt(++k);  
            
            close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean edit(DetalleCompra dt, int row) {
        long posD = row*SIZE_DETALLE;
        long posF = row*SIZE_FACTURA;
        DetalleCompraFactura compraFactura;
        
        if (dt == null){
            return false;
        }
        
        try
        {
            getRandomConection().getRafDetalle().seek(posD);
            getRandomConection().getRafDetalle().writeUTF(gson.toJson(dt));
            
            getRandomConection().getRafFactura().seek(posF);
            
            compraFactura = gson.fromJson(getRandomConection().getRafFactura().readUTF(), DetalleCompraFactura.class);
            
            compraFactura.setFactura(dt.getfactura());
            compraFactura.setFecha(dt.getFecha());
            compraFactura.setTipoCompra(dt.getTipoCompra());
            compraFactura.setTipoMoneda(dt.getTipomoneda());
            compraFactura.setProveedor(dt.getProveedor());
            compraFactura.setSubTotal(dt.getSubTotal());
            compraFactura.setIva(dt.getIva());
            compraFactura.setTotal(dt.getTotal());
            
            getRandomConection().getRafFactura().seek(posF);
            getRandomConection().getRafFactura().writeUTF(gson.toJson(compraFactura));
        } catch (IOException ex)
        {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public Collection<DetalleCompra> findAllDetalle() {
       Collection<DetalleCompra> detalleList = new ArrayList<>();
        DetalleCompra detalle= null;
         try {
            getRandomConection().getRafH().seek(0);
            int n = getRandomConection().getRafH().readInt();
            
            if ( (n<=0) ){
                return detalleList;
            }
            
            for (int i=0 ; i<n ; i++){
                long posD = i*SIZE_DETALLE;
                
                getRandomConection().getRafDetalle().seek(posD);
                detalle = gson.fromJson(getRandomConection().getRafDetalle().readUTF(), DetalleCompra.class);
                
                detalleList.add(detalle);
            }
             close();
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detalleList;
    }

    /**
     * Regresa una Colección de tipo DetalleCompraFactura, funcional para imprimir en una tabla
     * @return Devuelve una colección sobre todas las compras en detalle de factura
    **/
    @Override
    public Collection<DetalleCompraFactura> findAllFactura() {
        Collection<DetalleCompraFactura> facturaList = new ArrayList<>();
        DetalleCompraFactura compra = null;
        
        
        try {
            getRandomConection().getRafH().seek(0);
            int n = getRandomConection().getRafH().readInt();
            
            if ( (n<=0) ){
                return facturaList;
            }
            
            for (int i=0 ; i<n ; i++){
                long posD = i*SIZE_FACTURA;
                
                getRandomConection().getRafFactura().seek(posD);
                compra = gson.fromJson(getRandomConection().getRafFactura().readUTF(), DetalleCompraFactura.class);
                
                facturaList.add(compra);
            }
            close();
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  facturaList;
    }
    
    @Override
    /**
     * Regresa los datos del archivo de Proveedores, funcional para imprimir en la tabla de Proveedores
     * @return Devuelve en una Collection los proveedores comprado a credito
     **/
    public Collection<Proveedor> findAllCredito() {
        Collection <Proveedor> proveedores = new ArrayList<>();
        Proveedor p = null;
            
        try
        { 
            getRandomConection().getRafH().seek(0);
            int n = getRandomConection().getRafH().readInt();
            
            if ( (n<=0) ){
                return proveedores;
            }
            
            if (getRandomConection().getRafCredito().length() == 0){
                return proveedores;
            }
            
            for (int i=0 ; i<n ; i++){
                long posP = i*SIZE_PROVEEDORES;
                
                getRandomConection().getRafFactura().seek(posP);
                p = gson.fromJson(getRandomConection().getRafCredito().readUTF(), Proveedor.class);
                
                proveedores.add(p);
            }
            close();
        } catch (IOException ex)
        {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedores;

    }
    
    private void validationProveedor(Proveedor p, long posProveedor) throws IOException{
        Proveedor proveedor = null;
        if (getRegistros() < 0 || p == null){
            return;
        }
        
        if (getRandomConection().getRafCredito().length() == 0){
            getRandomConection().getRafCredito().seek(0);
            getRandomConection().getRafCredito().writeUTF(gson.toJson(p));
            return;
        }
        
        for (int i = 0 ; i<getRegistros() ; i++){
            long posP = i*SIZE_PROVEEDORES;
            
            getRandomConection().getRafCredito().seek(posP);
            proveedor = gson.fromJson(getRandomConection().getRafCredito().readUTF(), Proveedor.class);
            
            if(proveedor.getNombre().equalsIgnoreCase(p.getNombre())){
                proveedor.setSubTotal(p.getSubTotal() + proveedor.getSubTotal());
                proveedor.setIva(p.getIva() + proveedor.getIva());
                proveedor.setTotal(p.getTotal() + proveedor.getTotal());
                
                getRandomConection().getRafCredito().seek(posP);
                getRandomConection().getRafCredito().writeUTF(gson.toJson(proveedor));
                return;
            }
        }
        
        getRandomConection().getRafCredito().writeUTF(gson.toJson(p));
        
    }
    
    public void addBodega(DetalleCompra[] detalleCompras){
        try {
            int n = 0,k = 0,p = 0;
            List<Inventario> adquisicion = new ArrayList<>();
            
            getRandomConection().getRafInventario().seek(0);

            c = Calendar.getInstance();
            if (getRandomConection().getRafInventario().length() == 0){
                getRandomConection().getRafInventario().writeInt(++n); // Cantidad de adquisiciones
                getRandomConection().getRafInventario().writeInt(++k); // N° de Adquisición
                getRandomConection().getRafInventario().writeInt(detalleCompras.length); //N° de compras en la bodega
            }else{
                n = getRandomConection().getRafInventario().readInt();
                k = getRandomConection().getRafInventario().readInt();
                p = getRandomConection().getRafInventario().readInt();
            }
            
            String fecha = "";
            fecha = String.valueOf(c.get(Calendar.DATE));
            fecha += "/"+String.valueOf(c.get(Calendar.MONTH));
            fecha += "/"+String.valueOf(c.get(Calendar.YEAR));
            
            String factura = String.valueOf(k);
            
            for (DetalleCompra compra : detalleCompras){
                Inventario v = new Inventario(fecha, factura, compra.getDescripcion(),
                        compra.getCantidad(), compra.getCosto(), compra.getCantidad() * compra.getCosto());
                adquisicion.add(v);
            }
            
            long posI = 12 +SIZE_INVENTARIO * p;
            
            for (Inventario v : adquisicion){
                getRandomConection().getRafInventario().writeUTF(gson.toJson(v));
            }
            
            getRandomConection().getRafInventario().seek(0);
            getRandomConection().getRafInventario().writeInt(++n);
            getRandomConection().getRafInventario().writeInt(++k);
            getRandomConection().getRafInventario().writeInt(p + detalleCompras.length);
            
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Collection<Inventario> getBodega(){
        Collection<Inventario> inventario = new ArrayList<>();
        Inventario v = null;

        try {

            if (getRandomConection().getRafInventario().length() == 0){
                return inventario;
            }
            
            getRandomConection().getRafInventario().seek(8);
            int p = getRandomConection().getRafInventario().readInt(); //N° de compras en la bodega
            
            for (int i = 0 ; i<p ; i++){
                long posI = 12 + SIZE_INVENTARIO * i;
                
                getRandomConection().getRafInventario().seek(posI);
                
                v = gson.fromJson(getRandomConection().getRafInventario().readUTF(), Inventario.class );
                
                if (v.getFecha().equalsIgnoreCase("")){
                    continue;
                }
                
                inventario.add(v);
            }     
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return inventario;

    }
    
    //Este método devuelve la cantidad de registros que se encuentra en el archivo
    private int getRegistros() throws IOException{
        getRandomConection().getRafH().seek(0);
        
        return getRandomConection().getRafH().readInt();
    }

    
}
