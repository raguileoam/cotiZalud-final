/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.vista.util;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raguileoam
 */
public class TablaSeleccionados extends DefaultTableModel {

    private static final String[] row = {"Medicamento", "Dosis", "Presentación", "Marca", "Farmacia", "Precio", "Dirección", "Comuna", "Región", "Cantidad", "Precio total"};

    /**
     *
     */
    public TablaSeleccionados() {
        super();
        setColumnIdentifiers(row);
    }

    /**
     *
     * @param column
     * @return
     */
    @Override
    public Class
            getColumnClass(int column) {
        switch (column) {
            case 0:
                return Integer.class;

            case 6:
                return Integer.class;

            case 9:
                return Integer.class;

            case 10:
                return Integer.class;
            default:
                return String.class;
        }
    }
    boolean[] canEdit = new boolean[]{
        false, false, false, false, false, false, false, false, false, true, false
    };

    /**
     *
     * @param i
     * @param i1
     * @return
     */
    @Override
    public boolean isCellEditable(int i, int i1) {
        return canEdit[i1]; //To change body of generated methods, choose Tools | Templates.
    }

}
