/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import cotizalud.contexto.Medicamento;
import cotizalud.datos.Descarga;
import cotizalud.vista.VBusqueda;
import cotizalud.vista.VMedicamentos;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diegosaurio
 */
public class CotizaludTest {
    
    public CotizaludTest() {
    }
    @Test
    public void test1() throws SQLException{
    VMedicamentos gmed= new VMedicamentos();
        String region="Arica";
        String medicamento="ACNOTIN";
        String farmacia="Cruz Verde";
        Medicamento med = new Medicamento(region, medicamento, farmacia);
        med.setCodigo(3517);
        med.setNombre(medicamento);
        med.setDosis("10 mg");
        med.setPresentacion("30 CÁPSULAS BLANDAS");
        med.setMarca("LABORATORIO BAGÓ DE CHILE S.A.");
        med.setFarmacia(farmacia);
        med.setPrecio(29390);
        med.setDireccion("21 de Mayo 299");
        med.setComuna(region);
        med.setRegion(region);
        ArrayList<Medicamento> med1= new ArrayList<Medicamento>();
        med1.add(med);
        ArrayList<Medicamento> med2=gmed.generarMedicamentos(region, medicamento, farmacia);
        assertEquals(med1.get(0).getCodigo(),med2.get(0).getCodigo());
        assertEquals(med1.get(0).getNombre(),med2.get(0).getNombre());
        assertEquals(med1.get(0).getDosis(),med2.get(0).getDosis());
        assertEquals(med1.get(0).getPresentacion(),med2.get(0).getPresentacion());
        assertEquals(med1.get(0).getMarca(),med2.get(0).getMarca());
        assertEquals(med1.get(0).getFarmacia(),med2.get(0).getFarmacia());
        assertEquals(med1.get(0).getPrecio(),med2.get(0).getPrecio());
        assertEquals(med1.get(0).getDireccion(),med2.get(0).getDireccion());
        assertEquals(med1.get(0).getComuna(),med2.get(0).getComuna());
        assertEquals(med1.get(0).getRegion(),med2.get(0).getRegion());    
    }
    @Test
    public void test5() throws SQLException{
    VMedicamentos gmed= new VMedicamentos();
        String region="Arica";
        String medicamento="PARACETAMOL";
        String farmacia="Cruz Verde";
        Medicamento med = new Medicamento(region, medicamento, farmacia);
        med.setCodigo(3305);
        med.setNombre(medicamento);
        med.setDosis("500 mg");
        med.setPresentacion("16 COMPRIMIDOS");
        med.setMarca("LABORATORIOS ANDRÓMACO S.A.");
        med.setFarmacia(farmacia);
        med.setPrecio(930);
        med.setDireccion("21 de Mayo 299");
        med.setComuna(region);
        med.setRegion(region);
        ArrayList<Medicamento> med1= new ArrayList<Medicamento>();
        med1.add(med);
        ArrayList<Medicamento> med2=gmed.generarMedicamentos(region, medicamento, farmacia);
        assertEquals(med1.get(0).getCodigo(),med2.get(0).getCodigo());
        assertEquals(med1.get(0).getNombre(),med2.get(0).getNombre());
        assertEquals(med1.get(0).getDosis(),med2.get(0).getDosis());
        assertEquals(med1.get(0).getPresentacion(),med2.get(0).getPresentacion());
        assertEquals(med1.get(0).getMarca(),med2.get(0).getMarca());
        assertEquals(med1.get(0).getFarmacia(),med2.get(0).getFarmacia());
        assertEquals(med1.get(0).getPrecio(),med2.get(0).getPrecio());
        assertEquals(med1.get(0).getDireccion(),med2.get(0).getDireccion());
        assertEquals(med1.get(0).getComuna(),med2.get(0).getComuna());
        assertEquals(med1.get(0).getRegion(),med2.get(0).getRegion());
    }
   @Test
    public void test2() throws SQLException{
       String region="Arica";
        String medicamento="ACNOTIN";
        String farmacia="Cruz Verde";
        Medicamento med = new Medicamento(region, medicamento, farmacia);
            ResultSet rs = med.resp("MEDS");
            assertEquals(true, rs.next());
    }
    @Test
   public void test3() throws SQLException{
       VMedicamentos gMeds= new VMedicamentos();
       VBusqueda gBusqueda= new VBusqueda();
        ArrayList<Medicamento> tm = gMeds.generarMedicamentos((String) gBusqueda.getcRegiones().getSelectedItem(), gBusqueda.getTfMedicamento().getText(), (String) gBusqueda.getcFarmacias().getSelectedItem());
       assertEquals(null, tm);
   } 
   @Test
   public void test4() throws SQLException, IOException{
       Descarga des= new Descarga();
       boolean respuesta= des.descargar();
       assertEquals(true, respuesta);
   }
   } 

