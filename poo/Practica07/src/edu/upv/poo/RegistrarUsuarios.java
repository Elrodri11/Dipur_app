/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upv.poo;

import edu.upv.poo.dataaccess.UsuarioDao;
import edu.upv.poo.dbmodels.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class RegistrarUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarUsuarios
     */
    public RegistrarUsuarios() {
        initComponents();
        this.labelLlenar.setVisible(false);
        this.labelExiste.setVisible(false);
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
        editTextNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editTextContrasena = new javax.swing.JPasswordField();
        btnRegistrarCliente = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        labelLlenar = new javax.swing.JLabel();
        labelExiste = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSuperUsuario = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("REGISTRAR NUEVO USUARIO");

        jLabel2.setText("Nombre");

        jLabel3.setText("Contraseña");

        btnRegistrarCliente.setText("Registrar Usuario");
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

        labelLlenar.setForeground(new java.awt.Color(255, 0, 0));
        labelLlenar.setText("Porfavor llene todos los campos");

        labelExiste.setForeground(new java.awt.Color(255, 0, 0));
        labelExiste.setText("Ese nombre de usuario ya existe");

        jLabel4.setText("Super usuario");

        btnSuperUsuario.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(labelExiste)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelLlenar)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRegresar)
                            .addGap(37, 37, 37)
                            .addComponent(btnRegistrarCliente))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(editTextNombre)
                                .addComponent(editTextContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSuperUsuario)))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(editTextContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnSuperUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnRegistrarCliente))
                .addGap(18, 18, 18)
                .addComponent(labelLlenar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelExiste)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed

        
        try (
            Connection con = DbUtils.getConnection();
            Statement stmt = con.createStatement()) {
            UsuarioDao usuarioDao = new UsuarioDao(con);

            Usuario e = new Usuario();

            String nombre = this.editTextNombre.getText();
            String contrasena = this.editTextContrasena.getText();
            Usuario a = usuarioDao.getByName(nombre);
            
            if (a == null){
                this.labelExiste.setVisible(false);
                if (nombre.isEmpty() == false && contrasena.isEmpty() == false){
                    e.setNombre(nombre);
                    e.setContrasena(contrasena);
                    int superUsuario = 0;
                    
                    if(this.btnSuperUsuario.isSelected()){
                        superUsuario = 1;
                    }
                    
                    e.setSuperUsuario(superUsuario);
                    usuarioDao.insert(e);
                    this.labelLlenar.setVisible(false);
                }else{
                    this.labelLlenar.setVisible(true);
                }
            }else{
                this.labelExiste.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println("a");
        }
        
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MainApp main = new MainApp(1);
        main.show();
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JCheckBox btnSuperUsuario;
    private javax.swing.JPasswordField editTextContrasena;
    private javax.swing.JTextField editTextNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelExiste;
    private javax.swing.JLabel labelLlenar;
    // End of variables declaration//GEN-END:variables
}
