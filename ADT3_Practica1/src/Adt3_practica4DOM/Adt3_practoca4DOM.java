/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adt3_practica4DOM;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vesprada
 */
public class Adt3_practoca4DOM {

    public static void main(String[] args) {
        ArrayList<Alumno> listaAlumnos= new ArrayList<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("ejercicio4.xml"));
            
            NodeList nodeList = (NodeList) document.getElementsByTagName("alumne");
            
            for (int i = 0; i < nodeList.getLength();i++) {
                Node nodeIndividual = nodeList.item(i);
                
                if (nodeIndividual.getNodeType()==Node.ELEMENT_NODE) {
                    Element e1 = (Element) nodeIndividual;
                    String id = e1.getAttribute("id");
                    String nom = e1.getElementsByTagName("nom").item(0).getTextContent();
                    String cognom = e1.getElementsByTagName("cognom").item(0).getTextContent();
                    String curs = e1.getElementsByTagName("curs").item(0).getTextContent();
                   Alumno alumne = new Alumno((Integer.parseInt(id)), nom, cognom, curs);
                   listaAlumnos.add(alumne);
                }
                
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Adt3_practoca4DOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Adt3_practoca4DOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Adt3_practoca4DOM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
