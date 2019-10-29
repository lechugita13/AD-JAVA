/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vesprada
 */
public class App {

    public static void main(String[] args) {

        try {
            XmlCtrlDom ajuda = new XmlCtrlDom();
            ArrayList<Libro> listaLibros = new ArrayList<>();
            File xml = new File("libroXML.xml");
            
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            
            Document doc = ajuda.instanciarDocument(xml);
            //NodeList list = (NodeList) xpath.evaluate("//libro", doc,XPathConstants.NODESET);
            
            NodeList list = doc.getElementsByTagName("libro");
           
            
            for (int i = 0; i < list.getLength();i++) {
               NodeList titulos = doc.getElementsByTagName("titulo");
               NodeList autors = doc.getElementsByTagName("autor");
               NodeList anyos = doc.getElementsByTagName("anyo");
               NodeList editorials = doc.getElementsByTagName("editorial");
               String isbn = list.item(i).getPrefix();
               String titulo = titulos.item(i).getTextContent();
               String autor = autors.item(i).getTextContent();
               String anyo = anyos.item(i).getTextContent();
               String editorial = editorials.item(i).getTextContent();
               
               Libro l1 = new Libro(isbn, titulo, autor, Integer.parseInt(anyo), editorial);
               listaLibros.add(l1);
                       
            }
           
            for (int i = 0; i < listaLibros.size(); i++) {
                Libro get = listaLibros.get(i);
                System.out.println(get.toString());
                
            }
            
            System.out.println("A PARTIR DE ACI ESTA ORDENAT"+"\n");
            listaLibros.sort((Libro o1, Libro o2) -> {
                if (o1.getAnyo()>o2.getAnyo()) {
                    return 1;
                }
                return 0; //To change body of generated lambdas, choose Tools | Templates.
            });
            for (int i = 0; i < listaLibros.size(); i++) {
                Libro get = listaLibros.get(i);
                System.out.println(get.toString());
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
