/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upv.poo;


public class MainApp extends javax.swing.JFrame {

    /**
     * Creates new form MainApp
     */
    int currentSuperUsuario;
    public MainApp(int usuario) {
        initComponents();
        this.currentSuperUsuario = usuario;
        if (this.currentSuperUsuario == 0){
            this.btnConsultarAutos.setEnabled(false);
            this.btnConsultarAutos.setVisible(false);
            this.btnRegistrarUsuarios.setVisible(false);
            this.btnRegistrarUsuarios.setEnabled(false);
            this.btnRegistrarAutos.setEnabled(false);
            this.btnRegistrarAutos.setVisible(false);
            this.btnConsultarUsuarios.setVisible(false);
            this.btnConsultarUsuarios.setEnabled(false);
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
        btnConsultarClientes = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        btnRegistrarUsuarios = new javax.swing.JButton();
        btnConsultarUsuarios = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnRegistrarAutos = new javax.swing.JButton();
        btnConsultarAutos = new javax.swing.JButton();
        btnDevolucion = new javax.swing.JButton();
        btnPrestamo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("RENTA DE CARROS");

        btnConsultarClientes.setText("Consultar clientes");
        btnConsultarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarClientesActionPerformed(evt);
            }
        });

        btnRegistrarCliente.setText("Registrar clientes");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnRegistrarUsuarios.setText("Registrar usuarios");
        btnRegistrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuariosActionPerformed(evt);
            }
        });

        btnConsultarUsuarios.setText("Consultar usuarios");
        btnConsultarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarUsuariosActionPerformed(evt);
            }
        });

        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnRegistrarAutos.setText("Registrar autos");
        btnRegistrarAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAutosActionPerformed(evt);
            }
        });

        btnConsultarAutos.setText("Consultar autos");
        btnConsultarAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarAutosActionPerformed(evt);
            }
        });

        btnDevolucion.setText("Devolución");
        btnDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucionActionPerformed(evt);
            }
        });

        btnPrestamo.setText("Prestamo");
        btnPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrarAutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDevolucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPrestamo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultarAutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addComponent(jLabel1))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarClientes)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarCliente)
                .addGap(18, 18, 18)
                .addComponent(btnPrestamo)
                .addGap(18, 18, 18)
                .addComponent(btnDevolucion)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarUsuarios)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarUsuarios)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarAutos)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarAutos)
                .addGap(18, 18, 18)
                .addComponent(btnCerrarSesion)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClientesActionPerformed
        ConsultarClientes consultar = new ConsultarClientes(this.currentSuperUsuario);
        consultar.show();
        dispose();
    }//GEN-LAST:event_btnConsultarClientesActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        RegistrarCliente reg = new RegistrarCliente(this.currentSuperUsuario);
        reg.show();
        dispose();
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnRegistrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuariosActionPerformed
       RegistrarUsuarios con = new RegistrarUsuarios();
       con.show();
       dispose();
    }//GEN-LAST:event_btnRegistrarUsuariosActionPerformed

    private void btnConsultarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarUsuariosActionPerformed
       ConsultarUsuarios con = new ConsultarUsuarios();
       con.show();
       dispose();
    }//GEN-LAST:event_btnConsultarUsuariosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Login login = new Login();
        login.show();
        dispose();  
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnRegistrarAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAutosActionPerformed
        RegistrarAuto registrar = new RegistrarAuto();
        registrar.show();
        dispose();
    }//GEN-LAST:event_btnRegistrarAutosActionPerformed

    private void btnConsultarAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarAutosActionPerformed
        ConsultarAutos consultar = new ConsultarAutos();
        consultar.show();
        dispose();
    }//GEN-LAST:event_btnConsultarAutosActionPerformed

    private void btnDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucionActionPerformed
        Devoluciones d = new Devoluciones(this.currentSuperUsuario);
        d.show();
        dispose();
    }//GEN-LAST:event_btnDevolucionActionPerformed

    private void btnPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamoActionPerformed
        FramePrestamo frame = new FramePrestamo(this.currentSuperUsuario);
        frame.show();
        dispose();
    }//GEN-LAST:event_btnPrestamoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultarAutos;
    private javax.swing.JButton btnConsultarClientes;
    private javax.swing.JButton btnConsultarUsuarios;
    private javax.swing.JButton btnDevolucion;
    private javax.swing.JButton btnPrestamo;
    private javax.swing.JButton btnRegistrarAutos;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegistrarUsuarios;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}