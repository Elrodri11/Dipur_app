package edu.upv.poo;

import java.sql.*;

/**
 * Contiene utilerias para trabajar con bases de datos.
 */
public class DbUtils {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/autosDB";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    
    /**
     * Obtiene el objeto Connection a base de datos correspondiente a los 
     * parámetros de configuración por default.
     * @return El objeto Connection.
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        // Carga el controlador JDBC
        // Crea la conexión
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }    
}
