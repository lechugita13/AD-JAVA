/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt1_practica01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class GestionArchivos {

    private String nombreCarpeta;
    private String nuevaCarpeta;
    private String nombreArchivo;

    public GestionArchivos(String nombreCarpeta, String nuevaCarpeta, String nombreArchivo) {
        this.nombreCarpeta = "/home";
        this.nuevaCarpeta = nuevaCarpeta;
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreCarpeta() {
        return nombreCarpeta;
    }

    public void setNombreCarpeta(String nombreCarpeta) {
        this.nombreCarpeta = nombreCarpeta;
    }

    public String getNuevaCarpeta() {
        return nuevaCarpeta;
    }

    public void setNuevaCarpeta(String nuevaCarpeta) {
        this.nuevaCarpeta = nuevaCarpeta;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void listarCarpetaTrabajo() {
        File carpeta = new File(nombreCarpeta);

        File[] carpetas = carpeta.listFiles();
        for (File carpeta1 : carpetas) {

            System.out.println(carpeta1.getName());
        }
    }

    public String informacionDetallada() {
        Scanner s = new Scanner(System.in);
        System.out.println("Escribe el nombre del archivo");
        String nombre = s.next();
        File carpeta = new File(nombreCarpeta);
        File[] carpetas = carpeta.listFiles();
        for (int i = 0; i < carpetas.length; i++) {
            File carpeta1 = carpetas[i];
            if (carpeta1.getName().equals(nombre)) {
                String tornar
                        = "Nombre: " + carpeta1.getName()
                        + "/nLongitud: " + carpeta1.getTotalSpace()
                        + "/nUbicacion: " + carpeta1.getPath()
                        + "/nUltima modificacion: " + carpeta1.lastModified()
                        + "/Oculto: " + carpeta1.getName();
                return tornar;
            }
        }

        return null;

    }

    public void crearCarpeta() {
        
        File carpeta= new File(this.nombreCarpeta,this.nuevaCarpeta);
        if (!carpeta.mkdir()) {
            System.out.println("La carpeta no ha sigut creada");
        }else{
            System.out.println("Eres un parguela");
        }
    }

    public void crearFichero() {
        
        File fichero = new File(this.nombreArchivo);
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(GestionArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (fichero.exists()) {
            System.out.println("El archivo ha sido creado con exito");
        }else{
            System.out.println("Eres un parguela v2");
        }
    }

    public void eliminarFichero() {
       File fichero = new File(this.nombreArchivo);
        if (fichero.exists()) {
             fichero.delete();
        }
      
        
    }

}
