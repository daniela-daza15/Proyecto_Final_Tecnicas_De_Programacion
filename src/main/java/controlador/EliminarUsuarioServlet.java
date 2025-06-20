/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
/**
 * Servlet encargado de eliminar un usuario de la base de datos.
 * Atiende peticiones en la ruta "/eliminar".
 */
@WebServlet("/eliminar")
public class EliminarUsuarioServlet extends HttpServlet {
    // Instancia del DAO para operaciones con la base de datos
    private UsuarioDAO dao = new UsuarioDAO();
    
    /**
     * Método que responde a las peticiones GET.
     * Elimina el usuario cuyo ID se recibe como parámetro y redirige a la administración.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            // Obtiene el parámetro 'idusuarios' de la URL y lo convierte a entero
            int id = Integer.parseInt(request.getParameter("idusuarios"));
            // Llama al método DAO para eliminar el usuario por su ID
            dao.eliminarPorId(id);
        } catch (Exception e) {
            // Imprime la traza de la excepción si ocurre un error
            e.printStackTrace();
        }

        response.sendRedirect("administrar"); // Redirige al servlet que lista todos
    }
}
