/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raulfinal;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class RaulFinalRunableScheduleExecutor implements Runnable {

    public static ArrayList<String> missatges = new ArrayList<>();

    public RaulFinalRunableScheduleExecutor(ArrayList<String> missatges) {
       this.missatges = missatges;
    }

    public void run() {
       int random;
       random  = (int) (Math.random()*5);
        System.out.println(missatges.get(random).toString());
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        missatges.add("Menja 5 peces de fruita al dia");
        missatges.add("Fes esport diariament");
        missatges.add("Beu dos litres daigua al dia");
        missatges.add("Camina 5km cada dia");
        missatges.add("Hidratat be");
        RaulFinalRunableScheduleExecutor fil = new RaulFinalRunableScheduleExecutor(missatges);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleWithFixedDelay(fil, 0, 2, TimeUnit.SECONDS);
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(RaulFinalRunableScheduleExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        executor.shutdown();
        System.out.println("Completat");

    }

}
