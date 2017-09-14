/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airplane;
import beans.Airport;
import beans.Gate;
import beans.Terminal;
import beans.User;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jelena
 */
@ManagedBean(name = "adminflight")
@SessionScoped
public class AdminFlightController {
    private List<Airplane> airplanes;
    private List<Airport> airports;
    private int flightNumber;
    private Date flightTakeOffTime;
    private Date flightLandingTime;
    private int flightAvailableSeatsNumber;
    private boolean isReturn, isCharter;
    private List<User> pilots;
    private List<User> stewardess;
    private List<Terminal> terminals;
    private List<Gate> gates;
    
    @PostConstruct
    public void loadLists()
    {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            airplanes= session.createQuery(" from Airplane ").list(); 
            airports = session.createQuery(" from Airport ").list(); 
            pilots = session.createQuery(" from User where userTypeOfUser=:type ").setParameter("type", "Pilot").list(); 
            stewardess = session.createQuery(" from User where userTypeOfUser=:type ").setParameter("type", "Stewardess").list();
            terminals =  session.createQuery(" from Terminal ").list();
            gates = session.createQuery(" from Gate ").list();
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
