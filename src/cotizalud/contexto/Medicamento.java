/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.contexto;

import cotizalud.datos.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase medicamento del contexto problema
 */
public class Medicamento {

    private Statement consulta;
    private String region;
    private String medicamento;
    private String farmacia;
    private int codigo;
    private String dosis;
    private String presentacion;
    private String marca;
    private int precio;
    private String direccion;
    private String comuna;

    /**
     *
     */
    public DB db;

    /**
     *
     * @return
     */
    public Statement getConsulta() {
        return consulta;
    }

    /**
     *
     * @param consulta
     */
    public void setConsulta(Statement consulta) {
        this.consulta = consulta;
    }

    /**
     *
     * @return
     */
    public DB getDb() {
        return db;
    }

    /**
     *
     * @param db
     */
    public void setDb(DB db) {
        this.db = db;
    }

    /**
     * Constructor de la clase Buscador
     *
     * @param region region en donde buscar el medicamento
     * @param medicamento medicamento a buscar
     * @param farmacia farmacia en donde buscar el medicamento
     * @throws SQLException Excepcion en MySQL
     */
    public Medicamento(){}
    public Medicamento(String region, String medicamento, String farmacia) throws SQLException {
        this.db = new DB();
        this.consulta = (Statement) db.getConn().createStatement();
        this.region = region;
        this.medicamento = medicamento;
        this.farmacia = farmacia;
    }

    /**
     * Retorna consulta a base de datos en formato ResultSet
     *
     * @param tabla nombre de la tabla en formato database.tabla
     * @return consulta como ResultSet
     * @throws SQLException Excepcion en MySQL
     * Metodo para verificar en la base de datos si se encuentran datos que concuerden con la busqueda realizada
     */
    public ResultSet resp(String tabla) throws SQLException {
        String consulta = String.format("SELECT * FROM %s WHERE 1=1 ", tabla);
        if (null != region && !"".endsWith(region)) {
            consulta = consulta + " AND región like '%" + region.replace("\'", "''") + "%'";
        }
        if (null != medicamento && !"".endsWith(medicamento)) {
            consulta = consulta + " AND medicamento LIKE '%" + medicamento + "%'";
        }
        if (null != farmacia && !"".endsWith(farmacia)) {
            consulta = consulta + " AND farmacía = '" + farmacia + "'";
        }
        ResultSet rs = this.consulta.executeQuery(consulta);
        return rs;
    }

    /**
     *
     * @return
     */
    public Object[] toArray() {
        Object[] obj = new Object[10];
        obj[0] = codigo;
        obj[1] = medicamento;
        obj[2] = dosis;
        obj[3] = presentacion;
        obj[4] = marca;
        obj[5] = farmacia;
        obj[6] = precio;
        obj[7] = direccion;
        obj[8] = comuna;
        obj[9] = region;
        return obj;
    }

    /**
     * Constructor con parametros de Medicamento
     *
     * @param codigo Codigo del medicamento
     * @param medicamento Medicamento del medicamento
     * @param dosis Dosis del medicamento
     * @param presentacion Presentacion del medicamento
     * @param marca Marca del medicamento
     * @param farmacia Farmacia del medicamento
     * @param precio Precio del medicamento
     * @param direccion Direccion de la farmacia del medicamento
     * @param comuna Comuna de la farmacia del medicamento
     * @param region Region de la farmacia del medicamento
     */
    public Medicamento(int codigo, String medicamento, String dosis, String presentacion, String marca, String farmacia, int precio, String direccion, String comuna, String region) {
        this.codigo = codigo;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.presentacion = presentacion;
        this.marca = marca;
        this.farmacia = farmacia;
        this.precio = precio;
        this.direccion = direccion;
        this.comuna = comuna;
        this.region = region;
    }

    /**
     * Retorna codigo del medicamento
     *
     * @return este codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Edita el codigo del medicamento
     *
     * @param codigo Codigo del medicamento
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public String getMedicamento() {
        return medicamento;
    }

    /**
     *
     * @param medicamento
     */
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    /**
     *
     * @return
     */
    public String getDosis() {
        return dosis;
    }

    /**
     *
     * @param dosis
     */
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    /**
     *
     * @return
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     *
     * @param presentacion
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public String getFarmacia() {
        return farmacia;
    }

    /**
     *
     * @param farmacia
     */
    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    /**
     *
     * @return
     */
    public int getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public String getComuna() {
        return comuna;
    }

    /**
     *
     * @param comuna
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     *
     * @return
     */
    public String getRegion() {
        return region;
    }

    /**
     *
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }
}
//traer clase buscador aca y setear los valores encontrados por el metodo respuesta a los atributos,luego con el get de cada atributo agregar estos datos a cada fila y con esto setear el defaulttablemodel
