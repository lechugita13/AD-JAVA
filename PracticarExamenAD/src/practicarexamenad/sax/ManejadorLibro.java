/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicarexamenad.sax;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Guillem
 */
public class ManejadorLibro extends DefaultHandler{
    
    private ArrayList<Libro> listaLibros;
    
    private String temporal;
    private Libro libroTemporal;
    
    private boolean leer;

    public ManejadorLibro() {
        this.listaLibros = new ArrayList<>();
        this.leer = false;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public String getTemporal() {
        return temporal;
    }

    public void setTemporal(String temporal) {
        this.temporal = temporal;
    }

    public Libro getLibroTemporal() {
        return libroTemporal;
    }

    public void setLibroTemporal(Libro libroTemporal) {
        this.libroTemporal = libroTemporal;
    }

    public boolean isLeer() {
        return leer;
    }

    public void setLeer(boolean leer) {
        this.leer = leer;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.temporal = new String(ch,start,length);
    }

    @Override
    public void endElement(String uri, String nombre, String qName) throws SAXException {
        
        if (!this.leer) {
            return;
        }
        if (nombre.equals("prestamo")) {
            
            this.leer = false;
            
        }else if (nombre.equals("libro")) {
            this.listaLibros.add(this.libroTemporal);
        }else if (nombre.equals("titulo")) {
            this.libroTemporal.setTitulo(this.temporal);
        }else if (nombre.equals("autor")) {
           this.libroTemporal.setAutor(this.temporal);
        }else if (nombre.equals("anyo")) {
            this.libroTemporal.setAnyo(Integer.parseInt(this.temporal));
        }else if (nombre.equals("editorial")) {
            this.libroTemporal.setEditorial(this.temporal);
        }
    }

    @Override
    public void startElement(String uri, String nombre, String qName, Attributes attributes) throws SAXException {
        if (nombre.equals("prestamo")) {
            this.leer = true;
            
        }else if (this.leer && nombre.equals("libro")) {
            this.libroTemporal = new Libro();
            this.libroTemporal.setIsbn(attributes.getValue("isbn"));
        }
    }
    
    
    
    
    
    
}
