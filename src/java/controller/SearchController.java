/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Flight;
import beans.User;
import hibernate.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.TemporalType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jelena
 */
@ManagedBean(name = "searchController")
@SessionScoped
public class SearchController {

    private String twoWayFlight = "OneWay", flyTo, flyFrom;
    private int numOfPeople = 1;
    private boolean directFlight;
    private List<Flight> searchResults;
    private Date startDate, endDate;
    private Flight selectedFlight;

    public Flight getSelectedFlight() {
        return selectedFlight;
    }

    public void setSelectedFlight(Flight selectedFlight) {
        this.selectedFlight = selectedFlight;
    }

    @PostConstruct
    public void loadArilines() {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Flight where flight_TakeOffTime=:datetime");
            query.setParameter("datetime", (new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
            searchResults = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String executeSearch() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            boolean noFlyFrom = (flyFrom == null || flyFrom.isEmpty());
            boolean noFlyTo = (flyTo == null || flyTo.isEmpty());

            String queryStr = " from Flight fl join fetch fl.airportByFlightAirportIdFrom aiFrom "
                    + "join fetch fl.airportByFlightExpectedAirportIdTo aiTo "
                    + "where fl.flightAvailableSeatsNumber>:seats ";
            queryStr += noFlyFrom ? " AND ( 1=1 " : " AND ( aiFrom.airportCity=:city1 or aiFrom.airportName=:name1 ";
            queryStr += noFlyTo ? ")" : " or aiTo.airportCity=:city2 or aiTo.airportName=:name2 )";
            queryStr += startDate == null ? "" : " AND fl.flightTakeOffTime=:startDate";
            queryStr += endDate == null ? "" : " AND fl.flightExpectedLandingTime=:endDate";

            Query query = session.createQuery(queryStr);

            query.setParameter("seats", numOfPeople);
            if (flyFrom != null && !flyFrom.isEmpty()) {
                query.setParameter("city1", flyFrom);
                query.setParameter("name1", flyFrom);
            }
            if (flyTo != null && !flyTo.isEmpty()) {
                query.setParameter("city2", flyTo);
                query.setParameter("name2", flyTo);
            }
            if (startDate != null) {
                query.setParameter("startDate", startDate);
            }
            if (endDate != null) {
                query.setParameter("endDate", endDate);
            }

            searchResults = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            session.close();
        }

        return "guestSearch.xhtml";
    }

    public List<Flight> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Flight> searchResults) {
        this.searchResults = searchResults;
    }

    public String getTwoWayFlight() {
        return twoWayFlight;
    }

    public void setTwoWayFlight(String twoWayFlight) {
        this.twoWayFlight = twoWayFlight;
    }

    public String getFlyTo() {
        return flyTo;
    }

    public void setFlyTo(String flyTo) {
        this.flyTo = flyTo;
    }

    public String getFlyFrom() {
        return flyFrom;
    }

    public void setFlyFrom(String flyFrom) {
        this.flyFrom = flyFrom;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public boolean isDirectFlight() {
        return directFlight;
    }

    public void setDirectFlight(boolean directFlight) {
        this.directFlight = directFlight;
    }

    public String reserve(Flight flight) {
        selectedFlight = flight;
        return "Reservation";
    }

}
