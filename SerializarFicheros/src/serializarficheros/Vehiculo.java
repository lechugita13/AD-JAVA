/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializarficheros;

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
