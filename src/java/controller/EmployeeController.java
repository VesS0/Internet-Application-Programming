/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airline;
import beans.Flight;
import beans.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vlada
 */
@ManagedBean(name = "employee")
@RequestScoped
public class EmployeeController {
    private List<Flight> flights;
    private String message;
    private String severity="info";

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
            User airlin = (User) quer2.list().get(0);
            Query query = session.createQuery(
                    "from Flight fl join fetch fl.airplane "
                    + "aplane join fetch aplane.airline aline"
                    + " where aline.airlineId=:myAline" );
            query.setParameter("myAline", airlin.getAirline().getAirlineId());
            
            Query queryy = session.createQuery(
                    "from Flight where flightTakeOffTime>=:datetime or "
                    + "flightLandingTime=:datetime");
            queryy.setParameter("datetime", (new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
            List<Flight> flightsGood = queryy.list();
            flights = query.list();
            flights.retainAll(flightsGood);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
    }
}
