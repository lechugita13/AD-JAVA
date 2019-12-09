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
public class ClienteVo {
    
     private int id;
    private String nombre;
    private String apellido;
    private String nif;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public ClienteVo() {
    }

    public ClienteVo(int id, String nombre, String apellido, String nif) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
    }
}
