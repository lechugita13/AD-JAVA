/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vesprada
 */
public class ADT3_Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("libro.xml"));
            NodeList e = (NodeList) document.getElementsByTagName("prestamo");
            
            
            Element libroNuevo = document.createElement("libro");  
            libroNuevo.setAttribute("isbn", "666-666-666");
            Element titulo = document.createElement("titulo");
            Element autor = document.createElement("autor");
            Element anyo = document.createElement("anyo");
            Element editorial = document.createElement("editorial");
            titulo.setTextContent("Stormlight Archive");
            autor.setTextContent("Brandon Sanderson");
            anyo.setTextContent("2020");
            editorial.setTextContent("Bromera");
            
            libroNuevo.appendChild(titulo);
            libroNuevo.appendChild(autor);
            libroNuevo.appendChild(anyo);
            libroNuevo.appendChild(editorial);
            
            e.item(0).appendChild(libroNuevo);
             Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.METHOD, "xml");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("libro.xml"));
            try {
                trans.transform(source, result);
            } catch (TransformerException ex) {
                Logger.getLogger(ADT3_Practica1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(ADT3_Practica1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ADT3_Practica1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
