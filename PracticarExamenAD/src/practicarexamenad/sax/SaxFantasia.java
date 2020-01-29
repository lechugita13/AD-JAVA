/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicarexamenad.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
public class SaxFantasia {
    
    private static ArrayList<Libro> listaLibros;
    
    public static void main(String[] args) {
        
        listaLibros = leerDocumento();
        
        mostarLibros();
    }

    private static ArrayList<Libro> leerDocumento() {
        
        try {
            XMLReader xml = XMLReaderFactory.createXMLReader();
            ManejadorLibro manejador = new ManejadorLibro();
            xml.setContentHandler(manejador);
            xml.parse(new InputSource(new FileInputStream(new File("libroXML.xml"))));
            
            return manejador.getListaLibros();
        } catch (SAXException ex) {
            Logger.getLogger(SaxFantasia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaxFantasia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaxFantasia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static void mostarLibros() {
        for (Libro l : listaLibros) {
            l.toString();
        }
    }
    
    
}
