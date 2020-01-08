/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Statement;

/**
 *
 * @author Guillem
 */
public class LibroDAO {
       
 
    
    
    public void insertarLibro(Libro libro){
        GestionBD singeltonBDD = GestionBD.crearSingeltonBDD();
        try {
            Statement st = singeltonBDD.getConnection().createStatement();
            st.execute("INSERT INTO libro VALUES ('"+libro.getIsbn()+"','"+libro.getTitulo()+"','"+libro.getAutor()+"','"+libro.getNumejemplares()+"','"+libro.getAnyopublicacion()+"','"+libro.getEditorial()+"','"+libro.getNumpag()+"')");
            st.close();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    public Libro obtenerLibro(int id){
        return new Libro();
    }
    public void modificarLibro(Libro libro){
         GestionBD singeltonBDD = GestionBD.crearSingeltonBDD();
        try {
              Statement st = singeltonBDD.getConnection().createStatement();
               st.execute("UPDATE libro SET titulo = '"+libro.getTitulo()+"',"+"autor = '"+libro.getAutor()+"', titulo = '"+libro.getTitulo()+"',"+"numejemplares = '"+libro.getNumejemplares()+"',"+" anyopublicacion = '"+libro.getAnyopublicacion()+"',"+" editorial = '"+libro.getEditorial()+","+" numpag = '"+libro.getNumpag()+","+"WHERE isbn = '"+libro.getIsbn()+"'");
               st.close();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
      
    }
    public void eliminarLibro(Libro libro){
          GestionBD singeltonBDD = GestionBD.crearSingeltonBDD();
        try {
              Statement st = singeltonBDD.getConnection().createStatement();
               st.execute("DELETE FROM libro WHERE isbn = '"+libro.getIsbn()+"'");
               st.close();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        
    }
}


