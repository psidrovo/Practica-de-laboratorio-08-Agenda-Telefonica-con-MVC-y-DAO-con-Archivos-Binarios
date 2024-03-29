/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Telefono;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 * VistaMiDirectorio
 * 
 * Esta interfaz permite al usuario agregar, modificar, eliminar y buscar 
 * telefonos que esten registradosbajp ese mismo usuario. 
 * 
 * @author Paul Idrovo, Denys Dutan 
 */
public class VistaMiDirectorio extends javax.swing.JInternalFrame {

    private ControladorTelefono controladorTelefono;
    private ControladorUsuario controladorUsuario;

    public VistaMiDirectorio(ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono) {
        initComponents();
        this.controladorTelefono = controladorTelefono;
        this.controladorUsuario = controladorUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbOperadora = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        btAgregar = new javax.swing.JButton();
        txtNumero = new javax.swing.JFormattedTextField();
        btActualizar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDirectorio = new javax.swing.JTable();
        txtCodigoBuscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("MI DIRECTORIO");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TELEFONO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N

        cmbOperadora.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "MOVISTAR", "CLARO", "CNT", "TUENTI", "ETAPA" }));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("NUMERO");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("CODIGO");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("TIPO");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("OPERADORA");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 153, 102));
        txtCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCodigo.setDisabledTextColor(new java.awt.Color(153, 204, 255));

        cmbTipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "FIJO", "MOVIL", "FAX", "CASA", "TRABAJO", "FAX_CASA", "FAX_TRABAJO", "LOCALIZADOR" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        btAgregar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/anadir (1).png"))); // NOI18N
        btAgregar.setText("AGREGAR");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        txtNumero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNumero.setEnabled(false);
        txtNumero.setMaximumSize(new java.awt.Dimension(365, 365));

        btActualizar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/salvar.png"))); // NOI18N
        btActualizar.setText("ACTUALIZAR");
        btActualizar.setEnabled(false);
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/cerrar.png"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btEliminar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/basura.png"))); // NOI18N
        btEliminar.setText("ELIMINAR");
        btEliminar.setEnabled(false);
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbOperadora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(81, 81, 81)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(btActualizar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTipo))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(cmbOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DIRECTORIO PERSONAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        tblDirectorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero", "Tipo", "Operadora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDirectorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDirectorio.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDirectorio.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDirectorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDirectorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDirectorio);

        txtCodigoBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("CODIGO:");

        btBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/iconos/buscar.png"))); // NOI18N
        btBuscar.setText("BUSCAR");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(654, 654, 654))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action Event:btAgregarActionPerformed.
     * 
     * este action event lo que hace primero es comprobar que todos los campos 
     * estén completos, una vez comprobado esto llama al controlador teléfono
     * y manda a crear un nuevo teléfono con los datos ingresados en los textBox.
     * 
     * @param evt 
     */
    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed

        if (txtCodigo.getText().equals("") || txtNumero.getValue().toString().equals("")
                || cmbTipo.getSelectedItem().toString().equals("SELECCIONAR") || cmbOperadora.getSelectedItem().toString().equals("SELECCIONAR")) {
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS", "AGREGADO", JOptionPane.ERROR_MESSAGE);
        } else {
            controladorTelefono.crearNuevoTelefono(Integer.valueOf(txtCodigo.getText()), txtNumero.getValue().toString(),
                    cmbTipo.getSelectedItem().toString(), cmbOperadora.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "TELEFONO AGREGADO CORRECTAMENTE", "AGREGADO", JOptionPane.INFORMATION_MESSAGE);
            Limpiar();
            ActualizarTabla();
        }
    }//GEN-LAST:event_btAgregarActionPerformed
    public void Limpiar() {
        txtCodigo.setText(String.valueOf(controladorTelefono.getCodigoSiguiente()));
        txtNumero.setValue("");
        cmbTipo.setSelectedIndex(0);
        cmbOperadora.setSelectedIndex(0);
        txtCodigoBuscar.setText("");
    }
    /**
     * Action Event:btActualizarActionPerformed.
     * 
     * este action event lo que hace primero es comprobar que todos los campos 
     * estén completos, una vez comprobado esto llama al controlador teléfono 
     * y manda a actualizar el teléfono con los datos ingresados en los textBox.
     * 
     * @param evt 
     */
    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        if (txtCodigo.getText().equals("") || txtNumero.getText().equals("")
                || cmbTipo.getSelectedItem().toString().equals("SELECCIONAR") || cmbOperadora.getSelectedItem().toString().equals("SELECCIONAR")) {
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS", "EDITAR", JOptionPane.ERROR_MESSAGE);
        } else {
            controladorTelefono.actualizar(Integer.valueOf(txtCodigo.getText()), txtNumero.getText(),
                    cmbTipo.getSelectedItem().toString(), cmbOperadora.getSelectedItem().toString());

            JOptionPane.showMessageDialog(null, "TELEFONO AGREGADO CORRECTAMENTE", "AGREGADO", JOptionPane.INFORMATION_MESSAGE);
            Limpiar();
            Desactivar();
            ActualizarTabla();
        }
    }//GEN-LAST:event_btActualizarActionPerformed

    public void ActualizarTabla() {
        List<Telefono> listaTelefonos = controladorTelefono.verTelefonosUsuario();

        DefaultTableModel modelo = (DefaultTableModel) tblDirectorio.getModel();
        modelo.setRowCount(0);
        tblDirectorio.setModel(modelo);
        Object[] fila = new Object[4];

        for (Telefono telefono : listaTelefonos) {
            fila[0] = telefono.getCodigo();
            fila[1] = telefono.getNumero();
            fila[2] = telefono.getTipo();
            fila[3] = telefono.getOperadora();
            modelo.addRow(fila);
        }
        this.tblDirectorio.setModel(modelo);
    }
    /**
     * Action Event:btBuscarActionPerformed.
     * 
     * este action event lo que hace es recibir el código ingresado en la caja
     * de texto y lo busca en la tabla. Si es que lo encuentra automáticamente 
     * se señala los datos en la tabla si es que no nos muestra una option panel
     * informándonos que no se ha encontrado el dato. 
     * 
     * @param evt 
     */
    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed

        int codigoBuscar = Integer.valueOf(txtCodigoBuscar.getText());
        int filasTabla = tblDirectorio.getRowCount();
        boolean bandera = true;

        for (int i = 0; i < filasTabla; i++) {
            int codigoTabla = Integer.valueOf(tblDirectorio.getValueAt(i, 0).toString());
            if (codigoBuscar == codigoTabla) {
                bandera = false;
                tblDirectorio.setRowSelectionInterval(i, i);
                editarDatos(i);
                break;
            }
        }
        if (bandera) {
            JOptionPane.showMessageDialog(null, "VALOR NO ENCONTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tblDirectorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDirectorioMouseClicked
        int fila = tblDirectorio.getSelectedRow();
        editarDatos(fila);
    }//GEN-LAST:event_tblDirectorioMouseClicked

    public void editarDatos(int fila) {
        txtCodigo.setText(tblDirectorio.getValueAt(fila, 0).toString());
        cmbOperadora.setEnabled(true);
        cmbTipo.setEnabled(true);
        try {
            switch (tblDirectorio.getValueAt(fila, 2).toString().replace(" ", "")) {
                case "FIJO":
                    cmbTipo.setSelectedIndex(1);
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("(+593)#-###-####")));
                    break;
                case "MOVIL":
                    cmbTipo.setSelectedIndex(2);
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("(+593)##-###-####")));
                    break;
                case "FAX":
                    cmbTipo.setSelectedIndex(3);
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("FX (+593)##-###-####")));
                    break;
                case "CASA":
                    cmbTipo.setSelectedIndex(4);
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("(+593)#-###-####")));
                    break;
                case "TRABAJO":
                    cmbTipo.setSelectedIndex(5);
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("(+593)#-###-####")));
                    break;
                case "FAX_CASA":
                    cmbTipo.setSelectedIndex(6);
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("FX (+593)##-###-####")));
                    break;
                case "FAX_TRABAJO":
                    cmbTipo.setSelectedIndex(7);
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("FX (+593)##-###-####")));
                    break;
                case "LOCALIZADOR":
                    cmbTipo.setSelectedIndex(8);
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("LC (+593)##-###-####")));
                    break;
                default:
                    cmbTipo.setSelectedIndex(0);
                    break;
            }

        } catch (ParseException ex) {
            Logger.getLogger(VistaMiDirectorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNumero.setValue(tblDirectorio.getValueAt(fila, 1).toString());       
        switch (tblDirectorio.getValueAt(fila, 3).toString().replace(" ", "")) {
            case "MOVISTAR":
                cmbOperadora.setSelectedIndex(1);
                break;
            case "CLARO":
                cmbOperadora.setSelectedIndex(2);
                break;
            case "CNT":
                cmbOperadora.setSelectedIndex(3);
                break;
            case "TUENTI":
                cmbOperadora.setSelectedIndex(4);
                break;
            case "ETAPA":
                cmbOperadora.setSelectedIndex(5);
                break;
            default:
                cmbOperadora.setSelectedIndex(0);
                break;
        }
        btActualizar.setEnabled(true);
        btAgregar.setEnabled(false);
        btCancelar.setEnabled(true);
        btEliminar.setEnabled(true);
    }
    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed

        try {
            txtNumero.setEnabled(true);
            txtNumero.setValue("");
            String tipo = (String) cmbTipo.getSelectedItem();
            switch (tipo.replace(" ", "")) {
                case "FIJO":
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("(+593)#-###-####")));
                    break;
                case "MOVIL":
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("(+593)##-###-####")));
                    break;
                case "FAX":
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("FX (+593)##-###-####")));
                    break;
                case "CASA":
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("(+593)#-###-####")));
                    break;
                case "TRABAJO":
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("(+593)#-###-####")));
                    break;
                case "FAX_CASA":
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("FX (+593)##-###-####")));
                    break;
                case "FAX_TRABAJO":
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("FX (+593)##-###-####")));
                    break;
                case "LOCALIZADOR":
                    txtNumero.setFormatterFactory(
                            new javax.swing.text.DefaultFormatterFactory(
                                    new javax.swing.text.MaskFormatter("LC (+593)##-###-####")));
                    break;

                default:
                    txtNumero.setEnabled(false);
                    break;
            }

        } catch (ParseException ex) {
            Logger.getLogger(VistaMiDirectorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cmbTipoActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        txtCodigo.setText(String.valueOf(controladorTelefono.getCodigoSiguiente()));
        Limpiar();
        Desactivar();
        ActualizarTabla();
    }//GEN-LAST:event_formInternalFrameActivated
    public void Desactivar() {
        btAgregar.setEnabled(true);
        btActualizar.setEnabled(false);
        btCancelar.setEnabled(false);
        btEliminar.setEnabled(false);
    }
    /**
     * Action Event: btCancelarActionPerformed.
     * 
     * este action event lo que hace primero es comprobar que todos los campos 
     * estén completos, una vez comprobado esto llama al controlador teléfono y
     * manda a eliminar un teléfono con los datos ingresados en los textBox.
     * 
     * @param evt 
     */
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        Desactivar();
        Limpiar();
    }//GEN-LAST:event_btCancelarActionPerformed

    /**
     * 
     * @param evt 
     */
    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(null, "ELIMINAR EL TELEFONO SELECCIONADO?");
        if (JOptionPane.OK_OPTION == confirmar) {
            int codigo = Integer.valueOf(txtCodigo.getText());
            controladorTelefono.eliminar(codigo);
            ActualizarTabla();
            JOptionPane.showMessageDialog(null, "TELEFONO ELIMINADO", "ELIMINADO", JOptionPane.INFORMATION_MESSAGE);
            Desactivar();
            Limpiar();
        }
    }//GEN-LAST:event_btEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JComboBox<String> cmbOperadora;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDirectorio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoBuscar;
    private javax.swing.JFormattedTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
