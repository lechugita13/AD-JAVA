/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_activitat10;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vesprada
 */
public class Adt1_Activitat10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        ArrayList fantasia = new ArrayList<>();
        File file = new File("ejercicio10.data");
        String marca = "marca";
        String matricula = "matricula";
        String modelo = "modelo";
        String tamaño = "tamaño";
        String proba ="";
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException ex) {
                Logger.getLogger(Adt1_Activitat10.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Vehiculo v1 = new Vehiculo();
            v1.setMarca(JOptionPane.showInputDialog(marca));
            v1.setModelo(JOptionPane.showInputDialog(modelo));
            double deposito = Double.parseDouble(JOptionPane.showInputDialog(tamaño));
            v1.setTamDeposito(deposito);
            v1.setMatricula(JOptionPane.showInputDialog(matricula));
            
            
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            dos.writeUTF(v1.getMatricula());
            dos.writeUTF(v1.getMarca());
            dos.writeDouble(v1.getTamDeposito());
            dos.writeUTF(v1.getModelo());
            
            
            dos.close();
            
            try {
                DataInput dis = new DataInputStream(new FileInputStream(file));

                while (true) {

                   
                    
                    fantasia.add(dis.readUTF());
                    
                   
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Adt1_Activitat10.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                
                Logger.getLogger(Adt1_Activitat10.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        for (int i = 0; i < fantasia.size(); i++) {
            Object get = fantasia.get(i);
            
            JOptionPane.showMessageDialog(null, get);
        }
    }

}
