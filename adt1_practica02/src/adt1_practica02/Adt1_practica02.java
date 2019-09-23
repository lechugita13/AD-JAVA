/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_practica02;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class Adt1_practica02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File fichero2 = new File("/home/vesprada/Escriptori/fondo.gif");
       FileInputStream fin = null;
       FileOutputStream fout = null;
       boolean bandera= true;
       
        try {
            
             fin = new FileInputStream(fichero2);
            int numero = 0;
             File copia = new File("/home/vesprada/Escriptori/copia.gif");
           copia.createNewFile();
            fout = new FileOutputStream(copia);
            while (bandera) {     
                if(fichero2.length()==copia.length()){
                bandera=false;
                }
                fout.write(fin.read());
                
            }
           
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Adt1_practica02.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (EOFException ex) {
            Logger.getLogger(Adt1_practica02.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Adt1_practica02.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 if(fin!=null && fout!=null){
                   fin.close();
            fout.close();
                 }
          
        } catch (IOException ex) {
            Logger.getLogger(Adt1_practica02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        }
        
        
       
    
}
