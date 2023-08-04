/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upv.poo;

import edu.upv.poo.dataaccess.PrestamoDao;
import edu.upv.poo.dataaccess.UsuarioDao;
import edu.upv.poo.dbmodels.Prestamo;
import edu.upv.poo.dbmodels.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Devoluciones extends javax.swing.JFrame {
    int currentSuperUsuario;
    public Devoluciones(int usuario) {
        initComponents();
        this.currentSuperUsuario = usuario;
        this.llenarTabla();
    }

    public void llenarTabla(){
        try (
                Connection con = DbUtils.getConnection(); 
                Statement stmt = con.createStatement()) {
                PrestamoDao prestamoDao = new PrestamoDao(con);
            
            Prestamo[] prestamo = prestamoDao.getAll();
            DefaultTableModel model  =  (DefaultTableModel) this.tablePersonas.getModel();
            
            for (Prestamo i : prestamo) {
                
                Object[] row = {String.valueOf(i.getIdAuto()),String.valueOf(i.getIdCliente()),i.getFechaRenta(),i.getFinalRenta(),i.getLugarDeRenta(),String.valueOf(i.getMonto())};
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        editTextModiifcarPrestamo = new javax.swing.JTextField();
        btnModificarPrestamo = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersonas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id del auto");

        editTextModiifcarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTextModiifcarPrestamoActionPerformed(evt);
            }
        });

        btnModificarPrestamo.setText("Modificar prestamo");
        btnModificarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPrestamoActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tablePersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de auto", "Número de cliente", "Fecha del préstamo", "Fecha esperada de devolución", "Lugar de renta", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePersonas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editTextModiifcarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarPrestamo)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnRegresar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnRegresar)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(editTextModiifcarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarPrestamo))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editTextModiifcarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTextModiifcarPrestamoActionPerformed
        
    }//GEN-LAST:event_editTextModiifcarPrestamoActionPerformed

    private void btnModificarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPrestamoActionPerformed
        if(this.editTextModiifcarPrestamo.getText().isEmpty() == false){
            try{
                int id = Integer.valueOf(this.editTextModiifcarPrestamo.getText());
                Devolucion actualizar = new Devolucion(id,this.currentSuperUsuario);
                actualizar.show();
                dispose();
            } catch(Exception e){

            }
        }
    }//GEN-LAST:event_btnModificarPrestamoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MainApp main = new MainApp(this.currentSuperUsuario);
        main.show();
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificarPrestamo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField editTextModiifcarPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePersonas;
    // End of variables declaration//GEN-END:variables
}
