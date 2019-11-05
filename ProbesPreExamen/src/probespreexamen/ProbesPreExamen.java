/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probespreexamen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class ProbesPreExamen {

    /**
     * @param args the command line arguments
     */
    
    public static File ficheroDios=null;
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner e = new Scanner(System.in);
        boolean bandera = true;
        int opc;
        
        do {
            PrintWriter pw = null;
          
            
                menu();
                opc = e.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println("Indica la ruta del ficher on vols que es treballe");
                        String ruta = e.next();
                        File fichero = new File(ruta);
                        ficheroDios=fichero;
                        if (fichero.exists()) {
                            System.out.println("El ficher sa trobat amb exit");
                        }else{
                            try {
                                fichero.createNewFile();
                                System.out.println("El fichero no sa trobat pero sa creat");
                            } catch (IOException ex) {
                                Logger.getLogger(ProbesPreExamen.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 2:
                        
                       
                     escribirFichero();
                        break;
                    case 3:
                    //leerFichero();
                        leerFicheroScanner();
                        break;
                    case 4:
                        
                        break;
                    default:
                        throw new AssertionError();
                }
            
            
        } while (true);
        
    }

    private static void menu() {
        
        System.out.println("1.- Penk en el cap");
        System.out.println("2.- Escriu fichero");
        System.out.println("3.- LLitg fichero");
        System.out.println("4.- Mostra fichero");
    }

    private static void escribirFichero() {
     
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(ficheroDios));
            FileWriter fw = new FileWriter(ficheroDios);
            pw.write("Guillem es el dios i señor de este universo");
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(ProbesPreExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void leerFichero() {
     
        try {
            String linea;
            FileReader fr = new FileReader(ficheroDios);
            BufferedReader br = new BufferedReader(fr);
            while ((linea=br.readLine())!=null) {
                System.out.println(linea);
                
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProbesPreExamen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProbesPreExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }

    private static void leerFicheroScanner() {
        try {
            Scanner s = new Scanner(ficheroDios);
            while (s.hasNext()) {
                String next = s.nextLine();
                System.out.println(next);
            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProbesPreExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
