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
    private String factura; // 20 +14
    private String fecha; // 20 + 5
    private String tipoVenta; //14 + 20
    private String tipomoneda; // 14 + 20
    private String cliente; // 40 + 16
    private float subtotal; // 4 + 16
    private float iva; //  4 + 6
    private float total; // 4+ 10
    //227 bits 

    public DetalleVentaFactura() {
    }

    public DetalleVentaFactura(String factura, String fecha, String tipoVenta, String tipomoneda, String cliente, float subtotal, float iva, float total) {
        this.factura = factura;
        this.fecha = fecha;
        this.tipoVenta = tipoVenta;
        this.tipomoneda = tipomoneda;
        this.cliente = cliente;
        this.subtotal = subtotal;
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

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public String getTipomoneda() {
        return tipomoneda;
    }

    public void setTipomoneda(String tipomoneda) {
        this.tipomoneda = tipomoneda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
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
     Object[] obj = new Object[8];
        
        obj[0] = factura;
        obj[1] = fecha;
        obj[2] = tipoVenta;
        obj[3] = tipomoneda;
        obj[4] = cliente;
        obj[5] = subtotal;
        obj[6] = iva;
        obj[7] = total;
        
        return obj;}
}
