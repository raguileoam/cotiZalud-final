/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.vista;


import cotizalud.contexto.Medicamento;
import cotizalud.datos.Reporte;
import cotizalud.vista.util.SpinnerEditor;
import cotizalud.vista.util.TotalCellRenderer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author raguileoam
 */

public final class VApp extends JFrame implements ActionListener, KeyListener, TableModelListener {
    
    private VMedicamentos gMeds;
    private VSeleccionados gSelects;
    private VBusqueda gBusqueda;
    private JScrollPane spMeds;
    private JScrollPane spSelects;
    private VBotones gBotones;
    private JTabbedPane tablas;

    /**
     *
     */
    /*constructor de la calse VApp
    */
    public VApp() {
        super();
        initWindow();
        initComponents();
        addEvents();
    }

    /**
     *Inicio de todos los componentes de la clase VApp
     */
    public void initComponents() {
        this.setLocationRelativeTo(null);
        gMeds = new VMedicamentos();
        gSelects = new VSeleccionados();
        gBusqueda = new VBusqueda();
        this.add(gBusqueda, BorderLayout.NORTH);
        spMeds = new JScrollPane();
        spMeds.setViewportView(gMeds);
        spSelects = new JScrollPane();
        spSelects.setViewportView(gSelects);
        tablas = new JTabbedPane();
        tablas.addTab("Medicamentos", spMeds);
        tablas.addTab("Seleccionados", spSelects);
        this.add(tablas);
        gBotones = new VBotones();
        this.add(gBotones, BorderLayout.SOUTH);

    }

    /**
     *añadir eventos a todos los componentes de la clase VApp
     */
    public void addEvents() {
        gBusqueda.getBuscar().addActionListener(this);
        gBusqueda.getActualizar().addActionListener(this);
        gBusqueda.getTfMedicamento().addKeyListener(this);
        gBotones.getBtnAgregar().addActionListener(this);
        gBotones.getBtnEliminar().addActionListener(this);
        gBotones.getBtnReporte().addActionListener(this);
        gBotones.getBtnSalir().addActionListener(this);
        gSelects.getDtm().addTableModelListener(this);
    }

    /**
     *Dar propiedades basicas a la interfaz grafica de VApp
     */
    public void initWindow() {
        this.setTitle("Cotizalud");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.orange);
        setSize(800, 600);
        //setUndecorated(true);
        setLayout(new BorderLayout());
      
    }

    /**
     * Añadir funciones a los botones que posee la gui de VApp
     * @param ae ActionEvent de esta clase
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == gBusqueda.getBuscar()) {
            System.out.print("Buscando...");
            System.out.println(gBusqueda.getTfMedicamento().getText());
            ArrayList<Medicamento> medicamento = gMeds.generarMedicamentos((String) gBusqueda.getcRegiones().getSelectedItem(), gBusqueda.getTfMedicamento().getText(), (String) gBusqueda.getcFarmacias().getSelectedItem());
            DefaultTableModel dtm=gMeds.cargarMedicamentos(medicamento);
            if( dtm==null){
                JOptionPane.showMessageDialog(null, "no existen archivos, actualize la base de datos");
            }else{
            gMeds.setModel(dtm);
        }}
        if (ae.getSource() == gBusqueda.getActualizar()) {
           
            gBusqueda.actualizar();

        }
        if (ae.getSource() == gBotones.getBtnAgregar()) {
            int num = gMeds.getSelectedRow();
            if (num == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento de Medicamentos", "Atención", JOptionPane.WARNING_MESSAGE);
            } else {

                Object[] obj = new Object[11];
                for (int i = 0; i < 9; i++) {
                    obj[i] = (gMeds.getValueAt(num, i + 1)); //Para futuro, si se accede al valor del modelo y se ordena, la tabla no manda data actualizados
                }
                obj[9] = 1;
                obj[10] = (Integer) obj[5] * (Integer) obj[9]; //Hacer que se actualize respecto al de arriba
                gSelects.getDtm().addRow(obj);
                gSelects.setModel(gSelects.getDtm());
                gSelects.getColumn("Cantidad").setCellEditor(new SpinnerEditor()); //Intentar mover fuera de este método
                gSelects.getColumn("Precio total").setCellRenderer(new TotalCellRenderer());
            }

        }
        if (ae.getSource() == gBotones.getBtnEliminar()) {
            int num = gSelects.getSelectedRow();
            if (num == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un elemento de Seleccionados", "Atención", JOptionPane.WARNING_MESSAGE);
            } else {
                gSelects.getDtm().removeRow(num);
                gSelects.setModel(gSelects.getDtm());
            }
        }
        if (ae.getSource() == gBotones.getBtnReporte()) {
            Reporte.utilJTableToPdf(gSelects, new File("ReporteCotiZalud.pdf"), "cotiZalid");
            JOptionPane.showMessageDialog(null, "El reporte ha sido creado.", "CotiZalud Informa:", JOptionPane.INFORMATION_MESSAGE);

        }
        if (ae.getSource() == gBotones.getBtnSalir()) {
            dispose();
        }
    }

    /**
     *
     * @param evt
     * Denegar el uso de numeros y de signos como tambien que automaticamente se escriba siempre
     * en mayuscula
     */
    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == gBusqueda.getTfMedicamento()) {
            char c = evt.getKeyChar();
            if (Character.isLowerCase(c)) {
                String cad = ("" + c).toUpperCase();
                c = cad.charAt(0);
                evt.setKeyChar(c);
            }
            Pattern patron = Pattern.compile("[^A-Z]"); //si el patron es diferente a A-Z
            Matcher encaja = patron.matcher(String.valueOf(c));
            if (encaja.find()) {
                evt.setKeyChar((char) 0); //https://stackoverflow.com/questions/18410234/how-does-one-represent-the-empty-char
            }
        }
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyPressed(KeyEvent ke) {
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyReleased(KeyEvent ke) {
    }

    /**
     *
     * @param e
     * Si se añade un producto se actualiza el valor del precio total y si se elimina se resta
     */
    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getSource() == gSelects.getDtm()) {
            if (e.getColumn() == gSelects.getDtm().findColumn("Cantidad")) {
                int cantidad = (Integer) gSelects.getValueAt(e.getFirstRow(), gSelects.getDtm().findColumn("Cantidad"));
                int precio = (Integer) gSelects.getValueAt(e.getFirstRow(), gSelects.getDtm().findColumn("Precio"));
                int total = cantidad * precio;
                //System.out.println(total);
                gSelects.setValueAt(total, e.getFirstRow(), gSelects.getDtm().findColumn("Precio total"));

            }
            int num = 0;
            for (int i = 0; i < gSelects.getRowCount(); i++) {
                num = num + (Integer) gSelects.getValueAt(i, gSelects.getDtm().findColumn("Precio total"));
            }
            gBotones.getTotal().setText(Integer.toString(num));
            // System.out.println(gBotones.getTotal().getText());
        }
    }

}
