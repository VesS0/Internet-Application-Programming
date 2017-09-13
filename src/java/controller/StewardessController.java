/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airline;
import beans.Flight;
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
 * @author Jelena
 */
@ManagedBean(name = "stewardess")
@RequestScoped
public class StewardessController {

    private List<Flight> flights;
    private Flight flight;
    private String message;
    private List<Airline> availableAirlines = null;
    private int selectedAirlineId;

    public int getSelectedAirlineId() {
        return selectedAirlineId;
    }

    public void setSelectedAirlineId(int selectedAirlineId) {
        this.selectedAirlineId = selectedAirlineId;
    }

    public List<Airline> getAvailableAirlines() {
        return availableAirlines;
    }

    public void setAvailableAirlines(List<Airline> availableAirlines) {
        this.availableAirlines = availableAirlines;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @PostConstruct
    public void LoadFlightsAndAirlines() {
        Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Flight where userByFlightStewardessId1.userUserName=:myName or userByFlightStewardessId2.userUserName=:myName "
                    + "or userByFlightStewardessId3.userUserName=:myName or userByFlightStewardessId4.userUserName=:myName or userByFlightStewardessId5.userUserName=:myName");
            query.setParameter("myName", LoginController.user.getUserUserName());
            flights = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }

        Session session1 = hibernate.HibernateUtil.getSessionFactory().openSession();
        try {
            session1.beginTransaction();
            availableAirlines = session1.createQuery("from Airline").list();
            session1.getTransaction().commit();
        } catch (Exception e) {
            if (session1.getTransaction() != null) {
                session1.getTransaction().commit();
            }
        } finally {
            session1.close();
        }

    }

    public void changeCompany() {
        for (Airline a : availableAirlines) {
            if (a.getAirlineId() == selectedAirlineId) {
                LoginController.user.setAirline(a);
            }
        }

        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(LoginController.user);
            session.getTransaction().commit();
            message = "Company successfully changed!";
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
    }

    public String getDetails(Flight flight) {
        this.flight = null;
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery(
                    "from Flight fl join fetch fl.airplane airplane "
                    + " join fetch airplane.airplanetype airplanetype where fl.flightId=:flightId");
            query.setParameter("flightId", flight.getFlightId());
            this.flight = (Flight) query.list().get(0);
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }

        return "stewardessFlightDetails";
    }
}
