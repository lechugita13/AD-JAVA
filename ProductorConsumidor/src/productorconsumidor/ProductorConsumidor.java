/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author vesprada
 */
public class ProductorConsumidor {

    /**
     * programa principal
     */
    public static void main(String[] args) throws InterruptedException{
        // creem el monitor : buffer
        
        MonitorBuffer buffer = new MonitorBuffer();
        //Creem productor
        Productor p = new Productor(buffer);
        //Creem el consumidor
        Consumidor c = new Consumidor(buffer);
        //Creem els fils
        Thread productor = new Thread(p);
        Thread consumidor = new Thread(c);
        //Els fiquem en marxa
        productor.start();
        consumidor.start();
        
        
    }
    
}
