/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializarficheros;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Guillem
 */
public class Vehiculo implements Serializable{
    
    private String marca;
    private String modeloCoche;
    private String matricula;
    private int potencia;
    private String color;

    public Vehiculo(String marca, String modeloCoche, String matricula, int potencia, String color) {
        this.marca = marca;
        this.modeloCoche = modeloCoche;
        this.matricula = matricula;
        this.potencia = potencia;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca del cotxe: ").append(marca+"\n")
                .append("Modelo del cotxe: ").append(modeloCoche+"\n")
                .append("Matricula del cotxe: ").append(matricula+"\n")
                .append("Els caballs: ").append(potencia+"\n")
                .append("El color del cotxe: ").append(color+"\n");
        
        return sb.toString();
    }


    
}
