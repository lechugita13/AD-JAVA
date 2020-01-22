/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author vesprada
 */
public class Socio {
    private int numSocio,edad;
    private String nombre,apellidos,telefono,falta;

    public Socio() {
    }

    public Socio(int numSocio, int edad, String nombre, String apellidos, String telefono, String falta) {
        this.numSocio = numSocio;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.falta = falta;
    }

    public int getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFalta() {
        return falta;
    }

    public void setFalta(String falta) {
        this.falta = falta;
    }
    
    
}
