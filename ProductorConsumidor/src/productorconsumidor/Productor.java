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
 * classe proces productor
 */
class Productor implements Runnable {

    //Monitor que gestiona la comunicacio i sincronitzacio entre els procesos
    private MonitorBuffer buff;

    public Productor(MonitorBuffer buff) {
        this.buff = buff;
    }

    @Override
    public void run() {
        int numero = 0;
        //creem valor aleatori
        Random rm = new Random();
        //produira 10 elemments

        for (int i = 0; i < 10; i++) {
            //generem numero aleatori
            numero = rm.nextInt(100);
            //mostra el numero
            System.out.println("Productor: Numero produit: " + numero);
            //inserim lelement enel buffer
            buff.afegir(numero);
            try {
                Thread.sleep(rm.nextInt(1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
