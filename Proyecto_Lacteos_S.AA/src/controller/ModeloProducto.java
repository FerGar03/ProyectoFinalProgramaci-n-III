/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Iber Ramos Tzir
 */

 // Variables miembro privadas
public class ModeloProducto {
    private int codigoProductos;
    private String numeroProductos;
    private String serie;
    private String descripcion;
    private String fechaVencimiento;
    private String cantidad;
    private String precio;
    private String temperatura;
    private String fechaIngresa;
    
   
  // Método getter para obtener el código del producto
    public int getCodigoProductos() {
        return codigoProductos;
    }
// Método setter para establecer el código del producto
    public void setCodigoProductos(int codigoProductos) {
        this.codigoProductos = codigoProductos;
    }
// Método getter para obtener el número del producto
    public String getNumeroProductos() {
        return numeroProductos;
    }
// Método setter para establecer el número del producto
    public void setNumeroProductos(String numeroProductos) {
        this.numeroProductos = numeroProductos;
    }
// Método getter para obtener la serie del producto
    public String getSerie() {
        return serie;
    }
// Método setter para establecer la serie del producto
    public void setSerie(String serie) {
        this.serie = serie;
    }
 // Método getter para obtener la descripción del producto
    public String getDescripcion() {
        return descripcion;
    }
// Método setter para establecer la descripción del producto
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getFechaIngresa() {
        return fechaIngresa;
    }

    public void setFechaIngresa(String fechaIngresa) {
        this.fechaIngresa = fechaIngresa;
    }
    
}


  