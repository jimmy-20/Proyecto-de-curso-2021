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

    private String factura; // 20 +14
    private String fecha;// 20 + 5
    private String tipoVenta; //14 + 20
    private String tipomoneda; // 14 + 20
    private String nombreCliente;//20+26
    private String descripcion;//40+22
    private int cantidad;//4+16
    private float precioUnitario;//4+28
    private float subTotal;//4+16
    private float iva;//4 + 6
    private float total;//4+10
    //TOTAL =331 bytes

    public DetalleVenta(String factura, String fecha, String tipoVenta, String tipomoneda, String nombreCliente, String descripcion, int cantidad, float precioUnitario, float subTotal, float iva, float total) {
        this.factura = factura;
        this.fecha = fecha;
        this.tipoVenta = tipoVenta;
        this.tipomoneda = tipomoneda;
        this.nombreCliente = nombreCliente;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
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

    public Object[] toArray() {
        Object[] obj = new Object[11];

        obj[0] = factura;
        obj[1] = fecha;
        obj[2]=tipoVenta;
        obj[3]=tipomoneda;
        obj[4] = nombreCliente;
        obj[5] = descripcion;
        obj[6] = cantidad;
        obj[7] = precioUnitario;
        obj[8] = subTotal;
        obj[9] = iva;
        obj[10] = total;

        return obj;
    }
}
