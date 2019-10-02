/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt3_practica4;

import com.sun.xml.internal.fastinfoset.util.LocalNameQualifiedNamesMap;
import javax.xml.stream.events.StartElement;
import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import sun.security.util.Length;

/**
 *
 * @author vesprada
 */
public class ManejadorAlumno extends DefaultHandler{
    
    private String valor=null;
    private Alumno alumno;

    public ManejadorAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes atrbts) throws SAXException {
     
        valor= null;
        
        if(localName.equals("alumno")){
            String id = atrbts.getValue("id");
            alumno.setId((Integer.parseInt(id)));
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
      valor = new String(chars,start,length);  
      
      
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        switch (localName) {
            case "nom":
                alumno.setNom(valor);
                break;
            case "cognoms":
                alumno.setCognom(valor);
                break;
            case "curs":
                alumno.setCurs(valor);
                break;
            default:
                break;
        }
    }

    
}
