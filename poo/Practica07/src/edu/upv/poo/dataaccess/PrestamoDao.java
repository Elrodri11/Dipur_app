/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upv.poo.dataaccess;

import edu.upv.poo.dbmodels.Prestamo;
import edu.upv.poo.dbmodels.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class PrestamoDao {
    private final Connection connection;
    
    public PrestamoDao(Connection connection) {
        this.connection = connection;
    }
    
    public void delete(int idAuto) throws SQLException {
        
        // Sentencia SQL que representa el update.
        String sql = 
                "DELETE FROM PRESTAMOS WHERE IDAUTO = ?";
        
        // Objeto statement con el que vamos a ejecutar la sentencia.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1,idAuto);
            
            // Ejecución de la sentencia.
            stmt.executeUpdate();
        }
    }
    
    public Prestamo getById(int idAuto) throws SQLException {
        
        Prestamo i = null;  // El objeto que regresaremos si se encuentra.
        
        // La sentencia SQL a ejecutar para obtener el registro del empleado.
        String sql = "SELECT * FROM PRESTAMOS WHERE IDAUTO = ?";
        
        // Obtenemos el objeto Statement que representa la ejecución de la
        // sentencia SQL.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Parámetros que vamos a enviar en la consulta.
            stmt.setInt(1, idAuto);
            
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
    
    /**
     * Obtiene todos los registros de Employees.
     * @return Array de Employees.
     * @throws SQLException 
     */
    public Prestamo[] getAll() throws SQLException {
        
        // Para guardar los objetos employee que vamos encontrando.
        ArrayList<Prestamo> l = new ArrayList<>(); 
        String sql = "SELECT * FROM PRESTAMOS order by idAuto";  // Sentencia SQL a ejecutar.
        
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
        return l.toArray(new Prestamo[0]);
    }
    
    public void insert(Prestamo i) throws SQLException {
        
        // Sentencia SQL del insert del registro. Los '?' representan los 
        // parámetros de la consulta.
        String sql = 
                "INSERT INTO PRESTAMOS" +
                "     (IDAUTO,IDCLIENTE,FECHARENTA,FINALRENTA,LUGARDERENTA,MONTO)" +
                "  VALUES (?,?,?,?,?,?)";
        
        // Obtenemos el objeto Statement de la ejecución.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Ingresamos los parámetros que corresponden a los datos a insertar.
            stmt.setInt(1, i.getIdAuto());
            stmt.setInt(2, i.getIdCliente());
            // Convertimos la cadena de fecha en un objeto de fecha utilizando SimpleDateFormat.
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date fechaRentaDate = dateFormat.parse(i.getFechaRenta());
            java.sql.Date fechaRentaSqlDate = new java.sql.Date(fechaRentaDate.getTime());
            stmt.setDate(3, fechaRentaSqlDate);
            // Convertimos la cadena de fecha al formato de fecha MySQL utilizando otro SimpleDateFormat.
            SimpleDateFormat mysqlDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date finalRentaDate = dateFormat.parse(i.getFinalRenta());
            String finalRentaSqlString = mysqlDateFormat.format(finalRentaDate);
            stmt.setString(4, finalRentaSqlString);
            stmt.setString(5, i.getLugarDeRenta());
            stmt.setDouble(6, i.getMonto());
            
            if (stmt.executeUpdate() > 0) {
                try (ResultSet r = stmt.getGeneratedKeys()) {
                    if (r.next());
                }
            } 
        } catch(Exception SQL){
            System.out.println(SQL);
        }
    }


public void update(Prestamo i) throws SQLException, ParseException {
        
        // Sentencia SQL que representa el update.
        String sql = 
                "UPDATE PRESTAMOS SET " +    
                "       finalRenta=?,lugarDeRenta=?,monto=?, idCliente = ?, fechaRenta = ?" +
                "   WHERE idAuto = ?";
        
        // Objeto statement con el que vamos a ejecutar la sentencia.
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Convertimos la cadena de fecha en un objeto de fecha utilizando SimpleDateFormat.
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date fechaRentaDate = dateFormat.parse(i.getFechaRenta());
            java.sql.Date fechaRentaSqlDate = new java.sql.Date(fechaRentaDate.getTime());
            
            // Convertimos la cadena de fecha al formato de fecha MySQL utilizando otro SimpleDateFormat.
            SimpleDateFormat mysqlDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date finalRentaDate = dateFormat.parse(i.getFinalRenta());
            String finalRentaSqlString = mysqlDateFormat.format(finalRentaDate);
            
            // Enviamos los parámetros a la sentencia SQL a ejecutar.
            stmt.setString(1, finalRentaSqlString);
            stmt.setString(2, i.getLugarDeRenta());
            stmt.setDouble(3, i.getMonto());
            stmt.setInt(4, i.getIdCliente());
            stmt.setDate(5, fechaRentaSqlDate);
            stmt.setInt(6, i.getIdAuto());
            
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
    private Prestamo toObj(ResultSet r) throws SQLException {
        Prestamo i = new Prestamo();
        
        i.setFechaRenta(r.getString("FECHARENTA"));
        i.setFinalRenta(r.getString("FINALRENTA"));
        i.setIdAuto(r.getInt("IDAUTO"));
        i.setIdCliente(r.getInt("IDCLIENTE"));
        i.setLugarDeRenta(r.getString("LUGARDERENTA"));
        i.setMonto(r.getDouble("MONTO"));
        
        return i;
    }
}
