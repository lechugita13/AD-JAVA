/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraserialize;

/**
 *
 * @author vesprada
 */
public class EstadoCalculadora {
    
    private int operacionActiva;
    private double valor;
    private double resultado;

    public EstadoCalculadora(int operacionActiva, double valor, double resultado) {
        this.operacionActiva = operacionActiva;
        this.valor = valor;
        this.resultado = resultado;
    }

    public int getOperacionActiva() {
        return operacionActiva;
    }

    public void setOperacionActiva(int operacionActiva) {
        this.operacionActiva = operacionActiva;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    
    
}
