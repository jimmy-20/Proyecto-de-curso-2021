/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class DetalleVentaFactura {
    private String factura; //20 + 14
    private String fecha; //20 + 10
    private String nombreCliente;// 
   
    private int cantidad; //  
    private float precioUnitario;
    private float subTotal; 
    private float iva; 
    private float total; //
    
    //TOTAL = x  + y = ? bytes

    public DetalleVentaFactura(String factura, String fecha, String nombreCliente, int cantidad, float precioUnitario, float subTotal, float iva, float total) {
        this.factura = factura;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public Object []  toArray(){
        Object[] obj=new Object[8];
        
        obj[0]=factura;
        obj[1]=fecha;
        obj[2]=nombreCliente;
        obj[3]=cantidad;
        obj[4]=precioUnitario;
        obj[5]=subTotal;
        obj[6]=iva;
        obj[7]=total;
        
        return obj;
    }
}
