/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Conexion.cls_conexion;
import Conexion.id_ai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author Iber Ramos Tzir
 */
public class clientes extends javax.swing.JFrame {
DefaultTableModel modelo;
    String[] titulos={"ID Clientes","P. Nombre","S. Nombre","Apellido","DPI","Direccion","Telefono","Empresa","NIT"};
    String[] datos=new String[9];
    String idclientes;
    
    
    public clientes() {
        initComponents();
        setLocationRelativeTo(null);
        popupTable();
        
        this.setTitle(" CLIENTES ");
        this.setLocation(400,220);
       
    }
        public void eliminarRegistro(String valor){
        String sSQL="";
        try{
          cls_conexion mysql= new cls_conexion();
          Connection cn= mysql.getConnection();
          sSQL="Delete from clientes where idclientes='"+valor+"';";
          try{
            PreparedStatement pst=cn.prepareStatement(sSQL);
            int n= pst.executeUpdate();
            if(n>0){
              JOptionPane.showMessageDialog(this, "El registro se elimino correctamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);  
            }
            mostrar("clientes");
          }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error"+ex, "Error", JOptionPane.ERROR_MESSAGE); 
          }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error"+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
        void editarRegistro(String valor){
        String sSQL="";
        String nom1="", nom2="",ap="", dpi="", dir="", emp="";
        int cliente=0, tel=0,nit=0;
      
        try{
            cls_conexion mysql =new cls_conexion();
          Connection cn= mysql.getConnection();
          sSQL= "Select*from clientes where idclientes="+valor+";";
          try{
             Statement st= cn.createStatement();
             ResultSet rs= st.executeQuery(sSQL);
             while(rs.next()){
               cliente=rs.getInt("idclientes");
               nom1=rs.getString("primer_nombre");
               nom2=rs.getString("segundo_nombre");
               ap=rs.getString("apellidos");
               dpi=rs.getString("dpi");
               dir=rs.getString("direccion");
               tel=rs.getInt("telefono");
               emp=rs.getString("nombre_empresa");
               nit=rs.getInt("numero_nit");
             }
             jtextid.setText(""+cliente);
             jtextpnom.setText(nom1);
             jtextsnom.setText(nom2);
             jtextap.setText(ap);                         
             jtextdpi.setText(dpi);
             jtextdir.setText(dir);
             jtexttel.setText(""+tel);
             jtextemp.setText(emp);
             jtextnit.setText(""+nit);
            
             
                      
          }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error"+e, "Error", JOptionPane.ERROR_MESSAGE);  
          }
        }catch(Exception e){
           JOptionPane.showMessageDialog(this, "Error en la conexion"+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
                
}
    public void popupTable(){
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Editar Registro");
        
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        int fila = tblaclientes.getSelectedRow();
        if(fila>=0){
            jtextid.setText(tblaclientes.getValueAt(fila, 0).toString());
            jtextpnom.setText(tblaclientes.getValueAt(fila, 1).toString());
            jtextsnom.setText(tblaclientes.getValueAt(fila, 2).toString());
            jtextap.setText(tblaclientes.getValueAt(fila, 3).toString());
            jtextdpi.setText(tblaclientes.getValueAt(fila, 4).toString());
            jtextdir.setText(tblaclientes.getValueAt(fila, 5).toString());
            jtexttel.setText(tblaclientes.getValueAt(fila, 6).toString());
            jtextemp.setText(tblaclientes.getValueAt(fila, 7).toString());
            jtextnit.setText(tblaclientes.getValueAt(fila, 8).toString());
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Fila no encontrada");
            
        }
            }
        });
        popupMenu.add(menuItem1);
        tblaclientes.setComponentPopupMenu(popupMenu);
    }
    public void mostrar(String tabla){
        String sql = "select * from " + tabla;
        Statement st;
        cls_conexion con = new cls_conexion();
        Connection conexion = con.getConnection();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Primer Nombre");
        model.addColumn("Segundo Nombre");
        model.addColumn("Apellidos");
        model.addColumn("DPI");
        model.addColumn("Direccion");
        model.addColumn("Telefono");
        model.addColumn("Empresa");
        model.addColumn("NIT");
        tblaclientes.setModel(model);
        
        String [] datos = new String[9];
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
            datos[5]=rs.getString(6);
            datos[6]=rs.getString(7);
            datos[7]=rs.getString(8);
            datos[8]=rs.getString(9);
            model.addRow(datos);
         }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        }
             
    }
    
    
    
    //void CargarTabla(int valor){
        
    //    String sSQL="";
    //    modelo=new DefaultTableModel(null,titulos);
    //    cls_conexion mysql=new cls_conexion();
    //    Connection cn=mysql.getConnection();
    //    sSQL="SELECT * FROM clientes WHERE idclientes LIKE '%"+valor+"%'";
    //    try{
    //        Statement st=cn.createStatement();
    //        ResultSet rs=st.executeQuery(sSQL);
    //      while(rs.next()){
    //            datos[0]=rs.getString("idclientes");
    //            datos[1]=rs.getString("primer_nombre");
    //            datos[2]=rs.getString("segundo_nombre");
    //            datos[3]=rs.getString("apellidos");
    //            datos[4]=rs.getString("dpi");
    //            datos[5]=rs.getString("direccion");
    //            datos[6]=rs.getString("telefono");
    //            datos[7]=rs.getString("nombre_empresa");
    //            datos[8]=rs.getString("numero_nit");            
    //            modelo.addRow(datos);
    //        }
    //        tblaclientes.setModel(modelo);
    //    }catch(SQLException ex){
    //       JOptionPane.showMessageDialog(null,"Error "+ex ,"Error", JOptionPane.ERROR_MESSAGE);
    //  }
    //}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnvolver = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtextpnom = new javax.swing.JTextField();
        jtextsnom = new javax.swing.JTextField();
        jtextap = new javax.swing.JTextField();
        jtextdpi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtextdir = new javax.swing.JTextField();
        jtexttel = new javax.swing.JTextField();
        jtextemp = new javax.swing.JTextField();
        jtextnit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaclientes = new javax.swing.JTable();
        jbtnclientes = new javax.swing.JButton();
        jbtnmodificar = new javax.swing.JButton();
        jbtneliminar = new javax.swing.JButton();
        jtextid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/client.png"))); // NOI18N

        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salirr.png"))); // NOI18N
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar.png"))); // NOI18N
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("CONTROL DE CLIENTES");

        jLabel1.setForeground(new java.awt.Color(102, 0, 204));
        jLabel1.setText("Primer Nombre:");

        jLabel3.setForeground(new java.awt.Color(102, 0, 204));
        jLabel3.setText("Segundo Nombre:");

        jLabel4.setForeground(new java.awt.Color(102, 0, 204));
        jLabel4.setText("Apellidos:");

        jLabel5.setForeground(new java.awt.Color(102, 0, 204));
        jLabel5.setText("DPI:");

        jtextpnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextpnomActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(102, 0, 204));
        jLabel6.setText("Dirección:");

        jLabel7.setForeground(new java.awt.Color(102, 0, 204));
        jLabel7.setText("Telefono:");

        jLabel8.setForeground(new java.awt.Color(102, 0, 204));
        jLabel8.setText("Empresa:");

        jLabel9.setForeground(new java.awt.Color(102, 0, 204));
        jLabel9.setText("NIT");

        tblaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "P. Nombre", "S.Nombre", "Apellido", "DPI", "Direccion", "Telefono", "Empresa", "NIT"
            }
        ));
        tblaclientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblaclientes);

        jbtnclientes.setText("Mostrar");
        jbtnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnclientesActionPerformed(evt);
            }
        });

        jbtnmodificar.setText("Modificar");
        jbtnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnmodificarActionPerformed(evt);
            }
        });

        jbtneliminar.setText("Eliminar");
        jbtneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtneliminarActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(102, 0, 204));
        jLabel10.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jbtnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtneliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4)))
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtextsnom, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jtextdpi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(99, 99, 99)
                                                        .addComponent(jtextnit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jtextpnom, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jtextap, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7))
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel8)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtextemp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtextdir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtexttel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtextid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel11))))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnmodificar)
                        .addComponent(jbtneliminar)
                        .addComponent(jbtnclientes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jtextpnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jtextdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtextsnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(jtexttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jtextap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jtextemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jtextdpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jtextnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtextid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnvolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        this.setVisible(false);
        Menu ventana = new Menu ();
        ventana.setVisible (true);

        this.dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
     jtextpnom.setText(null);
     jtextsnom.setText(null);
     jtextap.setText(null);
     jtextdpi.setText(null);
     jtextdir.setText(null);
     jtextemp.setText(null);
     jtextnit.setText(null);
     jtexttel.setText(null);
     jtextid.setText(null);
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void jtextpnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextpnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextpnomActionPerformed

    private void jbtnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnclientesActionPerformed
     mostrar("clientes");
    }//GEN-LAST:event_jbtnclientesActionPerformed

    private void jbtnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnmodificarActionPerformed
        cls_conexion cn = new cls_conexion();
        Connection conexion = cn.getConnection();
       try{ 
         
        PreparedStatement pps = conexion.prepareStatement("UPDATE clientes SET primer_nombre='"+jtextpnom.getText()+"',segundo_Nombre='"+jtextsnom.getText()+"',apellidos='"+jtextap.getText()+"',dpi='"+jtextdpi.getText()+"',direccion='"
        +jtextdir.getText()+"',telefono='"+jtexttel.getText()+"',nombre_empresa='"+jtextemp.getText()+"',numero_nit='"+jtextnit.getText()+"' WHERE idclientes='"+jtextid.getText()+"'");
        pps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos Actualizados");
        mostrar("clientes");
        
        
       }catch(SQLException ex){
           
       }
        
    }//GEN-LAST:event_jbtnmodificarActionPerformed

    private void jbtneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneliminarActionPerformed
          int fila;
      try{
       fila= tblaclientes.getSelectedRow();
       if(fila==-1){
         JOptionPane.showMessageDialog(this, "No ha selecionado ninguna fial", "Error", JOptionPane.ERROR_MESSAGE);   
       }else{
          modelo= (DefaultTableModel)tblaclientes.getModel();
          idclientes=(String)modelo.getValueAt(fila, 0);
          int opcion=JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro? "+idclientes);
          if(opcion==0){
              eliminarRegistro(idclientes);
          }
       } 
      }catch(Exception e){
          
      }
    }//GEN-LAST:event_jbtneliminarActionPerformed

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
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnclientes;
    private javax.swing.JButton jbtneliminar;
    private javax.swing.JButton jbtnmodificar;
    private javax.swing.JTextField jtextap;
    private javax.swing.JTextField jtextdir;
    private javax.swing.JTextField jtextdpi;
    private javax.swing.JTextField jtextemp;
    private javax.swing.JTextField jtextid;
    private javax.swing.JTextField jtextnit;
    private javax.swing.JTextField jtextpnom;
    private javax.swing.JTextField jtextsnom;
    private javax.swing.JTextField jtexttel;
    public javax.swing.JTable tblaclientes;
    // End of variables declaration//GEN-END:variables
}
