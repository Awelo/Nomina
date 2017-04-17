/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import interfaces.*;
import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
/**
 *
 * @author awelo
 */
public class Nomina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Principal pantalla = new Principal();
        pantalla.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pantalla.setVisible(true);
    }
    
}
