/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Flight;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jelena
 */
@ManagedBean(name = "reservation")
@RequestScoped
public class ReservationController {
    private String name,surname,passport,bankAccount, generatedPassword, message, severity="info";

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void reserve(Flight flight, int numberOfSeats)
    {
        flight.setFlightAvailableSeatsNumber(flight.getFlightAvailableSeatsNumber()-numberOfSeats);
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();//getCurrentSession();
        try {
            session.beginTransaction();
            session.update(flight);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                severity="danger";
                message = "Reservation failed!";
                session.getTransaction().commit();
            }
            } finally {
                session.close();
            }
        severity="success";
        String val1 = ""+((int)(Math.random()*9000)+1000);
        String val2 = ""+((int)(Math.random()*9000)+1000);
        generatedPassword=val1+"-"+val2;// "9302-9201";
        message = "Reservation successfull! Your generated password is: "+generatedPassword;
    }
}
