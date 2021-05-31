/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Pojo.DetalleCompra;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class MainCompiler {
    public static void main(String[] args) {
        DetalleCompra dc = new DetalleCompra("1234", "27/07/2002", "CONTADO", "CORDOBAS", "Pellas", "Moto 2 cabina", 5, 50, 250, 75, 325);
        header();
        print(dc);
        
        String name = dc.getClass().getSimpleName();
        System.out.println("");
        System.out.println(name);
    }
    
    public static void header(){
        System.out.format("%5s %10s %15s %15s %20s %20s %4s %15s %7s %7s %7s\n -----------------------------------------------------------------------------------------------------------------------------------------------------\n",
                "Factura","Fecha","Tipo Compra","Tipo Moneda","Proveedor","Descripcion",
                "Cantidad","Costo Unitario","Sub Total","Iva","Total");
    }
    
    public static void print(DetalleCompra dc){
        System.out.format("%7s %10s %15s %15s %20s %20s %8d %15.2f %9.2f %7.2f %7.2f",dc.getNfactura(),
                dc.getFecha(),dc.getTipoCompra(),dc.getTipomoneda(),dc.getProveedor(),dc.getDescripcion(),
                dc.getCantidad(),dc.getCosto(),dc.getSubTotal(),dc.getIva(),dc.getTotal());
    }
}
