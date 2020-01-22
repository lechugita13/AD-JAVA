/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.text.SimpleDateFormat;
import javax.swing.JTable;
import modelo.Socio;
import modelo.SocioDAO;
import vista.JDSocios;
import vista.JPSocio;

/**
 *
 * @author Edgar
 */
public class ControladorSocio {
    private SocioDAO socioDAO; 
    private JPSocio vistaSocio;
    private JDSocios dialogSocio;

    public ControladorSocio( JPSocio vistaSocio) {
        this.socioDAO = new SocioDAO();
        this.vistaSocio = vistaSocio;
    }

    public ControladorSocio( JDSocios dialogSocio) {
        this.socioDAO = new SocioDAO();
        this.dialogSocio = dialogSocio;
    }
    
    

    public ControladorSocio() {
        
    }

    public SocioDAO getSocioDAO() {
        return socioDAO;
    }

    public void setSocioDAO(SocioDAO socioDAO) {
        this.socioDAO = socioDAO;
    }

    public JPSocio getVistaSocio() {
        return vistaSocio;
    }

    public void setVistaSocio(JPSocio vistaSocio) {
        this.vistaSocio = vistaSocio;
    }
    
    

    
    public void anyadirSocio(){
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        
        int edad = (int)vistaSocio.getSpEdadSocio().getValue();
        String nombre = vistaSocio.getTfNombreSocio().getText();
        String apellidos = vistaSocio.getTfApellidosSocio().getText();
        String telefono = vistaSocio.getTfTelefonoSocio().getText();
        String fecha = format.format(vistaSocio.getdChooser().getDate());
        
        
        
        
        Socio nuevoSocio = new Socio(0,edad,nombre,apellidos,telefono,fecha);
        
        socioDAO.insertarSocio(nuevoSocio);
    }
    
    public void modificarSocio(){
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        int numSocio = Integer.parseInt(vistaSocio.getTfNumSocio().getText());
        int edad = (int)vistaSocio.getSpEdadSocio().getValue();
        String nombre = vistaSocio.getTfNombreSocio().getText();
        String apellidos = vistaSocio.getTfApellidosSocio().getText();
        String telefono = vistaSocio.getTfTelefonoSocio().getText();
        String fecha = format.format(vistaSocio.getdChooser().getDate());
        
        Socio nuevoSocio = new Socio(numSocio,edad,nombre,apellidos,telefono,fecha);
        
        socioDAO.modificarSocio(nuevoSocio);
    }
    
    public void eliminarSocio(){
       int numsocio = Integer.parseInt(vistaSocio.getTfNumSocio().getText());
       socioDAO.eliminarSocio(numsocio);
    }
    
    public void buscarSocio(){
        String palabraClave = vistaSocio.getTfBusqueda().getText();
        
        socioDAO.buscarSocio(palabraClave, vistaSocio.getTbSocio());
        
    }
    
    public void buscarSocioDialog(String palabraClave,JTable tabla){
        socioDAO.buscarSocio(palabraClave, tabla);
    }
}
