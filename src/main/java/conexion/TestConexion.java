/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;
import java.sql.Connection;
/**
 * Clase de prueba para verificar la conexión a la base de datos usando la clase Conexion.
 * 
 * @author danis
 */
public class TestConexion {
    public static void main(String[] args) {
        // Obtiene la conexión a la base de datos llamando al método estático de la clase Conexion
        Connection conn = Conexion.getConexion();
        if (conn != null) { // Verifica si la conexión fue exitosa
            System.out.println("Conexión verificada."); // Mensaje si la conexión es exitosa
        } else {
            System.out.println("No se pudo establecer la conexión."); // Mensaje si la conexión falla
        }
    }
}
