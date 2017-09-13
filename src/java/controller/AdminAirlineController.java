/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airline;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jelena
 */
@ManagedBean(name = "adminairline")
@RequestScoped
public class AdminAirlineController {
    private String message,severity="info";
    private List<Airline> airlines;
    private List<Airline> newAirlines = new ArrayList<Airline>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public List<Airline> getNewAirlines() {
        return newAirlines;
    }

    public void setNewAirlines(List<Airline> newAirlines) {
        this.newAirlines = newAirlines;
    }
       
    @PostConstruct
    public void LoadAirlines()
    {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            airlines = session.createQuery("from Airline").list();
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        }
    }
    
    public void save(Airline airline)
    {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            
            if (newAirlines!=null && newAirlines.contains(airline)) 
                session.save(airline);
            else 
                session.update(airline);
            
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
    }
    
    public void addNewArline()
    {
        Airline airline = new Airline();
        airlines.add(airline);
        newAirlines.add(airline);
    }
        
}
