# Agencia de Publicidad Zenda 

Este es el proyecto final para la asignatura de **Técnicas de Programación**. Consiste en una aplicación web desarrollada en Java con el patrón **MVC**, usando **JSP, Servlets, JDBC y MySQL**, desplegada con **Apache Tomcat**.

## 🚀 Funcionalidades principales

- **Formulario de contacto:** Permite a clientes registrarse con sus datos y seleccionar un servicio.
- **Vista de administración:** Lista de usuarios registrados.
- **Editar usuarios:** Permite modificar los datos de un usuario existente.
- **Eliminar usuarios:** Elimina usuarios con confirmación previa.

## 🧱 Estructura del proyecto

- **Modelo:**  
  `modelo/Usuario.java` – Clase JavaBean que representa a un usuario.

- **Vista (JSP):**  
  `formulario.jsp` – Formulario de contacto  
  `usuarios.jsp` – Vista de administración  
  `editar_usuario.jsp` – Edición de usuarios  
  `index.jsp` – Página principal

- **Controlador (Servlets):**  
  `RegistrarUsuarioServlet.java`  
  `AdministrarUsuariosServlet.java`  
  `EditarUsuarioServlet.java`  
  `EliminarUsuarioServlet.java`

- **DAO:**  
  `dao/UsuarioDAO.java` – Acceso a la base de datos usando JDBC.

- **Conexión:**  
  `conexion/Conexion.java` – Implementa el patrón Singleton para conectar a la base de datos.

## 🧪 Tecnologías utilizadas

- Java 17
- Jakarta EE (Servlets y JSP)
- JDBC
- MySQL
- Apache Tomcat
- HTML/CSS/JS
- NetBeans

## ⚙️ Instrucciones para ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/AgenciaDePublicidadZenda.git
   
2. Abre el proyecto con NetBeans.
3. Configura la conexión a la base de datos en Conexion.java.
4. Asegúrate de tener un servidor Tomcat configurado en NetBeans.
5. Ejecuta el proyecto (Run).
6. Accede en el navegador a:
7. Formulario: http://localhost:8080/AgenciaDePublicidadZenda/formulario.jsp
8. Administrador: http://localhost:8080/AgenciaDePublicidadZenda/administrar

🧠 Aprendizajes
Aplicación del patrón MVC en Java Web.
Uso de Servlets para manejar la lógica del backend.
Comunicación cliente-servidor con JSP y Servlets.
Persistencia con JDBC y MySQL.

📌 Autor
Daniela Esperanza Daza Salgado
Estudiante de Técnicas de Programación
Junio 2025
