/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Foro;
import Modelo.Pregunta;
import Modelo.Respuesta;
import Modelo.Universitario;
import Modelo.Voto;
import controlador.Controlador;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nico2
 */
public class vistaVerPregunta extends javax.swing.JFrame {

    /**
     * Creates new form vistaVerPregunta
     */
    private Controlador controlador;
    private JFrame vistaAnterior;
    private Universitario universitario;
    private Pregunta unaPregunta;
    
    
    public vistaVerPregunta(Controlador c) {
        this.setVisible(true);
        initComponents();
        this.controlador=c;
        
    }
    
    public void limpiar(){
        //creamos una lista y la llenamos con todos los usuarios
        DefaultListModel modelolista = new DefaultListModel();
        this.listaRespuesta.setModel(modelolista);
        this.listaRespuesta.setListData(this.controlador.listarRespuestas(this.unaPregunta).toArray());
        
        if ("PROFESOR".equals(universitario.getTipo()) || "ESTUDIANTE".equals(universitario.getTipo())){
            this.botonEditarPregunta.setVisible(false);
            this.botonEliminarPregunta.setVisible(false);
        }
    }
    
    public void verPregunta(Pregunta unaPregunta){
        this.jLabel1.setText(unaPregunta.getTitulo());
        this.jLabel6.setText(unaPregunta.getDescripcion());
        this.jLabel4.setText(unaPregunta.getFecha().toString());
        this.jLabel5.setText("");
        this.jLabel2.setText("");
        this.panel3.setVisible(false);
        this.botonEditarRespuesta.setVisible(false);
        this.botonEliminarRespuesta.setVisible(false);
        
        Universitario auxUniversitario = unaPregunta.getUniversitario();
        String autor = auxUniversitario.getNombre() + " "+auxUniversitario.getApellido();
        this.jLabel3.setText(autor);
    }

    public vistaVerPregunta(Controlador controlador, Universitario universitario, JFrame aThis, Pregunta p1) {
       initComponents();
       this.controlador = controlador;
       this.universitario = universitario;
       this.vistaAnterior = aThis;
       this.unaPregunta = p1;
       this.setLocationRelativeTo(null);
       verPregunta(unaPregunta);
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

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonEditarPregunta = new javax.swing.JButton();
        botonEliminarPregunta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        panel4 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaRespuesta = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel3 = new java.awt.Panel();
        botonLike = new javax.swing.JButton();
        botonDislike = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        contadorLikes = new javax.swing.JLabel();
        contadorDislikes = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtRespuesta = new javax.swing.JTextField();
        botonResponder = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        botonEditarRespuesta = new javax.swing.JButton();
        botonEliminarRespuesta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(190, 189, 189));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(253, 253, 253));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Titulo de la pregunta");

        panel2.setBackground(new java.awt.Color(244, 244, 244));
        panel2.setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Autor");

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Fecha");

        botonEditarPregunta.setBackground(new java.awt.Color(244, 244, 244));
        botonEditarPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-edit-26.png"))); // NOI18N
        botonEditarPregunta.setBorder(null);
        botonEditarPregunta.setContentAreaFilled(false);
        botonEditarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarPreguntaActionPerformed(evt);
            }
        });

        botonEliminarPregunta.setBackground(new java.awt.Color(244, 244, 244));
        botonEliminarPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-delete-26.png"))); // NOI18N
        botonEliminarPregunta.setBorder(null);
        botonEliminarPregunta.setContentAreaFilled(false);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 532, Short.MAX_VALUE)
                .addComponent(botonEditarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEliminarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botonEditarPregunta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(botonEliminarPregunta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jLabel6.setText("Descripcion");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                    .addContainerGap(45, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55)))
        );

        panel4.setBackground(new java.awt.Color(253, 253, 253));

        listaRespuesta.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaRespuestaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaRespuesta);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Titulo de la pregunta");

        jLabel2.setText("Respuesta");

        panel3.setBackground(new java.awt.Color(244, 244, 244));

        botonLike.setBackground(new java.awt.Color(244, 244, 244));
        botonLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-love-26.png"))); // NOI18N
        botonLike.setBorder(null);
        botonLike.setContentAreaFilled(false);
        botonLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLikeActionPerformed(evt);
            }
        });

        botonDislike.setBackground(new java.awt.Color(244, 244, 244));
        botonDislike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-broken-heart-26.png"))); // NOI18N
        botonDislike.setBorder(null);
        botonDislike.setContentAreaFilled(false);
        botonDislike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDislikeActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Autor");

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Fecha");

        contadorLikes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contadorLikes.setText("0");

        contadorDislikes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contadorDislikes.setText("0");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(54, 54, 54)
                .addComponent(contadorLikes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(contadorDislikes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonDislike, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botonDislike, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonLike, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(contadorLikes)
                                    .addComponent(contadorDislikes))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel9.setText("Agregar una respuesta");

        txtRespuesta.setToolTipText("");

        botonResponder.setText("Responder");
        botonResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonResponderActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Respuestas");

        botonEditarRespuesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-edit-26.png"))); // NOI18N
        botonEditarRespuesta.setBorder(null);
        botonEditarRespuesta.setContentAreaFilled(false);
        botonEditarRespuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarRespuestaActionPerformed(evt);
            }
        });

        botonEliminarRespuesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-delete-26.png"))); // NOI18N
        botonEliminarRespuesta.setBorder(null);
        botonEliminarRespuesta.setContentAreaFilled(false);

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEditarRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarRespuesta)))
                .addGap(29, 29, 29)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRespuesta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonResponder))
                        .addGap(12, 12, 12))))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addGap(13, 13, 13)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonResponder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonEditarRespuesta)
                            .addComponent(botonEliminarRespuesta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.vistaAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void botonResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonResponderActionPerformed
        if (!this.txtRespuesta.getText().isEmpty()){
            if (this.listaRespuesta.isSelectionEmpty()){
                this.controlador.publicarRespuesta(this.universitario, this.txtRespuesta.getText(), this.unaPregunta);
                this.txtRespuesta.setText("");
            }
            else{
                Respuesta unaRespuesta = (Respuesta) this.listaRespuesta.getSelectedValue();
                String respuesta = this.txtRespuesta.getText();
                this.controlador.editarRespuesta(unaRespuesta, respuesta);
                this.txtRespuesta.setText("");
                System.out.println(respuesta);
                
            }           
        }
        else{
            JOptionPane.showMessageDialog(null, "Primero complete el campo respuesta");
        }
        limpiar();
    }//GEN-LAST:event_botonResponderActionPerformed

    private void listaRespuestaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaRespuestaValueChanged
        if(!this.listaRespuesta.isSelectionEmpty()){
           Respuesta unaRespuesta = (Respuesta) this.listaRespuesta.getSelectedValue();
           this.panel3.setVisible(true);
           this.jLabel5.setText(this.unaPregunta.getTitulo());
           this.jLabel2.setText(unaRespuesta.getRespuesta());
           this.jLabel7.setText(unaRespuesta.getUniversitario().getNombre()+ " "+unaRespuesta.getUniversitario().getApellido());
           this.jLabel8.setText(unaRespuesta.getFecha().toString());
           
           if ("ADMINISTRADOR".equals(universitario.getTipo())){
            this.botonEditarRespuesta.setVisible(true);
            this.botonEliminarRespuesta.setVisible(true);
           }
           
        }
    }//GEN-LAST:event_listaRespuestaValueChanged

    private void botonEditarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarPreguntaActionPerformed
        vistaAgregarPregunta editarPregunta = new vistaAgregarPregunta (unaPregunta, this, controlador);
        editarPregunta.setVisible(true);
    }//GEN-LAST:event_botonEditarPreguntaActionPerformed


    private void botonLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLikeActionPerformed
        // boton de like, primero ve si "yo" no vote esa "resapesta"
        boolean valor = true;
        Universitario unUniversitario = this.universitario;
        if(!this.listaRespuesta.isSelectionEmpty()){
            Respuesta unaRespuesta = (Respuesta) this.listaRespuesta.getSelectedValue();
            Voto existenteVoto = this.controlador.votoExiste(this.universitario, unaRespuesta);
            if(existenteVoto != null){ //si ya existe veo si se mofdifica
            
            //ver si estaba ya en like o dislike
                if(!existenteVoto.isValor()){
                    //meterle dislike, modificar voto y reputacion
                    this.controlador.modificarVoto(existenteVoto,true);
                    
                
                }
            
            
            }else{ //creo el voto
            
                this.controlador.votarRespuesta(unaRespuesta, unUniversitario, valor);
            
            
            }
            
        }else{
            
            JOptionPane.showMessageDialog(null, "seleccione una respuesta primero");
        
        }
        
        
        
    }//GEN-LAST:event_botonLikeActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        limpiar();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        limpiar();
    }//GEN-LAST:event_formWindowActivated

    private void botonEditarRespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarRespuestaActionPerformed
        Respuesta unaRespuesta = (Respuesta) this.listaRespuesta.getSelectedValue();
        this.txtRespuesta.setText(unaRespuesta.getRespuesta());
    }//GEN-LAST:event_botonEditarRespuestaActionPerformed

    private void botonDislikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDislikeActionPerformed
        // boton de dislike, primero ve si "yo" no vote esa "resapesta"
        boolean valor = true;
        Universitario unUniversitario = this.universitario;
        if(!this.listaRespuesta.isSelectionEmpty()){
            Respuesta unaRespuesta = (Respuesta) this.listaRespuesta.getSelectedValue();
            Voto existenteVoto = this.controlador.votoExiste(this.universitario, unaRespuesta);
            if(existenteVoto != null){ //si ya existe veo si se mofdifica
            
            //ver si estaba ya en like o dislike
                if(existenteVoto.isValor()){
                    //meterle like, modificar voto y reputacion
                    this.controlador.modificarVoto(existenteVoto,false);
                }
            
            
            }else{ //creo el voto
            
                this.controlador.votarRespuesta(unaRespuesta, unUniversitario, valor);
            
            
            }
            
        }else{
            
            JOptionPane.showMessageDialog(null, "seleccione una respuesta primero");
        
        }
    }//GEN-LAST:event_botonDislikeActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDislike;
    private javax.swing.JButton botonEditarPregunta;
    private javax.swing.JButton botonEditarRespuesta;
    private javax.swing.JButton botonEliminarPregunta;
    private javax.swing.JButton botonEliminarRespuesta;
    private javax.swing.JButton botonLike;
    private javax.swing.JButton botonResponder;
    private javax.swing.JLabel contadorDislikes;
    private javax.swing.JLabel contadorLikes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaRespuesta;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private javax.swing.JTextField txtRespuesta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setVisible(boolean c){
    verPregunta(unaPregunta);
    super.setVisible(c);
}
}

