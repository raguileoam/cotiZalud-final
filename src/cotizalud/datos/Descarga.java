/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.datos;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

/**
 * Descarga archivo excel
 */
public final class Descarga {

    private final URL url;
    private final String file;
    private final File dir;

    /**
     * Constructor de la clase Descarga
     *
     * @throws java.net.MalformedURLException
     */
    public Descarga() throws MalformedURLException  {
        this.url = new URL("https://www.sernac.cl/wp-content/themes/gobCL-sitios-1.0/sip/apiSIP.php?mercado=medicamentos&tipo=10");
        this.file = "descargas/medicamentos.html";
        this.dir = new File(file);
        descargar();
    }

    /**
     * Descarga archivo de la página del SIP
     * @return booleano para ver si la ejecución fue correcta
     */
    public boolean descargar() {
       try{
        FileUtils.copyURLToFile(url, dir);
        
    }catch(IOException e){
        return false;
    }
       return true;
    }

}
