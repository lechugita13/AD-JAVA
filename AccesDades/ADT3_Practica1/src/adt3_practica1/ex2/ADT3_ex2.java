/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica1.ex2;

import adt3_practica1.ADT3_Practica1;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.DoubleStream.builder;
import static java.util.stream.Stream.builder;
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
public class ADT3_ex2 {

    public static void main(String[] args) {

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();

            Element alumnos = document.createElement("alumnos");
            Element alumnoNuevo = document.createElement("alumno");

            Element nombre = document.createElement("nombre");
            Element apellido = document.createElement("apellido");
            Element edad = document.createElement("edad");

            nombre.setTextContent("Guillem");
            apellido.setTextContent("Clar Torres");
            edad.setTextContent("23");

            alumnoNuevo.appendChild(nombre);
            alumnoNuevo.appendChild(apellido);
            alumnoNuevo.appendChild(edad);
            alumnos.appendChild(alumnoNuevo);

           
            document.appendChild(alumnos);
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.METHOD, "xml");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("alumnos.xml"));
            try {
                trans.transform(source, result);
            } catch (TransformerException ex) {
                Logger.getLogger(ADT3_Practica1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ADT3_Practica1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ADT3_Practica1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
