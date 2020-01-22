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
public class Libro {
    private int isbn,numEjemplares,anyoPublicacion,numPag;
    private String titulo,autor,editorial;

    public Libro() {
    }

    public Libro(int isbn, int numEjemplares, int anyoPublicacion, int numPag, String titulo, String autor, String editorial) {
        this.isbn = isbn;
        this.numEjemplares = numEjemplares;
        this.anyoPublicacion = anyoPublicacion;
        this.numPag = numPag;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public int getAnyoPublicacion() {
        return anyoPublicacion;
    }

    public void setAnyoPublicacion(int anyoPublicacion) {
        this.anyoPublicacion = anyoPublicacion;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", numEjemplares=" + numEjemplares + ", anyoPublicacion=" + anyoPublicacion + ", numPag=" + numPag + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + '}';
    }
    
    
    
    
    
    
}
