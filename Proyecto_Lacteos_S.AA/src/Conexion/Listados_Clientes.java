/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.util.ArrayList;

//Se crea un lista de los clientes
public class Listados_Clientes {
    
    ArrayList<Cliente>lista;
   
   public Listados_Clientes(){
       lista=new ArrayList();
   }
   //Metodo para poder agreagar un cliente a la lista
   public void AgregarClientes(Cliente c){
       lista.add(c);
   }
}
