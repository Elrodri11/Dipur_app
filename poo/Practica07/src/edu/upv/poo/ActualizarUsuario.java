/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upv.poo;

import edu.upv.poo.dataaccess.PersonaDao;
import edu.upv.poo.dataaccess.UsuarioDao;
import edu.upv.poo.dbmodels.Persona;
import edu.upv.poo.dbmodels.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class ActualizarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form ActualizarUsuario
     */
    String nombre;
    public ActualizarUsuario(String nombre) {
        initComponents();
        this.nombre = nombre;
        this.labelExiste.setVisible(false);
        this.labelLlenar.setVisible(false);
        llenarDatos();
    }
    
    public void llenarDatos(){
          Usuario usuario = new Usuario();
        try (
                Connection con = DbUtils.getConnection(); 
                Statement stmt = con.createStatement()) {
            UsuarioDao usuarioDao = new UsuarioDao(con);
            usuario = usuarioDao.getByName(this.nombre);
            
            this.editTextContrasena.setText(usuario.getContrasena());
            this.editTextNombre.setText(usuario.getNombre());
            if (usuario.getSuperUsuario() == 1){
                this.btnSuperUsuario.setSelected(true);
            }
            
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

        btnRegresar = new javax.swing.JButton();
        btnSuperUsuario = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        labelLlenar = new javax.swing.JLabel();
        labelExiste = new javax.swing.JLabel();
        editTextNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        editTextContrasena = new javax.swing.JPasswordField();
        btnRegistrarCliente = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnSuperUsuario.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("ACTUALIZAR USUARIO");

        labelLlenar.setForeground(new java.awt.Color(255, 0, 0));
        labelLlenar.setText("Porfavor llene todos los campos");

        labelExiste.setForeground(new java.awt.Color(255, 0, 0));
        labelExiste.setText("Ese nombre de usuario ya existe");

        editTextNombre.setEnabled(false);

        jLabel2.setText("Nombre");

        jLabel3.setText("Contraseña");

        jLabel4.setText("Super usuario");

        btnRegistrarCliente.setText("Actualizar Usuario");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar usuario");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editTextNombre)
                    .addComponent(editTextContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuperUsuario))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLlenar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelExiste, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnRegistrarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1)))
                .addContainerGap(77, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCliente)
                    .addComponent(btnEliminarUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar)
                .addGap(9, 9, 9)
                .addComponent(labelLlenar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelExiste)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        ConsultarUsuarios con = new ConsultarUsuarios();
        con.show();
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
            
        try (
            Connection con = DbUtils.getConnection();
            Statement stmt = con.createStatement()) {
            UsuarioDao usuarioDao = new UsuarioDao(con);

            Usuario e = usuarioDao.getByName(this.nombre);
            Usuario e2 = e;
            
            String contrasena = this.editTextContrasena.getText();

            if (contrasena.isEmpty() == false){
                e.setNombre(nombre);
                e.setContrasena(contrasena);
                int superUsuario = 0;

                if(this.btnSuperUsuario.isSelected()){
                    superUsuario = 1;
                }

                e.setSuperUsuario(superUsuario);
                usuarioDao.update(e2);
                this.labelLlenar.setVisible(false);
            }else{
                this.labelLlenar.setVisible(true);
            }


        } catch (SQLException ex) {
            System.out.println("a");
        }
        

    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        try (
            Connection con = DbUtils.getConnection();
            Statement stmt = con.createStatement()) {
            UsuarioDao usuarioDao = new UsuarioDao(con);
                
            usuarioDao.delete(this.nombre);
            this.btnRegresarActionPerformed(evt);
        } catch (SQLException ex) {
            System.out.println("a");
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarUsuario;
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
