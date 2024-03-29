/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * VistaDirectorioGeneral
 * Esta vista se encragara de listar todos lo telefono que existan dentro del archivo,
 * a la misma vez permitira al usuario buscar a otros usuarios por su cedula o por su correo.
 * 
 * 
 * @author Paul Idrovo, Denys Dutan
 */
public class VistaDirectorioGeneral extends javax.swing.JInternalFrame {
    
    private ControladorTelefono controladorTelefono;
    private ControladorUsuario controladorUsuario;
    
    public VistaDirectorioGeneral(ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono) {
        initComponents();
        this.controladorTelefono = controladorTelefono;
        this.controladorUsuario = controladorUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdTipoDato = new javax.swing.JComboBox<>();
        btBuscar = new javax.swing.JButton();
        txtDatoBusqueda = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        btListarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDirectorioGeneral = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblNombre1 = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("DIRECTORIO GENERAL");
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

        cmdTipoDato.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdTipoDato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR TIPO", "CORREO", "CEDULA" }));

        btBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/buscar.png"))); // NOI18N
        btBuscar.setText("BUSCAR");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        txtDatoBusqueda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtDatoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDatoBusquedaKeyTyped(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTitulo.setText("DIRECTORIO GENERAL");

        btListarTodos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btListarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/agenda.png"))); // NOI18N
        btListarTodos.setText("TODO DIRECTORIO");
        btListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarTodosActionPerformed(evt);
            }
        });

        tblDirectorioGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero", "Tipo", "Operadora"
            }
        ));
        jScrollPane1.setViewportView(tblDirectorioGeneral);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18))); // NOI18N

        lblNombre1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblNombre1.setText("NOMBRE");

        lblCedula.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblCedula.setText("CEDULA");

        lblApellido1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblApellido1.setText("APELLIDO");

        lblCorreo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblCorreo.setText("CORREO");

        txtCedula.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCedula.setEnabled(false);
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNombre.setEnabled(false);

        txtApellido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtApellido.setEnabled(false);

        txtCorreo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCorreo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre1)
                    .addComponent(lblCedula)
                    .addComponent(lblApellido1)
                    .addComponent(lblCorreo))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(txtCorreo)
                    .addComponent(txtCedula)
                    .addComponent(txtNombre))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellido))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCorreo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmdTipoDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(txtDatoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(236, 236, 236))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(btListarTodos))
            .addGroup(layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(lblTitulo))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdTipoDato, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btListarTodos)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDatoBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatoBusquedaKeyTyped
        if (cmdTipoDato.getSelectedItem().toString().equals("CEDULA")) {
            char validar = evt.getKeyChar();
            int asscii = (int) validar;
            if (!Character.isDigit(validar) && asscii != 8) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "INGRESE SOLO NUMEROS PARA LA CEDULA", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtDatoBusquedaKeyTyped

    /**
     * Action Event:btListarTodosActionPerformed.
     * 
     * este action event lo que hace es actualizar la vista. 
     * @param evt 
     */
    private void btListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarTodosActionPerformed
        ActualizarTabla();
    }//GEN-LAST:event_btListarTodosActionPerformed
    
    public void ActualizarTabla() {
        List<Telefono> listaTelefonos = controladorTelefono.verTelefonosGeneral();
        
        DefaultTableModel modelo = (DefaultTableModel) tblDirectorioGeneral.getModel();
        modelo.setRowCount(0);
        tblDirectorioGeneral.setModel(modelo);
        Object[] fila = new Object[4];
        
        for (Telefono telefono : listaTelefonos) {
            fila[0] = telefono.getCodigo();
            fila[1] = telefono.getNumero();
            fila[2] = telefono.getTipo();
            fila[3] = telefono.getOperadora();
            modelo.addRow(fila);
        }
        this.tblDirectorioGeneral.setModel(modelo);
    }
    
    /**
     * Action Event:btBuscarActionPerformed.
     * 
     * este action event lo que hace es busacr al usuario y sus teléfonos 
     * por cedula o por correo. 
     * 
     * @param evt 
     */
    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if (cmdTipoDato.getSelectedItem().toString().equals("SELECCIONAR TIPO")) {
            JOptionPane.showMessageDialog(null, "SELECIONE EL TIPO DE DATO", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        } else {
            if (txtDatoBusqueda.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "INGRESE UN VALOR", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
            } else {
                List<Telefono> listaTelefonos = controladorTelefono.verTelefonosUsuarioBusqueda(txtDatoBusqueda.getText(), cmdTipoDato.getSelectedItem().toString());
                if (listaTelefonos != null) {
                    DefaultTableModel modelo = (DefaultTableModel) tblDirectorioGeneral.getModel();
                    modelo.setRowCount(0);
                    tblDirectorioGeneral.setModel(modelo);
                    Object[] fila = new Object[4];
                    
                    for (Telefono telefono : listaTelefonos) {
                        fila[0] = telefono.getCodigo();
                        fila[1] = telefono.getNumero();
                        fila[2] = telefono.getTipo();
                        fila[3] = telefono.getOperadora();
                        modelo.addRow(fila);
                    }
                    this.tblDirectorioGeneral.setModel(modelo);
                    Usuario usuarioBuscado = controladorUsuario.cargarDatosUsuario(txtDatoBusqueda.getText(), cmdTipoDato.getSelectedItem().toString());
                    txtNombre.setText(usuarioBuscado.getNombre());
                    txtApellido.setText(usuarioBuscado.getApellido());
                    txtCedula.setText(usuarioBuscado.getCedula());
                    txtCorreo.setText(usuarioBuscado.getCorreo().replace(" ", ""));
                } else {
                    JOptionPane.showMessageDialog(null, "NO EXISTE USUARIO", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char validar = evt.getKeyChar();
        int asscii = (int) validar;
        if (!Character.isDigit(validar) && asscii != 8) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NUMEROS", "ERROR DE DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        DefaultTableModel modelo = (DefaultTableModel) tblDirectorioGeneral.getModel();
        modelo.setRowCount(0);
        tblDirectorioGeneral.setModel(modelo);
        txtDatoBusqueda.setText("");
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btListarTodos;
    private javax.swing.JComboBox<String> cmdTipoDato;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblDirectorioGeneral;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDatoBusqueda;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
