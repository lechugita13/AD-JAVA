/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_activitat10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author vesprada
 */
public class Adt1_Activitat11 {
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        String url = "www.google.es";
        
        
   URL ficheroUrl = new URL(url);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()))) {
            String linea;
            while ((linea = in.readLine()) != null){
                System.out.println(linea);
            }    } 
}
    }
    

