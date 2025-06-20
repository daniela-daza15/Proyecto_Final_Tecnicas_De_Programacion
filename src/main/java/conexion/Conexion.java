/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase para gestionar la conexión a una base de datos MySQL.
 * Utiliza el patrón Singleton para asegurar que solo exista una conexión activa.
 * 
 * @author danis
 */
public class Conexion {
    // Variable estática que almacena la conexión única a la base de datos
    private static Connection connection;
    
    // Constantes con los datos de conexión a la base de datos
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/agencia_publicidad_zenda?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin1";
    
    // Constructor privado para evitar instanciación externa (patrón Singleton)
    private Conexion() {}
    
    /**
     * Método estático para obtener la conexión a la base de datos.
     * Si la conexión no existe, la crea; si ya existe, la retorna.
     * 
     * @return Connection objeto de conexión a la base de datos
     */
    public static Connection getConexion() {
        if (connection == null) { // Si no hay conexión activa
            try {
                Class.forName(DRIVER); // Carga el driver JDBC de MySQL
                connection = DriverManager.getConnection(URL, USER, PASSWORD); // Establece la conexión usando los datos proporcionados
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace(); // Imprime la traza de la excepción si ocurre un error
            }
        }
        // Retorna la conexión (nueva o existente)
        return connection;
    }
}
