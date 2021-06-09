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
    
     private String nFactura;
    private String fecha;
    private String tipoVenta;
    private String tipomoneda;
    private String nomCliente;
    private String descripcion;
    private int cantidad;
    private float costoUn;
    private float subtotal;
    private float iva;
    private float total;

    public DetalleVentaFactura() {
    }

    public DetalleVentaFactura(String nFactura, String fecha, String tipoVenta, String tipomoneda, String nomCliente, String descripcion, int cantidad, float costoUn, float subtotal, float iva, float total) {
        this.nFactura = nFactura;
        this.fecha = fecha;
        this.tipoVenta = tipoVenta;
        this.tipomoneda = tipomoneda;
        this.nomCliente = nomCliente;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoUn = costoUn;
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

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
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

    public float getCostoUn() {
        return costoUn;
    }

    public void setCostoUn(float costoUn) {
        this.costoUn = costoUn;
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
