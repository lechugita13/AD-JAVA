/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perruqueriaraul;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class PerruqueriaRaul {

    /**
     * @param args the command line arguments
     */
    private static int CADIRES = 5;
    private static final Semaphore HI_HA_CADIRES = new Semaphore(1);
    private static final Semaphore PERRUQUER = new Semaphore(0);
    private static final Semaphore CLIENTS = new Semaphore(0);

    public static class Perruquer extends Thread {

        @Override
        public void run() {
            while (true) {

                try {

                    CLIENTS.acquire();
                    System.out.println("Perruquer dormint...");
                   
                    
                    HI_HA_CADIRES.acquire();
                    System.out.println("Perruquer : Preparat per tallar el monyo a un nou client");
                    CADIRES++;
                    Thread.sleep(2000);
                    PERRUQUER.release();

                    Thread.sleep((long) (Math.random() * 1000 + 1000));
                    HI_HA_CADIRES.release();
                    System.out.println("Perruquer: Ja ho tens");

                } catch (InterruptedException ex) {
                    Logger.getLogger(PerruqueriaRaul.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

    public static class Client extends Thread {

        private int id;

        public Client(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {

                HI_HA_CADIRES.acquire();
                
                if (CADIRES > 0) {
                    CADIRES--;
                   
                    CLIENTS.release();
                    System.out.println("Client: " + id + " Ha arribat");
                    HI_HA_CADIRES.release();
                    PERRUQUER.acquire();
                    System.out.println("Client " + id + " Tallantse el monyo");
                    Thread.sleep((long) Math.random() * 500 + 500);
                    System.out.println("Client " + id + " paga al perruquer i sen va");
                   
                } else {
                    HI_HA_CADIRES.release();
                    System.out.println("Client: " + id + " Sen va perque no te lloc");
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(PerruqueriaRaul.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void main(String[] args) {

        new Perruquer().start();
        for (int i = 0; i < 15; i++) {
            new Client(i).start();
        }
    }

}
