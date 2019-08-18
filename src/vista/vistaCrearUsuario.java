/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Materia;
import Modelo.Universitario;
import controlador.Controlador;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nico2
 */
public final class vistaCrearUsuario extends javax.swing.JFrame {

    /**
     * Creates new form vistaCrearUsuario
     */
    private Controlador controlador;
    private JFrame vistaAnterior;
    private Universitario universitario;
    
    
    public vistaCrearUsuario() {
        initComponents();
    }
    
    //Metodo carar la lista de usuarios correctamente

    public void limpiar(){
        //vaciamos todos los txt
        this.txtApellido.setText("");
        this.txtCorreo.setText("");
        this.txtDNI.setText("");
        this.txtDireccion.setText("");
        this.txtLegajo.setText("");
        this.txtNombre.setText("");
        this.jDateChooser1.setCalendar(null);
        this.txtContrasena.setText("");
        this.comboSexo.setSelectedIndex(-1);
        this.comboTipoUsuario.setSelectedIndex(-1);
        
        
        
        //creamos un combo para las materias
        DefaultComboBoxModel comboMaterias2 = new DefaultComboBoxModel(this.controlador.listarMaterias().toArray());
        this.comboMaterias.setModel(comboMaterias2);
        
        //creamos una lista y la llenamos con todos los usuarios
        DefaultListModel modelolista = new DefaultListModel();
        this.listaUsuarios.setModel(modelolista);
        this.listaUsuarios.setListData(this.controlador.listarUniversitarios().toArray());
        
        //Creamos la lista de materias y la vaciamos
        DefaultListModel modelolista1 = new DefaultListModel();
        this.listaMaterias.setModel(modelolista1);
        
        //deseleccionamos el combo materas
        this.comboMaterias.setSelectedIndex(-1);
    }

    public vistaCrearUsuario(Controlador controlador, Universitario usuarioActual, vistaLogin aThis) {
        initComponents();
       this.controlador = controlador;
       this.universitario = usuarioActual;
       this.vistaAnterior = aThis;
       this.setLocationRelativeTo(null);
       limpiar();
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
        jLabel2 = new javax.swing.JLabel();
        comboTipoUsuario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtLegajo = new javax.swing.JTextField();
        comboCorreo = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        botonAgregarUsuario = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        comboCarrera = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList();
        botonNuevo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMaterias = new javax.swing.JList();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboMaterias = new javax.swing.JComboBox<>();
        botonAgregarMateria = new javax.swing.JButton();
        botonBorrarMateria = new javax.swing.JButton();
        botonCambiarEstado = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Seleccione el tipo de usuario:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Agregar un nuevo usuario");

        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Profesor" }));
        comboTipoUsuario.setSelectedIndex(-1);
        comboTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        jLabel5.setText("Correo:");

        jLabel6.setText("Fecha de Nacimiento:");

        jLabel7.setText("Dirección:");

        jLabel8.setText("Sexo:");

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M", "O" }));
        comboSexo.setSelectedIndex(-1);

        jLabel9.setText("Legajo:");

        comboCorreo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "@estudiante", "@profesor", "@administrador", "@registrador" }));
        comboCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCorreoActionPerformed(evt);
            }
        });

        botonAgregarUsuario.setText("Guardar");
        botonAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarUsuarioActionPerformed(evt);
            }
        });

        jLabel10.setText("DNI:");

        comboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LSI", "ASC", "PRO" }));

        listaUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaUsuariosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaUsuarios);

        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        jLabel11.setText("Usuarios:");

        jLabel12.setText("Materias:");

        jScrollPane2.setViewportView(listaMaterias);

        jLabel13.setText("Asignar materias al profesor:");

        jLabel14.setText("Seleccione:");

        botonAgregarMateria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonAgregarMateria.setText("+");
        botonAgregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarMateriaActionPerformed(evt);
            }
        });

        botonBorrarMateria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonBorrarMateria.setText("-");
        botonBorrarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarMateriaActionPerformed(evt);
            }
        });

        botonCambiarEstado.setText("Cambiar estado");
        botonCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarEstadoActionPerformed(evt);
            }
        });

        jLabel15.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAgregarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonNuevo))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel12)
                        .addComponent(jScrollPane2)
                        .addComponent(jLabel14)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(comboMaterias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(18, 18, 18)
                            .addComponent(botonAgregarMateria)))
                    .addComponent(botonBorrarMateria, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonCambiarEstado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addComponent(jScrollPane1))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCambiarEstado))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonAgregarMateria)))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBorrarMateria)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevo)
                    .addComponent(botonAgregarUsuario)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCorreoActionPerformed

    private void botonAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarUsuarioActionPerformed
        if (this.comboTipoUsuario.getSelectedItem()=="Estudiante" ||this.comboTipoUsuario.getSelectedItem()=="ESTUDIANTE"){
            if(this.comboTipoUsuario.getSelectedItem() != null && this.txtNombre.getText().isEmpty()!=true && this.txtApellido.getText().isEmpty()!=true && this.txtDNI.getText().isEmpty()!=true && this.comboCarrera.getSelectedItem() != null && this.txtLegajo.getText().isEmpty()!=true && this.txtCorreo.getText().isEmpty()!=true && this.comboCorreo.getSelectedItem() != null && this.comboTipoUsuario.getSelectedItem() != null && this.jDateChooser1.getDate() != null && this.txtDireccion.getText().isEmpty()!=true && this.comboSexo.getSelectedItem() != null & this.txtContrasena.getText().isEmpty()!=true){
                if (!this.listaUsuarios.isSelectionEmpty()){
                    int dni = Integer.parseInt(this.txtDNI.getText());
                    String legajo = this.comboCarrera.getSelectedItem().toString() + this.txtLegajo.getText().toUpperCase();
                    String correo = this.txtCorreo.getText().toUpperCase() + this.comboCorreo.getSelectedItem().toString().toUpperCase();
                    String auxSexo = this.comboSexo.getSelectedItem().toString();
                    char sexo = auxSexo.charAt(0);
                    this.controlador.editarEstudiante((Universitario) this.listaUsuarios.getSelectedValue(),this.txtNombre.getText().toUpperCase(), this.txtApellido.getText().toUpperCase(), dni, legajo, correo, (String) this.comboTipoUsuario.getSelectedItem(), this.jDateChooser1.getDate(), this.txtDireccion.getText().toUpperCase(), sexo, this.txtContrasena.getText());
                }
                else{
                    //Casteamos y juntamos los campos necesarios
                    int dni = Integer.parseInt(this.txtDNI.getText());
                    String legajo = this.comboCarrera.getSelectedItem().toString() + this.txtLegajo.getText().toUpperCase();
                    String correo = this.txtCorreo.getText().toUpperCase() + this.comboCorreo.getSelectedItem().toString().toUpperCase();
                    String auxSexo = this.comboSexo.getSelectedItem().toString();
                    char sexo = auxSexo.charAt(0);
                    this.controlador.crearEstudiante(this.txtNombre.getText().toUpperCase(), this.txtApellido.getText().toUpperCase(), dni, legajo, correo, (String) this.comboTipoUsuario.getSelectedItem(), this.jDateChooser1.getDate(), this.txtDireccion.getText().toUpperCase(), sexo, this.txtContrasena.getText());
                } 
            }
            //sino emito un mensaje
            else{
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
            }
            limpiar();
        }
        else{
            //Guardar profesor
            //si todos los campos estan seleccionados
            if(this.comboTipoUsuario.getSelectedItem() != null && this.txtNombre.getText().isEmpty()!=true && this.txtApellido.getText().isEmpty()!=true && this.txtDNI.getText().isEmpty()!=true && this.comboCarrera.getSelectedItem() != null && this.txtLegajo.getText().isEmpty()!=true && this.txtCorreo.getText().isEmpty()!=true && this.comboCorreo.getSelectedItem() != null && this.comboTipoUsuario.getSelectedItem() != null && this.jDateChooser1.getDate() != null && this.txtDireccion.getText().isEmpty()!=true && this.comboSexo.getSelectedItem() != null & this.txtContrasena.getText().isEmpty()!=true){
                if (!this.listaUsuarios.isSelectionEmpty()){    
                    int dni = Integer.parseInt(this.txtDNI.getText());
                    String legajo = this.comboCarrera.getSelectedItem().toString() + this.txtLegajo.getText().toUpperCase();
                    String correo = this.txtCorreo.getText().toUpperCase() + this.comboCorreo.getSelectedItem().toString().toUpperCase();
                    String auxSexo = this.comboSexo.getSelectedItem().toString();
                    char sexo = auxSexo.charAt(0);
                    this.controlador.editarProfesor((Universitario) this.listaUsuarios.getSelectedValue(),this.txtNombre.getText().toUpperCase(), this.txtApellido.getText().toUpperCase(), dni, legajo, correo, (String) this.comboTipoUsuario.getSelectedItem(), this.jDateChooser1.getDate(), this.txtDireccion.getText().toUpperCase(), sexo, this.txtContrasena.getText());
                }
                else{
                    //Casteamos y juntamos los campos necesarios
                    int dni = Integer.parseInt(this.txtDNI.getText());
                    String legajo = this.comboCarrera.getSelectedItem().toString() + this.txtLegajo.getText().toUpperCase();
                    String correo = this.txtCorreo.getText().toUpperCase() + this.comboCorreo.getSelectedItem().toString().toUpperCase();
                    String auxSexo = this.comboSexo.getSelectedItem().toString();
                    char sexo = auxSexo.charAt(0);
                    this.controlador.crearProfesor(this.txtNombre.getText().toUpperCase(), this.txtApellido.getText().toUpperCase(), dni, legajo, correo, (String) this.comboTipoUsuario.getSelectedItem(), this.jDateChooser1.getDate(), this.txtDireccion.getText().toUpperCase(), sexo, this.txtContrasena.getText());
                }
            }
        }
        limpiar();
    }//GEN-LAST:event_botonAgregarUsuarioActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.vistaAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void comboTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUsuarioActionPerformed
        if(this.comboTipoUsuario.getSelectedItem()=="Estudiante"){
           /*this.txtApellido.setText("");
           this.txtCorreo.setText("");
           this.txtDNI.setText("");
           this.txtContrasena.setText("");
           this.txtDireccion.setText("");
           this.txtLegajo.setText("");
           this.txtNombre.setText("");*/
           this.jLabel12.setText("");
           this.jLabel13.setText("");
           this.jLabel14.setText("");
           /*this.jDateChooser1.setCalendar(null);
           this.listaMaterias.setSelectedIndex(-1);
           this.listaUsuarios.setSelectedIndex(-1);*/
           this.comboMaterias.setVisible(false);
           this.botonAgregarMateria.setVisible(false);
           this.listaMaterias.setVisible(false);
           this.botonBorrarMateria.setVisible(false);
        }
        if(this.comboTipoUsuario.getSelectedItem()=="Profesor"){
           /*this.txtApellido.setText("");
           this.txtCorreo.setText("");
           this.txtDNI.setText("");
           this.txtContrasena.setText("");
           this.txtDireccion.setText("");
           this.txtLegajo.setText("");
           this.txtNombre.setText("");*/
           this.jLabel12.setText("Materias:");
           this.jLabel13.setText("Asignar materias al profesor:");
           this.jLabel14.setText("Seleccione:");
           this.comboMaterias.setVisible(true);
           this.botonAgregarMateria.setVisible(true);
           this.listaMaterias.setVisible(true);
           this.botonBorrarMateria.setVisible(true);
        }
    }//GEN-LAST:event_comboTipoUsuarioActionPerformed

    private void listaUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaUsuariosValueChanged
        if (!this.listaUsuarios.isSelectionEmpty()){
            Universitario auxUniversitario = (Universitario) this.listaUsuarios.getSelectedValue();
            this.txtApellido.setText(auxUniversitario.getApellido());
            this.txtContrasena.setText(auxUniversitario.getPass());
            //this.txtCorreo.setText(auxUniversitario.getCorreo());
            this.txtDNI.setText(Integer.toString(auxUniversitario.getDni()));
            this.txtDireccion.setText(auxUniversitario.getDireccion());
            String legajo2 = auxUniversitario.getLegajo();
            String legajo="";
            for (int n = 3; n<= legajo2.length()-1 ;n++){
                legajo=legajo+legajo2.charAt(n);
            }
            this.txtLegajo.setText(legajo);
            this.jDateChooser1.setDate(auxUniversitario.getFechaNac());
            this.txtDireccion.setText(auxUniversitario.getDireccion());
            this.txtNombre.setText(auxUniversitario.getNombre());
            char c=0;
            String auxCorreo="";
            String auxCorreo2 = auxUniversitario.getCorreo();
            for (int n = 0; n <= auxCorreo2.length()-1; n++){
                if (c !='@'){
                    auxCorreo=auxCorreo+auxCorreo2.charAt(n);
                    c = auxCorreo2.charAt(n);
                }
            }
            auxCorreo = auxCorreo.substring(0, auxCorreo.length()-1);
            this.txtCorreo.setText(auxCorreo);
            
            
            if (!"PROFESOR".equals(auxUniversitario.getTipo())){
                this.jLabel12.setText("");
                this.jLabel13.setText("");
                this.jLabel14.setText("");
                this.comboMaterias.setVisible(false);
                this.botonAgregarMateria.setVisible(false);
                this.listaMaterias.setVisible(false);
                this.botonBorrarMateria.setVisible(false);
            }
            else{
                this.jLabel12.setText("Materias:");
                this.jLabel13.setText("Asignar materias al profesor:");
                this.jLabel14.setText("Seleccione:");
                this.comboMaterias.setVisible(true);
                this.botonAgregarMateria.setVisible(true);
                this.listaMaterias.setVisible(true);
                this.botonBorrarMateria.setVisible(true);
                this.listaMaterias.setListData(auxUniversitario.getMaterias().toArray());
                
            }
            }
    }//GEN-LAST:event_listaUsuariosValueChanged

    private void botonCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarEstadoActionPerformed
        if(!this.listaUsuarios.isSelectionEmpty()){
            Universitario auxUniversitario = (Universitario) this.listaUsuarios.getSelectedValue();
            this.controlador.borrarUsuario(auxUniversitario);
        }
        this.listaUsuarios.setListData(this.controlador.listarUniversitarios().toArray());
    }//GEN-LAST:event_botonCambiarEstadoActionPerformed

    private void botonAgregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarMateriaActionPerformed
        if (this.listaUsuarios.getSelectedValue() != null && this.comboMaterias.getSelectedItem() != null){
            Materia auxMateria = (Materia) this.comboMaterias.getSelectedItem();
            Universitario auxUniversitario = (Universitario) this.listaUsuarios.getSelectedValue();
            this.controlador.asociarMaterias(auxMateria, auxUniversitario);
            this.listaMaterias.setListData(auxUniversitario.getMaterias().toArray());
        }
        this.comboMaterias.setSelectedIndex(-1);
    }//GEN-LAST:event_botonAgregarMateriaActionPerformed

    private void botonBorrarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarMateriaActionPerformed
        if (this.listaUsuarios.getSelectedValue() != null){
            Materia auxMateria = (Materia) this.listaMaterias.getSelectedValue();
            Universitario auxUniversitario = (Universitario) this.listaUsuarios.getSelectedValue();
            this.controlador.desasociarMateria(auxMateria, auxUniversitario);
            this.listaMaterias.setListData(auxUniversitario.getMaterias().toArray());
        }
        this.comboMaterias.setSelectedIndex(-1);
    }//GEN-LAST:event_botonBorrarMateriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarMateria;
    private javax.swing.JButton botonAgregarUsuario;
    private javax.swing.JButton botonBorrarMateria;
    private javax.swing.JButton botonCambiarEstado;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JComboBox<String> comboCarrera;
    private javax.swing.JComboBox<String> comboCorreo;
    private javax.swing.JComboBox<String> comboMaterias;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JComboBox<String> comboTipoUsuario;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaMaterias;
    private javax.swing.JList listaUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtLegajo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
