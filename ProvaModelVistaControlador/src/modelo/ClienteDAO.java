/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Statement;

/**
 *
 * @author vesprada
 */
public class ClienteDAO {
    
    
    public void insertarClienteVo(ClienteVo cliente){
        SingeltonBDD singeltonBDD = SingeltonBDD.crearSingeltonBDD();
        try {
            Statement st = singeltonBDD.getConnection().createStatement();
            st.execute("INSERT INTO cliente VALUES (NULL,'"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getNif()+"')");
            st.close();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    public ClienteVo obtenerClienteVo(int id){
        return new ClienteVo();
    }
    public void modificarClienteVo(ClienteVo cliente){
        
    }
    public void eliminarClienteVo(ClienteVo cliente){
        
    }
}
