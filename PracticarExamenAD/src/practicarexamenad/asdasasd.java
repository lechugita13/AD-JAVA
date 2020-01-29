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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class asdasasd {

    public static String ruta = "goleadores.dat";
    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

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

    public static boolean existeFichero() {
        File fichero = new File(ruta);
        return fichero.exists();
    }

    private static void anyadirJugador() throws IOException {

        System.out.println("Introduce el nombre");
        String nombre = entrada.nextLine();
        System.out.println("Introduce el equipo");
        String equipo = entrada.nextLine();
        System.out.println("Introduce goles");
        int goles = entrada.nextInt();

        Jugador j = new Jugador(nombre, equipo, goles);

        if (existeFichero()) {
            AppendableObjectOutputStream ficherooos = new AppendableObjectOutputStream(new FileOutputStream(ruta,true));
            ficherooos.writeObject(j);
            ficherooos.close();
        } else {
            ObjectOutputStream ficherooos = new ObjectOutputStream(new FileOutputStream(ruta));
            ficherooos.writeObject(j);
            ficherooos.close();
        }

    }

    private static void leerGoleadores() {
        if (existeFichero()) {
            System.out.println("Introduce equipo o equipos");
            String equipo = entrada.nextLine();
            ArrayList<Jugador> listaJugadores = listarJugadores();

            if (equipo.equalsIgnoreCase("equipos")) {
                
                for (Jugador j : listaJugadores) {
                    System.out.println(j.toString());
                }
            } else {
                for (int i = 0; i < listaJugadores.size(); i++) {
                    Jugador get = listaJugadores.get(i);
                    if (get.getEquipo().equalsIgnoreCase(equipo)) {
                        System.out.println(get.toString());
                    } else {
                        System.out.println("El equipo no existe");
                    }
                }
            }
        }

    }

    private static ArrayList<Jugador> listarJugadores() {

        ArrayList<Jugador> jugadoresLeidos = new ArrayList<>();
        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream(ruta));
            while (true) {
                jugadoresLeidos.add((Jugador) inputStream.readObject());
            }

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {

                }
            }
            return jugadoresLeidos;
        }
    }

    private static void modificarGoles() throws FileNotFoundException, IOException {
        ArrayList<Jugador> listaJugador = listarJugadores();
        boolean existe = false;
        System.out.println("Introduce el nombre");
        String nombre = entrada.nextLine();
        System.out.println("Introduce goles");
        int goles = entrada.nextInt();

        for (int i = 0; i < listaJugador.size(); i++) {
            Jugador get = listaJugador.get(i);
            if (get.getNombre().equalsIgnoreCase(nombre)) {
                existe = true;
                get.setGoles(goles);
            } else {
                System.out.println("El jugador introducido no esta en la base de datos");
            }
        }

        if (existe) {
            File fichero = new File(ruta);
            fichero.delete();

            for (int i = 0; i < listaJugador.size(); i++) {
                Jugador get = listaJugador.get(i);
                if (i == 0) {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(ruta));
                    output.writeObject(get);
                    output.close();
                } else {
                    AppendableObjectOutputStream output = new AppendableObjectOutputStream(new FileOutputStream(ruta));
                    output.writeObject(get);
                    output.close();
                }

            }
        }

    }

    private static void golesPorEquipos() {

        System.out.println("Introduce el nombre del equipo");
        String equipo = entrada.nextLine();

        int goles = 0;
        ArrayList<Jugador> listaJugadores = listarJugadores();
        for (int i = 0; i < listaJugadores.size(); i++) {
            Jugador get = listaJugadores.get(i);
            if (get.getEquipo().equalsIgnoreCase(equipo)) {
                goles += get.getGoles();
            }
        }
        System.out.println(goles);
    }

}
