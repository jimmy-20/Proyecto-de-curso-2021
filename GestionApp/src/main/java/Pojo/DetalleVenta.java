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
public class DetalleVenta {
    private String factura;
    private String fecha;
    private String nombreCliente;
    private String descripcion;
    private int cantidad;
    private float precioUnitario;
    private float subTotal;
    private float iva;
    private float total;
    //TOTAL = x  + y = ? bytes

    public DetalleVenta(String factura, String fecha, String nombreCliente, String descripcion, int cantidad, float precioUnitario, float subTotal, float iva, float total) {
        this.factura = factura;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        Object[] obj=new Object[11];
        
        obj[0]=factura;
        obj[1]=fecha;
        obj[2]=nombreCliente;
        obj[3]=descripcion;
        obj[4]=cantidad;
        obj[5]=precioUnitario;
        obj[6]=subTotal;
        obj[7]=iva;
        obj[8]=total;
        
        return obj;
    }
}
