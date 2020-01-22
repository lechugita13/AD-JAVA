/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vesprada
 */
public class PrestamoDAO {
    public void insertarPrestamo(Prestamo prestamo){
        GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("INSERT INTO prestamo VALUES ("+prestamo.getLibro()+","+prestamo.getSocio()+",'"+prestamo.getFprestamo()+"','"+prestamo.getFdevolucion()+"')");
            System.out.println("Prestamo insertado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public Prestamo obtenerPrestamo(int id){
        return new Prestamo();
    }
    
    public void modificarPrestamo(Prestamo prestamo){
        GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("UPDATE prestamo SET fprestamo='"+prestamo.getFprestamo()+"', fdevolucion='"+prestamo.getFdevolucion()+"' "
                    + "WHERE libro="+prestamo.getLibro()+" AND socio="+prestamo.getSocio()+"");
            System.out.println("Prestamo modificado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public void eliminarPrestamo(int socio,int libro){
        GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("DELETE from prestamo WHERE socio="+socio+" AND libro="+libro+"");
            
            System.out.println("Prestamo eliminado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
    }
}
