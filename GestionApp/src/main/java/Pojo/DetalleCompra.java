/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Javier Ramirez
 */
public class DetalleCompra { 
    private String factura;  // 10*2 = 20 + 14 
    private String fecha; // 10*2 = 20 + 5
    private String tipoCompra; // Credito Contado 7*2 = 14 + 20
    private String tipoMoneda; // 7 *2 = 14 + 20
    private String proveedor; // 20*2 = 40 + 18
    private String descripcion; // 30*2 = 60 + 22
    private int cantidad; // 4 + 16
    private float costo; //4 + 10
    private float subTotal; //4 + 16
    private float iva; //4 + 6
    private float total; //4 + 10

    //Total = 188 + 157 = 345Bytes// Pero se usa: 200 + 157 = 357Bytes
    public DetalleCompra() {
    }

    public DetalleCompra(String nfactura, String fecha, String tipoCompra, String tipomoneda, String proveedor, String descripcion, int cantidad, float costo, float subTotal, float iva, float total) {
        this.factura = nfactura;
        this.fecha = fecha;
        this.tipoCompra = tipoCompra;
        this.tipoMoneda = tipomoneda;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo = costo;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }

    public String getfactura() {
        return factura;
    }

    public void setfactura(String nfactura) {
        this.factura = nfactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public String getTipomoneda() {
        return tipoMoneda;
    }

    public void setTipomoneda(String tipomoneda) {
        this.tipoMoneda = tipomoneda;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
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

    public Object[] toArray() {
        Object[] obj = new Object[11];
        
        obj[0] = factura;
        obj[1] =fecha;
        obj[2] =tipoCompra;
        obj[3] = tipomoneda;
        obj[4] = proveedor;
        obj[5] = descripcion;
        obj[6] = cantidad;
        obj[7] =costo;
        obj[8] =subTotal;
        obj[9] = iva;
        obj[10] = total;
        return obj;
        
    }
    
    
    
            
    
}
