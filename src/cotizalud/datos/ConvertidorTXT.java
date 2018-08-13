/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.datos;

import java.io.*;
import net.htmlparser.jericho.*;

/**
 * Clase que se encarga de transformar un HTML a un archivo de texto
 */
public class ConvertidorTXT {

    private String dirHTML;
    private InputStream inp;
    private Renderer preTexto;
    private String texto;

    /**
     * Constructor de la clase ConvertidorTXT
     *
     * @param dirHTML
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public ConvertidorTXT(String dirHTML) throws FileNotFoundException, IOException, Exception {
        this.inp = inp = new FileInputStream(dirHTML);
        this.dirHTML = dirHTML;
        this.preTexto = new Source(inp).getRenderer();
        preTexto.setMaxLineLength(0);
        preTexto.setTableCellSeparator(";");
        preTexto.setNewLine("\n");
        this.texto = "ID;" + preTexto.toString();
        System.out.println("Preprocesado de texto listo");
        toTxt();
    }

    /**
     * Escribe en un archivo texto los datos
     *
     * @throws Exception
     */
    private void toTxt() throws Exception {
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter("descargas/medicamentos.txt"));
        bw.write(this.texto);
        bw.close();
    }

}
