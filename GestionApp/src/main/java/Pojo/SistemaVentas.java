/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Sistemas-15
 */
public class SistemaVentas {
    private String descripcion;
    private int cantidad;
    private float costoU;
    private float total ;

    public SistemaVentas(String descripcion, int cantidad, float costoU, float total) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoU = costoU;
        this.total = total;
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
