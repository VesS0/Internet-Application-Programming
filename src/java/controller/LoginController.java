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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    private String username;
    private String password;

    private int alertType;
    private String message;
    
    @ManagedProperty(value = "#{user}")
    static public User user;


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
            Query query = session.createQuery("from User where user_UserName=:username");
            query.setParameter("username", username);
            users = query.list();            
            session.getTransaction().commit();  
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return (users!=null && users.size()>0)?users.get(0):null;
    }
    
    public String userLogin() {
        User user = getUserFromUsername(username);
        if(user==null)
        {
            message = "There is no user with these credidetials";
            return "index.xthml";
        }
        if (!user.getUserPassword().equals(password))
        {
            message = "Password does not match with username";
           return "index.xhtml";
        }
        
        switch (user.getUserTypeOfUser())
        {
            case "Employee":
                return "Employee.xhtml";
            case "Stewardess":
                return "Stewardess.xhtml";
            case "Pilot":
                return "Pilot.xhtml";
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
    public void CreateUser(User newUser)
    {
        ;
    }
    public void CreateUser()
    {
        ;
    }
    public void LogOut()
    {
        // user=null;
    }
    public String searchStuff()
    {
        return "guestSearch.xhtml";
    }

}
