/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicahibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author vesprada
 */
public class PracticaHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SessionFactory sf;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sf = configuration.buildSessionFactory(sr);
        Professor p1 = new Professor(9, "Guillem", "Clar", "Torres");
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(p1);
        session.getTransaction().commit();
        
        Professor p2 = (Professor) session.get(Professor.class,1001);
        session.close();
        
    }
    
}
