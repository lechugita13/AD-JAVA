/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumadevalorsguillem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class SumaDeValorsGuillem {

    /**
     * @param args the command line arguments
     */
    private static final Semaphore MUTEX = new Semaphore(1);
    private static final Semaphore ENTRARSUMAR = new Semaphore(0);
    private static final Semaphore ENTRARIMPRIMIR = new Semaphore(0);
    private static int suma = 0;
    private static ArrayList<String> dades = new ArrayList<>();
    private static ArrayList<Integer> resultat = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        Lector l = new Lector();
        Sumador s = new Sumador();
        Impresor imp = new Impresor();

        l.start();
        s.start();
        imp.start();

    }

    public static class Lector extends Thread {

        private File dadestxt = new File("dades.txt");

        public Lector() {
        }

        @Override
        public void run() {
            try {
                MUTEX.acquire();
                try {
                    String cadena;
                    FileReader f = new FileReader(dadestxt);
                    BufferedReader b = new BufferedReader(f);
                    while ((cadena = b.readLine()) != null) {
                        dades.add(cadena);
                        System.out.println(cadena);
                    }
                    b.close();
                } catch (IOException ex) {
                    Logger.getLogger(SumaDeValorsGuillem.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(SumaDeValorsGuillem.class.getName()).log(Level.SEVERE, null, ex);
            }
            MUTEX.release();
            ENTRARSUMAR.release();
        }
    }

    public static class Sumador extends Thread {

        @Override
        public void run() {

            try {
                ENTRARSUMAR.acquire();
                for (int i = 0; i < 5; i++) {
                    suma += Integer.parseInt(dades.get(i));
                    System.out.println(suma + " Esto es la suma");
                }
                resultat.add(suma);
                System.out.println(resultat.get(0));
                ENTRARIMPRIMIR.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(SumaDeValorsGuillem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static class Impresor extends Thread {

        private File resultattxt = new File("resultat.txt");

        public Impresor() {
        }

        @Override
        public void run() {

            try {
                ENTRARIMPRIMIR.acquire();

                if (!resultattxt.exists()) {

                    resultattxt.createNewFile();
                }

                FileWriter fw = new FileWriter(resultattxt);
                for (int i = 0; i < resultat.size(); i++) {
                    fw.write(resultat.get(i));
                    System.out.println();

                }
                for (int i = 0; i < resultat.size(); i++) {
                    System.out.println(resultat.get(i));
                }
                MUTEX.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(SumaDeValorsGuillem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SumaDeValorsGuillem.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
