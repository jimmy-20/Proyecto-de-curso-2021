/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Connection;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public abstract class FileConnection {
    private File fileHeader;
    private File fileDetalle;
    private File fileFactura;
    private File fileCredito;
    private File fileInventario;
    private RandomConnection raf;

    public FileConnection(File fileHeader, File fileDetalle, File fileFactura, File fileCredito, File inventario) {
        this.fileHeader = fileHeader;
        this.fileDetalle = fileDetalle;
        this.fileFactura = fileFactura;
        this.fileCredito = fileCredito;
        this.fileInventario = inventario;
    }
    
    protected RandomConnection getRandomConection() throws IOException{
        if (raf == null){
            raf = new RandomConnection(fileHeader, fileDetalle, fileFactura, fileCredito, fileInventario);
        }
        
        return raf;
    }
    
    public void close() throws IOException{
        raf.close();
        raf = null;
    }
    
    
}
