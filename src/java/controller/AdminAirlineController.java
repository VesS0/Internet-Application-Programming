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
import org.hibernate.Transaction;

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
    private String airlineSite,airlineEmail,airlineCountry,airlineAddress,airlineName;

    public String getAirlineSite() {
        return airlineSite;
    }

    public void setAirlineSite(String airlineSite) {
        this.airlineSite = airlineSite;
    }

    public String getAirlineEmail() {
        return airlineEmail;
    }

    public void setAirlineEmail(String airlineEmail) {
        this.airlineEmail = airlineEmail;
    }

    public String getAirlineCountry() {
        return airlineCountry;
    }

    public void setAirlineCountry(String airlineCountry) {
        this.airlineCountry = airlineCountry;
    }

    public String getAirlineAddress() {
        return airlineAddress;
    }

    public void setAirlineAddress(String airlineAddress) {
        this.airlineAddress = airlineAddress;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
    
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
    public int getNextFreeId()
    {
        int free=0;
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            free = (int) session.createQuery("select MAX(airlineId) from Airline ").list().get(0);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
        
        return free+1;
    }
    
    public void addNewArline()
    {
        Airline airline;// AirlineVesa
        airline = new Airline(getNextFreeId(), airlineName, airlineAddress, airlineCountry ,airlineSite,airlineEmail);
        // newAirlines.add(airline);
       // airlines.add(airline);//
        // save(airline); 
         SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            
            
                session.save(airline);

            
            tx.commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        }
    }
        
}
