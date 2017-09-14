/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airline;
import beans.Airplane;
import beans.Flight;
import beans.Rent;
import beans.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vlada
 */
@ManagedBean(name = "employee")
@SessionScoped
public class EmployeeController {
    private List<Flight> flights;
    private String message;
    private String severity="info";
    private List<Airplane> freePlanes;
    private User airlin;
    private List<Rent> requestedRents;

    public User getAirlin() {
        return airlin;
    }

    public void setAirlin(User airlin) {
        this.airlin = airlin;
    }

    public List<Rent> getRequestedRents() {
        return requestedRents;
    }

    public void setRequestedRents(List<Rent> requestedRents) {
        this.requestedRents = requestedRents;
    }
    
    public List<Airplane> getFreePlanes() {
        return freePlanes;
    }

    public void setFreePlanes(List<Airplane> freePlanes) {
        this.freePlanes = freePlanes;
    }
    
    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
    
    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
        @PostConstruct
    public void LoadMyCOmpanyFlights()
    {
        
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            
            Query quer2 = session.createQuery("from User u join fetch u.airline alin where u.userUserName=:me");
            quer2.setParameter("me", LoginController.user.getUserUserName());
            airlin = (User) quer2.list().get(0);
            Query query = session.createQuery(
                    "from Flight fl join fetch fl.airplane "
                    + "aplane join fetch aplane.airline aline"
                    + " where aline.airlineId=:myAline" );
            query.setParameter("myAline", airlin.getAirline().getAirlineId());
            
            flights = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
        {
        Session session2 = hibernate.HibernateUtil.getSessionFactory().openSession();
        try{
            session2.beginTransaction();
             int notTaken = 8;
            Query qqq = session2.createQuery("from Airplane air join fetch air.airline aln where aln.airlineId=:free");
            qqq.setParameter("free",notTaken);
            freePlanes = qqq.list();
            session2.getTransaction().commit();
        } catch (Exception e) {
        if (session2.getTransaction() != null) {
        session2.getTransaction().commit();
        }
        } finally {
            session2.close();
        } 
        }
        {
        Session session2 = hibernate.HibernateUtil.getSessionFactory().openSession();
        try{
            session2.beginTransaction();
             int notTaken = 8;
            Query qqq = session2.createQuery("from Rent where rentAirlineId=:myAirline and rentIsAccepted=:status");
            qqq.setParameter("myAirline",airlin.getAirline().getAirlineId());
            qqq.setParameter("status", false);
            requestedRents = qqq.list();
            session2.getTransaction().commit();
        } catch (Exception e) {
        if (session2.getTransaction() != null) {
        session2.getTransaction().commit();
        }
        } finally {
            session2.close();
        } 
        }
    }
    
    public void AddAirplane(Airplane plane)
    {
        // plane.setAirline(airlin.getAirline());
        Airplane dbPlane = null;
        {
            SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            dbPlane = (Airplane) session.createQuery("from Airplane where airplaneId=:planeId").setParameter("planeId", plane.getAirplaneId()).list().get(0);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } }
        
        dbPlane.setAirline(airlin.getAirline());
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(dbPlane);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
        freePlanes.remove(plane);
    }
    
    
    public void AcceptRent(Rent r)
    {
        r.setRentIsAccepted(true);
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(r);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
        requestedRents.remove(r);
    }
}
