/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class Exercici2 {

    // Quantitat de participants
    static private  int participants = 543;
    static private int vidriola =0;
    static private int vidriola100=0;
    static private int monedesIntroduides=0;
    static private int numVidrioles=1;
    // Acc�s en exclusi� m�tua a l'array de cadenes
    private static final Semaphore MUTEX = new Semaphore(1);
    private static final Semaphore NOVIDRIOLAPLENA = new Semaphore(0);
    private static final Semaphore SIVIDRIOLABUIDA = new Semaphore(1);

    static class Visitant extends Thread {

        // identificador del participant
        private int id;
        private int moneda =1;
        
        public Visitant(int id) {
            this.id = id;
        }

        @Override
        public void run() {
           
               
                 try {
                SIVIDRIOLABUIDA.acquire();
                MUTEX.acquire();
                if (vidriola100 == 100) {
                    
                    
                    System.out.println("Visitant "+numVidrioles+" La vidriola esta plena, ja tornare");
                     Thread.sleep(2000);
                    MUTEX.release();
                    NOVIDRIOLAPLENA.release();
                   
                }else{
                    participants--;
                     MUTEX.release();
                     vidriola+=moneda;
                     vidriola100+=moneda;
                     monedesIntroduides+=moneda;
                    System.out.println("Vistitant "+id+" fica la moneda "+monedesIntroduides+"/"+vidriola);
                     Thread.sleep(50); 
                    SIVIDRIOLABUIDA.release();
                    
                    
                }
              
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Exercici2.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            
           
            
            
        }
        static class Voluntaria extends Thread {

           
            @Override
            public void run() {
                
                while (true) {
                    try {
                        NOVIDRIOLAPLENA.acquire();
                        MUTEX.acquire();
                        numVidrioles++;
                        vidriola100=0;
                        monedesIntroduides =0;
                        MUTEX.release();
                        int numero = numVidrioles -1;
                        System.out.println("Ja teniu la vidriola "+numero+" disponible");
                        vidriola= vidriola + 100;
                        SIVIDRIOLABUIDA.release();
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Exercici2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            
        }

        public static void main(String[] args) {
            new Voluntaria().start();
            for (int i = 0; i < 543; i++) {
                new Visitant(i).start();
            }
        }
        }
    }
