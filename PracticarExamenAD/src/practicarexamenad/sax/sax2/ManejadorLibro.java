/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicarexamenad.sax.sax2;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Guillem
 */
public class ManejadorLibro extends DefaultHandler{
    
    private ArrayList<Libro>listaLibros;
    private String temporal;

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }
    private Libro libroTemporal;
    private boolean leer;
    
    public ManejadorLibro() {
        listaLibros=new ArrayList<>();
        leer = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.temporal = new String(ch,start,length);
    }

    @Override
    public void startElement(String uri, String nombre, String qName, Attributes attributes) throws SAXException {
        
       
        if (nombre.equals("prestamo")) {
            this.leer = true;
            
        }if (this.leer && nombre.equals("libro")) {
            libroTemporal = new Libro();
            libroTemporal.setIsbn(attributes.getValue("isbn"));
        }
    }

    @Override
    public void endElement(String uri, String nombre, String qName) throws SAXException {
        
        if (!this.leer) {
            return;
        }
        if (nombre.equals("prestamo")) {
            this.leer = false;
        }else if (nombre.equals("libro")) {
            listaLibros.add(libroTemporal);
        }else if (nombre.equals("titulo")) {
            libroTemporal.setTitulo(this.temporal);
        }else if (nombre.equals("autor")) {
            libroTemporal.setAutor(this.temporal);
        }else if (nombre.equals("anyo")) {
            libroTemporal.setAnyo(Integer.parseInt(this.temporal));
        }else if (nombre.equals("editorial")) {
            libroTemporal.setEditorial(this.temporal);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
