/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.User;
import hibernate.HibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jelena
 */

@ManagedBean(name = "changePasswordController")
@RequestScoped
public class ChangePasswordController {
    private String userName, password, newPassword, newPassword2, message, severity="info";

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void ChangePassword()
    {
        User user = LoginController.getUserFromUsername(userName);
        severity="danger";
        if (user==null)
        {
            message = "There is no user with provided credentials";
            return;
        }
        if (!user.getUserPassword().equals(password))
        {
            message = "Password WRONG !!!!!!!!!!!";
            return;
        }
        if (!newPassword.equals(newPassword2))
        {
            message = "New passwords do not match";
            return;
        }
        
        Session  session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            user.setUserPassword(newPassword);
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
           message="Unexpected exception";
           severity="danger";
        } finally {
            session.close();
        }
         message = "Password successfully updated.";
         severity="success";
    }
}
