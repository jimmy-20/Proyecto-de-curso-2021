/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.Connection.FileConnection;
import Backend.Idao.IdaoActions;
import Pojo.Cliente;
import Pojo.DetalleCompraFactura;
import Pojo.DetalleVenta;
import Pojo.DetalleVentaFactura;
import Pojo.Ventas;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class FilesVentas extends FileConnection implements IdaoActions<DetalleVentaFactura, DetalleVenta,Cliente>{
    private final int detalle_size = 192;
    private final int reporte_size = 357; 
    private Gson gson;
    
    public FilesVentas() {
        super(new File("headerVentas.dat"), new File("Detalle de Venta.dat"),
                new File("Detalle de Factura de Venta.dat"), new File("Clientes.dat"), new File("Inventario de Ventas.dat"));
        gson = new Gson();
    } 
    
    @Override
    public void add(DetalleVentaFactura g, DetalleVenta t,Cliente c) {
        try {
            if (t == null){
                return;
            }
            getRandomConection().getRafH().seek(0);
            
            int n = getRandomConection().getRafH().readInt(); //Nª de registros;
            int k = getRandomConection().getRafH().readInt(); //id
            
            long posD = k*detalle_size;
            long posF = k*reporte_size;
            
            //Se colocan los punteros en sus respectivos archivos
            getRandomConection().getRafDetalle().seek(posD);
            getRandomConection().getRafFactura().seek(posF);
            
            getRandomConection().getRafDetalle().writeUTF(gson.toJson(t)); 
            getRandomConection().getRafFactura().writeUTF(gson.toJson(g)); 
            
            getRandomConection().getRafH().seek(0);
            getRandomConection().getRafH().writeInt(++n);
            getRandomConection().getRafH().writeInt(++k);  
            
            close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public Collection<DetalleVenta> findAllDetalle() {
        Collection <DetalleVenta> detalleVentas = new ArrayList<>();
        
        //Implementar !!!
        return detalleVentas;
    }

    @Override
    public boolean edit(DetalleVenta t, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<DetalleVentaFactura> findAllFactura() {
        Collection<DetalleVentaFactura> ListFac = new ArrayList<>();
        DetalleVentaFactura venta = null;
        
        try {
            getRandomConection().getRafH().seek(0);
            int n = getRandomConection().getRafH().readInt();
            
            if ( (n<=0) ){
                return ListFac;
            }
            
            for (int i=0 ; i<n ; i++){
                long posD = i*reporte_size;
                
                getRandomConection().getRafFactura().seek(posD);
                venta = gson.fromJson(getRandomConection().getRafFactura().readUTF(), DetalleVentaFactura.class);
                
                ListFac.add(venta);
            }
        } catch (IOException ex) {
            Logger.getLogger(FilesVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListFac ;
    }

    @Override
    public Collection<Cliente> findAllCredito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
