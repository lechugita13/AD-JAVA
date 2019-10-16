/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica00;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author vesprada
 */
public class Periodico {

    private ArrayList<Noticia> listaNoticias;
    private int numNoticias;

    public Periodico() {
        listaNoticias = new ArrayList(1000);
        numNoticias = this.numNoticias;
    }

    public ArrayList<Noticia> getListaNoticias() {

        return listaNoticias;
    }

    public void setListaNoticias(ArrayList<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    public int getNumNoticias() {
        return numNoticias;
    }

    public void setNumNoticias(int numNoticias) {
        this.numNoticias = numNoticias;
    }

    public void insertar(Noticia n) {
        

    }

    ;
    
    public Noticia primeraNoticia(int d, int m, int a) {
        
        int fechaDona=d+m*100+a*10000;
        for (int i = 0; i < listaNoticias.size(); i++) {
            Noticia get = listaNoticias.get(i);
            if (fechaDona==get.getFecha()) {
                return get;
            }
        }
        return null;

    }

    public void masPopulares() {
        //Per a ints reversed per a fer de major a menor
        listaNoticias.sort(Comparator.comparing(Noticia::getContLeido).reversed());
        //Per a String reserved de baix a dalt del abecedari
        
        listaNoticias.get(1).toString();
        
        File pepe = new File("home/");
        

    }

    public void borrarAnteriores(int d, int m, int a) {

        
        
    };
}
