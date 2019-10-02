/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica3;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Guillem
 */
public class Adt3_practica3 {

    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);
        int opc;
        File ejercicio3 = new File("ejercicio3.xml");
        String expression = "/libros/prestamo";

        do {
            try {
                menu();
                opc = e.nextInt();
                switch (opc) {
                    case 1:
                        
                        XmlCtrlDom fantasia = new XmlCtrlDom();
                        
                        fantasia.escribirDocumentAXmlPantalla(fantasia.instanciarDocument(ejercicio3));
                        
                        break;
                    case 2:
                     
                        
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Adt3_practica3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(Adt3_practica3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Adt3_practica3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(Adt3_practica3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);

    }

    private static void menu() {
        System.out.println("Opcion 1.- Vista de todo el documento XML");
        System.out.println("Opcion 2.- Listado de los libros prestados");
        System.out.println("Opcion 3.- Listado de los libros en venta");
        System.out.println("Opcion 4.- Añadir un nuevo libro prestado");
        System.out.println("Opcion 5.- Salir");
    }
}
