/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upv.poo.dataaccess;

import edu.upv.poo.dbmodels.Auto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutoDao {
    private final Connection connection;
    
    public AutoDao(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * Obtiene un Employee por su identificador.
     * @param id
     * @return El Employee según el id, null si no se encontró.
     * @throws SQLException 
     */
    
    public void delete(int id) throws SQLException {
        
        // Sentencia SQL que representa el update.
        String sql = 
                "DELETE FROM AUTOS WHERE ID = ?";
        
        // Objeto statement con el que vamos a ejecutar la sentencia.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1,id);
            
            // Ejecución de la sentencia.
            stmt.executeUpdate();
        }
    }
    
    public Auto getById(int id) throws SQLException {
        
        Auto i = null;  // El objeto que regresaremos si se encuentra.
        
        // La sentencia SQL a ejecutar para obtener el registro del empleado.
        String sql = "SELECT * FROM AUTOS WHERE ID = ?";
        
        // Obtenemos el objeto Statement que representa la ejecución de la
        // sentencia SQL.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Parámetros que vamos a enviar en la consulta.
            stmt.setInt(1, id);
            
            // Ejecutamos la sentencia SQL y obtenemos el objeto ResultSet que
            // contiene los registros encontrados.
            try (ResultSet r = stmt.executeQuery()) {
                
                // Si el ResultSet tiene resultados, obtenemos el objeto
                // Employee.
                if (r.next()) i = toObj(r);
            }
        }
        
        return i;
    }
    
        public int getLastId() throws SQLException {
        
        int i = 0;
        
        // La sentencia SQL a ejecutar para obtener el registro del empleado.
        String sql = "SELECT max(id)FROM AUTOS";
        
        // Obtenemos el objeto Statement que representa la ejecución de la
        // sentencia SQL.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet r = stmt.executeQuery()) {
                
                // Si el ResultSet tiene resultados, obtenemos el objeto
                // Employee.
                if (r.next()) i = r.getInt(1);
            }
        }
        
        return i;
    }
    
    /**
     * Obtiene todos los registros de Employees.
     * @return Array de Employees.
     * @throws SQLException 
     */
    public Auto[] getAll() throws SQLException {
        
        // Para guardar los objetos employee que vamos encontrando.
        ArrayList<Auto> l = new ArrayList<>(); 
        String sql = "SELECT * FROM AUTOS order by id";  // Sentencia SQL a ejecutar.
        
        // try with resources para cerrar/liberar automáticamente los recursos.
        try (
                // Obtenemos el objeto Statement que corresponde a la ejecución
                // de la sentencia SQL.
                PreparedStatement stmt = connection.prepareStatement(sql);
                
                // Obtenemos el objeto ResultSet que contiene los resultados
                // de la consulta.
                ResultSet r = stmt.executeQuery()) {
            
            while (r.next()) {  // Mientras el ResultSet tenga resultados.
                
                // Del resultset obtenemos el objeto Employee y lo agregamos
                // al ArrayList para después regresalo.
                l.add(toObj(r));  
            }
        }
        
        // Regresamos un array de los elementos del ArrayList que contiene los
        // objetos/registros obtenidos de la consulta.
        return l.toArray(new Auto[0]);
    }

    public void insert(Auto i) throws SQLException {
        
        // Sentencia SQL del insert del registro. Los '?' representan los 
        // parámetros de la consulta.
        String sql = 
                "INSERT INTO AUTOS " +
                "     (MATRICULA,MARCA,MODELO,OBSERVACIONES,COLOR,RENTAPORDIA)" +
                "  VALUES (?,?,?,?,?,?)";
        
        // Obtenemos el objeto Statement de la ejecución.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Ingresamos los parámetros que corresponden a los datos a insertar.
            stmt.setString(1, i.getMatricula());
            stmt.setString(2, i.getMarca());
            stmt.setString(3, i.getModelo());
            stmt.setString(4, i.getObservaciones());
            stmt.setString(5,i.getColor());
            stmt.setDouble(6    ,i.getRentaPorDia()); 
            
            if (stmt.executeUpdate() > 0) {
                try (ResultSet r = stmt.getGeneratedKeys()) {
                    if (r.next()) i.setAutoId(r.getInt(1));
                }
            } 
        }
    }
    /**
     * Realiza la operación de update de un registro.
     * @param i El objeto que representa el registro a actualizar.
     * @throws SQLException 
     */
    public void update(Auto i) throws SQLException {
        
        // Sentencia SQL que representa el update.
        String sql = 
                "UPDATE AUTOS SET " +
                "      MATRICULA = ?, MARCA  = ?, MODELO = ?, " +
                "      OBSERVACIONES = ?, COLOR = ?, RENTAPORDIA = ?" +
                "   WHERE id = ?";
        
        // Objeto statement con el que vamos a ejecutar la sentencia.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Enviamos los parámetros a la sentencia SQL a ejecutar.
            stmt.setString(1, i.getMatricula());
            stmt.setString(2, i.getMarca());
            stmt.setString(3, i.getModelo());
            stmt.setString(4, i.getObservaciones());
            stmt.setString(5,i.getColor());
            stmt.setDouble(6    ,i.getRentaPorDia()); 
            stmt.setInt(7,i.getAutoId());
            
            // Ejecución de la sentencia.
            stmt.executeUpdate();
        }        
    }
    
    /**
     * Del registro actual que contiene el ResultSet, obtenemos el objeto
     * Empoyee que representa este regsitro.
     * @param r El ResultSet del cual el registo actual queremos obtener el
     * objeto Employee.
     * @return El objeto Employee que representa el regsitro.
     * @throws SQLException 
     */
    private Auto toObj(ResultSet r) throws SQLException {
        Auto i = new Auto();
        i.setAutoId(r.getInt("ID"));
        i.setMatricula(r.getString("MATRICULA"));
        i.setMarca(r.getString("MARCA"));
        i.setModelo(r.getString("MODELO"));
        i.setObservaciones(r.getString("OBSERVACIONES"));
        i.setColor(r.getString("COLOR"));
        i.setRentaPorDia(r.getDouble("RENTAPORDIA"));
        return i;
    }
}
