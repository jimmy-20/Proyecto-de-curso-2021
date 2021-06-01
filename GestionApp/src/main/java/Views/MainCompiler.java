/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Backend.FilesCompras;
import Pojo.DetalleCompra;
import Pojo.DetalleCompraFactura;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author FAMILIASOZAORTIZ
 * 
 * Clase Compiler con fines de Prueba y error usando el compilador
 */
public class MainCompiler {
    public static void main(String[] args) {
        FilesCompras fc = new FilesCompras();
        List<DetalleCompraFactura> facturas = fc.findAllFactura().stream().collect(Collectors.toList());
        
        headerDetalleFactura();
        facturas.stream().forEach(x -> print(x));
        
        
    }
    
    public static void headerDetalleCompra(){
        System.out.format("%5s %10s %15s %15s %20s %20s %4s %15s %7s %7s %7s\n -----------------------------------------------------------------------------------------------------------------------------------------------------\n",
                "Factura","Fecha","Tipo Compra","Tipo Moneda","Proveedor","Descripcion",
                "Cantidad","Costo Unitario","Sub Total","Iva","Total");
    }
    
    public static void headerDetalleFactura(){
        System.out.format("%5s %10s %15s %15s %20s %7s %7s %7s\n -----------------------------------------------------------------------------------------------------------------------------------------------------\n",
                "Factura","Fecha","Tipo Compra","Tipo Moneda","Proveedor","Sub Total","Iva","Total");
    }
    
    public static void print(DetalleCompra dc){
        System.out.format("%7s %10s %15s %15s %20s %20s %8d %15.2f %9.2f %7.2f %7.2f",dc.getNfactura(),
                dc.getFecha(),dc.getTipoCompra(),dc.getTipomoneda(),dc.getProveedor(),dc.getDescripcion(),
                dc.getCantidad(),dc.getCosto(),dc.getSubTotal(),dc.getIva(),dc.getTotal());
    }
    
    public static void print(DetalleCompraFactura df){
        System.out.format("%7s %10s %15s %15s %20s %9.2f %9.2f %9.2f\n",df.getFactura(),df.getFecha(),
                df.getTipoCompra(),df.getMoneda(),df.getProveedor(),df.getSubTotal(),df.getIva(),df.getTotal());
    }
}
