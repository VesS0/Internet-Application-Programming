/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airplane;
import beans.Airport;
import beans.Flight;
import beans.Flightstate;
import beans.Gate;
import beans.Radarcenter;
import beans.Terminal;
import beans.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
    private List<User> pilots;
    private List<User> stewardess;
    private List<Terminal> terminals;
    private List<Gate> gates;

    private Airplane selectedAirplane;
    private Airport selectedAirportFrom;
    private Airport selectedAirportTo;
    private Gate selectedGateOne;
    private Gate selectedGateTwo;
    private Terminal selectedTerminalOne;
    private Terminal selectedTerminalTwo;
    private User []crew = new User[7];
    private int flightNumber;
    private Date flightTakeOffTime;
    private Date flightLandingTime;
    private int flightAvailableSeatsNumber;
    private boolean isReturn, isCharter;
    private String message,severity="info";
    
    public void addInfo()
    {
        Flight flight = new Flight();
        flight.setFlightId(getNextFreeId("flightId", "Flight"));
        flight.setFlightIsCharter(isCharter);
        flight.setFlightIsReturnFlight(isReturn);
        flight.setFlightTakeOffTime(flightTakeOffTime);
        flight.setFlightNumber(flightNumber+"");
        flight.setFlightExpectedLandingTime(flightLandingTime);
        flight.setAirplane(selectedAirplane);
        flight.setAirportByFlightAirportIdFrom(selectedAirportFrom);
        flight.setAirportByFlightExpectedAirportIdTo(selectedAirportTo);
        flight.setGateByFlightGateIdFrom(selectedGateOne);
        flight.setGateByFlightGateIdTo(selectedGateTwo);
        flight.setTerminalByFlightTerminalIdFrom(selectedTerminalOne);
        flight.setTerminalByFlightTerminalIdTo(selectedTerminalTwo);
        flight.setUserByFlightPilotId(crew[0]);
        flight.setUserByFlightCopilotId(crew[1]);
        flight.setUserByFlightStewardessId1(crew[2]);
        flight.setUserByFlightStewardessId2(crew[3]);
        flight.setUserByFlightStewardessId3(crew[4]);
        flight.setUserByFlightStewardessId4(crew[5]);
        flight.setUserByFlightStewardessId5(crew[6]);
        
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(flight);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        }
        
        return;
    }
    
    @PostConstruct
    public void loadLists()
    {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            airplanes= session.createQuery(" from Airplane ").list(); 
            airports = session.createQuery(" from Airport ").list(); 
            pilots = session.createQuery(" from User u where u.userTypeOfUser=:type ").setParameter("type", "Pilot").list(); 
            stewardess = session.createQuery(" from User u where u.userTypeOfUser=:type ").setParameter("type", "Stewardess").list();
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
 public int getNextFreeId(String id, String from)
    {
        int free=0;
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            free = (int) session.createQuery("select MAX(A."+id+") from "+from+" A ").list().get(0);
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

    public Airport getSelectedAirportFrom() {
        return selectedAirportFrom;
    }

    public void setSelectedAirportFrom(Airport selectedAirportFrom) {
        this.selectedAirportFrom = selectedAirportFrom;
    }

    public Airport getSelectedAirportTo() {
        return selectedAirportTo;
    }

    public void setSelectedAirportTo(Airport selectedAirportTo) {
        this.selectedAirportTo = selectedAirportTo;
    }

    public Gate getSelectedGateOne() {
        return selectedGateOne;
    }

    public void setSelectedGateOne(Gate selectedGateOne) {
        this.selectedGateOne = selectedGateOne;
    }

    public Gate getSelectedGateTwo() {
        return selectedGateTwo;
    }

    public void setSelectedGateTwo(Gate selectedGateTwo) {
        this.selectedGateTwo = selectedGateTwo;
    }

    public Terminal getSelectedTerminalOne() {
        return selectedTerminalOne;
    }

    public void setSelectedTerminalOne(Terminal selectedTerminalOne) {
        this.selectedTerminalOne = selectedTerminalOne;
    }

    public Terminal getSelectedTerminalTwo() {
        return selectedTerminalTwo;
    }

    public void setSelectedTerminalTwo(Terminal selectedTerminalTwo) {
        this.selectedTerminalTwo = selectedTerminalTwo;
    }
    
    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airplane getSelectedAirplane() {
        return selectedAirplane;
    }

    public void setSelectedAirplane(Airplane selectedAirplane) {
        this.selectedAirplane = selectedAirplane;
    }


    public User[] getCrew() {
        return crew;
    }

    public void setCrew(User[] crew) {
        this.crew = crew;
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

    public Date getFlightTakeOffTime() {
        return flightTakeOffTime;
    }

    public void setFlightTakeOffTime(Date flightTakeOffTime) {
        this.flightTakeOffTime = flightTakeOffTime;
    }

    public Date getFlightLandingTime() {
        return flightLandingTime;
    }

    public void setFlightLandingTime(Date flightLandingTime) {
        this.flightLandingTime = flightLandingTime;
    }

    public int getFlightAvailableSeatsNumber() {
        return flightAvailableSeatsNumber;
    }

    public void setFlightAvailableSeatsNumber(int flightAvailableSeatsNumber) {
        this.flightAvailableSeatsNumber = flightAvailableSeatsNumber;
    }

    public boolean isIsReturn() {
        return isReturn;
    }

    public void setIsReturn(boolean isReturn) {
        this.isReturn = isReturn;
    }

    public boolean isIsCharter() {
        return isCharter;
    }

    public void setIsCharter(boolean isCharter) {
        this.isCharter = isCharter;
    }

    public List<User> getPilots() {
        return pilots;
    }

    public void setPilots(List<User> pilots) {
        this.pilots = pilots;
    }

    public List<User> getStewardess() {
        return stewardess;
    }

    public void setStewardess(List<User> stewardess) {
        this.stewardess = stewardess;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
    
    
}
