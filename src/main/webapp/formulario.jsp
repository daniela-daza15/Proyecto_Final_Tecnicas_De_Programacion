<%--
    Document   : formulario
    Created on : 17/06/2025, 1:59:34 a. m.
    Author     : danis
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.net.*" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Contacto</title>
    <link rel="stylesheet" href="css/style_form.css">
</head>
<body>
    <div class="container">
        <div class="section-header">
            <h2>Contáctanos</h2>
            <p>¿Listo para llevar tu negocio al siguiente nivel? Completa el formulario y nos pondremos en contacto contigo</p>
        </div>

        <%-- Bloque para mostrar el mensaje de éxito si existe --%>
        <%
            String exito = request.getParameter("exito");
            if (exito != null && !exito.isEmpty()) {
        %>
        <div style="background-color: #d4edda; color: #155724; padding: 10px; margin-bottom: 15px; border-radius: 5px; border: 1px solid #c3e6cb;">
            <%= exito %>
        </div>
        <%
            }
        %>

        <div class="contact-content">
            <div class="contact-form-container">
                <form id="contactForm" class="contact-form" action="<%= request.getContextPath() %>/registrar" method="POST">
                    <div class="form-group">
                        <label for="nombre">Nombre Completo</label>
                        <input type="text" id="nombre" name="nombre" required>
                    </div>

                    <div class="form-group">
                        <label for="email">Correo Electrónico</label>
                        <input type="email" id="email" name="email" required>
                    </div>

                    <div class="form-group">
                        <label for="telefono">Teléfono</label>
                        <input type="tel" id="telefono" name="telefono">
                    </div>

                    <div class="form-group">
                        <label for="empresa">Empresa</label>
                        <input type="text" id="empresa" name="empresa">
                    </div>

                    <div class="form-group">
                        <label for="servicio">Servicio de Interés</label>
                        <select id="servicio" name="servicio" required>
                            <option value="">Selecciona un servicio</option>
                            <option value="marketing-digital">Marketing Digital</option>
                            <option value="diseno-grafico">Diseño Gráfico</option>
                            <option value="redes-sociales">Publicidad en Redes</option>
                            <option value="seo-sem">SEO & SEM</option>
                            <option value="video">Producción de Video</option>
                            <option value="consultoria">Consultoría</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="mensaje">Mensaje</label>
                        <textarea id="mensaje" name="mensaje" rows="5" placeholder="Cuéntanos sobre tu proyecto..."></textarea>
                    </div>

                    <button type="submit" class="btn-primary">Enviar</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>