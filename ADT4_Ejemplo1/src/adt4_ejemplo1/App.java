/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt4_ejemplo1;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            // TODO code application logic here
            //1. Cargar el driver
            
            Class.forName("com.mysql.jdbc.Driver");
            //2. Establecer la conexion
            
            conexion = DriverManager.getConnection("jdbc:mysql://192.168.8.99/adt4_ejemplo0", "pepe", "pepe");
            
            //3.Enviar sentencias
            String sql = "INSERT INTO articulos (nombre,precio,stock,descripcion) VALUES  ('Hacker',10.00,2,'Soc una merda de persona');";
            Statement sentencia = conexion.createStatement();
            
            int filas = sentencia.executeUpdate(sql);
            //4. Procesar los resultados
            
            System.out.println("Filas afectadas: "+filas);
            //Cerrar conex
            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
        }
    }
    
}
