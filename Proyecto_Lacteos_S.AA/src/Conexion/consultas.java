/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Formularios.Menu;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




/**
 *
 * @author HP
 */
public class consultas {
     //Metodo para guardar un usuario en la tabla "usuarios"
     public void guardarUsuario(String usuario, String password){
        
        cls_conexion db = new cls_conexion();
        String sql = "insert into usuarios(usuario, contraseña) values ('" + usuario +"', '" + password +"');";
        Statement st;
        //Connection conexion = db.conectar();
        Connection conexion = db.getConnection();
        try
        {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        }catch(SQLException e)
        {
            System.out.println(e);
        }
}
     //Metodo para dar o no acceso a la aplicacion
     public void accesoUsuario(String user, String pass)
     {
      // TODO add your handling code here:
        cls_conexion db = new cls_conexion();
        // Se inicializa a null
        String usuarioCorrecto = null;
        String passCorrecto = null;
    try {

        Connection cn = db.getConnection();
        PreparedStatement pst = cn.prepareStatement("SELECT usuario, contraseña FROM usuarios");
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            usuarioCorrecto = rs.getString(1);
            passCorrecto = rs.getString(2);
        }

        if (user.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
            JOptionPane.showMessageDialog(null, "Login correcto Bienvenido " + user);
            Menu f3 = new Menu();
            f3.setVisible (true);
        } else if (!user.equals(usuarioCorrecto) || pass.equals(passCorrecto)) {

            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error " + e);
    }
    }   
     }
     

