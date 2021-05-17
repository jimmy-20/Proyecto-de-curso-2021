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
    private File fileData;
    private RandomConnection raf;

    public FileConnection(File fileHeader, File fileData) {
        this.fileHeader = fileHeader;
        this.fileData = fileData;
        
    }
    
    protected RandomConnection getRandomConection() throws IOException{
        if (raf == null){
            raf = new RandomConnection(fileHeader, fileData);
        }
        
        return raf;
    }
    
    public void close() throws IOException{
        raf.close();
        raf = null;
    }
    
    
}
