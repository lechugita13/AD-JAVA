/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicarexamenad;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
class GestionJugador {

    private final String nomFitxer;

    public GestionJugador() {
        this.nomFitxer = "goleadores.dat";
    }

    public GestionJugador(String nomFitxer) {
        this.nomFitxer = nomFitxer;
    }

    public boolean guardarAFichero(Jugador j) {

        ObjectOutputStream oos = null;
        try {
            if (this.inicializarJugador(j)) {
                return true;
            }
            File fitxer = new File(this.nomFitxer);
            oos = new ObjectOutputStream(new FileOutputStream(fitxer, true));
            oos.writeObject(j);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(GestionJugador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
        return true;

    }

    private boolean inicializarJugador(Jugador j) {
        File fitxer = new File(this.nomFitxer);
        if (!fitxer.exists()) {
            try {
                ObjectOutputStream objectoos = new ObjectOutputStream(new FileOutputStream(fitxer));
                objectoos.writeObject(j);
                objectoos.close();
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestionJugador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GestionJugador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            return false;
        }
        return false;
    }

    public ArrayList<Jugador> listarJugadores() {

        ArrayList<Jugador> jugadoresLeidos = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(this.nomFitxer)));
            while (true) {
                jugadoresLeidos.add((Jugador) ois.readObject());

            }
        } catch (EOFException ex) {
            System.out.println("Nose que esta pasant");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionJugador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionJugador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionJugador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return jugadoresLeidos;
        }

    }

    boolean borrarTodo() {
        
        File fitxer = new File(this.nomFitxer);
        if (fitxer.exists()) {
            return fitxer.delete();
        }else{
            return true;
        }
    }

}
