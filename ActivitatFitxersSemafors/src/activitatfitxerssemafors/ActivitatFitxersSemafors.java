/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitatfitxerssemafors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class ActivitatFitxersSemafors {

    private static final Semaphore PARS = new Semaphore(0);
    //private static final Semaphore MUTEX = new Semaphore(1);
    private static final Semaphore IMPARS = new Semaphore(1);

    private static File linea = new File("linies.txt");
    private static File liniesCambiades = new File("liniesCanviades2.txt");
    private static File linniesCambiades1 = new File("liniesCambiades1.txt");

    public static class Impars extends Thread {

        private Impars() {

        }

        @Override
        public void run() {
            try {
                //MUTEX.acquire();

                IMPARS.acquire();

                FileReader fr = new FileReader(linea);
                BufferedReader br = new BufferedReader(fr);
                int cont = 1;
                String linea;
                if (!linniesCambiades1.exists()) {
                    linniesCambiades1.createNewFile();
                }
                if (!liniesCambiades.exists()) {
                    liniesCambiades.createNewFile();
                }
                FileWriter fw = new FileWriter(linniesCambiades1,true);
                FileWriter fwCanviades = new FileWriter(liniesCambiades,true);
                while ((linea = br.readLine()) != null) {
                    String linea2 = br.readLine();
                    if (cont % 2 != 0) {
                        fw.write("\n" + linea);
                    }

                    cont++;
                    fwCanviades.write("\n"+linea2);
                    fwCanviades.write("\n" + linea);

                }
                IMPARS.release();
                PARS.release();
                fw.close();
                fr.close();
                fwCanviades.close();
                //MUTEX.release();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ActivitatFitxersSemafors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ActivitatFitxersSemafors.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ActivitatFitxersSemafors.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static class Pars extends Thread {

        private Pars() {

        }

        @Override
        public void run() {
            try {
                PARS.acquire();
                FileReader fr = null;
                try {

                    FileReader fr1 = new FileReader(linea);
                    BufferedReader br = new BufferedReader(fr1);
                    if (!liniesCambiades.exists()) {
                        liniesCambiades.createNewFile();
                    }

                    int cont = 1;
                    String linea;
                    if (!linniesCambiades1.exists()) {
                        linniesCambiades1.createNewFile();
                    }
                    FileWriter fw1 = new FileWriter(linniesCambiades1,true);
                    FileWriter fwCanviades = new FileWriter(liniesCambiades,true);
                    while ((linea = br.readLine()) != null) {

                        if (cont % 2 == 0) {
                            fw1.write("\n" + linea);
                        }
                        cont++;

                        //fwCanviades.write("\n" + linea);

                    }
                    fw1.close();
                    fr1.close();
                    fwCanviades.close();
                    //MUTEX.release();
                    PARS.release();
                    IMPARS.release();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ActivitatFitxersSemafors.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ActivitatFitxersSemafors.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ActivitatFitxersSemafors.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) {
        new Pars().start();
        new Impars().start();
        liniesCambiades.delete();
        linniesCambiades1.delete();

    }

}
