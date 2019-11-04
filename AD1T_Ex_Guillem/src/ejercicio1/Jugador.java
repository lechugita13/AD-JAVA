/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.Serializable;

/**
 *
 * @author vesprada
 */
public class Jugador implements Serializable{
    
    private String nombre;
    private String equipo;
    private int goles;

    public Jugador(String nombre, String equipo, int goles) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.goles = goles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", equipo=" + equipo + ", goles=" + goles + '}';
    }
    
}
