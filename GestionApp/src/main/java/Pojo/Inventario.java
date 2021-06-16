/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Jimmy-Soza
 */
public class Inventario {
    private String fecha; // 10*2 + 5*2 = 30
    private String factura; // 10*2 + 7*2 = 34
    private String descripcion; // 30*2 + 11*2 = 82
    private int cantidad; // 4 + 8*2 = 20
    private float costoU; // 4 + 6*2 = 16
    private float total; // 4 + 5*2 = 14
    //TOTAL = 196 Bytes

    public Inventario(String fecha, String factura, String descripcion, int cantidad, float costoU, float total) {
        this.fecha = fecha;
        this.factura = factura;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoU = costoU;
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
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

    public float getCostoU() {
        return costoU;
    }

    public void setCostoU(float costoU) {
        this.costoU = costoU;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
