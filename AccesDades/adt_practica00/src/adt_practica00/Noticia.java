/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_practica00;

import java.util.Date;

/**
 *
 * @author vesprada
 */
public class Noticia {

    private int fecha;
    private int hora;
    private String texto;
    private int contLeido;

    public Noticia(int fecha, int hora, String texto) {
        this.fecha = fecha;
        this.hora = hora;
        this.texto = texto;

    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getContLeido() {
        return contLeido;
    }

    public void setContLeido(int contLeido) {
        this.contLeido = contLeido;
    }

    public int getData() {

        return getFecha();
    }

    ;
    
    public int getLecturas() {
        return getContLeido();
    }

    ;
    
    public void incLecturas() {
        contLeido++;

    }

    ;
    
    public boolean igualDate(int d, int m, int a) {

        int fechaProba;
        fechaProba = d + m * 100 + a * 10000;
        return fechaProba == this.fecha;
    }

    ;

    @Override
    public String toString() {
        String s = "";
        s += fecha % 100 + "/" + (fecha / 100) % 100 + "/" + (fecha / 10000) + " - ";
        s += (hora / 100) + ":" + (hora % 100) + "\n";
        s += texto + "\n";
        s += "Leída " + contLeido + " veces\n";
        return s;
    }

}
