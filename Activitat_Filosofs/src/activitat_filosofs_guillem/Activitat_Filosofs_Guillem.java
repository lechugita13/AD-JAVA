/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat_filosofs_guillem;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author sergi
 */
public class Activitat_Filosofs_Guillem {

    final static int NUM_FILOSOFS = 5;
    final static int[][] PALILLO = {
        {0, 4}, //  0
        {1, 0}, //  1
        {2, 1}, //  2
        {3, 2}, //  3
        {4, 3} //  4
    };

    final static Semaphore[] semafor = new Semaphore[NUM_FILOSOFS];

    public static class Filosof extends Thread {

        private final int id;
        private final Semaphore[] SEMAFOR;
        private final int TENEDOR;
        private final int GANIVET;

        public Filosof(int id, Semaphore[] semaforo) {
            this.id = id;
            this.SEMAFOR = semaforo;
            this.TENEDOR = PALILLO[id][0];
            this.GANIVET = PALILLO[id][1];
        }

        protected void menjar() {

            if (SEMAFOR[GANIVET].tryAcquire()) {
                if (SEMAFOR[GANIVET].tryAcquire()) {
                    System.out.println("FILÒSOF " + id + " esta menjant " + TENEDOR + " I " + GANIVET);
                    try {
                        int time = 0;
                        while (time <= 0) {
                            time = new Random().nextInt() % 2000;
                        }
                        sleep(time);
                    } catch (InterruptedException ex) {
                        System.out.println("Error : " + ex.toString());
                    }
                    System.out.println("Filosof " + id + " acaba de menjar. Allibera el " + TENEDOR + " i " + GANIVET);
                    SEMAFOR[GANIVET].release();
                }
                SEMAFOR[TENEDOR].release();
            } else {
                System.out.println("Filosofo " + id + " té fam.");
            }
        }

        protected void pensar() {
            System.out.println("Filosof " + id + " està pensant.");
            try {
                int time = 0;
                while (time <= 0) {
                    time = new Random().nextInt() % 2000;
                }
                sleep(time);
            } catch (InterruptedException ex) {
                System.out.println("Error en pensar(): " + ex.toString());
            }
        }

        @Override
        public void run() {
            while (true) {
                pensar();
                menjar();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM_FILOSOFS; i++) {
            semafor[i] = new Semaphore(1);
        }

        for (int idFilosof = 0; idFilosof < NUM_FILOSOFS; idFilosof++) {
            new Filosof(idFilosof, semafor).start();
        }
    }

}
