/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Usuario;
import conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para gestionar operaciones CRUD sobre la tabla 'usuarios'.
 * Permite agregar, listar, eliminar, buscar y actualizar usuarios en la base de datos.
 * 
 * @author danis
 */
public class UsuarioDAO {
    // Conexión a la base de datos
    private Connection conn = null;

    /**
     * Agrega un nuevo usuario a la base de datos.
     * @param usuario Objeto Usuario con los datos a insertar.
     */
    public void agregar(Usuario usuario) {
        try {
            conn = Conexion.getConexion(); // usamos la conexión tipo Singleton

            String query = "INSERT INTO usuarios (nombre, email, telefono, empresa, servicio, mensaje) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            
            // Asigna los valores a los parámetros de la consulta
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getEmpresa());
            ps.setString(5, usuario.getServicio());
            ps.setString(6, usuario.getMensaje());

            ps.executeUpdate(); // Ejecuta la inserción
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Lista todos los usuarios de la base de datos.
     * @return Lista de objetos Usuario.
     */
    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        try {
            conn = Conexion.getConexion();
            String query = "SELECT * FROM usuarios";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            // Recorre los resultados y crea objetos Usuario
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("idusuarios")); 
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                u.setEmpresa(rs.getString("empresa"));
                u.setServicio(rs.getString("servicio"));
                u.setMensaje(rs.getString("mensaje"));

                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    /**
     * Elimina un usuario de la base de datos por su ID.
     * @param id ID del usuario a eliminar.
     */
    public void eliminarPorId(int id) {
        try {
            conn = Conexion.getConexion();
            String sql = "DELETE FROM usuarios WHERE idusuarios = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Busca un usuario por su ID.
     * @param idusuarios ID del usuario a buscar.
     * @return Objeto Usuario si lo encuentra, null si no existe.
     */
    public Usuario buscarPorId(int idusuarios) {
        Usuario usuario = null;
        try {
            conn = Conexion.getConexion();
            String sql = "SELECT * FROM usuarios WHERE idusuarios = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idusuarios);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("idusuarios"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("empresa"),
                        rs.getString("servicio"),
                        rs.getString("mensaje")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    /**
     * Actualiza los datos de un usuario existente en la base de datos.
     * @param usuario Objeto Usuario con los datos actualizados.
     */
    public void actualizar(Usuario usuario) {
        try {
            conn = Conexion.getConexion();
            String sql = "UPDATE usuarios SET nombre=?, email=?, telefono=?, empresa=?, servicio=?, mensaje=? WHERE idusuarios=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getEmpresa());
            ps.setString(5, usuario.getServicio());
            ps.setString(6, usuario.getMensaje());
            ps.setInt(7, usuario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
