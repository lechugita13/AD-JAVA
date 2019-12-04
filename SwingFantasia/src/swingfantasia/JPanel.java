/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingfantasia;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author vesprada
 */
public class JPanel extends JFrame {
    
    public static final int BOTONES_COLUMNAS = 5;
    public static final int BOTONES_FILAS = 5;
    
    public static void main(String[] args) {
      
        
        JPanel jp = new JPanel();
        JFrame jf = new JFrame("LA VIDA ES DURA PERO MES DURA LA VERDURA");
       
        jf.setVisible(true);
        BorderLayout bl = new BorderLayout();
        JLabel jl = new JLabel("EL SERGI VA VOLANT");
        bl.addLayoutComponent(jl, BorderLayout.NORTH);
        jf.add(jl);
        bl.addLayoutComponent(jp,BorderLayout.CENTER);
        
        JLabel reservas = new JLabel("RESERVAS");
        jf.add(reservas);
        bl.addLayoutComponent(jp, BorderLayout.SOUTH);
        
        GridLayout gl = new GridLayout(BOTONES_FILAS, BOTONES_COLUMNAS);
        ImageIcon icon2 = new ImageIcon("reservat.jpg");
        ImageIcon icon = new ImageIcon("A380.jpg");
        for (int i = 0; i < BOTONES_FILAS; i++) {
            
            for (int j = 0; j < BOTONES_COLUMNAS; j++) {
                
                JButton b1 = new JButton("", icon);
                jp.add(b1);
                
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        if (b1.getIcon() == icon) {
                            System.out.println("vuic saber si va");
                             int input = JOptionPane.showConfirmDialog(null, "Seguro que quieres realizar esta reserva?");
                             if (input == 0) {
                                
                            b1.setIcon(icon2);
                        }
                        }else{
                             JOptionPane.showMessageDialog(null, "Este asiento esta reservado");
                            System.out.println("Q te follen josep");
                        }
                       
                        
                    }
                });
            }
            
        }
        gl.setHgap(10);
        gl.setVgap(10);
        jf.setBounds(200, 200, 1000, 1000);
        jp.setLayout(gl);
        
        jf.setLayout(bl);
        jp.show();
        
        
       
        
    }
    
}
