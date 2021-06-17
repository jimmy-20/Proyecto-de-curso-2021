/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.Connection.FileConnection;
import Backend.Idao.IdaoActions;
import Pojo.Cliente;
import Pojo.DetalleCompra;
import Pojo.DetalleCompraFactura;
import Pojo.DetalleVenta;
import Pojo.DetalleVentaFactura;
import Pojo.Proveedor;
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

public class FilesVentas extends FileConnection implements IdaoActions<DetalleVentaFactura, DetalleVenta, Cliente> {

    private final int SIZE_DETALLE = 331;
    private final int reporte_size = 357;
    private final int SIZE_CLIENTE=77;
    private final int SIZE_FACTURA=227;
    private Gson gson;

    public FilesVentas() {
        super(new File("headerVentas.dat"), new File("Detalle de Venta.dat"),
                new File("Detalle de Factura de Venta.dat"), new File("Clientes.dat"), new File("Inventario de Ventas.dat"));
        gson = new Gson();
    }

    @Override
    public void add(DetalleVentaFactura g, DetalleVenta t, Cliente c) {
        try {
            if (t == null) {
                return;
            }
            getRandomConection().getRafH().seek(0);

            int n = getRandomConection().getRafH().readInt(); //Nª de registros;
            int k = getRandomConection().getRafH().readInt(); //id

            long posD = k * SIZE_DETALLE;
            long posF = k * reporte_size;

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

    public void addVentas(DetalleVentaFactura df, DetalleVenta[] dv, Cliente c) {
        if (dv == null) {
            return;
        }
    }

    @Override
    public Collection<DetalleVenta> findAllDetalle() {
        Collection<DetalleVenta> detalleVentas = new ArrayList<>();
        DetalleCompra detalle = null;
        //Implementar !!!
        try {
            getRandomConection().getRafCredito().seek(0);
            int n=getRandomConection().getRafH().readInt();
            
            if(n<=0){
                return  detalleVentas;
            }
            
            for (int i=0;i<n;i++){
                long posD=i*SIZE_DETALLE;
                
                getRandomConection().getRafDetalle().seek(posD);
               // detalle=gson.fromJson(getRandomConection().getRafDetalle().readUTF(),DetalleVenta.class);
                
             //   detalleVentas.add(detalle);
            }
        } catch (IOException ex) {
            Logger.getLogger(FilesVentas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return detalleVentas;
    }

    @Override
    public boolean edit(DetalleVenta t, int row) {
        long posD= row*SIZE_DETALLE;
        long posF=row*SIZE_FACTURA;
        DetalleVentaFactura detalleVentaFactura;
        if(t==null){
            return false;
        }
        try{
            getRandomConection().getRafDetalle().seek(posD);
            getRandomConection().getRafDetalle().writeUTF(gson.toJson(t));
            
            getRandomConection().getRafFactura().seek(posF);
            
            detalleVentaFactura=gson.fromJson(getRandomConection().getRafFactura().readUTF(), DetalleVentaFactura.class);
            
           detalleVentaFactura.setFactura(t.getFactura());
           detalleVentaFactura.setFecha(t.getFecha());
            detalleVentaFactura.setTipoVenta(t.getTipoVenta());
            detalleVentaFactura.setTipomoneda(t.getTipomoneda());
            detalleVentaFactura.setCliente(t.getNombreCliente());
            detalleVentaFactura.setSubtotal(t.getSubTotal());
            detalleVentaFactura.setIva(t.getIva());
            detalleVentaFactura.setTotal(t.getTotal());
            
           // getRandomConection().getRafFactura().writeUTF(gson.fromJson(detalleVentaFactura));
        
            
        }catch (IOException ex)
        {
            Logger.getLogger(FilesVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
      
    }

    @Override
    public Collection<DetalleVentaFactura> findAllFactura() {
        Collection<DetalleVentaFactura> ListFac = new ArrayList<>();
        DetalleVentaFactura venta = null;

        try {
            getRandomConection().getRafH().seek(0);
            int n = getRandomConection().getRafH().readInt();

            if ((n <= 0)) {
                return ListFac;
            }

            for (int i = 0; i < n; i++) {
                long posD = i * reporte_size;

                getRandomConection().getRafFactura().seek(posD);
                venta = gson.fromJson(getRandomConection().getRafFactura().readUTF(), DetalleVentaFactura.class);

                ListFac.add(venta);
            }
        } catch (IOException ex) {
            Logger.getLogger(FilesVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListFac;
    }

    @Override
    public Collection<Cliente> findAllCredito() {
       Collection <Cliente>clientes= new ArrayList<>();
       Cliente c= null;
       try
        { 
            getRandomConection().getRafH().seek(0);
            int n = getRandomConection().getRafH().readInt();
            
            if ( (n<=0) ){
                return clientes;
            }
            
            if (getRandomConection().getRafCredito().length() == 0){
                return clientes;
            }
            
            for (int i=0 ; i<n ; i++){
                long posP = i*SIZE_CLIENTE;
                
                getRandomConection().getRafFactura().seek(posP);
                c = gson.fromJson(getRandomConection().getRafCredito().readUTF(), Cliente.class);
                
                clientes.add(c);
            }
            close();
        } catch (IOException ex)
        {
            Logger.getLogger(FilesVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
}
