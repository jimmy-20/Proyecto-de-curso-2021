/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pojo;

/**
 * 
 * @author HenocOrtiz
 */
public class Cliente {
    private String nombreCliente;   //20+13
    private float subTotal;// 4 + 16
    private float iva;//  4 + 6
    private float total; // 4+ 10
    //TOTAL= 77

    public Cliente(String nombreCliente, float subTotal, float iva, float total) {
        this.nombreCliente = nombreCliente;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }
    
    
    
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
        Object[] obj = new Object[4];
        obj[0]= nombreCliente;
        obj[1]= subTotal;
        obj[2]= iva;
        obj[3]=total;
                
        return obj;
    }
}
