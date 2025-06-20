<%-- 
    Document   : usuarios_admin
    Created on : 18/06/2025, 8:10:02 p. m.
    Author     : danis
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuarios Registrados</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        .btn {
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
            color: white;
        }
        .editar {
            background-color: #4CAF50;
        }
        .eliminar {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <h2>Lista de Usuarios</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Teléfono</th>
            <th>Empresa</th>
            <th>Servicio</th>
            <th>Mensaje</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Usuario> lista = (List<Usuario>) request.getAttribute("usuarios");
            if (lista != null && !lista.isEmpty()) {
                for (Usuario u : lista) {
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getNombre() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getTelefono() %></td>
            <td><%= u.getEmpresa() %></td>
            <td><%= u.getServicio() %></td>
            <td><%= u.getMensaje() %></td>
            <td>
                <a href="<%= request.getContextPath()%>/editar?idusuarios=<%= u.getId()%>" class="btn editar">Editar</a>
                <a href="<%= request.getContextPath()%>/eliminar?idusuarios=<%= u.getId()%>" class="btn eliminar" onclick="return confirm('¿Estás seguro de eliminar este usuario?');">Eliminar</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="8">No hay usuarios registrados.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>