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
public class PrestamoDAO {
      
    public void insertarPrestamo(Prestamo prestamo){
        GestionBD singeltonBDD = GestionBD.crearSingeltonBDD();
        try {
            Statement st = singeltonBDD.getConnection().createStatement();
            st.execute("INSERT INTO cliente VALUES (NULL,'"+prestamo.getLibro()+"','"+prestamo.getSocio()+"','"+prestamo.getFprestamo()+"','"+prestamo.getFdevolucion()+"')");
            st.close();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    public Prestamo obtenerPrestamo(int id){
        return new Prestamo();
    }
    public void modificarPrestamo(Prestamo prestamo){
        
    }
    public void eliminarPrestamo(Prestamo prestamo){
        
    }
}
