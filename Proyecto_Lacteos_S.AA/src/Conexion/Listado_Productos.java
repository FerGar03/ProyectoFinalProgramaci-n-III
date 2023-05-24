/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.util.ArrayList;

//Se crea una lista de los productos
public class Listado_Productos {
   ArrayList<Producto>lista;
   
   public Listado_Productos(){
       lista=new ArrayList();
   }
   //Metodo para agregar un producto a la lista
   public void AgregarProductos(Producto c){
       lista.add(c);
   }
}
