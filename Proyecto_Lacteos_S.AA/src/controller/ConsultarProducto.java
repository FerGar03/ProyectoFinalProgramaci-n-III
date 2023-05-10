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
import java.util.ArrayList;

/**
 *
 *
 */
public class ConsultarProducto {

    private cls_conexion conectar;
    private ModeloRegistro modelo;
    private Connection con;

    public ConsultarProducto() {
        conectar = new cls_conexion();
        modelo = new ModeloRegistro();
    }

    public ArrayList<ModeloProducto> comprobar() {

        ArrayList<ModeloProducto> listaProductos = new ArrayList<>();
        PreparedStatement ps;
        String sql;

        try {
            con = conectar.getConnection();
            sql = "select * from registro_productos";
            ps = con.prepareStatement(sql);

            ResultSet productos = ps.executeQuery();

            while (productos.next()) {

                ModeloProducto producto = new ModeloProducto();

                producto.setCodigoProductos(productos.getInt("codigo_productos"));
                producto.setNumeroProductos(productos.getString("numero_productos"));
                producto.setSerie(productos.getString("serie"));
                producto.setDescripcion(productos.getString("descripcion"));
                producto.setFechaVencimiento(productos.getString("fecha_vencimiento"));
                producto.setCantidad(productos.getString("cantidad"));
                producto.setPrecio(productos.getString("precio"));
                producto.setTemperatura(productos.getString("temperatura"));
                producto.setFechaIngresa(productos.getString("fecha_ingresa"));

                listaProductos.add(producto);

            }

            if (!productos.next()) {
                return listaProductos;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            
        }

        return listaProductos;

    }

}
