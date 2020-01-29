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
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static practicarexamenad.App1.anyadirJugador;
import static practicarexamenad.App1.golesPorEquipos;
import static practicarexamenad.App1.leerGoleadores;
import static practicarexamenad.App1.listarJugadores;
import static practicarexamenad.App1.modificarGoles;

/**
 *
 * @author Guillem
 */
public class App2 {
    
    private static String ruta = "goleadores.dat";
    private static Scanner entrada = new Scanner(System.in);
  
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        int opcion;
        do {
            System.out.println("***\n"
                    + "1.- Añadir jugador\n"
                    + "2.- Leer goleadores\n"
                    + "3.- Modificar goles de un jugador\n"
                    + "4.- Visualizar el total de goles por equipo\n"
                    + "5.- Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    anyadirJugador();
                    break;
                case 2:
                    leerGoleadores();
                    break;
                case 3:
                    modificarGoles();
                    break;
                case 4:
                    golesPorEquipos();
                    break;
            }
        } while (opcion != 5);
        
    }
    public static boolean existeFichero(){
        File fichero = new File(ruta);
        return fichero.exists();
    }
    public static void anyadirJugador() throws FileNotFoundException, IOException{
        
        System.out.println("Introduce el nombre");
        String nombre = entrada.nextLine();
        System.out.println("Introduce el equipo");
        String equipo  = entrada.nextLine();
        System.out.println("Introduce el numero de goles");
        int goles = entrada.nextInt();
        
        Jugador j = new Jugador(nombre, equipo, goles);
        
        if (existeFichero()) {
            AppendableObjectOutputStream out = new AppendableObjectOutputStream(new FileOutputStream(ruta,true));
            out.writeObject(j);
            out.close();
        }else{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
            out.writeObject(j);
            out.close();
        }
    }
    
    public static void leerGoleadores() {
        if (existeFichero()) {
            System.out.println("Introduce el equipo o equipos");
            String equipo = entrada.nextLine();
            ArrayList<Jugador> listaJugadores = listarJugadores();
            
            if (equipo.equalsIgnoreCase("equipos")) {
                for (Jugador j : listaJugadores) {
                    System.out.println(j.toString());
                }
            }else{
                for (int i = 0; i < listaJugadores.size(); i++) {
                    Jugador get = listaJugadores.get(i);
                    if (get.getEquipo().equalsIgnoreCase(equipo)) {
                        System.out.println(get.toString());
                    }
                }
            }
        }else{
            System.out.println("ESTA VACIOOOOOOOOO");
        }
    }

    private static ArrayList<Jugador> listarJugadores() {
        
        ArrayList<Jugador> jugadoresLeidos = new ArrayList<>();
        ObjectInputStream inputObjects = null;
        
        try {
            inputObjects = new ObjectInputStream(new FileInputStream(ruta));
            while (true) {                
                jugadoresLeidos.add((Jugador) inputObjects.readObject());
            }
           
        } catch (IOException | ClassNotFoundException ex) {
            
          
        } finally{
            try {
                inputObjects.close();
            } catch (IOException ex) {
                
            }
        }
        
        return jugadoresLeidos;
    }
    
    public static void modificarGoles() throws FileNotFoundException, IOException {
        ArrayList<Jugador> listaJugadores = listarJugadores();
        boolean existe = false;
        
        System.out.println("Introduce el nombre");
        String nombre = entrada.nextLine();
        
        System.out.println("Introduce los goles");
        int goles = entrada.nextInt();
        
        for (int i = 0; i < listaJugadores.size(); i++) {
            Jugador get = listaJugadores.get(i);
            if (get.getNombre().equalsIgnoreCase(nombre)) {
                existe = true;
                get.setGoles(goles);
            }
        }
        if (existe) {
            File fichero = new File(ruta);
            fichero.delete();
            
            for (int i = 0; i < listaJugadores.size(); i++) {
                if (i == 0) {
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
                     out.writeObject(listaJugadores.get(i));
                     out.close();
                }else{
                    AppendableObjectOutputStream out = new AppendableObjectOutputStream(new FileOutputStream(ruta, true));
                    out.writeObject(listaJugadores.get(i));
                    out.close();
                }
            }
        }else{
            System.out.println("No existe ningun jugador");
        }
    }
    public static void golesPorEquipos(){
        
        System.out.println("Introduce el nombre del equipo:");
        String nombreEquipo = entrada.nextLine();
         int goles = 0;
        
        ArrayList <Jugador> listaJugadores = listarJugadores();
        
        for (int i = 0; i < listaJugadores.size(); i++) {
            
            if(listaJugadores.get(i).getEquipo().equalsIgnoreCase(nombreEquipo)){
                goles += listaJugadores.get(i).getGoles();
            }
            
        }
        System.out.println(goles);
    }
}
