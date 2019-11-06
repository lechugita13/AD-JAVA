/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt4_ejemplo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class App {
    public static void main(String[] args) {
        
        Connection conexion = null;
        try {
            // TODO code application logic here
            //1. Cargar el driver
            
            Class.forName("com.mysql.jdbc.Driver");
            //2. Establecer la conexion
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/adt4_ejemplo0", "root", "");
            
            //3.Enviar sentencias
            String sql = "UPDATE articulos SET stock = ? WHERE id = ?;";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
           
            sentencia.setInt(1,80);
            sentencia.setInt(2,1);
             
            //ResultSet filas = sentencia.executeQuery(sql);
            //4. Procesar los resultados
            
//            while (filas.next()) {
//               String nombre = filas.getString("nombre");
//               float precio = filas.getFloat("precio");
//               int stock = filas.getInt("stock");
//              String descripcion = filas.getString("descripcion");
//                System.out.println("FILA: "+ nombre + " " + precio + " " +stock + " "+descripcion);
//               
//                
//            }

            int filas = sentencia.executeUpdate();
            
            System.out.println("Filas afectadas: "+filas);
            //Cerrar conex
            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(adt4_ejemplo1.App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adt4_ejemplo1.App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
        }
    }
}
