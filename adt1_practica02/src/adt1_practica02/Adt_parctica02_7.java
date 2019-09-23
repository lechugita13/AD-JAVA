/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_practica02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class Adt_parctica02_7 {
    
    public static void main(String[] args) {
        
        
        File ex7 = new File("/home/vesprada/Escriptori/exercici7.txt");
        
        try {
            Scanner scn = new Scanner(new BufferedReader(new FileReader(ex7)));
            while (scn.hasNext()) {
                String paraula = scn.next();
                paraula.toLowerCase();
                for (int i = 0; i < paraula.length(); i++) {
//                    if (paraula[i]='a' || paraula[i]='e' || paraula[i]='i' || paraula[i]='o' || paraula[i]='u') {
//                    
//                    
//                    }

                
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Adt_parctica02_7.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
