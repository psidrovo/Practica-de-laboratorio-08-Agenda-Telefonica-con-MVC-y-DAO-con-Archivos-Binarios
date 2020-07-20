/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 * VistaRegistrar
 * 
 * Esta interfaz permite al usuario registrarse si es que no tiene un cuenta exsistente.
 * 
 * @author Paul Idrovo, Denys Dutan
 */
public class VistaRegistrar extends javax.swing.JInternalFrame {

    private ControladorTelefono controladorTelefono;
    private ControladorUsuario controladorUsuario;

    public VistaRegistrar(ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono) {
        initComponents();
        this.controladorTelefono = controladorTelefono;
        this.controladorUsuario = controladorUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        pwsPassword = new javax.swing.JPasswordField();
        pwsConfirmar = new javax.swing.JPasswordField();
        btRegistrar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("REGISTRAR");

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTitulo.setText("REGISTRAR");

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblNombre.setText("NOMBRE");

        lblCedula.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblCedula.setText("CEDULA");

        lblApellido.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblApellido.setText("APELLIDO");

        lblCorreo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblCorreo.setText("CORREO");

        lblPassword.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblPassword.setText("CONTRASEÑA");

        lblConfirmPassword.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblConfirmPassword.setText("CONFIRMAR");

        txtCedula.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        pwsPassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        pwsConfirmar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btRegistrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/salvar.png"))); // NOI18N
        btRegistrar.setText("REGISTRAR");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblCedula)
                    .addComponent(lblApellido)
                    .addComponent(lblCorreo)
                    .addComponent(lblPassword)
                    .addComponent(lblConfirmPassword))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtApellido)
                    .addComponent(txtCorreo)
                    .addComponent(pwsPassword)
                    .addComponent(pwsConfirmar)
                    .addComponent(txtCedula)
                    .addComponent(txtNombre))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRegistrar)
                    .addComponent(lblTitulo))
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellido))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCorreo))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwsPassword))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwsConfirmar))
                .addGap(28, 28, 28)
                .addComponent(btRegistrar)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char validar = evt.getKeyChar();
        int asscii = (int) validar;
        if (!Character.isDigit(validar) && asscii != 8) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NUMEROS", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    /**
     * Action Event:btRegistrarActionPerformed.
     * 
     * este action event lo que hace es recibir todos los datos ingresado en
     * los cajones de texto y pasa esos datos al controlador para que cree un 
     * nuevo usuario. Al final esconde esa vista y borra los datos de los 
     * textbox. 
     * 
     * @param evt 
     */
    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
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
        if (confirmar.equals(password)&& confirmar.length()==8) {

            if (txtNombre.getText().equals("") || password.equals("") || txtApellido.getText().equals("") || txtCedula.getText().equals("") || txtCorreo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if(txtCedula.getText().length()==10){
                    controladorUsuario.registrar(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), password);
                    this.setVisible(false);
                    txtApellido.setText("");
                    txtCedula.setText("");
                    txtCorreo.setText("");
                    txtNombre.setText("");
                    pwsConfirmar.setText("");
                    pwsPassword.setText("");
                    JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "TAMAÑO DE CEDULA NO VALIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "CONTRASEÑAS NO CONINCIDEN O NO TIENEN 8 CARACTERES", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    public void cambiarIdiomaVistaRegistrar(ResourceBundle mensajes) {
        lblTitulo.setText(mensajes.getString("registrarse"));
        lblCedula.setText(mensajes.getString("cedula"));
        lblApellido.setText(mensajes.getString("apellido"));
        lblConfirmPassword.setText(mensajes.getString("confirmar"));
        lblCorreo.setText(mensajes.getString("correo"));
        lblNombre.setText(mensajes.getString("nombre"));
        lblPassword.setText(mensajes.getString("contrasena"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistrar;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField pwsConfirmar;
    private javax.swing.JPasswordField pwsPassword;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
