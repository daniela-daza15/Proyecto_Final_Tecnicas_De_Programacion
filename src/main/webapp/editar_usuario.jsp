<%-- 
    Document   : editar_usuario
    Created on : 19/06/2025, 6:56:20 p. m.
    Author     : danis
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="modelo.Usuario" %>
<%
    Usuario u = (Usuario) request.getAttribute("usuario");
    if (u == null) {
        response.sendRedirect("AdministrarUsuariosServlet");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="css/style_form.css">
</head>
<body>
    <div class="container">
        <div class="section-header">
            <h2>Editar Usuario</h2>
            <p>Modifica los datos del usuario y guarda los cambios.</p>
        </div>
        <div class="contact-content">
            <div class="contact-form-container">
                <form class="contact-form" action="editar" method="POST">
                    <input type="hidden" name="idusuarios" value="<%= u.getId() %>">

                    <div class="form-group">
                        <label for="nombre">Nombre Completo</label>
                        <input type="text" id="nombre" name="nombre" value="<%= u.getNombre() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="email">Correo Electrónico</label>
                        <input type="email" id="email" name="email" value="<%= u.getEmail() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="telefono">Teléfono</label>
                        <input type="tel" id="telefono" name="telefono" value="<%= u.getTelefono() %>">
                    </div>

                    <div class="form-group">
                        <label for="empresa">Empresa</label>
                        <input type="text" id="empresa" name="empresa" value="<%= u.getEmpresa() %>">
                    </div>

                    <div class="form-group">
                        <label for="servicio">Servicio de Interés</label>
                        <select id="servicio" name="servicio" required>
                            <option value="">Selecciona un servicio</option>
                            <%
                                String servicio = u.getServicio() != null ? u.getServicio() : "";
                            %>
                            <option value="marketing-digital" <%= servicio.equals("marketing-digital") ? "selected" : ""%>>Marketing Digital</option>
                            <option value="diseno-grafico" <%= u.getServicio().equals("diseno-grafico") ? "selected" : ""%>>Diseño Gráfico</option>
                            <option value="redes-sociales" <%= u.getServicio().equals("redes-sociales") ? "selected" : ""%>>Publicidad en Redes</option>
                            <option value="seo-sem" <%= u.getServicio().equals("seo-sem") ? "selected" : ""%>>SEO & SEM</option>
                            <option value="video" <%= u.getServicio().equals("video") ? "selected" : "" %>>Producción de Video</option>
                            <option value="consultoria" <%= u.getServicio().equals("consultoria") ? "selected" : "" %>>Consultoría</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="mensaje">Mensaje</label>
                        <textarea id="mensaje" name="mensaje" rows="5"><%= u.getMensaje() %></textarea>
                    </div>

                    <button type="submit" class="btn-primary">Guardar Cambios</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>