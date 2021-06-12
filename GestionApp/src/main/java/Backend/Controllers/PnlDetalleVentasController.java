

package Backend.Controllers;

import Model.TableModel;
import Panels.Ventas.PnlDetalleVentas;
import Pojo.Cliente;
import Pojo.DetalleVenta;
import java.util.List;


public class PnlDetalleVentasController {
private TableModel <DetalleVenta> modelDetalle;
private TableModel <Cliente>modelCliente;
private PnlDetalleVentas pnlDetalleVentas;
private final String[] headerVentas={"N° Factura", "Fecha", "Nombre Cliente",
        "Descripción", "Cantidad", "Precio Unitario",
        "Sub-Total", "IVA", "Total"};
private final String[] headerCliente = { "Cliente",
        "Sub-Total", "IVA", "Total"
    };
private List <DetalleVenta> listVentas;
private List <Cliente> listClientes;

    public PnlDetalleVentasController(PnlDetalleVentas pnlVentas) {
        this.pnlDetalleVentas = pnlVentas;
        initComponent();
    }

    private void initComponent() {
        

        modelDetalle=new TableModel(listVentas,headerVentas);
        modelCliente= new TableModel(listClientes,headerCliente);
        
        pnlDetalleVentas.getTblViewDetalleVentas().setModel(modelDetalle);
        pnlDetalleVentas.getTblViewClientes().setModel(modelCliente);
    }

}
