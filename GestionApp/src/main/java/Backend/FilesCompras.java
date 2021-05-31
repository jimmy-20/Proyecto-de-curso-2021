/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.Connection.FileConnection;
import Backend.Idao.IdaoActions;
import Pojo.DetalleFactura;
import Pojo.DetalleCompra;
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
public class FilesCompras extends FileConnection implements IdaoActions<DetalleFactura,DetalleCompra>{
    private final int SIZE_DETALLE = 200;
    private final int SIZE_FACTURA = 130;
    private Gson gson;

    public FilesCompras() {
        super(new File("headerCompra.dat"),new File("Detalle de compra.dat"),new File("Detalle de factura.dat"));
        gson = new Gson();
    }

    @Override
    public void add(DetalleFactura t,DetalleCompra dt) { // Detalle de factura, Detalle de compra
        try {
            if (t == null){
                return;
            }
            getRandomConection().getRafH().seek(0);
            
            int n = getRandomConection().getRafH().readInt(); //Nª de registros;
            int k = getRandomConection().getRafH().readInt(); //id
            
            long posD = k*SIZE_DETALLE;
            long posF = k*SIZE_FACTURA;
            
            //Se colocan los punteros en sus respectivos archivos
            getRandomConection().getRafDetalle().seek(posD);
            getRandomConection().getRafFactura().seek(posF);
            
            getRandomConection().getRafDetalle().writeUTF(gson.toJson(dt)); //Se crea el archivo del detalle de compra
            getRandomConection().getRafFactura().writeUTF(gson.toJson(t)); //Se crea e archivo del detalle de factura

            
            getRandomConection().getRafH().seek(0);
            getRandomConection().getRafH().writeInt(++n);
            getRandomConection().getRafH().writeInt(++k);  
            
            close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean edit(DetalleFactura t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<DetalleCompra> findAllDetalle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<DetalleFactura> findAllFactura() {
        Collection<DetalleFactura> facturaList = new ArrayList<>();
        DetalleFactura compra = null;
        
        try {
            int n = getRandomConection().getRafH().readInt();
            
            if (n<0){
                return null;
            }
            
            for (int i=0 ; i<n ; i++){
                long posD = i*SIZE_FACTURA;
                
                getRandomConection().getRafDetalle().seek(posD);
                compra = gson.fromJson(getRandomConection().getRafDetalle().readUTF(), DetalleFactura.class);
                
                facturaList.add(compra);
            }
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  facturaList;
    }
}