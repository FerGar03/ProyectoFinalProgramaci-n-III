/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import Conexion.cls_conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.sql.ResultSet;

/**
 *
 *
 */
public class IniciarUsuario {
    
    
    private cls_conexion conectar;
    private ModeloRegistro modelo;
    private Connection con;
     
    public IniciarUsuario(){
        conectar = new cls_conexion();
        modelo = new ModeloRegistro();
    }
     
    public int comprobar(String usuario, String contraseña){
        PreparedStatement ps;
        String sql;
        modelo.setUsuario(usuario);
        modelo.setContraseña(contraseña);
        try{
            con = conectar.getConnection();
            sql = "select usuario from usuarios where usuario=? AND contraseña=?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, modelo.getUsuario());
            ps.setString(2, modelo.getContraseña());
            ResultSet nombre = ps.executeQuery();
            
            if(!nombre.next()) {return 0;}
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            return 0;
        }
        
        return 1;
        
    }
    
}
