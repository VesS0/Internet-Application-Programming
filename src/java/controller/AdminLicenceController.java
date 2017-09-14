/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airplanetype;
import beans.Pilotlicence;
import beans.PilotlicenceId;
import beans.User;
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
@ManagedBean(name = "adminlic")
@RequestScoped
public class AdminLicenceController {

    private String selectedLicence, message, severity = "info";
    private List<Airplanetype> licences;
    private List<User> users;
    private String  username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @PostConstruct
    public void getUsersAndLicences() {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            String pilot = "Pilot";
            session.beginTransaction();
            licences = session.createQuery(" from Airplanetype ").list();
            Query q = session.createQuery(" from User u where u.userTypeOfUser=:type");
            q.setParameter("type",pilot);
            users = q.list();
            
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
    }

    public void addLicence() {

        User usr = LoginController.getUserFromUsername(username);
        
        PilotlicenceId pilLilId = new PilotlicenceId();
        pilLilId.setPilotLicenceUserName(username);
        pilLilId.setPilotLicenceLicence(selectedLicence);

        Pilotlicence pilLil = new Pilotlicence();
        pilLil.setId(pilLilId);
        pilLil.setUser(usr);

        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(pilLil);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        } 
    }
    
    

    public String getSelectedLicence() {
        return selectedLicence;
    }

    public void setSelectedLicence(String selectedLicence) {
        this.selectedLicence = selectedLicence;
    }

    public List<Airplanetype> getLicences() {
        return licences;
    }

    public void setLicences(List<Airplanetype> licences) {
        this.licences = licences;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
