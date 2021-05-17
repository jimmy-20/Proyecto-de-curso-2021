/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.Connection.FileConnection;
import Backend.Idao.IdaoActions;
import Pojo.Compra;
import com.google.gson.Gson;
import java.io.File;
import java.util.Collection;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class Compras extends FileConnection implements IdaoActions<Compra>{
    
    private Gson gson;

    public Compras(File fileHeader, File fileData) {
        super(fileHeader, fileData);
        gson = new Gson();
    }

    @Override
    public void add(Compra t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Compra t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(Compra t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Compra> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
