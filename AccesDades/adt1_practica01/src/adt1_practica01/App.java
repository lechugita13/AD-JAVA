/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_practica01;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author vesprada
 */
public class App {

    /**
     * @param args the command line arguments
     */
    static GestionArchivos gestion = new GestionArchivos("", "/", "");

    public static void main(String[] args) {
        boolean bandera = true;
        do {
            menu();
            Scanner s = new Scanner(System.in);

            int opc = s.nextInt();
            switch (opc) {
                case 1:
                    asignarCarpeta();

                    break;
                case 2:
                    gestion.listarCarpetaTrabajo();
                    break;
                case 3:
                    gestion.informacionDetallada();
                    break;
                case 4:
                    System.out.println("Introdueix un nom per a crear la carpeta: ");
                    String nombreC = s.next();
                    gestion.setNombreCarpeta(nombreC);
                    gestion.crearCarpeta();
                    break;
                case 5:
                    System.out.println("Introdueix un nom per a crear el fichero: ");
                    String nombreA = s.next();
                    gestion.setNombreArchivo(nombreA);
                    gestion.crearFichero();
                    break;
                case 6:
                    System.out.println("Introdueix un nom per a crear la carpeta: ");
                    String nombreAE = s.next();
                    gestion.setNombreArchivo(nombreAE);
                    gestion.eliminarFichero();
                    break;
                case 7:
                    
                    System.out.println("Adios...");
                    bandera=false;
                    break;
                default:
                    throw new AssertionError();
            }
        } while (bandera);
    }

    private static void menu() {

        System.out.println("1.Asignar carpeta de trabajo");
        System.out.println("2.Listado de la carpeta de trabajo");
        System.out.println("3.Informacion detallada de un archivo");
        System.out.println("4.Creacion de un directorio");
        System.out.println("5.Creacion de un fichero");
        System.out.println("6.Eliminacion de un fichero");
        System.out.println("7.Salir");

    }

    private static void asignarCarpeta() {
        Scanner s = new Scanner(System.in);
        System.out.println("Escriu la ruta de la carpeta: ");
        String ruta = s.next();
        gestion.setNombreCarpeta(ruta);
    }

}
