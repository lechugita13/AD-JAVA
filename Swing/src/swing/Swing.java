/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.sun.xml.internal.ws.wsdl.ActionBasedOperationSignature;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author vesprada
 */
public class Swing extends  JFrame{

    /**
     * @param args the command line arguments
     */
    
    private JLabel saludo;
    private JButton botonNombre;
    private JTextField text; 
    public Swing() {
        super("Pantalla Principal");
        setBounds(200,200,400,400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        crearLable();
        crearBoton();
        actionPerformed();
        crearTextField();
    }
    

    public static void main(String[] args) {
        // TODO code application logic here
        Swing swing = new Swing();
        
    }

    private void crearLable() {
        saludo = new JLabel();
        saludo.setText("Sergi puto");
        saludo.setBounds(50,50,100,50);
        add(saludo);
    }

    private void crearBoton() {
        botonNombre = new JButton("Saluda");
        botonNombre.setBounds(100,100,100,100);
        
        add(botonNombre);
        
    }

   
    private void actionPerformed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void crearTextField() {
        
        text = new JTextField();
        text.setBounds(50, 50, 50, 50);
    }
    
    
}
