package com.simarro.practica_6;

public class Robot {

    private String material;
    private String nombre;
    private int anyo;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Robot(String nombre, String material, int anyo,String tipo) {
        this.material = material;
        this.nombre = nombre;
        this.anyo = anyo;
        this.tipo = tipo;
    }

    public String getmaterial() {
        return material;
    }

    public void setmaterial(String material) {
        this.material = material;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
