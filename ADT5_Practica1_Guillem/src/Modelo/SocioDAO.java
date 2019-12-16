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
public class SocioDAO {
    
    public void insertarPrestamo(Socio socio){
        GestionBD singeltonBDD = GestionBD.crearSingeltonBDD();
        try {
            Statement st = singeltonBDD.getConnection().createStatement();
            st.execute("INSERT INTO cliente VALUES (NULL,'"+socio.getNumsocio()+"','"+socio.getNombre()+"','"+socio.getApellidos()+"','"+socio.getTelefono()+"','"+socio.getEdad()+"','"+socio.getFalta()+"')");
            st.close();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    public Socio obtenerPrestamo(int id){
        return new Socio();
    }
    public void modificarPrestamo(Socio socio){
        
    }
    public void eliminarPrestamo(Socio socio){
        
    }
}
