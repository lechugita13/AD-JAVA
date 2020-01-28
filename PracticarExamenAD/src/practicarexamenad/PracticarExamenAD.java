/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicarexamenad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Guillem
 */
public class PracticarExamenAD {

    
    private static GestionJugador gestion;
    private static Scanner entrada = new Scanner(System.in);
   
    private static void mostrarTotalGolPorEquipo() {
        System.out.println("Introduce el equipo o nada para mostrar todos");
        String equipo = entrada.nextLine();
        
        if (equipo.equals("")) {
            agruparGolesPorEquipo();
        }else{
            ArrayList<Jugador> listaGoleadores = gestion.listarJugadores();
            int totalGol =0;
            
            for (Jugador j : listaGoleadores) {
                if (j.getEquipo().equals(equipo)) {
                    totalGol += j.getGoles();
                }
            }
            System.out.println("El total de goles es de: "+totalGol);
        }
    }

    private static void modificarGoles() {
        System.out.println("Introduce el nombre del jugador");
        String nombre = entrada.nextLine();
        System.out.println("Introduce el numero de goles");
        int goles = entrada.nextInt();
        
        ArrayList<Jugador> listaGoleadores = gestion.listarJugadores();
        
        for (Jugador j : listaGoleadores) {
            if (j.getNombre().equals(nombre)) {
                j.setGoles(j.getGoles() + goles);
                break;
            }
        }
        
        if (gestion.borrarTodo()) {
            for (Jugador j : listaGoleadores) {
                gestion.guardarAFichero(j);
            }
        }
    }

    private static void leerGoleadores() {
        System.out.println("Introduce el equipo a buscar o equipos");
        String equipo = entrada.nextLine();
        ArrayList<Jugador> listaGoleadores = gestion.listarJugadores();
    }

    private static void crearJugador() {
        System.out.println("Introduce el nombre del jugador");
        String nombre = entrada.nextLine();
        System.out.println("Introduce el nombre del equipo");
        String equipo = entrada.nextLine();
        System.out.println("Introduce el numero de goles");
        int goles = entrada.nextInt();
        
        Jugador j = new Jugador(nombre,equipo,goles);
        if (!gestion.guardarAFichero(j)) {
            System.out.println("EROR nose que esta pasant");
            
        }
        
    }
 
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gestion = new GestionJugador();
        int opcion = 0;
        boolean bandera = true;
        
        do {
            System.out.println("*******\n"
            +"1.- Añadir jugaodr\n"
            +"2.- Leer goleadores\n"
            +"3.- Modificar goles de un jugador\n"
            +"4.- Visualizar el total de goles por equipo\n"
            +"5.- Salir");
            
            opcion = entrada.nextInt();
            entrada.nextLine();
            
            switch (opcion) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    leerGoleadores();
                    break;
                case 3:
                    modificarGoles();
                    break;
                case 4:
                    mostrarTotalGolPorEquipo();
                    break;
                case 5:
                    System.out.println("Adios amigos");
                    bandera = false;
                    break;    
                default:
                    throw new AssertionError();
            }
        } while (bandera);
        
        
    }

    private static void agruparGolesPorEquipo() {
        HashMap<String, Integer> golesPorEquipo = new HashMap<>();
        ArrayList<Jugador> listaGoleadores = gestion.listarJugadores();
        for (Jugador j : listaGoleadores) {
            if (golesPorEquipo.putIfAbsent(j.getEquipo(), j.getGoles()) !=null) {
                int goles = golesPorEquipo.get(j.getEquipo());
                golesPorEquipo.put(j.getEquipo(),goles + j.getGoles());
                
            }
        }
        System.out.println(golesPorEquipo.toString());
    }
    
}
