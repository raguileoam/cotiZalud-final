/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.vista.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author raguileoam
 */
public class TotalCellRenderer extends DefaultTableCellRenderer {

    private static final int VALIDATION_COLUMN = 1;

    /**
     *
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param col
     * @return
     * Genera el valor total del coste de todos los remedios seleccionados
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        String s = table.getModel().getValueAt(row, VALIDATION_COLUMN).toString();

        if (s.equalsIgnoreCase("1")) {
            comp.setForeground(Color.red);
        } else {
            comp.setForeground(null);
        }

        return (comp);
    }
}
