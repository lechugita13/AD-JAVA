package ejercicio2;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlCtrlDom {

    public XmlCtrlDom() {
    }

    public Document instanciarDocument()
            throws ParserConfigurationException {
        // Para conseguir una instancia del analizador DOM a través de
        // JAXP usamos las clases DocumentBuider y DocumentBuildrFactory
        // W3C - Clase no abstracta
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // W3C - Especificación de la clase para poder instaciar estruturas DOM
        DocumentBuilder db = dbf.newDocumentBuilder();
        // Crea un arbol DOM vacío
        Document document = db.newDocument();

        return document;
    }

    public Document instanciarDocument(File fXmlFile)
            throws ParserConfigurationException, IOException, SAXException {
        // Para conseguir una instancia del analizador DOM a través de
        // JAXP usamos las clases DocumentBuider y DocumentBuilderFactory
        // W3C - Clase no abstracta
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // W3C - Especificación de la clase para poder instaciar estruturas DOM
        DocumentBuilder db = dbf.newDocumentBuilder();
        // Representa el documento XML en DOM
        Document document = db.parse(fXmlFile);
        // Para eliminar nodos de textos vacios
        document.getDocumentElement().normalize();

        return document;
    }

    /* 
     TransformerFactory  obtiene  un objecto  de la  factoria de transformadores. 
     Una vez obtenido   una   instancia   de   transformador, se   puede   definir   
     propiedades   para   su   posterior serialización. Se debe indicar el 
     Document de donde se obtiene el XML (clase Source) y también donde se va 
     a escribir por medio del objeto de tipo Result  
     */
    public void escribirDocumentAXmlFichero(Document doc, File file)
            throws TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        trans.transform(source, result);
    }

    public void escribirDocumentAXmlPantalla(Document doc)
            throws TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        // Mostrar XML x pantalla
        StreamResult pantalla = new StreamResult(System.out);
        trans.transform(source, pantalla);
    }

    public void escribirDocumentAXmlPantallaFormato(Document doc)
            throws FileNotFoundException, IOException {
        OutputFormat format = new OutputFormat(doc);
        format.setIndenting(true);

        XMLSerializer serializer = new XMLSerializer(System.out, format);
        serializer.serialize(doc);
    }

    public void escribirDocumentAXmlFicheroFormato(Document doc, File file)
            throws FileNotFoundException, IOException {
        OutputFormat format = new OutputFormat(doc);
        format.setIndenting(true);

        XMLSerializer serializer = new XMLSerializer(new FileOutputStream(file), format);
        serializer.serialize(doc);
    }
}
