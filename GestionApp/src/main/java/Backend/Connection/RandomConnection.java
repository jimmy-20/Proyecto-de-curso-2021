/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class RandomConnection {
    private RandomAccessFile rafH;
    private RandomAccessFile rafDDetalle;    
    private RandomAccessFile rafDFactura;
    private RandomAccessFile rafProveedor;
    
    public RandomConnection(File header, File detalle,File factura, File proveedor) throws FileNotFoundException, IOException{
        this.rafH = new RandomAccessFile(header, "rw");
        this.rafDDetalle = new RandomAccessFile(detalle, "rw");
        this.rafDFactura = new RandomAccessFile(factura, "rw");
        this.rafProveedor = new RandomAccessFile(proveedor, "rw");
        
        if (rafH.length() == 0){
            rafH.seek(0);
            
            rafH.writeInt(0); //n = Cantidad total
            rafH.writeInt(0); //k = ID unico
        }
    }

    /**
     * Obtiene de regreso el archivo "Header" de compras
     * @return Archivo "Header"
     **/
    public RandomAccessFile getRafH() {
        return rafH;
    }

    /**
     * Obtiene el archivo del Detalle de compras
     * @return Archivo "Detalle de Compras"
     **/
    public RandomAccessFile getRafDetalle() {
        return rafDDetalle;
    }
    
    /**
     * Obtiene el archivo del Detalle de Factura de compras
     * @return Archivo "Detalle de Factura"
     **/
    public RandomAccessFile getRafFactura()
    {
        return rafDFactura;
    }
    
    /**
     * @Obtiene el archivo de los proveedores a los que les debe
     * @return Archivo "Proveedores"
     **/
    public RandomAccessFile getRafProveedores(){
        return rafProveedor;
    }
    
    /**
     * Cierra los flujos de bytes de todos los archivos con los que se gestiona
     * @exception IOException - En caso se produzca un error en los flujos de Bytes
     **/
    public void close() throws IOException{
        if(rafH != null){
            rafH.close();
        }
        
        if(rafDDetalle != null){
            rafDDetalle.close();
        }
        
        if (rafDFactura != null){
            rafDFactura.close();
        }
    }
}
