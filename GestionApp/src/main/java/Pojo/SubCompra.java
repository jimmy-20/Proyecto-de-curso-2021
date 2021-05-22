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
public class SubCompra {
    private String nFactura;
    private String fecha;
    private String TipoCompra;
    private String moneda;
    private String proveedor;
    private float subtotal;
    private float iva;
    private float total;

    public SubCompra(String nFactura, String fecha, String TipoCompra, String moneda, String proveedor, float subtotal, float iva, float total) {
        this.nFactura = nFactura;
        this.fecha = fecha;
        this.TipoCompra = TipoCompra;
        this.moneda = moneda;
        this.proveedor = proveedor;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public String getnFactura() {
        return nFactura;
    }

    public void setnFactura(String nFactura) {
        this.nFactura = nFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCompra() {
        return TipoCompra;
    }

    public void setTipoCompra(String TipoCompra) {
        this.TipoCompra = TipoCompra;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
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
    
    
}
