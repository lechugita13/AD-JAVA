/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vesprada
 */
public class SocioDAO {
    public void insertarSocio(Socio socio){
        GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            
            
            
            st.executeUpdate("INSERT INTO socio VALUES (NULL,'"+socio.getNombre()+"'"
                    + ",'"+socio.getApellidos()+"','"+socio.getTelefono()+"',"+socio.getEdad()+",'"+socio.getFalta()+"')");
            System.out.println("Socio insertado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public Socio obtenerSocio(int id){
        return new Socio();
    }
    
    public void modificarSocio(Socio socio){
        GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("UPDATE socio SET nombre='"+socio.getNombre()+"', apellidos='"+socio.getApellidos()+"', telefono='"+socio.getTelefono()+"'"
                    + ", edad="+socio.getEdad()+", falta='"+socio.getFalta()+"' WHERE numsocio="+socio.getNumSocio()+"");
            
            System.out.println("Socio modificado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
    }
    
    public void eliminarSocio(int numSocio){
        GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("DELETE from socio WHERE numsocio="+numSocio+"");
            
            System.out.println("Socio eliminado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
    }
    
    public void buscarSocio(String palabraClave, JTable tabla ){
         GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
         ResultSet rs;
         boolean encontrado;
         String[] nombreColumnas = null;
         ArrayList<String[]> resultado = new ArrayList();
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM socio WHERE  nombre LIKE '%"+palabraClave+"%' OR apellidos LIKE '%"+palabraClave+"%'");
            
            int columnas = rs.getMetaData().getColumnCount();
            System.out.println("Columnas: "+columnas);
            nombreColumnas = new String[columnas];
            
            for (int i = 0; i < nombreColumnas.length; i++) {
                nombreColumnas[i] = rs.getMetaData().getColumnName(i+1);
            }
            
            while (rs.next()) {
                String[] row = new String[columnas];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getString(i + 1);
                }
                resultado.add(row);
            }
            
            System.out.println("Socio encontrado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        model.setRowCount(0);
        
        
        for (int i = 0; i < resultado.size(); i++) {
            String[] fila = resultado.get(i);
            
            model.addRow(new Object[]{fila[0],fila[1],fila[2],fila[3],fila[4],fila[5]});
        }
        
        
    }
}
