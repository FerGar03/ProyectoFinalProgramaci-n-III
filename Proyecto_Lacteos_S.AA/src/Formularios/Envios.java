/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Conexion.Cliente;
import Conexion.Listado_Productos;
import Conexion.Listados_Clientes;
import Conexion.Producto;
import Conexion.cls_conexion;
import Conexion.id_envios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iber Ramos Tzir
 */
public class Envios extends javax.swing.JFrame {

    /**
     * Creates new form registro_productos
     */
    public Envios() {
        initComponents();
        setLocationRelativeTo(null);
        
        this.setTitle(" REGISTRO DE PRODUCTOS ");
        this.setLocation(400,220);
        
        cargarProducto(cmbboxproducto);
        cargarCliente(cmbboxcliente);
        
       
    }
    //Metodo para mostrar en tblenvios todo los datos en la tabla "envios" y actualiza el campo "cantidad" del productos
    //seleccionado en la tabla "stock"
    public void mostrar(String tabla){
        String sql = "select * from " + tabla;
        Statement st;
        cls_conexion con = new cls_conexion();
        Connection conexion = con.getConnection();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID ENVIOS");
        model.addColumn("PRODUCTO");
        model.addColumn("CANTIDAD");
        model.addColumn("FECHA");
        model.addColumn("CLIENTE");
        tblenvios.setModel(model);
        
        String [] datos = new String[5];
        try{
         st = conexion.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next())
         {
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
            model.addRow(datos);
         }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }
             
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblenvios = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        cmbboxproducto = new javax.swing.JComboBox<>();
        cmbboxcliente = new javax.swing.JComboBox<>();
        jtextcan = new javax.swing.JTextField();
        jtextdate = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 204));
        jLabel6.setText(" ");

        jLabel11.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 204));
        jLabel11.setText("Producto");

        tblenvios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID ENVIO", "PRODUCTO", "CANTIDAD", "FECHA", "CLIENTE"
            }
        ));
        jScrollPane1.setViewportView(tblenvios);

        jLabel10.setForeground(new java.awt.Color(102, 0, 204));
        jLabel10.setText("Cantidad");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("ENVÍOS");

        jLabel1.setForeground(new java.awt.Color(102, 0, 204));
        jLabel1.setText("Fecha");

        jLabel2.setForeground(new java.awt.Color(102, 0, 204));
        jLabel2.setText("Cliente");

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarr.png"))); // NOI18N
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salii.png"))); // NOI18N
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jtextcan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextcanActionPerformed(evt);
            }
        });
        jtextcan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtextcanKeyTyped(evt);
            }
        });

        jtextdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextdateActionPerformed(evt);
            }
        });
        jtextdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtextdateKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbboxproducto, 0, 120, Short.MAX_VALUE)
                                            .addComponent(jtextcan))
                                        .addGap(64, 64, 64)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbboxcliente, 0, 120, Short.MAX_VALUE)
                                            .addComponent(jtextdate))))))
                        .addGap(0, 140, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(btnguardar)
                .addGap(28, 28, 28)
                .addComponent(btnsalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cmbboxproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2)
                    .addComponent(cmbboxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextcan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar)
                    .addComponent(btnsalir))
                .addGap(124, 124, 124)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
      //Se oculta esta ventana y emerge la ventana de "menu"
        this.setVisible(false);
        Menu ventana = new Menu ();
        ventana.setVisible (true);

        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        //Metodo para guardar los datos en la tabla "envios", usando los datos obtnedios de los campos del formulario.
        //Se utilizan sentencias SQL para poder guardar los datos en la tabla
        cls_conexion mysql= new cls_conexion();
        Connection cn=mysql.getConnection();
        String pro, date, cl="";
        int idenv, can=0;
        
        String sSQL="";
        
        id_envios s =new id_envios();
        idenv= s.id_incrementableenv();
        pro= cmbboxproducto.getSelectedItem().toString();
        can= Integer.parseInt(jtextcan.getText());
        date= jtextdate.getText();
        cl = cmbboxcliente.getSelectedItem().toString();
        sSQL="INSERT INTO envios(idenvios, producto, cantidad, fecha, cliente)"
                +"VALUES(?,?,?,?,?)";
        
        try{
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, idenv);
            pst.setString(2, pro);
            pst.setInt(3, can);
            pst.setString(4, date);
            pst.setString(5, cl);
            
            int n=pst.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null,"El registro se ingreso","Ingreso", JOptionPane.INFORMATION_MESSAGE);
                mostrar("envios");
                
                String producto = (String) cmbboxproducto.getSelectedItem();
                int cantidad = Integer.parseInt(jtextcan.getText());
                String queryVerificar = "SELECT cantidad FROM stock WHERE producto = ?";
                PreparedStatement statementVerificar = cn.prepareStatement(queryVerificar);
                statementVerificar.setString(1, producto); 
                ResultSet resultSet = statementVerificar.executeQuery();
                
                if (resultSet.next()) {
                // El producto ya existe, se debe actualizar la cantidad
                int cantidadExistente = resultSet.getInt("cantidad");
                int nuevaCantidad = cantidadExistente - cantidad;
                
                String queryActualizar = "UPDATE stock SET cantidad = ? WHERE producto = ?";
                PreparedStatement statementActualizar = cn.prepareStatement(queryActualizar);
                statementActualizar.setInt(1, nuevaCantidad);
                statementActualizar.setString(2, producto);
                
                statementActualizar.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Cantidad actualizada en la tabla 'stock'.","Ingreso", JOptionPane.INFORMATION_MESSAGE);
            } 
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error"+ex,"Ingreso", JOptionPane.ERROR_MESSAGE);
        } 
        //limpiar casillas
        
                jtextcan.setText("");
        jtextdate.setText("");
         cmbboxproducto.setSelectedIndex(0); //posicion cero es la primera
          cmbboxcliente.setSelectedIndex(0); //posicion cero es la primera
         

    }//GEN-LAST:event_btnguardarActionPerformed

    private void jtextcanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextcanKeyTyped
 char numeros=evt.getKeyChar();
    if (Character.isLetter(numeros)) {
        getToolkit().beep();
    
        evt.consume();
    JOptionPane.showMessageDialog(rootPane,"Porfavor ingrese una fecha ");
    } 
      
    }//GEN-LAST:event_jtextcanKeyTyped

    private void jtextdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextdateKeyTyped
 char numeros=evt.getKeyChar();
    if (Character.isLetter(numeros)) {
        getToolkit().beep();
    
        evt.consume();
    JOptionPane.showMessageDialog(rootPane,"Porfavor ingrese solo numeros");
    }  
    }//GEN-LAST:event_jtextdateKeyTyped

    private void jtextdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextdateActionPerformed

    private void jtextcanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextcanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextcanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Envios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Envios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Envios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Envios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Envios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cmbboxcliente;
    private javax.swing.JComboBox<String> cmbboxproducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jtextcan;
    private javax.swing.JTextField jtextdate;
    private javax.swing.JTable tblenvios;
    // End of variables declaration//GEN-END:variables
     //Metodo que permite extraer los nombres de los productos de la tabla "productos" y colocarlos como
    //elementos de las lista del cmbboxproductos
    private void cargarProducto(JComboBox c) {
       cls_conexion con= new cls_conexion();
        Connection cn=con.getConnection();
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        c.setModel(combo);
        Listado_Productos lp = new Listado_Productos();
        try{
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery("SELECT nombre_producto FROM productos");
            while (rs.next()) {                
               Producto pro = new Producto();
               pro.setNom_producto(rs.getString(1));
               lp.AgregarProductos(pro);
               combo.addElement(pro.getNom_producto());
               System.out.println("Exito");
            }
        }catch (Exception e){
            System.out.println("ERROR,NO SE PUEDE MOSTRAR COMBO"+e);
        }
    }
    //Metodo que permite extraer los nombres de las empresas de los clientes de la tabla "clientes" y colocarlos como
    //elementos de las lista del cmbboxclientes
    private void cargarCliente(JComboBox c) {
      cls_conexion con= new cls_conexion();
        Connection cn=con.getConnection();
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        c.setModel(combo);
        Listados_Clientes lc = new Listados_Clientes();
        try{
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery("SELECT nombre_empresa FROM clientes");
            while (rs.next()) {                
               Cliente cl = new Cliente();
               cl.setNom_cliente(rs.getString(1));
               lc.AgregarClientes(cl);
               combo.addElement(cl.getNom_cliente());
               System.out.println("Exito");
            }
        }catch (Exception e){
            System.out.println("ERROR,NO SE PUEDE MOSTRAR COMBO"+e);
        }
    }
    }
