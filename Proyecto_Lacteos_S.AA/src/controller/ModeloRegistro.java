/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Iber Ramos Tzir
 */
public class ModeloRegistro {

// Variables miembro privadas
    private String usuario;
    private String contraseña;

    public String getUsuario() {
        return usuario;
    }
 // Método getter para obtener el usuario
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}