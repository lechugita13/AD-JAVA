/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_activitat10;

import javax.swing.JOptionPane;

/**
 *
 * @author vesprada
 */
public class Vehiculo {
    
    private String matricula;
    private String marca;
    private double tamDeposito;
    private String modelo;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamDeposito() {
        return tamDeposito;
    }

    public void setTamDeposito(double tamDeposito) {
        this.tamDeposito = tamDeposito;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
}