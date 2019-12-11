package com.example.proyecto1evaluacionguillem;

import java.io.Serializable;

public class Pedido implements Serializable {

    public String nombre;
    public String empresa;
    public int puntadas;
    public Tipo tipo;

    public Pedido() {
    }

    public Pedido(String nombre, String empresa, int puntadas, Tipo tipo) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.puntadas = puntadas;
        this.tipo = tipo;
    }
}
