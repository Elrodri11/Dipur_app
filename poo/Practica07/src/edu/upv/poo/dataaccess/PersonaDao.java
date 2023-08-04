package edu.upv.poo.dataaccess;

import edu.upv.poo.dbmodels.Persona;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Representa el Data Access Object de Empoyee (table Employees)
 * @author luisroberto
 */
public class PersonaDao {
    
    private final Connection connection;
    
    public PersonaDao(Connection connection) {
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
                "DELETE FROM PERSONAS WHERE ID = ?";
        
        // Objeto statement con el que vamos a ejecutar la sentencia.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1,id);
            
            // Ejecución de la sentencia.
            stmt.executeUpdate();
        }
    }
    
    public Persona getById(int id) throws SQLException {
        
        Persona i = null;  // El objeto que regresaremos si se encuentra.
        
        // La sentencia SQL a ejecutar para obtener el registro del empleado.
        String sql = "SELECT * FROM PERSONAS WHERE ID = ?";
        
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
        String sql = "SELECT max(id)FROM PERSONAS";
        
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
    public Persona[] getAll() throws SQLException {
        
        // Para guardar los objetos employee que vamos encontrando.
        ArrayList<Persona> l = new ArrayList<>(); 
        String sql = "SELECT * FROM PERSONAS order by id";  // Sentencia SQL a ejecutar.
        
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
        return l.toArray(new Persona[0]);
    }

    public void insert(Persona i) throws SQLException {
        
        // Sentencia SQL del insert del registro. Los '?' representan los 
        // parámetros de la consulta.
        String sql = 
                "INSERT INTO PERSONAS " +
                "     (IDENTIFICACION,CORREOELECTRONICO, NUMTARJETA," +
                "      RFC,TIPOIDENTIFICACION)" +
                "  VALUES (?,?,?,?,?)";
        
        // Obtenemos el objeto Statement de la ejecución.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Ingresamos los parámetros que corresponden a los datos a insertar.
            stmt.setString(1, i.getIdentificacion());
            stmt.setString(2, i.getCorreoElectronico());
            stmt.setString(3, i.getNumTarjeta());
            stmt.setString(4, i.getRfc());
            stmt.setString(5,i.getTipoIdentificacion());
            
            if (stmt.executeUpdate() > 0) {
                try (ResultSet r = stmt.getGeneratedKeys()) {
                    if (r.next()) i.setPersonaId(r.getInt(1));
                }
            } 
        }
    }
    /**
     * Realiza la operación de update de un registro.
     * @param i El objeto que representa el registro a actualizar.
     * @throws SQLException 
     */
    public void update(Persona i) throws SQLException {
        
        // Sentencia SQL que representa el update.
        String sql = 
                "UPDATE PERSONAS SET " +
                "      IDENTIFICACION = ?, CORREOELECTRONICO = ?, NUMTARJETA = ?, " +
                "      RFC = ?, TIPOIDENTIFICACION = ?" +
                "   WHERE id = ?";
        
        // Objeto statement con el que vamos a ejecutar la sentencia.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Enviamos los parámetros a la sentencia SQL a ejecutar.
            stmt.setString(1, i.getIdentificacion());
            stmt.setString(2, i.getCorreoElectronico());
            stmt.setString(3, i.getNumTarjeta());
            stmt.setString(4, i.getRfc());
            stmt.setString(5,i.getTipoIdentificacion());
            stmt.setInt(6,i.getPersonaId());
            
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
    private Persona toObj(ResultSet r) throws SQLException {
        Persona i = new Persona();
        i.setPersonaId(r.getInt("ID"));
        i.setIdentificacion(r.getString("IDENTIFICACION"));
        i.setCorreoElectronico(r.getString("CORREOELECTRONICO"));
        i.setNumTarjeta(r.getString("NUMTARJETA"));
        i.setRfc(r.getString("RFC"));
        i.setTipoIdentificacion(r.getString("TIPOIDENTIFICACION"));
        return i;
    }
}
