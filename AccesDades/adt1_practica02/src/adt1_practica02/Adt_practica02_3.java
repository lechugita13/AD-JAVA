/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_practica02;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class Adt_practica02_3 {

    public static void main(String[] args) {
        File pepe = new File("/home/vesprada/Escriptori/pepe.txt");
        File pepe2 = new File("/home/vesprada/Escriptori/pepe2.txt");
        boolean bandera=true;
        try {
            Scanner scn1 = new Scanner(new BufferedReader(new FileReader(pepe)));
            Scanner scn2 = new Scanner(new BufferedReader(new FileReader(pepe2)));
            
            while (scn2.hasNext() && scn1.hasNext() && bandera) {
                String next = scn2.next();
                String next1 = scn1.next();
                System.out.println(next);
                System.out.println(next1);
                if (!next.equals(next1)) {
                    System.out.println("Els archius son diferents");
                    bandera=false;
                   
                }
               
            }
            if (bandera) {
                System.out.println("Els archius son iguals");
            }
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Adt_practica02_3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
