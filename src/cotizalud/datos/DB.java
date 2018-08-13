/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

/**
 * Clase que conecta base de Datos H2 con el proyecto cotiZalud
 */
public class DB {

    private Connection conn;
    private String url;

    /**
     * Construye la conexión entre el servidor con base de datos y el proyecto
     */
    public DB() {
        try {
            url = "jdbc:h2:./database/MED";
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retorna la conexión con H2
     *
     * @return esta conexión (Connection)
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * Cierra la conexión con el servidor
     *
     * @throws SQLException Si hay una excepción en H2
     */
    public void desconectar() throws SQLException {
        conn.close();
    }

    /**
     * Importa archivo txt a H2
     *
     * @throws java.sql.SQLException
     */
    public void impTxt() throws SQLException {
        Statement ins = conn.createStatement();
        String query1 = "DROP TABLE IF EXISTS MEDS;CREATE TABLE MEDS AS SELECT * FROM CSVREAD('descargas/medicamentos.txt',null,'fieldSeparator=;');";
        ins.executeUpdate(query1);

    }

    /**
     * Usa clase Descarga, ConvertidorTXT y DB para llevar los datos a H2
     *
     * @throws IOException
     * @throws Exception
     */
    public void loadData() throws IOException, Exception {
        Descarga d = new Descarga();
        ConvertidorTXT a = new ConvertidorTXT("descargas/medicamentos.html");
        System.out.println("Convertido existoso");
        impTxt();
        System.out.println("Importación existoso");
        desconectar();
    }


}
