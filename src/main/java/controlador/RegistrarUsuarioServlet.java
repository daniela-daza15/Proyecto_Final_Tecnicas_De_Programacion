/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import dao.UsuarioDAO;
import jakarta.servlet.annotation.WebServlet;
import java.net.URLEncoder;
/**
 * Servlet encargado de registrar un nuevo usuario.
 * Atiende peticiones en la ruta "/registrar" y gestiona el formulario de registro.
 */
@WebServlet("/registrar")
public class RegistrarUsuarioServlet extends HttpServlet {
    // Instancia del DAO para operaciones con la base de datos
    UsuarioDAO userDAO = new UsuarioDAO();
    // Instancia de Usuario para almacenar los datos del formulario
    Usuario user = new Usuario();

    /**
     * Método que responde a las peticiones GET.
     * Muestra el formulario de registro al usuario.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirige a la página del formulario de registro
        RequestDispatcher view = request.getRequestDispatcher("formulario.jsp");
        view.forward(request, response);
    }
    
    /**
     * Método que responde a las peticiones POST.
     * Recibe los datos del formulario, crea un usuario y lo guarda en la base de datos.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtiene los datos enviados desde el formulario
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String empresa = request.getParameter("empresa");
        String servicio = request.getParameter("servicio");
        String mensaje = request.getParameter("mensaje");

        // Asigna los datos al objeto Usuario
        user.setNombre(nombre);
        user.setEmail(email);
        user.setTelefono(telefono);
        user.setEmpresa(empresa);
        user.setServicio(servicio);
        user.setMensaje(mensaje);

        // Guarda el usuario en la base de datos
        userDAO.agregar(user);

        // Redirige al formulario con un mensaje de éxito
        response.sendRedirect("formulario.jsp?exito=" + URLEncoder.encode("¡Usuario registrado exitosamente!", "UTF-8"));
    }
}
