/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.datos;

import com.lowagie.text.Anchor;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Exporta texto de la tabla de medicamentos seleccionados a pdf
 * @author raguileoam, originally from
 * http://codigoxules.org/java-itext-pdf-creando-pdf-java-itext/
 */
public class Reporte {

    private static final Font categoryFont = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subCategoryFont = new Font(Font.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font small = new Font(Font.TIMES_ROMAN, 7, Font.BOLD);
    private static final String dia = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

    /**
     *
     * @param jTable
     * @param pdfNewFile
     * @param title
     * Genera un pdf con los datos agregados a la interfaz de objetos seleccionados 
     */
    public static void utilJTableToPdf(JTable jTable, File pdfNewFile, String title) {
      
        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF (No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();
            document.addTitle("Medicamentos " + dia);
            document.addAuthor("cotiZalud");
            Anchor anchor = new Anchor("Medicamentos " + dia, categoryFont);

            Paragraph subPara = new Paragraph("Cotizalud ", subCategoryFont);
            Paragraph v = new Paragraph(" ", subCategoryFont);

            PdfPTable table = new PdfPTable(jTable.getColumnCount());
            table.calculateHeightsFast();
            PdfPCell columnHeader;
        
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                columnHeader = new PdfPCell(new Paragraph(jTable.getColumnName(column), small));
                table.addCell(columnHeader);
            }

            table.setHeaderRows(1);

            for (int row = 0; row < jTable.getRowCount(); row++) {
                for (int column = 0; column < jTable.getColumnCount(); column++) {
                    table.addCell(new Paragraph(jTable.getValueAt(row, column).toString(), small));
                }
            }

            document.add(anchor);
            document.add(subPara);
            document.add(v);
            document.add(table);

            document.close();
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);

        }

    }
    
}
