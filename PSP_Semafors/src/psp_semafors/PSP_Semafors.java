/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_semafors;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 *
 * @author vesprada
 */
public class PSP_Semafors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayDeque<Integer> cua = new ArrayDeque<Integer>();
        //Rec�rrer Cua per imprimir

        Iterator<Integer> itr = cua.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        //Afegir al final
        //cua.add(valorEnter);

    }

}
