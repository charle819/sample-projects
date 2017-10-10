package com.company.JpaDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import com.company.JpaDemo.Entity.Address;
import com.company.JpaDemo.Utility.PersistenceManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Address a1 = new Address();
        a1.setCity("Dehli");
        a1.setCountry("IND");
        a1.setId(0);
        a1.setPostalcode("111111");
        a1.setStreet("Caugnaut Palace");
        
     
        
        EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        //em.getTransaction().begin();
        Session s1  =  em.unwrap(Session.class);
        s1.getTransaction().begin();
        s1.save(a1);
        s1.getTransaction().commit();
        s1.close();
        //em.persist(a1);
        
        //em.getTransaction().commit();
        //em.close();
        PersistenceManager.getInstance().closeEMF();
    }
}
