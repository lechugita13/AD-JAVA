/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


/**
 *
 * @author vesprada
 */
public class Adt3_practica4 {

    public static void main(String[] args) {
        try {
            File filename = new File("ejercicio4.xml");
            Alumno a1 = new Alumno();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler ((ContentHandler) new ManejadorAlumno (a1));
            reader.parse(new InputSource(new FileInputStream(filename)));
            System.out.println(a1.toString());
            
        } catch (SAXException ex) {
            Logger.getLogger(Adt3_practica4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Adt3_practica4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    
}
