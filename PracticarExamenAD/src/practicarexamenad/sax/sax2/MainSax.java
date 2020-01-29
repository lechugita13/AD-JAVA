/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicarexamenad.sax.sax2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Guillem
 */
public class MainSax {
    
    public static ArrayList<Libro> listaLibros;
    
    public static void main(String[] args) {
        
        try {
            listaLibros = leerLibros();
        } catch (IOException ex) {
            Logger.getLogger(MainSax.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MainSax.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("LIBROS DESORDENADOOOOS");
        mostarLibros();
        
        System.out.println("LIBROS ORDENADOOOOOOOOOOOS");
        
        ordenarLibros();
    }

    
    private static ArrayList<Libro> leerLibros() throws FileNotFoundException, IOException, SAXException {
       XMLReader xml = XMLReaderFactory.createXMLReader();
       ManejadorLibro manejador = new ManejadorLibro();
       xml.setContentHandler(manejador);
       xml.parse(new InputSource(new FileInputStream(new File("libroXML.xml"))));
       
       return manejador.getListaLibros();
       
    }

    private static void mostarLibros() {
        for (Libro libro : listaLibros) {
            System.out.println(libro.toString());
        }
    }

    private static void ordenarLibros() {
        Collections.sort(listaLibros);
        mostarLibros();
    }
  
    
}
