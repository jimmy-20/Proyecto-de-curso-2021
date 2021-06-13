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
    private File fileProveedores;
    private RandomConnection raf;

    public FileConnection(File fileHeader, File fileDetalle, File fileFactura, File fileProveedores) {
        this.fileHeader = fileHeader;
        this.fileDetalle = fileDetalle;
        this.fileFactura = fileFactura;
        this.fileProveedores = fileProveedores;
    }
    
    protected RandomConnection getRandomConection() throws IOException{
        if (raf == null){
            raf = new RandomConnection(fileHeader, fileDetalle, fileFactura,fileProveedores);
        }
        
        return raf;
    }
    
    public void close() throws IOException{
        raf.close();
        raf = null;
    }
    
    
}
