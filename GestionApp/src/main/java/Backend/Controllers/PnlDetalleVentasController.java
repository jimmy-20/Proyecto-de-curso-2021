

package Backend.Controllers;

import Model.TableModel;
import Panels.Ventas.PnlDetalleVentas;
import Pojo.Cliente;
import Pojo.DetalleVenta;
import java.util.List;


public class PnlDetalleVentasController {
private TableModel <DetalleVenta> modelDetalle;
private TableModel <Cliente>modelCliente;
private PnlDetalleVentas pnlVentas;
private final String[] headerVentas={"N° Factura", "Fecha", "Nombre Cliente",
        "Descripción", "Cantidad", "Precio Unitario",
        "Sub-Total", "IVA", "Total"};
private final String[] headerCliente = { "Cliente",
        "Sub-Total", "IVA", "Total"
    };
private List <DetalleVenta> listVentas;
private List <Cliente> listClientes;

    public PnlDetalleVentasController(PnlDetalleVentas pnlVentas) {
        this.pnlVentas = pnlVentas;
        initComponent();
    }

    private void initComponent() {
//        String factura="1";
//       String fecha="06/06/2021";
//        String nombreCliente= "Pedro";
//        String descripcion= "Aceite litro";
//        int cantidad= 1;
//        float precioUnitario=2.5f;
//        float subTotal=6.4f;
//        float iva=0.08f;
//        float total= subTotal*iva;
//        
//        DetalleVenta detalleVenta= new DetalleVenta(factura, fecha, nombreCliente, 
//                descripcion, cantidad, precioUnitario, subTotal, iva, total);
//        listVentas.add(detalleVenta);

        modelDetalle=new TableModel(listVentas,headerVentas);
        modelCliente= new TableModel(listClientes,headerCliente);
        
        pnlVentas.getTblViewDetalleVentas().setModel(modelDetalle);
        pnlVentas.getTblViewClientes().setModel(modelCliente);
    }

}
