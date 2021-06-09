/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.Connection.FileConnection;
import Backend.Idao.IdaoActions;
import Pojo.DetalleVenta;
import Pojo.DetalleVentaFactura;
import com.google.gson.Gson;
import java.io.File;
import java.util.Collection;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class FilesVentas extends FileConnection implements IdaoActions<DetalleVenta, DetalleVentaFactura>{
    private final int detalle_size = 226;
    private final int reporte_size = 357; 
    private Gson gson;
    
    public FilesVentas() {
        super(new File("headerventas.dat"), new File("DetalleVenta.dat"), new File("DetalleFacturaVenta.dat"));
        gson = new Gson();
    } 

    
    
    @Override
    public void add(DetalleVenta t, DetalleVentaFactura g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(DetalleVenta t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<DetalleVenta> findAllFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<DetalleVentaFactura> findAllDetalle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
