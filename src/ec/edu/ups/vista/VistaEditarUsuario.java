/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Usuario;
import javax.swing.JOptionPane;

/**
 * VistaEditarUsuario
 * 
 * Esta interfaz permite al usuario editar sus datos personales.
 * 
 * @author Paul Idrovo, Denys Dutan
 */
public class VistaEditarUsuario extends javax.swing.JInternalFrame {

    private ControladorTelefono controladorTelefono;
    private ControladorUsuario controladorUsuario;
    private VistaPrincipalApp vistaPrincipal;
    
    public VistaEditarUsuario(ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono, VistaPrincipalApp vistaPrincipal) {
        initComponents();
        this.controladorTelefono = controladorTelefono;
        this.controladorUsuario = controladorUsuario;
        this.vistaPrincipal = vistaPrincipal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btGuardarDatos = new javax.swing.JButton();
        lblApellido = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        pwsPassword = new javax.swing.JPasswordField();
        pwsConfirmar = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDITAR DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18))); // NOI18N

        btGuardarDatos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btGuardarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/salvar.png"))); // NOI18N
        btGuardarDatos.setText("GUARDAR DATOS");
        btGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarDatosActionPerformed(evt);
            }
        });

        lblApellido.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblApellido.setText("APELLIDO");

        lblCorreo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblCorreo.setText("CORREO");

        txtCedula.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblNombre.setText("NOMBRE");

        lblCedula.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblCedula.setText("CEDULA");

        lblConfirmPassword.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblConfirmPassword.setText("CONFIRMAR");

        lblPassword.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblPassword.setText("CONTRASEÑA");

        pwsPassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        pwsConfirmar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblCedula)
                            .addComponent(lblApellido)
                            .addComponent(lblCorreo))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtApellido)
                            .addComponent(txtCorreo)
                            .addComponent(txtCedula)
                            .addComponent(txtNombre))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword)
                            .addComponent(lblConfirmPassword))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwsPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(pwsConfirmar))
                        .addGap(36, 36, 36))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btGuardarDatos)
                .addGap(135, 135, 135))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellido))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCorreo))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwsPassword))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwsConfirmar))
                .addGap(18, 18, 18)
                .addComponent(btGuardarDatos)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action Event:btGuardarDatosActionPerformed.
     * 
     * este action event primero comprueba que todos los campos estén completos.
     * Una vez comprobado llama al controlador usuario para que actualiza los 
     * datos obtenidos de los textbox.
     * 
     * @param evt 
     */
    private void btGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarDatosActionPerformed
        String password = "";
        char[] password2 = pwsPassword.getPassword();
        for (int x = 0; x < password2.length; x++) {
            password += password2[x];
        }
        String confirmar = "";
        char[] confirmar2 = pwsConfirmar.getPassword();
        for (int x = 0; x < confirmar2.length; x++) {
            confirmar += confirmar2[x];
        }
        if (confirmar.equals(password)) {

            if (txtNombre.getText().equals("") || password.equals("") || txtApellido.getText().equals("") || txtCedula.getText().equals("") || txtCorreo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                controladorUsuario.actualizarDatos(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), password);                
                vistaPrincipal.getBienvenido().setText("BIENVENIDO " + txtNombre.getText().toUpperCase() + " " + txtApellido.getText().toUpperCase());
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS", "DATOS", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "CONTRASEÑAS NO CONINCIDEN", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       
         
    }//GEN-LAST:event_btGuardarDatosActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped

    }//GEN-LAST:event_txtCedulaKeyTyped

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        cargarDatos();
    }//GEN-LAST:event_formInternalFrameActivated

    public void cargarDatos(){
        Usuario datosusuario = controladorUsuario.verUsuario();
        txtCedula.setText(datosusuario.getCedula());
        txtNombre.setText(datosusuario.getNombre());
        txtApellido.setText(datosusuario.getApellido());
        txtCorreo.setText(datosusuario.getCorreo());
        pwsPassword.setText(datosusuario.getContrasena());
        pwsConfirmar.setText(datosusuario.getContrasena());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGuardarDatos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPasswordField pwsConfirmar;
    private javax.swing.JPasswordField pwsPassword;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
