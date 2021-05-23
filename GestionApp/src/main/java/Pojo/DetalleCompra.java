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
    private String nfactura;  // 10*2 = 20
    private String fecha; // 10*2
    private String tipoCompra; // Credito Contado 7*2 = 14
    private String tipomoneda; // 7 *2 = 14
    private String proveedor; // 20*2 = 40;
    private String descripcion; // 30*2 = 60
    private int cantidad; // 4
    private float costo; //4
    private float subTotal; //4
    private float iva; //4
    private float total; //4

    //Total = 188
    public DetalleCompra() {
    }

    public DetalleCompra(String nfactura, String fecha, String tipoCompra, String tipomoneda, String proveedor, String descripcion, int cantidad, float costo, float subTotal, float iva, float total) {
        this.nfactura = nfactura;
        this.fecha = fecha;
        this.tipoCompra = tipoCompra;
        this.tipomoneda = tipomoneda;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo = costo;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }

    public String getNfactura() {
        return nfactura;
    }

    public void setNfactura(String nfactura) {
        this.nfactura = nfactura;
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
        return tipomoneda;
    }

    public void setTipomoneda(String tipomoneda) {
        this.tipomoneda = tipomoneda;
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
    
    
    
            
    
}
