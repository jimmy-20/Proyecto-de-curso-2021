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
    private RandomAccessFile rafD;    
    
    public RandomConnection(File header, File data) throws FileNotFoundException, IOException{
        this.rafH = new RandomAccessFile(header, "rw");
        this.rafD = new RandomAccessFile(data, "rw");
        
        if (rafH.length() == 0){
            rafH.seek(0);
            
            rafH.writeInt(0); //n = Cantidad total
            rafH.writeInt(0); //k = ID unico
        }
    }

    public RandomAccessFile getRafH() {
        return rafH;
    }

    public RandomAccessFile getRafD() {
        return rafD;
    }
    
    public void close() throws IOException{
        if(rafH != null){
            rafH.close();
        }
        
        if(rafD != null){
            rafD.close();
        }
    }
}
