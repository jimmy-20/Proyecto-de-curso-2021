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
    private String factura; //20 + 14
    private String fecha; //20 + 10
    private String nombreCliente;// 
   
    private int cantidad; //  
    private float precioUnitario;
    private float subTotal; 
    private float iva; 
    private float total; //
    
<<<<<<< HEAD
    //TOTAL = x  + y = ? bytes

    public DetalleVentaFactura(String factura, String fecha, String nombreCliente, int cantidad, float precioUnitario, float subTotal, float iva, float total) {
        this.factura = factura;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
=======
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
    //357 bits

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
>>>>>>> BranchMassiel
        this.iva = iva;
        this.total = total;
    }

<<<<<<< HEAD
    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
=======
    public String getnFactura() {
        return nFactura;
    }

    public void setnFactura(String nFactura) {
        this.nFactura = nFactura;
>>>>>>> BranchMassiel
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

<<<<<<< HEAD
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    
=======
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

>>>>>>> BranchMassiel
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> BranchMassiel
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
    
<<<<<<< HEAD
    public Object []  toArray(){
        Object[] obj=new Object[8];
        
        obj[0]=factura;
        obj[1]=fecha;
        obj[2]=nombreCliente;
        obj[3]=cantidad;
        obj[4]=precioUnitario;
        obj[5]=subTotal;
        obj[6]=iva;
        obj[7]=total;
        
        return obj;
    }
=======
    
>>>>>>> BranchMassiel
}
