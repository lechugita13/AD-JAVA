/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probespreexamen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.security.smartcardio.SunPCSC;

/**
 *
 * @author Guillem
 */
public class Dom {
    public static void main(String[] args) {
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(new File("pepe.xml"));
            Element ele = doc.getElementById("fantasia");
            NodeList nList = doc.getElementsByTagName("coche");
            
            for (int i = 0; i < nList.getLength(); i++) {
                
                Node nNode = nList.item(i);
                
                if (nNode.getNodeType()==Node.ELEMENT_NODE) {
                    Element element = (Element)nNode;
                }
            }
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Dom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Dom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
