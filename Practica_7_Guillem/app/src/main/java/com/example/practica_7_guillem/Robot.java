package com.example.practica_7_guillem;

import java.io.Serializable;

public class Robot implements Serializable {

    public String nombre;
    public String material;
    public int anyo;
    public Tipo tipo;

    public Robot() {
    }

    public Robot(String nombre, String material, int anyo, Tipo tipo) {
        this.nombre = nombre;
        this.material = material;
        this.anyo = anyo;
        this.tipo = tipo;
    }
}
