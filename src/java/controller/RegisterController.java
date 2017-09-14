/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airline;
import beans.User;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jelena
 */

@ManagedBean(name = "registerController")
@RequestScoped
public class RegisterController {
    private User user = new User();
    private static List<Airline> availableAirlines;
    private String message, severity="info";
    private int airline;
    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public int getAirline() {
        return airline;
    }

    public void setAirline(int airline) {
        this.airline = airline;
    }
            
    @PostConstruct
    public void loadArilines()
    {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            availableAirlines = session.createQuery("from Airline").list(); 
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        }   
    }
    
    public List<Airline> getAvailableAirlines() {
        return availableAirlines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void registerUser()
    {
        User userExists = LoginController.getUserFromUsername(user.getUserUserName());
        severity = "danger";
        if (userExists!=null)
        {
            message = "User with same credentials already exists";
            return;
        }
       
        for( Airline air:availableAirlines)
        {
            if (air.getAirlineId()==airline)
            {
                user.setAirline(air);
            }
        }
        // message = "Ooops, user with same UserName already exists!";
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();//getCurrentSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            severity="success";
            message = "Your registration is successfull! Congratz!";
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().commit();
            }
            } finally {
                session.close();
            }
        user = new User();
    }
    
    public void userChangePassword()
    {
        
    }
}
