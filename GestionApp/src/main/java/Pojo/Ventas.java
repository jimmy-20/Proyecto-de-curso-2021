/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author FAM. FONSECA SANDINO
 */
public class Ventas {
    private String nFactura;   // 20 +14
    private String fecha;       // 20 + 10
    private String nomCliente;   // 40 + 18
    private float subtotal; //  4+16
    private float iva;      // 4 + 6
    private float total;    // 4+10
    private String item;    // 14+12    = total 192
    
    public Ventas() {
    }

    public Ventas(String nFactura, String fecha, String nomCliente, float subtotal, float iva, float total, String item) {
        this.nFactura = nFactura;
        this.fecha = fecha;
        this.nomCliente = nomCliente;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.item = item;
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

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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
