/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vesprada
 */
public class LibroDAO {
    
    
    
    public void insertarLibro(Libro libro){
        GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("INSERT INTO libro VALUES ('"+libro.getIsbn()+"','"+libro.getTitulo()+"',"
                    + "'"+libro.getAutor()+"',"+libro.getNumEjemplares()+","+libro.getAnyoPublicacion()+",'"+libro.getEditorial()+"',"+libro.getNumPag()+")");
            
            System.out.println("Libro insertado con exito!");
            System.out.println("Hola");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
            System.out.println("Hola");
        }
    }
    
    public Libro obtenerLibro(int id){
        return new Libro();
    }
    
    public void modificarLibro(Libro libro){
        GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("UPDATE libro SET titulo='"+libro.getTitulo()+"', autor='"+libro.getAutor()+"', numejemplares="+libro.getNumEjemplares()+""
                    + ", anyopublicacion="+libro.getAnyoPublicacion()+", editorial='"+libro.getEditorial()+"', numpag="+libro.getNumPag()+"  WHERE isbn="+libro.getIsbn()+"");
            
            System.out.println("Libro modificado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
    }
    
    public void eliminarLibro(int isbn){
        GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
        
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            st.executeUpdate("DELETE from libro WHERE isbn="+isbn+"");
            
            System.out.println("Libro eliminado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
    }
    
    public void buscarLibro(String palabraClave, JTable tabla ){
         GestionSG singletonBBDD = GestionSG.crearSingletonBBDD();
         ResultSet rs;
         boolean encontrado;
         String[] nombreColumnas = null;
         ArrayList<String[]> resultado = new ArrayList();
        try {
            Statement st = singletonBBDD.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM libro WHERE  titulo LIKE '%"+palabraClave+"%' OR autor LIKE '%"+palabraClave+"%'");
            
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
            
            System.out.println("Libro encontrado con exito!");
            st.close();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        model.setRowCount(0);
        
        
        for (int i = 0; i < resultado.size(); i++) {
            String[] fila = resultado.get(i);
            
            model.addRow(new Object[]{fila[0],fila[1],fila[2],fila[3],fila[4],fila[5],fila[6]});
        }
        
        
    }
    
}
