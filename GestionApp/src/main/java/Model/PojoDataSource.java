/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.DetalleCompra;
import Pojo.DetalleCompraFactura;
import Pojo.DetalleVenta;
import Pojo.DetalleVentaFactura;
import java.util.List;
import java.util.stream.Collectors;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author FAMILIASOZAORTIZ
 * @param <T> Parametro generico que recibira un Pojo
 */
public class PojoDataSource<T> implements JRDataSource{
    private List<T> lista;
    private int indice = -1;
    private final String nameClass;
    
    public PojoDataSource (List<T> lista){
        this.lista = lista;
        nameClass = lista.get(0).getClass().getSimpleName();
    }

    @Override
    public boolean next() throws JRException {
        return ++indice < lista.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object obj = null;
        
        switch(nameClass){
            case "DetalleCompra":
                List<DetalleCompra> compras = (List<DetalleCompra>) lista;
                
                switch(jrf.getName()){
                    case "factura":
                        obj = compras.get(indice).getfactura();
                        break;
                    case "fecha":
                        obj = compras.get(indice).getFecha();
                        break;
                    case "tipoCompra":
                        obj = compras.get(indice).getTipoCompra();
                        break;
                    case "tipoMoneda":
                        obj = compras.get(indice).getTipomoneda();
                        break;
                    case "proveedor":
                        obj = compras.get(indice).getProveedor();
                        break;
                    case "descripcion":
                        obj = compras.get(indice).getDescripcion();
                        break;
                    case "cantidad":
                        obj = compras.get(indice).getCantidad();
                        break;
                    case "costo":
                        obj = compras.get(indice).getCosto();
                        break;
                    case "subTotal":
                        obj = compras.get(indice).getSubTotal();
                        break;
                    case "iva":
                        obj = compras.get(indice).getIva();
                        break;
                    case "total":
                        obj = compras.get(indice).getTotal();
                        break;
                    default :
                        return null;
                }
                break;
            case "DetalleCompraFactura":
                List<DetalleCompraFactura> compraFacturas = (List<DetalleCompraFactura>) lista;
                
                switch(jrf.getName()){
                    case "factura":
                        obj = compraFacturas.get(indice).getFactura();
                        break;
                    case "fecha":
                        obj = compraFacturas.get(indice).getFecha();
                        break;
                    case "tipoCompra":
                        obj = compraFacturas.get(indice).getTipoCompra();
                        break;
                    case "tipoMoneda":
                        obj = compraFacturas.get(indice).getTipoMoneda();
                        break;
                    case "proveedor":
                        obj = compraFacturas.get(indice).getProveedor();
                        break;
                    case "subTotal":
                        obj = compraFacturas.get(indice).getSubTotal();
                        break;
                    case "iva":
                        obj = compraFacturas.get(indice).getIva();
                        break;
                    case "total":
                        obj = compraFacturas.get(indice).getTotal();
                        break;
                    default :
                        return null;
                }
                
                break;
                
            case "DetalleVentaFactura":
                List<DetalleVentaFactura> detalleVentaFactura = (List<DetalleVentaFactura>) lista;
                
                switch(jrf.getName()){
                    case "factura":
                        obj = detalleVentaFactura.get(indice).getFactura();
                        break;
                    case "fecha":
                        obj = detalleVentaFactura.get(indice).getFecha();
                        break;
                    case "tipoVenta":
                        obj = detalleVentaFactura.get(indice).getTipoVenta();
                        break;
                    case "tipomoneda":
                        obj = detalleVentaFactura.get(indice).getTipomoneda();
                        break;
                    case "cliente":
                        obj = detalleVentaFactura.get(indice).getCliente();
                        break;
                    case "subtotal":
                        obj = detalleVentaFactura.get(indice).getSubtotal();
                        break;
                    case "iva":
                        obj = detalleVentaFactura.get(indice).getIva();
                        break;
                    case "total":
                        obj = detalleVentaFactura.get(indice).getTotal();
                        break;
                    default :
                        return null;
                }
                
                break;
                
            case "DetalleVenta":
                List<DetalleVenta> detalleVenta = (List<DetalleVenta>) lista;
                
                switch(jrf.getName()){
                    case "factura":
                        obj = detalleVenta.get(indice).getFactura();
                        break;
                    case "fecha":
                        obj = detalleVenta.get(indice).getFecha();
                        break;
//                    case "tipoVenta":
//                        obj = detalleVenta.get(indice).getTipoVenta();
//                        break;
//                    case "tipomoneda":
//                        obj = detalleVenta.get(indice).getTipomoneda();
//                        break;
                    case "nombreCliente":
                        obj = detalleVenta.get(indice).getNombreCliente();
                        break;
                    case "descripcion":
                        obj = detalleVenta.get(indice).getDescripcion();
                        break;
                    case "cantidad":
                        obj = detalleVenta.get(indice).getCantidad();
                        break;
                    case "precioUnitario":
                        obj = detalleVenta.get(indice).getPrecioUnitario();
                        break;
                    case "subTotal":
                        obj = detalleVenta.get(indice).getSubTotal();
                        break;
                    case "iva":
                        obj = detalleVenta.get(indice).getIva();
                        break;
                    case "total":
                        obj = detalleVenta.get(indice).getTotal();
                        break;
                    default :
                        return null;
                }
                
                break;
                
                
            default :
                return obj;
        }
        
        return obj;
    }
    
    public void toCast(){
        
    }
    
}
