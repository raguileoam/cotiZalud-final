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
 * Clase nombre del contexto problema
 */
public class Medicamento {

    private Statement consulta;
    private String region;
    private String nombre;
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
     * Consulta para la base de datos
     * @return esta consulta
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
     * Constructor vacio de la clase Medicamento
     * 
     */
    public Medicamento(){}
     /**
     * Constructor de la clase nombre
     *
     * @param region region en donde buscar el nombre
     * @param medicamento nombre a buscar
     * @param farmacia farmacia en donde buscar el nombre
     * @throws SQLException Excepcion en MySQL
     */
    public Medicamento(String region, String medicamento, String farmacia) throws SQLException {
        this.db = new DB();
        this.consulta = (Statement) db.getConn().createStatement();
        this.region = region;
        this.nombre = medicamento;
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
        if (null != nombre && !"".endsWith(nombre)) {
            consulta = consulta + " AND medicamento LIKE '%" + nombre + "%'";
        }
        if (null != farmacia && !"".endsWith(farmacia)) {
            consulta = consulta + " AND farmacía = '" + farmacia + "'";
        }
        ResultSet rs = this.consulta.executeQuery(consulta);
        return rs;
    }

    /**
     * Convierte la clase Medicamento en array de Object
     * @return este array de Object
     */
    public Object[] toArray() {
        Object[] obj = new Object[10];
        obj[0] = codigo;
        obj[1] = nombre;
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
     * @param nombre Nombre del medicamento
     * @param dosis Dosis del medicamento
     * @param presentacion Presentacion del medicamento
     * @param marca Marca del medicamento
     * @param farmacia Farmacia del medicamento
     * @param precio Precio del nombre
     * @param direccion Direccion de la farmacia del medicamento
     * @param comuna Comuna de la farmacia del medicamento
     * @param region Region de la farmacia del medicamento
     */
    public Medicamento(int codigo, String nombre, String dosis, String presentacion, String marca, String farmacia, int precio, String direccion, String comuna, String region) {
        this.codigo = codigo;
        this.nombre = nombre;
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
     * @param codigo Codigo del nombre
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *  Retorna nombre del medicamento
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Edita el codigo del medicamento
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *  Retorna dosis del medicamento
     * @return
     */
    public String getDosis() {
        return dosis;
    }

    /**
     * Edita la dosis del medicamento
     * @param dosis
     */
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    /**
     *  Retorna presentacion del medicamento
     * @return
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     * Edita la presentacion del medicamento
     * @param presentacion
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    /**
     * Retorna marca del medicamento
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Edita la marca del medicamento
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna farmacia del medicamento
     * @return
     */
    public String getFarmacia() {
        return farmacia;
    }

    /**
     * Edita la farmacia del medicamento
     * @param farmacia
     */
    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    /**
     * Retorna precio del medicamento
     * @return
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Edita el precio del medicamento
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
     * Edita la direccion del medicamento
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
     * Edita la comuna del medicamento
     * @param comuna
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     * Retorna region del medicamento
     * @return esta region del medicamento
     */
    public String getRegion() {
        return region;
    }

    /**
     * Edita la region del medicamento
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }
}
