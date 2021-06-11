/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Pojo.DetalleCompra;
import Pojo.DetalleCompraFactura;
import java.util.List;
import java.util.stream.Collectors;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author FAMILIASOZAORTIZ
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
                
            default :
                return obj;
        }
        
        return obj;
    }
    
    public void toCast(){
        
    }
    
}
