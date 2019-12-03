/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
class Consumidor implements Runnable {

    private MonitorBuffer buff;

    public Consumidor(MonitorBuffer buff) {
        this.buff = buff;
    }

    @Override
    public void run() {
        //per obtenir el valor de lelement del buffer
        int numero;
        //creem valor aleatori
        Random rm = new Random();
        //produira 10 elemments

        for (int i = 0; i < 10; i++) {
            //generem numero aleatori
            numero = buff.agafar();

            //mostra el numero
            System.out.println("Consumidor: Numero agafat: " + numero);
            //inserim lelement enel buffer

            try {
                Thread.sleep(rm.nextInt(2000));

            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
