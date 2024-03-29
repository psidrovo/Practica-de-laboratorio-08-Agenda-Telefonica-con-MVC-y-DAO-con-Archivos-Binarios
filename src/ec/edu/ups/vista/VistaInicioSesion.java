/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Usuario;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * VistaInicioSesion
 * 
 * esta interfaz permite al usuario ingresar su correo y contraseña, 
 * si es que existe permite al usuario utilizar las demas itemTabs caso contrario
 * no lo permitira. 
 * 
 * @author Paul Idrovo, Denys Dutan
 */
public class VistaInicioSesion extends javax.swing.JInternalFrame {

    private ControladorTelefono controladorTelefono;
    private ControladorUsuario controladorUsuario;
    private VistaPrincipalApp vistaPrincipal;

    public VistaInicioSesion(VistaPrincipalApp vistaPrincipal, ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono) {

        initComponents();
        //ASIGNAR PARAMETROS
        this.controladorTelefono = controladorTelefono;
        this.controladorUsuario = controladorUsuario;
        this.vistaPrincipal = vistaPrincipal;
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        pswContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btIniciar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setForeground(java.awt.Color.lightGray);
        setTitle("INICIAR SESION");

        lblUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/usuario.png"))); // NOI18N
        lblUsuario.setText("CORREO");

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTitulo.setText("    INICIO DE SESION");

        lblContraseña.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/contraseña.png"))); // NOI18N
        lblContraseña.setText("CONTRASEÑA");

        pswContraseña.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pswContraseña.setMinimumSize(new java.awt.Dimension(90, 30));
        pswContraseña.setPreferredSize(new java.awt.Dimension(90, 30));

        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuario.setMaximumSize(new java.awt.Dimension(90, 30));
        txtUsuario.setMinimumSize(new java.awt.Dimension(90, 30));
        txtUsuario.setPreferredSize(new java.awt.Dimension(90, 30));

        btIniciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btIniciar.setText("INICIAR SESION");
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblContraseña))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(pswContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblTitulo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseña)
                    .addComponent(pswContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btIniciar)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action Event:btIniciarActionPerformed.
     * 
     * este action evento lo que hace es comprobar si es que el correo y 
     * contraseña que ingreso el usuario existen en el archivo de datos. 
     * si es que existe activa unos action tabs y si es que no aparece un option
     * panel informando que se ingreso mal los datos. 
     * 
     * @param evt 
     */
    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
        // TODO add your handling code here:

        String passwordDeco = "";
        char[] password = pswContraseña.getPassword();
        for (int x = 0; x < password.length; x++) {
            passwordDeco += password[x];
        }

        Usuario inicioSesion = controladorUsuario.inicioSesion(txtUsuario.getText(), passwordDeco);
        if (inicioSesion != null) {
            vistaPrincipal.getMisTelefonos().setEnabled(true);
            vistaPrincipal.getIniciarSesion().setEnabled(false);
            vistaPrincipal.getSalir().setEnabled(true);
            vistaPrincipal.getRegistrarse().setEnabled(false);
            vistaPrincipal.getCerrarSesion().setEnabled(true);
            vistaPrincipal.getEditarMisDatos().setEnabled(true);
            txtUsuario.setText("");
            pswContraseña.setText("");
            this.setVisible(false);
            vistaPrincipal.getBienvenido().setText("BIENVENIDO " + inicioSesion.getNombre().toUpperCase().replace("  ", "") + " " + inicioSesion.getApellido().toUpperCase().replace("  ", ""));
            JOptionPane.showMessageDialog(null, "INICIO DE SESION CORRECTO", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "USUARIO Y/O CONTRASEÑA INCORRECTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btIniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciar;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pswContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
