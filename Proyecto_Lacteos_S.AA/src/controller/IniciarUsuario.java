/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import Conexion.cls_conexion; // Importación de la clase de conexión

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class IniciarUsuario {
    
    private cls_conexion conectar; // Objeto para la conexión a la base de datos
    private ModeloRegistro modelo; // Objeto para el modelo de registro
    private Connection con; // Objeto de conexión
     
    public IniciarUsuario(){
        conectar = new cls_conexion(); // Inicialización del objeto de conexión
        modelo = new ModeloRegistro(); // Inicialización del objeto de modelo de registro
    }
     
    public int comprobar(String usuario, String contraseña){
        PreparedStatement ps; // Objeto para la ejecución de consultas preparadas
        String sql; // Variable para almacenar la consulta SQL
        modelo.setUsuario(usuario); // Establecer el usuario en el modelo de registro
        modelo.setContraseña(contraseña); // Establecer la contraseña en el modelo de registro
        try{
            con = conectar.getConnection(); // Establecer la conexión con la base de datos
            sql = "select usuario from usuarios where usuario=? AND contraseña=?"; // Consulta SQL para verificar el usuario y contraseña
            ps = con.prepareStatement(sql); // Preparar la consulta SQL
            
            ps.setString(1, modelo.getUsuario()); // Establecer el valor del primer parámetro de la consulta
            ps.setString(2, modelo.getContraseña()); // Establecer el valor del segundo parámetro de la consulta
            ResultSet nombre = ps.executeQuery(); // Ejecutar la consulta y obtener el resultado
            
            if(!nombre.next()) {return 0;} // Si no hay resultados, devuelve 0 (no se encontró un usuario válido)
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return 0;
        }
        
        return 1; // Devolver 1 (se encontró un usuario válido)
        
    }
    
}
