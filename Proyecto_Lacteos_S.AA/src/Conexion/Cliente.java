/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

    //Se crea el constructor para Clientes
public class Cliente {
    private int id;
    private String nom_cliente;

    public Cliente() {
    }

    public Cliente(int id, String nom_cliente) {
        this.id = id;
        this.nom_cliente = nom_cliente;
    }
//Se crean los getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }
    
    

}
