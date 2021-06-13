/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Ramiro Suarez
 */
public class Proveedor {
    private String nombre; // 12 + 20
    private float subTotal; //16 + 4
    private float iva; // 6 + 4
    private float total; // 10 + 4
    //  44 + 32 = 76

    public Proveedor(String nombre, float subTotal, float iva, float total) {
        this.nombre = nombre;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
