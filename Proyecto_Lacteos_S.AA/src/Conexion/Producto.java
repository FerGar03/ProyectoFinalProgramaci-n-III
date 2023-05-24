/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

//Se crea el Metodo para Productos
public class Producto {
    private int id;
    private String nom_producto;

    public Producto() {
    }
    

    public Producto(int id, String nom_producto) {
        this.id = id;
        this.nom_producto = nom_producto;
    }
//Se crean los getters y los setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }
    
}
