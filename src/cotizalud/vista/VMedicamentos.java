/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.vista;

import cotizalud.contexto.Medicamento;
import cotizalud.vista.util.TablaMedicamentos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author raguileoam
 */
public class VMedicamentos extends JTable {

    /**
     *Constructor de la clase GUI_Medicamentos
     */
    public VMedicamentos() {
        super();
        this.setAutoCreateRowSorter(true);
        this.getTableHeader().setReorderingAllowed(false);
        this.setModel(new TablaMedicamentos());
    }

    /**
     *
     * @param region
     * @param medicamento
     * @param farmacia
     * @return
     * Carga los medicamentos, que fueron encontrados en la base de datos , en un arraylist de medicamentos
     */
    public ArrayList<Medicamento> generarMedicamentos(String region, String medicamento, String farmacia) {
        try {
            ArrayList<Medicamento> listaMedicamentos= new ArrayList<>();
            Medicamento med = new Medicamento(region, medicamento, farmacia);
            ResultSet rs = med.resp("MEDS");
            if(rs.next()==false){
                JOptionPane.showMessageDialog(null,"no se ha encontrado ningun remedio");
            }
            while (rs.next()) {
                Medicamento medic=new Medicamento();
                medic.setCodigo(rs.getInt("id"));
                medic.setMedicamento(rs.getString("medicamento"));
                medic.setDosis(rs.getString("dosis"));
                medic.setPresentacion(rs.getString("presentación"));
                medic.setMarca(rs.getString("marca"));
                medic.setFarmacia(rs.getString("farmacía"));
                medic.setPrecio(rs.getInt("precio"));
                medic.setDireccion(rs.getString("dirección"));
                medic.setComuna(rs.getString("comuna"));
                medic.setRegion(rs.getString("región"));
                listaMedicamentos.add(medic);
            }
            med.getDb().desconectar();
            return listaMedicamentos;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    /*
    * Genera un modelo te tabla a partir de un arraylist de medicamentos
    */
    public DefaultTableModel cargarMedicamentos(ArrayList<Medicamento> medicamentos){
        DefaultTableModel dtm = new TablaMedicamentos();
        for (int i=0; i<medicamentos.size();i++){
        Object[] obj = new Object[10];
        obj[0] = medicamentos.get(i).getCodigo();
        obj[1] = medicamentos.get(i).getMedicamento();
        obj[2] = medicamentos.get(i).getDosis();
        obj[3] = medicamentos.get(i).getPresentacion();
        obj[4] = medicamentos.get(i).getMarca();
        obj[5] = medicamentos.get(i).getFarmacia();
        obj[6] = medicamentos.get(i).getPrecio();
        obj[7] = medicamentos.get(i).getDireccion();
        obj[8] = medicamentos.get(i).getComuna();
        obj[9] = medicamentos.get(i).getRegion();    
        dtm.addRow(obj);
        }
        return dtm;
    }
}
