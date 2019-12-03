/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
class MonitorBuffer {

    //recurscompartir bufer : array de 10 integers
    private int buffer[] = new int[10];
    //index de lelement de larray a agafar
    private int indexArray = 0;
    //variables de condicio
    private boolean bufferPle = false;
    private boolean bufferBuit = true;

    //metode per agafar un element del buffer
    public synchronized void afegir(int numero) {
        //mentre el buffer estiga ple el productor ha de esperar
        while (bufferPle) {
            try {
                wait();

            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            //afegim el numero en la posicio indicada per el index array
            buffer[indexArray] = numero;
            //mostrem per pantalla lelement afegit
            System.out.println("Index de lelement de larray a afegir: " + indexArray);
            //actualitzem el valor de lindex
            indexArray++;
            //Atualitzem els valors de les variables de condicio
            if (indexArray == 10) {
                bufferPle = true;

            }
            bufferBuit = false;
            notify();

        
    }

    public synchronized int agafar() {
        //mentre el buffer estiga buit espera

        while (bufferBuit) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //socunafantasia de persona 
        //ha dactualitzar el valor de la posicio de lelement en el array
        indexArray--;
        //Mostrem el valor de lelement agafat 
        System.out.println("Index de larray de larray a agafar: " + indexArray);
        //si ja no queden elements a consumir
        if (indexArray == 0) {
            bufferBuit = true;//el buffer esta buit
        }
        //el buffer segur que ja no esta ple
        bufferPle = false;
        //avisem que ja es pot accedir al buffer per a produir
        notify();

        return buffer[indexArray];
    }

}
