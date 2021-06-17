/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controllers;

import Backend.FilesCompras;
import Model.TableModel;
import Panels.Inventario.PnlInventario;
import Pojo.Inventario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jeison Suarez
 */
public class PnlInvetarioController {

    private List<Inventario> listInventario;

    private FilesCompras fCompras;
    private TableModel<Inventario> modelDetalle;

    private PnlInventario pnlInventario;
    private String[] headerInventario = {"Fecha", "N° Factura",
        "Descripción", "Cantidad", "Costo Unitario",
        "Total"

    };
    private TableRowSorter<TableModel> tblRowSorter;
    private Inventario inventario;

    public PnlInvetarioController(PnlInventario pnlInventario) {
        this.pnlInventario = pnlInventario;

        fCompras = new FilesCompras();

        listInventario = fCompras.getBodega().stream().collect(Collectors.toList());

        initComponent();
    }

    private void initComponent() {
        loadTable();
        pnlInventario.getTxtFinder().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                txtFinderKeyTyped(e);
            }

        });

    }

    private void txtFinderKeyTyped(KeyEvent e) {
        RowFilter<TableModel, Object> rf = null;
        rf = RowFilter.regexFilter(pnlInventario.getTxtFinder().getText(), 0, 1, 2, 3, 4, 5);
        tblRowSorter.setRowFilter(rf);
    }

    private void loadTable() {
        modelDetalle = new TableModel(listInventario, headerInventario);

        pnlInventario.getTblInventario().setModel(modelDetalle);
        tblRowSorter = new TableRowSorter<>(modelDetalle);
        pnlInventario.getTblInventario().setRowSorter(tblRowSorter);

    }

}
