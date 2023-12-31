/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.NumeroLinea;
import java.io.File;
import java.util.ArrayList;
/**
 *
 * @author astridmc
 */
public class Editor extends javax.swing.JPanel {
    String nombre;
    File documento;
    NumeroLinea numeroLinea;
    
    
    public Editor(String texto) {
        initComponents();
        numeroLinea = new NumeroLinea(AreaTexto);
        scrollPane.setRowHeaderView(numeroLinea);
        llenarTexto(texto);
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public File getDocumento() {
        return documento;
    }

    public void setDocumento(File documento) {
        this.documento = documento;
    }

    public NumeroLinea getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(NumeroLinea numeroLinea) {
        this.numeroLinea = numeroLinea;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        AreaTexto = new javax.swing.JTextPane();

        scrollPane.setViewportView(AreaTexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTexto(String Texto){
        AreaTexto.setText(Texto);
    }
    
    public String ObtenerTexto(){
        return AreaTexto.getText();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextPane AreaTexto;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
