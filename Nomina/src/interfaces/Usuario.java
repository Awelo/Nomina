/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.plaf.IconUIResource;

/**
 *
 * @author awelo
 */
public class Usuario extends javax.swing.JPanel {

    /**
     * Creates new form Usuario
     */
    public Usuario() {
        initComponents();
    }
    
    public void setDatos(String datos[]){
        lblCodigo.setText(datos[0]);
        lblNombre.setText(datos[1]);
        URL url = this.getClass().getResource(datos[2]);
        ImageIcon icon = new ImageIcon(url);
        lblImagen.setIcon(icon);
        lblCargo.setText(datos[3]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblSueldo = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();

        jButton1.setText("Pagar");

        lblNombre.setText("Nombre:");

        lblCargo.setText("Cargo:");

        lblSueldo.setText("Sueldo:");

        lblCodigo.setText("Codigo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSueldo)
                            .addComponent(lblNombre)
                            .addComponent(lblCargo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(8, 8, 8)))
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(lblCargo)
                        .addGap(18, 18, 18)
                        .addComponent(lblSueldo))
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSueldo;
    // End of variables declaration//GEN-END:variables
}
