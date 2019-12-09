/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vesprada
 */
public class SingeltonBDD {
    
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String BD = "ejemploMVC";
    private String LOGIN = "root";
    private String PASSWORD = "";
    private String URL = "jdbc:mysql://localhost";
    
    private static SingeltonBDD singleton;
    private Connection conexion;
    
    private SingeltonBDD(){
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, LOGIN,PASSWORD);
            
        } catch (Exception e) {
            System.out.println("Error conexion "+e.getMessage());
        }
    }
     public static SingeltonBDD crearSingeltonBDD(){
        if (singleton == null) {
            singleton = new SingeltonBDD();
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
