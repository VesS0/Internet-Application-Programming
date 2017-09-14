/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import hibernate.HibernateUtil;
import beans.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController {

    private String username;
    private String password;

    private int alertType;
    private String message,severity="info";
    static public User user;
    private int selectedLicence;
    private List<Airplanetype> licences;

    public int getSelectedLicence() {
        return selectedLicence;
    }

    public void setSelectedLicence(int selectedLicence) {
        this.selectedLicence = selectedLicence;
    }


    public List<Airplanetype> getLicences() {
        return licences;
    }

    public void setLicences(List<Airplanetype> licences) {
        this.licences = licences;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        LoginController.user = user;
    }
    
   /* @ManagedProperty(value = "#{l}")
    
*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAlertType() {
        return alertType;
    }

    public void setAlertType(int alertType) {
        this.alertType = alertType;
    }

    public String getMessage() {
        return message;
    }
    
    public static User getUserFromUsername(String username)
    {
        Session  session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> users = null;
        try {
            Query query = session.createQuery("from User where userUserName=:username");
            query.setParameter("username", username);
            users = query.list();            
            session.getTransaction().commit();  
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return (users!=null && users.size()>0)?users.get(0):null;
    }
    public static List<Pilotlicence> GetPilotLicences(User user)
    {
        Session  session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Pilotlicence> licences = null;
        try {
            Query query = session.createQuery("from Pilotlicence where user.userUserName=:username");
            query.setParameter("username", user.getUserUserName());
            licences = query.list();            
            session.getTransaction().commit();  
        } catch (Exception e) {
        } finally {
            session.close();
        }
        
        return (licences==null || licences.size()==0 || licences.isEmpty())?null:licences;
    }
    public String userLogin() {
        User loggedUser = getUserFromUsername(username);
         severity = "danger";
        if(loggedUser==null)
        {
            message = "There is no user with these credidetials";
            return "index.xthml";
        }
        if (!loggedUser.getUserPassword().equals(password))
        {
            message = "Password does not match with username";
           return "index.xhtml";
        }
        this.user = loggedUser;
        severity = "success";
        switch (user.getUserTypeOfUser())
        {
            case "Employee":
                return "Employee.xhtml";
            case "Stewardess":
                return "Stewardess.xhtml";
            case "Pilot":
                List<Pilotlicence> liccc= GetPilotLicences(user);
                if (liccc == null)
                {
                    Session  session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    try {
                        this.licences = session.createQuery("from Airplanetype ").list();           
                        session.getTransaction().commit();  
                    } catch (Exception e) {
                    } finally {
                        session.close();
                    }
                    return "pilotLicence.xhtml";
                }
                return "Pilot.xhtml";
            case "Admin":
                return "Admin.xhtml";
        }
        
        return "index.xthml";
    }
    
    public String userRegister()
    {
        // worker, stewardess, pilot kopilot,guest
           return "registration";//"guestRegister";
    }
    public String userChangePassword()
    {
        return "changePassword.xhtml";
    }
    
    public String goTo(String str)
    {
        return str;
    }
    
    public void LogOut()
    {
        // user=null;
    }
    public String searchStuff()
    {
        return "guestSearch.xhtml";
    }
    
    public static boolean isValidLicence(String licence)
    {
        // TODO: regex
        return true;
    }
    
    public String addLicence()
    {
        String licen=null;
        Session  session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();
        try {
            Query query = session1.createQuery("from Airplanetype where airplaneTypeId=:typeId");
            query.setParameter("typeId", selectedLicence);
            licen = query.list().get(0).toString();            
            session1.getTransaction().commit();  
        } catch (Exception e) {
        } finally {
            session1.close();
        }
        if (isValidLicence(licen))
        {
            PilotlicenceId pilLilId = new PilotlicenceId();
            pilLilId.setPilotLicenceUserName(LoginController.user.getUserUserName());
            pilLilId.setPilotLicenceLicence(licen);
            
            Pilotlicence pilLil = new Pilotlicence();
            pilLil.setId(pilLilId);
            pilLil.setUser(LoginController.user);
            
            SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            try{
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
            return "Pilot";
        }
        return "pilotLicence";
    }

}
