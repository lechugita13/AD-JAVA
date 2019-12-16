/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Guillem
 */
public class Prestamo {
    
    private int libro;
    private int socio;
    private Date fprestamo;
    private Date fdevolucion;

    Prestamo() {
      
    }

    public int getLibro() {
        return libro;
    }

    public void setLibro(int libro) {
        this.libro = libro;
    }

    public int getSocio() {
        return socio;
    }

    public void setSocio(int socio) {
        this.socio = socio;
    }

    public Date getFprestamo() {
        return fprestamo;
    }

    public void setFprestamo(Date fprestamo) {
        this.fprestamo = fprestamo;
    }

    public Date getFdevolucion() {
        return fdevolucion;
    }

    public void setFdevolucion(Date fdevolucion) {
        this.fdevolucion = fdevolucion;
    }

    public Prestamo(int libro, int socio, Date fprestamo, Date fdevolucion) {
        this.libro = libro;
        this.socio = socio;
        this.fprestamo = fprestamo;
        this.fdevolucion = fdevolucion;
    }
}
