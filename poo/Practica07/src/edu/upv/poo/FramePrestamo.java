/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upv.poo;

import edu.upv.poo.dataaccess.AutoDao;
import edu.upv.poo.dataaccess.PersonaDao;
import edu.upv.poo.dataaccess.PrestamoDao;
import edu.upv.poo.dataaccess.UsuarioDao;
import edu.upv.poo.dbmodels.Auto;
import edu.upv.poo.dbmodels.Persona;
import edu.upv.poo.dbmodels.Prestamo;
import edu.upv.poo.dbmodels.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FramePrestamo extends javax.swing.JFrame {
    int currentSuperUsuario;
    public FramePrestamo(int usuario) {
        initComponents();
        this.currentSuperUsuario = usuario;
        this.labelLlenar.setVisible(false);
        llenarDatos();
    }

    private void llenarDatos(){
        this.comboIdAuto.removeAllItems();
        this.comboIdCliente.removeAllItems();
        try (
                
            Connection con = DbUtils.getConnection(); 
            Statement stmt = con.createStatement()) {
            
            AutoDao autoDao = new AutoDao(con);
            PrestamoDao prestamoDao = new PrestamoDao(con);
            PersonaDao personaDao = new PersonaDao(con);
            
            Persona[] personas = personaDao.getAll();
            Auto[] autos = autoDao.getAll();
            edu.upv.poo.dbmodels.Prestamo[] prestamos = prestamoDao.getAll();
            
            for (Persona i: personas) {
                this.comboIdCliente.addItem(String.valueOf(i.getPersonaId()));
            }
            
            for (Auto i: autos){
                edu.upv.poo.dbmodels.Prestamo e = prestamoDao.getById(i.getAutoId());
                if (e == null){
                    this.comboIdAuto.addItem(String.valueOf(i.getAutoId()));
                }
            }
            
            
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }        
    }

    private void actualizarMonto(){
        Date date1 = (Date)this.spinnerFecha.getValue();
        Date date2 = (Date)this.spinnerFechaFinal.getValue();
        
        long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        
        try (
                
            Connection con = DbUtils.getConnection(); 
            Statement stmt = con.createStatement()) {
            
            AutoDao autoDao = new AutoDao(con);
            try{
                Auto auto = autoDao.getById(Integer.valueOf(this.comboIdAuto.getSelectedItem().toString()));
                double montoFinal = diff * auto.getRentaPorDia();
                this.editTextMonto.setText(String.valueOf(montoFinal));
            }catch(Exception e){
                
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboIdAuto = new javax.swing.JComboBox<>();
        comboIdCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        editTextLugarDeRenta = new javax.swing.JTextField();
        editTextMonto = new javax.swing.JTextField();
        btnPrestar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        spinnerFechaFinal = new javax.swing.JSpinner();
        spinnerFecha = new javax.swing.JSpinner();
        labelLlenar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("PRÉSTAMO NUEVO");

        jLabel2.setText("Id del auto a prestar");

        jLabel3.setText("Id del cliente");

        jLabel4.setText("Fecha del préstamo");

        comboIdAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboIdAuto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboIdAutoItemStateChanged(evt);
            }
        });

        comboIdCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Lugar de renta");

        jLabel6.setText("Monto");

        editTextMonto.setEnabled(false);
        editTextMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTextMontoActionPerformed(evt);
            }
        });

        btnPrestar.setText("Confirmar préstamo");
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel8.setText("Fecha de devolución esperada");

        spinnerFechaFinal.setModel(new javax.swing.SpinnerDateModel());
        spinnerFechaFinal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerFechaFinalStateChanged(evt);
            }
        });

        spinnerFecha.setModel(new javax.swing.SpinnerDateModel());
        spinnerFecha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerFechaStateChanged(evt);
            }
        });

        labelLlenar.setForeground(new java.awt.Color(255, 0, 0));
        labelLlenar.setText("Porfavor llene todos los campos con valores adecuados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(btnRegresar)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editTextMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editTextLugarDeRenta, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboIdAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnPrestar)))))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelLlenar)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboIdAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(spinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(spinnerFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(editTextLugarDeRenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTextMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrestar)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addComponent(labelLlenar)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MainApp main = new MainApp(this.currentSuperUsuario);
        main.show();
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void editTextMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTextMontoActionPerformed
        
    }//GEN-LAST:event_editTextMontoActionPerformed

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed
        try (
            Connection con = DbUtils.getConnection();
            Statement stmt = con.createStatement()) {
            PrestamoDao prestamoDao = new PrestamoDao(con);
            
            Prestamo prestamo = new Prestamo();
            
            int idAuto = Integer.valueOf(this.comboIdAuto.getSelectedItem().toString());
            int idCliente = Integer.valueOf(this.comboIdCliente.getSelectedItem().toString());
            SimpleDateFormat DateForm = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            
            String fechaPrestamo = DateForm.format(this.spinnerFecha.getValue());
            String fechaFinal = DateForm.format(this.spinnerFechaFinal.getValue());
            String lugar = this.editTextLugarDeRenta.getText();
            double monto = 0;
            try{
                monto = Double.valueOf(this.editTextMonto.getText());
            }catch (Exception e){
                monto = 0;
            }
            

            if (lugar.isEmpty() == false && monto > 0) {
                prestamo.setFechaRenta(fechaPrestamo);
                prestamo.setFinalRenta(fechaFinal);
                prestamo.setIdAuto(idAuto);
                prestamo.setIdCliente(idCliente);
                prestamo.setMonto(monto);
                prestamo.setLugarDeRenta(lugar);
                prestamoDao.insert(prestamo);
                this.editTextLugarDeRenta.setText("");
                this.editTextMonto.setText("");
                llenarDatos();
                this.labelLlenar.setVisible(false);

            }else{
                this.labelLlenar.setVisible(true);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
                

    }//GEN-LAST:event_btnPrestarActionPerformed

    private void spinnerFechaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerFechaStateChanged
  
        this.actualizarMonto();
    }//GEN-LAST:event_spinnerFechaStateChanged

    private void spinnerFechaFinalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerFechaFinalStateChanged
        this.actualizarMonto();
    }//GEN-LAST:event_spinnerFechaFinalStateChanged

    private void comboIdAutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboIdAutoItemStateChanged
        this.actualizarMonto();
    }//GEN-LAST:event_comboIdAutoItemStateChanged



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrestar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboIdAuto;
    private javax.swing.JComboBox<String> comboIdCliente;
    private javax.swing.JTextField editTextLugarDeRenta;
    private javax.swing.JTextField editTextMonto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelLlenar;
    private javax.swing.JSpinner spinnerFecha;
    private javax.swing.JSpinner spinnerFechaFinal;
    // End of variables declaration//GEN-END:variables
}
