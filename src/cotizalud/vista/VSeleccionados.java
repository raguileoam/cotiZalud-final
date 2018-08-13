/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.vista;


import cotizalud.vista.util.TablaSeleccionados;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author raguileoam
 */
class VSeleccionados extends JTable {

    private DefaultTableModel dtm;

    /**
     *
     */
    public VSeleccionados() {
        super();
        dtm = loadSeleccionados();
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {

                if (value instanceof JButton) {
                    JButton btn = (JButton) value;
                    if (isSelected) {
                        btn.setForeground(table.getSelectionForeground());
                        btn.setBackground(table.getSelectionBackground());
                    } else {
                        btn.setForeground(table.getForeground());
                        btn.setBackground(UIManager.getColor("Button.background"));
                    }
                    return btn;
                }

                if (value instanceof JCheckBox) {
                    JCheckBox ch = (JCheckBox) value;

                    return ch;
                }
                if (value instanceof JSpinner) {
                    JSpinner sp = (JSpinner) value;
                    return sp;
                }

                return super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    /**
     * @return
     */
    public DefaultTableModel getDtm() {
        return dtm;
    }

    /**
     * @return
     */
    private DefaultTableModel loadSeleccionados() {
        dtm = new TablaSeleccionados();
        setModel(dtm);
        return dtm;
    }

}