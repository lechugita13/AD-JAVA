/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JTable;
import modelo.Libro;
import modelo.LibroDAO;
import vista.JDLibros;
import vista.JPLibro;

/**
 *
 * @author vesprada
 */
public class ControladorLibro {
    
    private LibroDAO libroDAO; 
    private JPLibro vistaLibro;
    private JDLibros dialogLibros;

    public ControladorLibro( JPLibro vistaLibro) {
        this.libroDAO = new LibroDAO();
        this.vistaLibro = vistaLibro;
    }

    public ControladorLibro( JDLibros dialogLibros) {
        this.libroDAO = new LibroDAO();
        this.dialogLibros = dialogLibros;
    }
    
    

    public ControladorLibro() {
    }

    public LibroDAO getLibroDAO() {
        return libroDAO;
    }

    public void setLibroDAO(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    public JPLibro getVistaLibro() {
        return vistaLibro;
    }

    public void setVistaLibro(JPLibro vistaLibro) {
        this.vistaLibro = vistaLibro;
    }
    
    public void anyadirLibro(){
        
        int isbn = Integer.parseInt(vistaLibro.getTfIsbn().getText());
        int numEjemplares = (int)vistaLibro.getSpEjemplares().getValue();
        int anyo = (int) vistaLibro.getSpAno().getValue();
        int numPag = (int)vistaLibro.getSpNumPags().getValue();
        String titulo = vistaLibro.getTfTitulo().getText();
        String autor = vistaLibro.getTfAutor().getText();
        String editorial = vistaLibro.getCbEditorial().getSelectedItem().toString();
        
        Libro nuevoLibro = new Libro(isbn,numEjemplares, anyo, numPag, titulo,autor,editorial);
      
       
        libroDAO.insertarLibro(nuevoLibro);
    }
    
    public void modificarLibro(){
        int isbn = Integer.parseInt(vistaLibro.getTfIsbn().getText());
        int numEjemplares = (int)vistaLibro.getSpEjemplares().getValue();
        int anyo = (int) vistaLibro.getSpAno().getValue();
        int numPag = (int)vistaLibro.getSpNumPags().getValue();
        String titulo = vistaLibro.getTfTitulo().getText();
        String autor = vistaLibro.getTfAutor().getText();
        String editorial = vistaLibro.getCbEditorial().getSelectedItem().toString();
        
        Libro nuevoLibro = new Libro(isbn,numEjemplares, anyo, numPag, titulo,autor,editorial);
        
        libroDAO.modificarLibro(nuevoLibro);
    }
    
    public void eliminarLibro(){
        int isbn = Integer.parseInt(vistaLibro.getTfIsbn().getText());
        
        libroDAO.eliminarLibro(isbn);
    }
    
    public void buscarLibro(){
        String palabraClave = vistaLibro.getTfBusqueda().getText();
        
        libroDAO.buscarLibro(palabraClave,vistaLibro.getTbLibro());
        
    }
    
    public void buscarLibroDialog(String palabraClave,JTable tabla){
        libroDAO.buscarLibro(palabraClave, tabla);
    }
    
}
