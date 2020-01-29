/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicarexamenad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class probanumero7 {
    
    public static String ruta = "ostias.dat";
    
    public static void main(String[] args) {
        
        
    }
    
    public static void fantasia(){
        ArrayList<Jugador> listaJugador = listarJugadores();
    }

    private static ArrayList<Jugador> listarJugadores() {
        ArrayList<Jugador>listaJugadores = new ArrayList<>();
            ObjectInputStream inputStream =null;
        try {
           
            
            inputStream = new ObjectInputStream(new FileInputStream(ruta));
            while (true) {                
              listaJugadores.add((Jugador) inputStream.readObject());
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            try {
                inputStream.close();
            } catch (IOException ex1) {
               
            }
        }
        
    
        
         return listaJugadores;   
    }
}
