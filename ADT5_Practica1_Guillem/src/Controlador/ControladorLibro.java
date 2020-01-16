/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Libro;
import Modelo.LibroDAO;
import Vista.JPLibro;

/**
 *
 * @author Guillem
 */
public class ControladorLibro {
    
    private LibroDAO modeloLibro;
    private JPLibro vistaLibro;

    public ControladorLibro(JPLibro vistaLibro) {
        this.modeloLibro = new LibroDAO();
        this.vistaLibro = vistaLibro;
    }

    public LibroDAO getModeloLibro() {
        return modeloLibro;
    }

    public void setModeloLibro(LibroDAO modeloLibro) {
        this.modeloLibro = modeloLibro;
    }

    public JPLibro getVistaLibro() {
        return vistaLibro;
    }

    public void setVistaLibro(JPLibro vistaLibro) {
        this.vistaLibro = vistaLibro;
    }

    public ControladorLibro() {
    }
    
    public void anyadirLibro(){
        
        System.out.println(vistaLibro.getTfIsbn().getText()+ vistaLibro.getTfTitulo().getText()+vistaLibro.getTfAutor().getText()+ (int)vistaLibro.getSpEjemplares().getValue()+ (int)vistaLibro.getSpAno().getValue()+ vistaLibro.getCbEditorial().getSelectedItem().toString()+ (int)vistaLibro.getSpNumPags().getValue());
        Libro nuevoLibro = new Libro(Integer.parseInt(vistaLibro.getTfIsbn().getText()), vistaLibro.getTfTitulo().getText(), vistaLibro.getTfAutor().getText(), (int)vistaLibro.getSpEjemplares().getValue(), (int)vistaLibro.getSpAno().getValue(), vistaLibro.getCbEditorial().getSelectedItem().toString(), (int)vistaLibro.getSpNumPags().getValue());
        
        modeloLibro.insertarLibro(nuevoLibro);
        
    }
    
    public void modificarLibro(){
        
        
    }
    
}
