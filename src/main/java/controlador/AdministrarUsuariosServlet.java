/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
/**
 * Servlet encargado de administrar la visualización de usuarios.
 * Atiende peticiones GET en la ruta "/administrar" y muestra la lista de usuarios.
 * 
 * @author danis
 */
@WebServlet("/administrar")
public class AdministrarUsuariosServlet extends HttpServlet {
    
    // Instancia del DAO para acceder a los datos de los usuarios
    private UsuarioDAO dao = new UsuarioDAO();
    
    /**
     * Método que responde a las peticiones GET.
     * Obtiene la lista de usuarios y la envía a la vista JSP para mostrarla.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtiene la lista de todos los usuarios desde la base de datos
        List<Usuario> usuarios = dao.listarTodos();
        // Agrega la lista como atributo a la petición para que esté disponible en la JSP
        request.setAttribute("usuarios", usuarios);
        // Redirige la petición a la página usuarios.jsp para mostrar los datos
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
    }
}
