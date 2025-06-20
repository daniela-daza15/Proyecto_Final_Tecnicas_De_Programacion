/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que representa un usuario con sus datos personales y de contacto.
 * 
 * @author danis
 */
public class Usuario {
    //Atributos en representación de los datos personales de un usuario
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String empresa;
    private String servicio;
    private String mensaje;
    
    // Constructor vacío
    public Usuario() {
    }
    
    // Constructor con todos los atributos
    public Usuario(int id, String nombre, String email, String telefono, String empresa, String servicio, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.empresa = empresa;
        this.servicio = servicio;
        this.mensaje = mensaje;
    }
    
    // Métodos getter y setter para cada atributo
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}

