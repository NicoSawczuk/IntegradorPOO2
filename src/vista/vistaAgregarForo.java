/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Foro;
import Modelo.Tema;
import Modelo.Universitario;
import controlador.Controlador;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nico2
 */
public class vistaAgregarForo extends javax.swing.JFrame {

    /**
     * Creates new form vistaAgregarForo
     */
    private Controlador controlador;
    private JFrame vistaAnterior;
    private Universitario universitario;
    private Tema unTema;
    private Foro unForo;
    
    
    public vistaAgregarForo() {
        initComponents();
    }
    
    public vistaAgregarForo(Controlador controlador, Universitario universitario, vistaHome aThis,Foro f){
       initComponents();
       this.controlador = controlador;
       this.universitario = universitario;
       this.vistaAnterior = aThis;
       this.unForo=f; 
       this.setLocationRelativeTo(null);
       this.jLabel1.setText("Editar "+" "+unForo.getTitulo().toUpperCase());
    }

    public vistaAgregarForo(Controlador controlador, Universitario universitario, vistaHome aThis,Tema t) {
       initComponents();
       this.controlador = controlador;
       this.universitario = universitario;
       this.vistaAnterior = aThis;
       this.unTema=t;
       this.setLocationRelativeTo(null);
       this.labelTema.setText(unTema.toString());
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
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        botonCrear = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelTema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(253, 253, 253));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Crear un nuevo foro");

        jLabel2.setText("Titulo:");

        botonCrear.setText("Guardar");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonCrear)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(51, 51, 51)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonCrear)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(253, 253, 253));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Detalles");

        jLabel5.setText("Tema:");

        labelTema.setForeground(new java.awt.Color(102, 102, 102));
        labelTema.setText("tema");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(labelTema)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelTema))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // al precionar crear llama al controlador (modulo (para los amigos) para el DSD )
        if(!this.txtTitulo.getText().isEmpty()){//si completo el campo
            String titulo = txtTitulo.getText().toUpperCase();
            
            if ("Crear un nuevo foro".equals(this.jLabel1.getText())){
                this.controlador.crearForo(unTema,titulo);
                System.out.println("entro a crear");
            }
            else{
                
                this.controlador.editarForo(unForo, titulo);
                System.out.println("entro a editar");
            }
            
            this.dispose();
        }else{
             JOptionPane.showMessageDialog(null, "complete el campo titulo");
        }
        
    }//GEN-LAST:event_botonCrearActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.vistaAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelTema;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
