/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenguillempspfinal.exercici1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.ScriptingFunctions;

/**
 *
 * @author vesprada
 */
public class Exercici1 {

    private static final int NFILS = 100;
    private static final Semaphore MUTEX = new Semaphore(0);
    private static File arxiu = new File("binari.txt");

    private static List<LlegirLinea> llistaTasques = new ArrayList<LlegirLinea>();

    static class LlegirLinea implements Callable<String> {

        private int numLinea;

        private String binari;
        private int cont = 0;

        public LlegirLinea(int numLinea) {
            this.numLinea = numLinea;

        }

        @Override
        public String call() throws Exception {

            String resultat = "";
            int valorDecimal = 0;
            int proba = 0;
            FileReader fr = null;
            try {
                
                fr = new FileReader(arxiu);
                BufferedReader br = new BufferedReader(fr);
                String linea = br.readLine();

                while (linea != null) {
                    if (cont == numLinea) {

                        for (int i = 0; i < linea.length(); i++) {
                            if (linea.charAt(i) == 0) {

                            } else {
                                proba = (int) Math.pow(2, i);

                                valorDecimal += proba;

                            }

                        }
                        resultat = valorDecimal + "";
                        System.out.println(numLinea + " " + linea + " Decimal: " + valorDecimal);
                        //System.out.println(resultat);
                        return resultat;

                    }
                    cont++;

                    linea = br.readLine();

                }
                br.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Exercici1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Exercici1.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(Exercici1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return null;

        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int contadorMain = 0;
        int resultatBo = 0;
        
        File nouArxiu = new File("decimal.txt");
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(NFILS);
        List<LlegirLinea> llistaTasques = new ArrayList<LlegirLinea>();
        for (int i = 0; i < NFILS; i++) {

            LlegirLinea ll = new LlegirLinea(contadorMain);
            llistaTasques.add(ll);

            contadorMain++;
        }
        List<Future<String>> llistaResultats;
        // Fem que s'executen totes les tasques cridant-les amb invokeAll (des
        // del gestor de fils)
        llistaResultats = executor.invokeAll(llistaTasques);
        // Evitem que s'execute cap altre proc�s fins que acaben els que hem
        // ficat en marxa.
        executor.shutdown();

        FileWriter fw = null;
      

        for (int i = 0; i < llistaResultats.size(); i++) {
            // obtenim el valor de RecompteMonedes del resultat
            Future<String> resultat = llistaResultats.get(i);

            try {
                // actualitzem valors de cares i creus

                fw = new FileWriter(nouArxiu);
                PrintWriter pw = new PrintWriter(fw);

                resultatBo = Integer.parseInt(resultat.get().trim());

                System.out.println(resultatBo);

                pw.write(resultatBo + "\n");

                //System.out.println(llistaResultats.get(i));
            } catch (IOException ex) {
                Logger.getLogger(Exercici1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {

            }

        }

    }
}
