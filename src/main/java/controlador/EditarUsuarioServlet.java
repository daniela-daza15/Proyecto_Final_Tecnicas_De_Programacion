/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
/**
 * Servlet encargado de editar los datos de un usuario existente.
 * Atiende peticiones en la ruta "/editar" y gestiona la edición de usuarios.
 */
@WebServlet("/editar")
public class EditarUsuarioServlet extends HttpServlet {
    // Instancia del DAO para operaciones con la base de datos
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * Método que responde a las peticiones GET.
     * Busca el usuario por su ID y muestra el formulario de edición.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene el parámetro 'idusuarios' de la URL
        String idStr = request.getParameter("idusuarios");
        System.out.println("[EDITAR] idusuarios recibido: " + idStr);

        if (idStr != null && !idStr.isEmpty()) {
            try {
                int idusuarios = Integer.parseInt(idStr);
                // Busca el usuario en la base de datos
                Usuario usuario = usuarioDAO.buscarPorId(idusuarios);

                if (usuario != null) {
                    // Si el usuario existe, lo agrega como atributo y muestra el formulario de edición
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("editar_usuario.jsp").forward(request, response);
                } else {
                    // Si no existe, redirige a la administración de usuarios
                    response.sendRedirect("administrar");
                }

            } catch (NumberFormatException e) {
                // Si el parámetro no es numérico, redirige a la administración
                System.out.println("Error: el parámetro idusuarios no es numérico");
                response.sendRedirect("administrar");
            }
        } else {
            // Si falta el parámetro, redirige a la administración
            System.out.println("Error: parámetro idusuarios faltante");
            response.sendRedirect("administrar");
        }
    }

    /**
     * Método que responde a las peticiones POST.
     * Recibe los datos editados y actualiza el usuario en la base de datos.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idStr = request.getParameter("idusuarios");
            if (idStr == null || idStr.isEmpty()) {
                response.sendRedirect("administrar");
                return;
            }
            
            int idusuarios = Integer.parseInt(idStr);
            // Crea un objeto Usuario con los datos editados
            Usuario usuario = new Usuario();
            usuario.setId(idusuarios);
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setTelefono(request.getParameter("telefono"));
            usuario.setEmpresa(request.getParameter("empresa"));
            usuario.setServicio(request.getParameter("servicio"));
            usuario.setMensaje(request.getParameter("mensaje"));

            // Actualiza el usuario en la base de datos
            usuarioDAO.actualizar(usuario);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Para depuración
        }

        // Redirige a la administración de usuarios después de actualizar
        response.sendRedirect("administrar");
    }
}
