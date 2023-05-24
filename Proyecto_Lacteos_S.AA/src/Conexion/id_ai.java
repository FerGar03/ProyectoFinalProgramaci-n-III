/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
//Metodo para dar un id a los clientes de forma autoincrementable
public class id_ai {
    public int id_incrementable(){
        int id= 1;
        PreparedStatement ps= null;
        ResultSet rs = null;
        cls_conexion db=new cls_conexion();
        
        try{
            ps = db.getConnection().prepareStatement("SELECT MAX(idclientes) FROM clientes");
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1)+1;
            }
            
        }catch(Exception ex){
            System.out.println("Error");
        }
        return id;
    }
}
