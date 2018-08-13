/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.vista;

import cotizalud.datos.DB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author raguileoam
 */
public class VBusqueda extends JPanel {

    private JComboBox<String> cbFarmacias;
    private JComboBox<String> cbRegiones;
    private JTextField tfMedicamento;
    private JLabel lMedicamento;
    private JLabel lRegion;
    private JLabel lFarmacia;
    private JPanel pCentro;
    private JButton bBuscar;
    private JPanel pSur;
    private JPanel pNorte;
    private JButton bActualizar;

    /**
     * Constructor de la clase GUI_Busqueda
     */
    public VBusqueda() {
        super(new BorderLayout());
        initPanel();
        this.pCentro = new JPanel();
        this.cbFarmacias = new JComboBox<>(new String[]{"Cruz Verde", "Ahumada", "Salcobrand"});
        this.cbRegiones = new JComboBox<>(new String[]{"Arica", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso", "Metropolitana", "O\'higgins", "Maule", "Bio-bío", "Araucanía", "Los Ríos", "Los Lagos", "Aysén", "Magallanes"});
        this.tfMedicamento = new JTextField(20);
        this.lMedicamento = new JLabel("Medicamento");
        this.lFarmacia = new JLabel("Farmacia");
        this.lRegion = new JLabel("Región");
        this.bBuscar = new JButton("Buscar");
        this.pSur = new JPanel();

        this.bActualizar = new JButton("Actualizar Base de Datos");
        this.pNorte = new JPanel(new BorderLayout());
        addComponents();

    }

    void initPanel() {

    }

    /**
     *
     * @return
     */
    public JButton getBuscar() {
        return bBuscar;
    }

    /**
     *
     * @param buscar
     */
    public void setBuscar(JButton buscar) {
        this.bBuscar = buscar;
    }

    /**
     *
     * @return
     */
    public JButton getActualizar() {
        return bActualizar;
    }

    /**
     *
     * @param actualizar
     */
    public void setActualizar(JButton actualizar) {
        this.bActualizar = actualizar;
    }

    /* añadir componentes a los jpanel del norte del centro y del sur
     */
    void addComponents() {
        pCentro.setBackground(Color.orange);
        pSur.setBackground(Color.orange);
        pNorte.setBackground(Color.orange);
        pCentro.add(lFarmacia);
        pCentro.add(cbFarmacias);
        pCentro.add(lMedicamento);
        pCentro.add(tfMedicamento);
        pCentro.add(lRegion);
        pCentro.add(cbRegiones);
        this.add(pCentro, BorderLayout.CENTER);

        pSur.add(bBuscar);
        this.add(pSur, BorderLayout.SOUTH);

        pNorte.add(bActualizar, BorderLayout.EAST);

        this.add(pNorte, BorderLayout.NORTH);
    }

    /**
     *
     * @return
     */
    public JComboBox<String> getcFarmacias() {
        return cbFarmacias;
    }

    /**
     *
     * @param cFarmacias
     */
    public void setcFarmacias(JComboBox<String> cFarmacias) {
        this.cbFarmacias = cFarmacias;
    }

    /**
     *
     * @return
     */
    public JComboBox<String> getcRegiones() {
        return cbRegiones;
    }

    /**
     *
     * @param cRegiones
     */
    public void setcRegiones(JComboBox<String> cRegiones) {
        this.cbRegiones = cRegiones;
    }

    /**
     *
     * @return
     */
    public JTextField getTfMedicamento() {
        return tfMedicamento;
    }

    /**
     *
     * @param tfMedicamento
     */
    public void setTfMedicamento(JTextField tfMedicamento) {
        this.tfMedicamento = tfMedicamento;
    }

    /**
     * Metodo para actualizar la base de datos con respecto a la del Sernac
     */
    public void actualizar() {
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "¿Desea actualizar la base de datos? Este proceso demora unos minutos.", "Cotizalud consulta:", JOptionPane.YES_NO_OPTION) == 0) {
            try {
                DB db = new DB();
                db.loadData();

            } catch (Exception ex) {
                Logger.getLogger(VBusqueda.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "La base de datos ha sido actualizada.", "CotiZalud Informa:", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Error en la actualización.", "CotiZalud Informa:", JOptionPane.ERROR_MESSAGE);
        }
    }

}
