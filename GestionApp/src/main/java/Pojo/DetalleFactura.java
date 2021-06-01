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
public class DetalleFactura {
    private String factura; //20 + 14
    private String fecha; //20 + 10
    private String tipoCompra;// 14 + 20
    private String moneda; // 14 + 12
    private String proveedor; // 40 + 18 
    private float subTotal; //4 + 16
    private float iva; //4 + 6
    private float total; //4 + 10 
    //TOTAL = 120  + 106 = 226 bytes

    public DetalleFactura(String factura, String fecha, String tipoCompra, String moneda, String proveedor, float subTotal, float iva, float total) {
        this.factura = factura;
        this.fecha = fecha;
        this.tipoCompra = tipoCompra;
        this.moneda = moneda;
        this.proveedor = proveedor;
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

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
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
    
    public Object[] toArray(){
        Object[] obj = new Object[8];
        
        obj[0] = factura;
        obj[1] = fecha;
        obj[2] = tipoCompra;
        obj[3] = moneda;
        obj[4] = proveedor;
        obj[5] = subTotal;
        obj[6] = iva;
        obj[7] = total;
        
        return obj;
    }
    
    
}
