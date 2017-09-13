/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Flight;
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
            // Query query = session.createQuery("from flight fl join fetch where fl.userByFlightCopilotId=:myUsername or fl.userByFlightPilotId=:myUsername" );
            // query.setParameter("myUsername", LoginController.user.getUserUserName());
            // flights = query.list();
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
