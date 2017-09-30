/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.Controller;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Estado;
import model.MaquinaEstadoFinito;


public class View extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form View
     */
    String idInicial; 
    String idIntermedio; 
    String idFinal;
    String hilera;
    
    public View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuGuardar = new javax.swing.JMenuItem();
        MenuRecuperar = new javax.swing.JMenuItem();
        MenuLimpiar = new javax.swing.JMenuItem();
        MenuEstado = new javax.swing.JMenu();
        MenuEstadoInicial = new javax.swing.JMenuItem();
        MenuEstadoIntermedio = new javax.swing.JMenuItem();
        MenuEstadoFinal = new javax.swing.JMenuItem();
        MenuVerificar = new javax.swing.JMenu();
        MenuVerificarHilera = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Archivo");

        MenuGuardar.setText("Guardar");
        MenuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(MenuGuardar);

        MenuRecuperar.setText("Recuperar");
        MenuRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRecuperarActionPerformed(evt);
            }
        });
        jMenu1.add(MenuRecuperar);

        MenuLimpiar.setText("Limpiar");
        MenuLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLimpiarActionPerformed(evt);
            }
        });
        jMenu1.add(MenuLimpiar);

        jMenuBar1.add(jMenu1);

        MenuEstado.setText("Estado");

        MenuEstadoInicial.setText("Inicial");
        MenuEstadoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEstadoInicialActionPerformed(evt);
            }
        });
        MenuEstado.add(MenuEstadoInicial);

        MenuEstadoIntermedio.setText("Intermedio");
        MenuEstadoIntermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEstadoIntermedioActionPerformed(evt);
            }
        });
        MenuEstado.add(MenuEstadoIntermedio);

        MenuEstadoFinal.setText("Final");
        MenuEstadoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEstadoFinalActionPerformed(evt);
            }
        });
        MenuEstado.add(MenuEstadoFinal);

        jMenuBar1.add(MenuEstado);

        MenuVerificar.setText("Verificar");

        MenuVerificarHilera.setText("Hilera");
        MenuVerificarHilera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVerificarHileraActionPerformed(evt);
            }
        });
        MenuVerificar.add(MenuVerificarHilera);

        jMenuBar1.add(MenuVerificar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGuardarActionPerformed
        String s=JOptionPane.showInputDialog("Ingrese el nombre del archivo");

        if(s.indexOf('.')==-1){
            s=s+".xml";
        }
        if(s==null)
            s="archivo.xml";
        model.guardar(s);
    }//GEN-LAST:event_MenuGuardarActionPerformed

    private void MenuEstadoIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEstadoIntermedioActionPerformed
        idIntermedio = JOptionPane.showInputDialog("Ingrese el ID del estado");
        if(idIntermedio != null){
            if(model.crearEstado("Intermedio", idIntermedio, 160, 80)){
                }
            else{
                JOptionPane.showMessageDialog(rootPane, "No pueden haber IDs repetidos");
            }
        }
    }//GEN-LAST:event_MenuEstadoIntermedioActionPerformed

    private void MenuVerificarHileraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVerificarHileraActionPerformed
        hilera = JOptionPane.showInputDialog("Ingrese los Simbolos");
        if(model.verificaHilera(hilera)){
          JOptionPane.showMessageDialog(rootPane, "hilera valida");
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "hilera Invalida");
        }
    }//GEN-LAST:event_MenuVerificarHileraActionPerformed

    private void MenuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLimpiarActionPerformed
        model.Limpiar();
    }//GEN-LAST:event_MenuLimpiarActionPerformed

    private void MenuEstadoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEstadoInicialActionPerformed
        if(model.validaEstadoInicialUnico()){
            idInicial= JOptionPane.showInputDialog("Ingrese el ID del estado");
            if(idInicial != null){
                if(model.crearEstado("Inicial", idInicial, 160, 80)){
                }
                 else{
                    JOptionPane.showMessageDialog(rootPane, "No pueden haber IDs repetidos");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "No puede haber mas de un ID Inicial");
        }
    }//GEN-LAST:event_MenuEstadoInicialActionPerformed

    private void MenuEstadoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEstadoFinalActionPerformed
        idFinal = JOptionPane.showInputDialog("Ingrese el ID del estado");
        if(idFinal != null){
        if(model.crearEstado("Final", idFinal, 160, 80)){
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "No pueden haber IDs repetidos");
        }
        }
    }//GEN-LAST:event_MenuEstadoFinalActionPerformed

    private void MenuRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRecuperarActionPerformed
        JFileChooser jfc = new JFileChooser();
	jfc.setAcceptAllFileFilterUsed(false);
	FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files","xml");
	jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
	if (returnValue == JFileChooser.APPROVE_OPTION) {
                    
            String s = jfc.getSelectedFile().getName();
            model.cargar(s);
        }
    }//GEN-LAST:event_MenuRecuperarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }
    
    
    MaquinaEstadoFinito model;
    Controller controller;
    
public void setModel(MaquinaEstadoFinito model){
    this.model=model;
    model.addObserver(this);
}    

public void setController(Controller controller){
    this.controller = controller;
    this.addMouseListener(controller);
    this.addMouseMotionListener(controller);
   
}

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
            if(model.isLineatemp()){
                g.drawLine(model.getTemplinex(),model.getTempliney(),model.getTemplinex2(),model.getTempliney2());
            }
            for (int p=0; p<model.getNumeroTran();p++ ){
                if(model.getTransiciones(p).getEstadoSaliente().getUnico() == model.getTransiciones(p).getEstadoEntrante().getUnico()){  //
                g.drawRect(model.getTransiciones(p).getEstadoSaliente().getX(), model.getTransiciones(p).getEstadoSaliente().getY(), 20,20);
                g.drawString(model.getTransiciones(p).getSimbolo(),model.getTransiciones(p).getEstadoSaliente().getX()+21, model.getTransiciones(p).getEstadoSaliente().getY()+15);
                }
                else{
                g.setColor(Color.BLUE);
                g.drawLine(model.getTransiciones(p).getEstadoSaliente().getX(),model.getTransiciones(p).getEstadoSaliente().getY(),model.getTransiciones(p).getEstadoEntrante().getX(),model.getTransiciones(p).getEstadoEntrante().getY());
                int v = (model.getTransiciones(p).getEstadoSaliente().getX() - model.getTransiciones(p).getEstadoEntrante().getX())/2;
                int w = (model.getTransiciones(p).getEstadoSaliente().getY() - model.getTransiciones(p).getEstadoEntrante().getY())/2;
                g.drawString(model.getTransiciones(p).getSimbolo(), model.getTransiciones(p).getEstadoEntrante().getX()+v,model.getTransiciones(p).getEstadoEntrante().getY()+w);
                }
            }
                
            for (int i = 0; i < model.getNumeroEstados(); i++){
                
                if(model.getEstado(i).getTipo().equals("Inicial")){
                    g.setColor(Color.BLUE);
                    Estado e = model.getEstado(i);
                    g.fillOval((model.getEstado(i).getX()-9), (model.getEstado(i).getY()-10), 20, 20);

                    g.setColor(Color.white);
                    g.drawString(model.getEstado(i).getId(), model.getEstado(i).getX()-3 , model.getEstado(i).getY()+5);
                }
                if(model.getEstado(i).getTipo().equals("Intermedio")){
                    g.setColor(Color.green);
                    Estado e = model.getEstado(i);
                    g.fillOval((model.getEstado(i).getX()-9), (model.getEstado(i).getY()-10), 20, 20);
                    
                    g.setColor(Color.white);
                    g.drawString(model.getEstado(i).getId(), model.getEstado(i).getX()-3 , model.getEstado(i).getY()+5);
                    
                }          
                if(model.getEstado(i).getTipo().equals("Final")){
                    g.setColor(Color.red);
                    Estado e = model.getEstado(i);
                    g.fillOval((model.getEstado(i).getX()-9), (model.getEstado(i).getY()-10), 20, 20);
                    
                    g.setColor(Color.white);
                    g.drawString(model.getEstado(i).getId(), model.getEstado(i).getX()-3 , model.getEstado(i).getY()+5);
                }
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuEstado;
    private javax.swing.JMenuItem MenuEstadoFinal;
    private javax.swing.JMenuItem MenuEstadoInicial;
    private javax.swing.JMenuItem MenuEstadoIntermedio;
    private javax.swing.JMenuItem MenuGuardar;
    private javax.swing.JMenuItem MenuLimpiar;
    private javax.swing.JMenuItem MenuRecuperar;
    private javax.swing.JMenu MenuVerificar;
    private javax.swing.JMenuItem MenuVerificarHilera;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}