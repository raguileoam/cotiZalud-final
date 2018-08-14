/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author raguileoam
 */
public class VBotones extends JPanel {

    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnReporte;
    private JButton btnSalir;
    private JPanel pIzq;
    private JLabel total;
    private JLabel textTotal;
    private JPanel pDer;

    /**
     *
     * @return
     */
    public JPanel getpIzq() {
        return pIzq;
    }

    /**
     *
     * @param pIzq
     */
    public void setpIzq(JPanel pIzq) {
        this.pIzq = pIzq;
    }

    /**
     *
     * @return
     */
    public JPanel getpDer() {
        return pDer;
    }

    /**
     *
     * @param pDer
     */
    public void setpDer(JPanel pDer) {
        this.pDer = pDer;
    }

    /**
     *
     */
    public VBotones() {
        super(new BorderLayout());
        initComponents();
    }

    /**
     *
     * @return
     */
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    /**
     *
     * @param btnAgregar
     */
    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    /**
     *
     * @return
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    /**
     *
     * @param btnEliminar
     */
    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    /**
     *
     * @return
     */
    public JButton getBtnReporte() {
        return btnReporte;
    }

    /**
     *
     * @param btnReporte
     */
    public void setBtnReporte(JButton btnReporte) {
        this.btnReporte = btnReporte;
    }

    /**
     *
     * @return
     */
    public JButton getBtnSalir() {
        return btnSalir;
    }

    /**
     *
     * @param btnSalir
     */
    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    /**
     *
     * @return
     */
    public JLabel getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(JLabel total) {
        this.total = total;
    }

    /**
     *Inicio de todos los botones que posee la interfaz 
     */
    public void initComponents() {
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnReporte = new JButton("Hacer Reporte");
        btnSalir = new JButton("Salir");
        pIzq = new JPanel();
        textTotal = new JLabel("Total medicamentos: $");
        total = new JLabel("0");
        pDer = new JPanel();
        pIzq.setBackground(Color.ORANGE);
        pDer.setBackground(Color.orange);
        pIzq.add(btnAgregar);
        pIzq.add(btnEliminar);
        pIzq.add(btnReporte);
        pDer.add(textTotal);
        pDer.add(total);
        pDer.add(btnSalir);
        this.add(pIzq, BorderLayout.WEST);
        this.add(pDer, BorderLayout.EAST);

    }

}
