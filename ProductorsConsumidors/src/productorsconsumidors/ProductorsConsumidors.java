/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorsconsumidors;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class ProductorsConsumidors {

    /**
     * @param args the command line arguments
     */
    private static final Semaphore CUA_PRODUCTORS = new Semaphore(10);
    private static final Semaphore CUA_CONSUMIDORS = new Semaphore(0);
    private static final Semaphore MUTEX = new Semaphore(1);
    private static int contadorP = 0;
    private static int contadorC = 0;
    private static ArrayDeque cua = new ArrayDeque(10);
    
    public static class Consumidors extends Thread {

        private int id;

        public Consumidors(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                
                for (int i = 0; i < 20; i++) {
                    CUA_CONSUMIDORS.acquire();
                    MUTEX.acquire();
                    
                   StringBuilder sb = new StringBuilder();
                    
                        
                      System.out.println("Hem consumit: " + "(C" + id + ") " +":: Consumidor numero: " + contadorC);
                        
                    
                    
                    Thread.sleep((long) Math.random() * 900);
                    cua.pollFirst();
                    contadorC++;
                    
                    MUTEX.release();
                    CUA_PRODUCTORS.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ProductorsConsumidors.class.getName()).log(Level.SEVERE, null, ex);
            }
            CUA_CONSUMIDORS.release();

        }

    }

    public static class Productors extends Thread {

        private int id;

        public Productors(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {

                for (int i = 0; i < 20; i++) {
                    CUA_PRODUCTORS.acquire();
                    MUTEX.acquire();
                    int random = (int) (Math.random() * 20);
                    cua.addFirst(random);

                  
                        System.out.println("Hem produit: " + "(P" + id + ") "+":: Produïts numero: " + contadorC);
                    
                    

                    Thread.sleep((long) Math.random() * 900);
                    contadorP++;

                    MUTEX.release();
                    CUA_CONSUMIDORS.release();

                }

            } catch (InterruptedException ex) {
                Logger.getLogger(ProductorsConsumidors.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here

        for (int i = 1; i < 6; i++) {

            new Productors(i).start();
            new Consumidors(i).start();
        }
    }

}
