/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class App {

    public static void main(String[] args) {

        File goleadores = new File("goleadores.dat");
        Scanner e = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        boolean bandera = true;
        int opc;

        do {
            menu();
            opc = e.nextInt();
            switch (opc) {
                case 1:
                    if (!goleadores.exists()) {
                        try {
                            System.out.println("El archivo no estaba creado ahora se ha creador correctamente");
                            goleadores.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {

                        ObjectOutputStream oos;
                        try {
                            System.out.println("Introduce el nombre del jugador");
                            String nombre = e.next();
                            System.out.println("Introduce el equipo al que pertenece el jugador");
                            String equipo = e.next();
                            System.out.println("Introduce el numero de goles del jugador");
                            int goles = e.nextInt();
                            Jugador j1 = new Jugador(nombre, equipo, goles);
                            jugadores.add(j1);
                            oos = new ObjectOutputStream(new FileOutputStream(goleadores,true));

                            if (goleadores.length() == 0) {
                                oos.writeObject(j1);
                               
                                
                               
                            } else {
                                AppendableObjectOutputStream append = new AppendableObjectOutputStream(oos);
                                append.writeObject(j1);
                               
                            }
                            oos.close();
                            

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    break;
                case 2:
            {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(goleadores));
                    
                    Scanner leer = new Scanner(goleadores);
                    
                    System.out.println("Introduce el nombre del equipo o equipos");
                    if (e.next().equals("equipos")) {
                        while (leer.hasNextLine()) {
                            String next = leer.nextLine();
                            System.out.println(next);
                        }
                    }else{
                        while (leer.hasNextLine()) {
                            String next = leer.nextLine();
                            for (int i = 0; i < jugadores.size(); i++) {
                                Jugador jugadorSel = jugadores.get(i);
                                if (next.equals(jugadorSel.getEquipo())) {
                                   jugadorSel.toString();
                                }
                            }
                        }
                    }
                    
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    
                    
                    break;
                case 3:

                    break;
                case 4:
            {
                try {
                    Scanner proba = new Scanner(goleadores);
                    
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                      
                
                    break;
                case 5:
                    System.out.println("Adeu");
                    bandera = false;
                    break;

                default:
                    throw new AssertionError();
            }

        } while (bandera);

    }

    private static void menu() {
        System.out.println("1.-Añadir Jugador");
        System.out.println("2.-Leer goleadores del fichero");
        System.out.println("3.-Modificar goles jugador");
        System.out.println("4.-Visualizar el total de goles");
        System.out.println("5.-Salir");
    }
}
