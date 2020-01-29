/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicarexamenad.sax.sax2;

/**
 *
 * @author Guillem
 */
public class Libro implements Comparable<Libro>{
    
  
    private String isbn;
    private String titulo;
    private String autor;
    private int anyo;
    private String editorial;

    public Libro() {
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", anyo=" + anyo + ", editorial=" + editorial + '}';
    }

    public Libro(String isbn, String titulo, String autor, int anyo, String editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anyo;
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public int compareTo(Libro o) {
       
        if (this.anyo > o.anyo) {
            return -1;
            
        }else if (this.anyo< o.anyo) {
            return 1;
        }else{
            return 0;
        }
    }

   
   
    
    
}
