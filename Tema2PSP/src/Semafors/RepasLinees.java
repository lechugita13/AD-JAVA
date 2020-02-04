/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semafors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class RepasLinees {
    
    private static File arxiu = new File("lineesrepas.txt");
    private static ArrayList<String>paraulesInvertides = new ArrayList<>();
    private static File nouArxiu = new File("textinvertit.txt");
    public static void main(String[] args) {
        int contadorMain=0;
      ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            
            executor.execute(new proces(contadorMain));
            contadorMain++;
        }
        executor.shutdown();
        
    }
    
    static class proces implements Runnable{
        private int cont = 0;
        
        public proces(int cont) {
            this.cont = cont;
        }

        @Override
        public void run() {
            FileReader fr = null;
            try {
                fr = new FileReader(arxiu);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(nouArxiu,true);
                
                String linea = br.readLine();
               
                while (linea !=null) {                    
                    System.out.println(cont+" "+linea);
                    StringBuilder sb= new StringBuilder();
                    sb.append(linea);
                    fw.write(sb.reverse().toString()+"\n");
                    this.cont++;
                    linea=br.readLine();
                    
                }
                br.close();
                fw.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RepasLinees.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RepasLinees.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(RepasLinees.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        
    }
    
    
    
    
}
