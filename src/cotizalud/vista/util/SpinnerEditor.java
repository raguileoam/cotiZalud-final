/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.vista.util;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author (extraido de
 * https://stackoverflow.com/questions/1882400/is-there-a-convenient-way-to-use-a-spinner-as-an-editor-in-a-swing-jtable)
 */
public class SpinnerEditor extends DefaultCellEditor {

    private JSpinner spinner;

    /**
     *Constructor de la clase SpinnerEditor
     */
    public SpinnerEditor() {
        super(new JTextField());
        spinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spinner.setBorder(null);
    }

    /**
     *
     * @param table
     * @param value
     * @param isSelected
     * @param row
     * @param column
     * @return
     */
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        spinner.setValue(value);
        return spinner;
    }

    /**
     *
     * @return
     */
    public Object getCellEditorValue() {
        return spinner.getValue();
    }

}
