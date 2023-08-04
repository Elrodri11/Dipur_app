/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upv.poo.dataaccess;

import edu.upv.poo.dbmodels.Persona;
import edu.upv.poo.dbmodels.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuarioDao {
    private final Connection connection;
    
    public UsuarioDao(Connection connection) {
        this.connection = connection;
    }
    
    public void delete(String nombre) throws SQLException {
        
        // Sentencia SQL que representa el update.
        String sql = 
                "DELETE FROM USUARIOS WHERE NOMBRE = ?";
        
        // Objeto statement con el que vamos a ejecutar la sentencia.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1,nombre);
            
            // Ejecución de la sentencia.
            stmt.executeUpdate();
        }
    }
    
    public Usuario getByName(String nombre) throws SQLException {
        
        Usuario i = null;  // El objeto que regresaremos si se encuentra.
        
        // La sentencia SQL a ejecutar para obtener el registro del empleado.
        String sql = "SELECT * FROM USUARIOS WHERE NOMBRE = ?";
        
        // Obtenemos el objeto Statement que representa la ejecución de la
        // sentencia SQL.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Parámetros que vamos a enviar en la consulta.
            stmt.setString(1, nombre);
            
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
        String sql = "SELECT max(id)FROM USUARIOS";
        
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
    public Usuario[] getAll() throws SQLException {
        
        // Para guardar los objetos employee que vamos encontrando.
        ArrayList<Usuario> l = new ArrayList<>(); 
        String sql = "SELECT * FROM USUARIOS order by id";  // Sentencia SQL a ejecutar.
        
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
        return l.toArray(new Usuario[0]);
    }

    public void insert(Usuario i) throws SQLException {
        
        // Sentencia SQL del insert del registro. Los '?' representan los 
        // parámetros de la consulta.
        String sql = 
                "INSERT INTO USUARIOS" +
                "     (NOMBRE,CONTRASENA,SUPERUSUARIO)" +
                "  VALUES (?,?,?)";
        
        // Obtenemos el objeto Statement de la ejecución.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Ingresamos los parámetros que corresponden a los datos a insertar.
            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getContrasena());
            stmt.setInt(3, i.getSuperUsuario());
            
            if (stmt.executeUpdate() > 0) {
                try (ResultSet r = stmt.getGeneratedKeys()) {
                    if (r.next()) i.setUsuarioId(r.getInt(1));
                }
            } 
        } catch(Exception SQL){
            System.out.println(SQL);
        }
    }
    /**
     * Realiza la operación de update de un registro.
     * @param i El objeto que representa el registro a actualizar.
     * @throws SQLException 
     */
    public void update(Usuario i) throws SQLException {
        
        // Sentencia SQL que representa el update.
        String sql = 
                "UPDATE USUARIOS SET " +    
                "      NOMBRE = ?, CONTRASENA = ?, SUPERUSUARIO = ?" +
                "   WHERE nombre = ?";
        
        // Objeto statement con el que vamos a ejecutar la sentencia.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Enviamos los parámetros a la sentencia SQL a ejecutar.
            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getContrasena());
            stmt.setInt(3, i.getSuperUsuario());
            stmt.setString(4, i.getNombre());
            
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
    private Usuario toObj(ResultSet r) throws SQLException {
        Usuario i = new Usuario();
        i.setNombre(r.getString("NOMBRE"));
        i.setContrasena(r.getString("CONTRASENA"));
        i.setSuperUsuario(r.getInt("SUPERUSUARIO"));
        i.setUsuarioId(r.getInt("ID"));
        
        return i;
    }
}
