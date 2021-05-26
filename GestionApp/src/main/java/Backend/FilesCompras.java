/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.Connection.FileConnection;
import Backend.Idao.IdaoActions;
import Pojo.Compra;
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
public class FilesCompras extends FileConnection implements IdaoActions<Compra,DetalleCompra>{
    private final int SIZE_DETALLE = 200;
    private final int SIZE_FACTURA = 130;
    private Gson gson;

    public FilesCompras(File fileHeader, File fileData) {
        super(fileHeader, fileData);
        gson = new Gson();
    }

    @Override
    public void add(Compra t,DetalleCompra dt) {
        try {
            if (t == null){
                return;
            }
            
            int n = getRandomConection().getRafH().readInt(); //Nª de registros;
            int k = getRandomConection().getRafH().readInt(); //id
            
            long posD = k*SIZE_FACTURA;
            
            
            getRandomConection().getRafD().seek(posD);
            
            getRandomConection().getRafD().writeUTF(gson.toJson(t));
            
            getRandomConection().getRafH().seek(0);
            getRandomConection().getRafH().writeInt(++n);
            getRandomConection().getRafH().writeInt(++k);
            
            close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean edit(Compra t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Compra> findAllFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<DetalleCompra> findAllDetalle() {
        List<Compra> compras = new ArrayList<>();
        Compra compra = null;
        
        try {
            int n = getRandomConection().getRafH().readInt();
            
            if (n<0){
                return null;
            }
            
            for (int i=0 ; i<n ; i++){
                long posD = i*SIZE_FACTURA;
                
                getRandomConection().getRafD().seek(posD);
                compra = gson.fromJson(getRandomConection().getRafD().readUTF(), Compra.class);
                
                compras.add(compra);
            }
        } catch (IOException ex) {
            Logger.getLogger(FilesCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (Collection) compras;
    }
}
