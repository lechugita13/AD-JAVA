/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perruqueriaraul;

import java.util.ArrayList;
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
    //private static final Semaphore CADIRES = new Semaphore(5);
    private static final int CADIRES =0;
    private static final Semaphore MUTEX = new Semaphore(1);
    private static ArrayList<Client> llistaClients = new ArrayList<>();
    public static class Perruquer extends Thread{

        @Override
        public void run() {
            try {
                MUTEX.acquire();
                if (llistaClients.isEmpty()) {
                    System.out.println("El perruquer esta somiant // Dormint");
                }
                
                
                System.out.println("Preparat pa tallarli el monyo a un nou client");
                
                
                MUTEX.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(PerruqueriaRaul.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public static class Client extends Thread{

        @Override
        public void run() {
          
                
               
                
                llistaClients.add(this);
                System.out.println("Client Arriba");
            
        }
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        for (int i = 0; i < 15; i++) {
           
            
        }
    }
    
}
