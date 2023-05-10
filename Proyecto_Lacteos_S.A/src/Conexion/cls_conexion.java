package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


// CONFIGURACION PARA LA CONEXION
public class cls_conexion {
    
    private static final String DRIVER      = "com.mysql.cj.jdbc.Driver";
    private static final String USER        = "root";
    private static final String PASSWORD    = "root";
    private static final String URL         = "jdbc:mysql://localhost:3306/lacteos_s.a";
    private Connection CN;
    
    //public cls_conexion (){
    //    CN = null;
    //}

// ESTABLECEMOS CONEXION CON LA BASE DE DATOS
    public Connection getConnection() {
         CN = null;
        try{
            Class.forName(DRIVER);
            CN = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa", "Conexion",JOptionPane.INFORMATION_MESSAGE );
    
        } catch (ClassNotFoundException | SQLException ex){
            JOptionPane.showInputDialog(null, ex.getMessage(), "NO SE HIZO LA CONEXIÓN A LA BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return CN;
    }
// CERRAR LA CONEXION
    public void close(){
        try{
            CN.close();
        }catch (SQLException ex){
            JOptionPane.showInputDialog(null, ex.getMessage(), "NO SE CERRO LA CONEXIÓN", JOptionPane.ERROR_MESSAGE);
        }
    }
}