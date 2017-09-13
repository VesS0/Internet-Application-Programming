/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airline;
import beans.Flight;
import beans.Pilotlicence;
import beans.PilotlicenceId;
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
@ManagedBean(name = "pilot")
@RequestScoped
public class PilotController {
    private String licence, message;
    private List<PilotlicenceId> piloteLicences;
    private List<Airline> availableAirlines;
    private List<Flight> flights;
    private Airline selectedAirline;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @PostConstruct
    public void LoadLicencesAndAirlinesAndMyFlights()
    {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            piloteLicences= session.createQuery("from PilotlicenceId ").list();
            availableAirlines = session.createQuery("from Airline").list();
            Query query = session.createQuery("from flight fl where fl.userByFlightCopilotId=:myUsername or fl.userByFlightPilotId=:myUsername" );
            query.setParameter("myUsername", LoginController.user.getUserUserName());
            flights = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
    }

    public List<PilotlicenceId> getPiloteLicences() {
        return piloteLicences;
    }

    public void setPiloteLicences(List<PilotlicenceId> piloteLicences) {
        this.piloteLicences = piloteLicences;
    }

    public List<Airline> getAvailableAirlines() {
        return availableAirlines;
    }

    public void setAvailableAirlines(List<Airline> availableAirlines) {
        this.availableAirlines = availableAirlines;
    }

    public Airline getSelectedAirline() {
        return selectedAirline;
    }

    public void setSelectedAirline(Airline selectedAirline) {
        this.selectedAirline = selectedAirline;
    }
    
    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
    public String addLicence()
    {
        if (isValidLicence(licence))
        {
            PilotlicenceId pilLilId = new PilotlicenceId();
//             get flicence from list ?? piloteLicences  :S??
            pilLilId.setPilotLicenceUserName(LoginController.user.getUserUserName());
            pilLilId.setPilotLicenceLicence(licence);
            
            Pilotlicence pilLil = new Pilotlicence();
            pilLil.setUser(LoginController.user);
            pilLil.setId(pilLilId);
            LoginController.user.getPilotlicences().add(pilLil);
            
            return "Pilot.xhtml";
        }
        return "pilotLicence.xhtml";
    }
    
    public void changeCompany()
    {
        LoginController.user.setAirline(selectedAirline);
        
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(LoginController.user);
            session.getTransaction().commit();
            message="Company successfully changed!";
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
    }
    
        public void updateFlightStatus(Flight flight)
    {
        ;
        message="Successfully updated flight status";
    }
    public static boolean isValidLicence(String licence)
    {
        // TODO: regex
        return true;
    }
}
