/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vesprada
 */
public class GestionBD {
    
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String BD = "biblioteca";
    private String LOGIN = "root";
    private String PASSWORD = "";
    private String URL = "jdbc:mysql://localhost/"+BD;
    
    private static GestionBD singleton;
    private Connection conexion;
    
    private GestionBD(){
        try {
            Class.forName(DRIVER);
            
            conexion = DriverManager.getConnection(URL, LOGIN,PASSWORD);
            System.out.println("Conectado a la base de penks");
        } catch (Exception e) {
            System.out.println("Error conexion "+e.getMessage());
        }
    }
     public static GestionBD crearSingeltonBDD(){
        if (singleton == null) {
            singleton = new GestionBD();
        }
        return singleton;
    }
     public Connection getConnection(){
         return conexion;
     }
     public void desconectar(){
         try {
             singleton.conexion.close();
         } catch (Exception e) {
             System.out.println("Josep esta penk");
         }
     }
}
