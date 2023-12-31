/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upv.poo;

import edu.upv.poo.dataaccess.PersonaDao;
import edu.upv.poo.dbmodels.Persona;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RegistrarCliente extends javax.swing.JFrame {
    int currentSuperUsuario;
    public RegistrarCliente(int usuario) {
        initComponents();
        setClientId();
        this.labelLlenar.setVisible(false);
        this.currentSuperUsuario = usuario;
    }
    
    private void setClientId(){
        try (
                Connection con = DbUtils.getConnection(); 
                Statement stmt = con.createStatement()) {
            PersonaDao personaDao = new PersonaDao(con);
            
            this.editTextId.setText(String.valueOf(personaDao.getLastId()));
            
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        editTextIdentificacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboTipoIdentificacion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        editTextCorreo = new javax.swing.JTextField();
        editTextNumTarjeta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editTextRfc = new javax.swing.JTextField();
        btnRegistrarCliente = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        editTextId = new javax.swing.JTextField();
        labelLlenar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("REGISTRAR NUEVO CLIENTE");

        jLabel2.setText("Tipo de identificación");

        comboTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acta de nacimiento", "Pasaporte", "Visa" }));
        comboTipoIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoIdentificacionActionPerformed(evt);
            }
        });

        jLabel3.setText("Identificacion");

        jLabel4.setText("Correo Electrónico");

        editTextNumTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTextNumTarjetaActionPerformed(evt);
            }
        });

        jLabel6.setText("Número de tarjeta");

        jLabel7.setText("RFC");

        editTextRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTextRfcActionPerformed(evt);
            }
        });

        btnRegistrarCliente.setText("Registrar Cliente");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel5.setText("Número de cliente");

        editTextId.setEnabled(false);
        editTextId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTextIdActionPerformed(evt);
            }
        });

        labelLlenar.setForeground(new java.awt.Color(255, 0, 0));
        labelLlenar.setText("Porfavor llene todos los campos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(138, 138, 138)
                                    .addComponent(btnRegistrarCliente))
                                .addComponent(btnRegresar))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelLlenar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editTextIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(editTextCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(editTextNumTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(editTextRfc, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(editTextId, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(editTextIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(editTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTextNumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTextRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(editTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnRegistrarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18)
                .addComponent(labelLlenar)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoIdentificacionActionPerformed

    private void editTextNumTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTextNumTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editTextNumTarjetaActionPerformed

    private void editTextRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTextRfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editTextRfcActionPerformed

    private void editTextIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTextIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editTextIdActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MainApp main = new MainApp(this.currentSuperUsuario);
        main.show();
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        try (
            Connection con = DbUtils.getConnection();
            Statement stmt = con.createStatement()) {
            PersonaDao personaDao = new PersonaDao(con);

            Persona e = new Persona();

            String correo = this.editTextCorreo.getText();
            String identificacion = this.editTextIdentificacion.getText();
            String numTarjeta = this.editTextNumTarjeta.getText();
            String rfc = this.editTextRfc.getText();
            String tipoIdentificacion = this.comboTipoIdentificacion.getSelectedItem().toString();

            if (correo.isEmpty() == false && identificacion.isEmpty() == false && numTarjeta.isEmpty() == false && rfc.isEmpty() == false) {
                e.setIdentificacion(identificacion);
                e.setCorreoElectronico(correo);
                e.setNumTarjeta(numTarjeta);
                e.setRfc(rfc);
                e.setTipoIdentificacion(tipoIdentificacion);
                personaDao.insert(e);

                this.setClientId();
                this.editTextCorreo.setText("");
                this.editTextIdentificacion.setText("");
                this.editTextNumTarjeta.setText("");
                this.editTextRfc.setText("");
                this.labelLlenar.setVisible(false);

            }else{
                this.labelLlenar.setVisible(true);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboTipoIdentificacion;
    private javax.swing.JTextField editTextCorreo;
    private javax.swing.JTextField editTextId;
    private javax.swing.JTextField editTextIdentificacion;
    private javax.swing.JTextField editTextNumTarjeta;
    private javax.swing.JTextField editTextRfc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelLlenar;
    // End of variables declaration//GEN-END:variables
}
