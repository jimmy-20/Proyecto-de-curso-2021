

package Backend.Controllers;

import Backend.FilesVentas;
import Model.TableModel;
import Panels.Ventas.PnlDetalleVentas;
import Pojo.Cliente;
import Pojo.DetalleVenta;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class PnlDetalleVentasController {
private TableModel <DetalleVenta> modelDetalle;
private TableModel <Cliente>modelCliente;
private PnlDetalleVentas pnlDetalleVentas;
private FilesVentas filesVentas;
private final String[] headerVentas={"N° Factura", "Fecha","Tipo de Compra","Moneda", "Cliente",
        "Descripción", "Cantidad", "Precio Unitario",
        "Sub-Total", "IVA", "Total"};
private final String[] headerCliente = { "Cliente",
        "Sub-Total", "IVA", "Total"
    };
private TableRowSorter<TableModel> rowSorter;
private List <DetalleVenta> listVentas;
private List <Cliente> listClientes;
private PropertyChangeSupport propertyChangeSupport;

    public PnlDetalleVentasController(PnlDetalleVentas pnlVentas) {
        this.pnlDetalleVentas = pnlVentas;
        filesVentas=new FilesVentas();
        
        listVentas=filesVentas.findAllDetalle().stream().collect(Collectors.toList());
        listClientes=filesVentas.findAllCredito().stream().collect(Collectors.toList());
        initComponent();
    }

    private void initComponent() {
        
        loadTable();
        
        pnlDetalleVentas.getTxtFinder().addKeyListener(new KeyAdapter() {
            @Override
            public  void keyTyped(KeyEvent e){
                txtFinderKeyTyped(e);
            }
        });
        

    }
    private void loadTable(){
        modelDetalle=new TableModel(listVentas,headerVentas);
        modelCliente= new TableModel(listClientes,headerCliente);
        
        pnlDetalleVentas.getTblViewClientes().setModel(modelCliente);
        pnlDetalleVentas.getTblViewDetalleVentas().setModel(modelDetalle);
        
        rowSorter= new TableRowSorter<>(modelDetalle);
        pnlDetalleVentas.getTblViewDetalleVentas().setRowSorter(rowSorter);
        
    }
    private void txtFinderKeyTyped(KeyEvent e){
        RowFilter <TableModel, Object> rf=null;
        rf=RowFilter.regexFilter(pnlDetalleVentas.getTxtFinder().getText(),0,1,2,3,4,5);
        
        rowSorter.setRowFilter(rf);
        
    }
}
