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
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class Adt_practica02_2 {

    public static void main(String[] args) {

        File texto = new File("/home/vesprada/Escriptori/texto.txt");
        try {
            Scanner scn = new Scanner(new BufferedReader(new FileReader(texto)));
            PrintWriter pw = new PrintWriter(new FileWriter(texto));

            while (scn.hasNext()) {
                String next = scn.next();
                pw.write(next.toUpperCase());

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Adt_practica02_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Adt_practica02_2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
