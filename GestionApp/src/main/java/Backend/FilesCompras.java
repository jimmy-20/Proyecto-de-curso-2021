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
import Pojo.Proveedor;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    private Gson gson;
    
    /**
     *Constructor que instancia y crea los flujos hacia los archivos de compra
     **/
    public FilesCompras() {
        super(new File("headerCompra.dat"),new File("Detalle de compra.dat"),new File("Detalle de factura.dat"),new File("Proveedores.dat"));
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
    public boolean edit(DetalleCompraFactura t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  facturaList;
    }
    
    private void validationProveedor(Proveedor p, long posProveedor) throws IOException{
        Proveedor proveedor = null;
        if (getRegistros() <= 0 || p == null){
            return;
        }
        
        if (getRandomConection().getRafProveedores().length() == 0){
            getRandomConection().getRafProveedores().seek(0);
            getRandomConection().getRafProveedores().writeUTF(gson.toJson(p));
            return;
        }
        
        for (int i = 0 ; i<getRegistros() ; i++){
            long posP = i*SIZE_PROVEEDORES;
            
            getRandomConection().getRafProveedores().seek(posP);
            proveedor = gson.fromJson(getRandomConection().getRafProveedores().readUTF(), Proveedor.class);
            
            if(proveedor.getNombre().equalsIgnoreCase(p.getNombre())){
                proveedor.setSubTotal(p.getSubTotal() + proveedor.getSubTotal());
                proveedor.setIva(p.getIva() + proveedor.getIva());
                proveedor.setTotal(p.getTotal() + proveedor.getTotal());
                
                getRandomConection().getRafProveedores().seek(posP);
                getRandomConection().getRafProveedores().writeUTF(gson.toJson(proveedor));
                return;
            }
        }
        
        getRandomConection().getRafProveedores().writeUTF(gson.toJson(p));
        
    }
    
    //Este método devuelve la cantidad de registros que se encuentra en el archivo
    private int getRegistros() throws IOException{
        getRandomConection().getRafH().seek(0);
        
        return getRandomConection().getRafH().readInt();
    }
}
