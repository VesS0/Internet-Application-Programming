/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Flight;
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
 * @author Jelena
 */
@ManagedBean(name = "stewardess")
@RequestScoped
public class StewardessController {
    private List<Flight> flights;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    @PostConstruct
    public void LoadFlights()
    {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            Query query = session.createQuery("from Flight where flight_StewardessId_1=:myName or flight_StewardessId_2=:myName "
                    + "or flight_StewardessId_3=:myName or flight_StewardessId_4=:myName or flight_StewardessId_5=:myName");
            query.setParameter("myName", LoginController.user.getUserUserName());
            flights = query.list();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
    }
    public String getDetails()
    {
        return null;
    }
}
