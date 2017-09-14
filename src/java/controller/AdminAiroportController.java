/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airport;
import beans.Gate;
import beans.Terminal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jelena
 */
@ManagedBean(name = "adminairport")
@RequestScoped
public class AdminAiroportController {
    private String message,severity="info";
    public static  Airport airportt;
    private Airport airport = new Airport();;
   // private static int tenrumalNum;
    private Terminal terminal = new Terminal();
    public static Terminal terminall;
    private Gate gate = new Gate();
    private String terminalName, gateName;

    public static Airport getAirportt() {
        return airportt;
    }

    public static void setAirportt(Airport airportt) {
        AdminAiroportController.airportt = airportt;
    }

    public Terminal getTerminall() {
        return terminall;
    }

    public void setTerminall(Terminal terminall) {
        this.terminall = terminall;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
    }
    

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
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
    
    public void addNewAirport()
    {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(airport);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        }
        airportt=airport;
        airport = new Airport();
    }
    
    public void addGate()
    {
        if (airportt==null || terminall==null) return;
        int nextId = getNextFreeId("gateId", "Gate");
        gate.setGateId(nextId);
        gate.setAirport(airportt);
        gate.setTerminal(new Terminal(terminall.getTerminalId(), terminall.getAirport(), terminall.getTerminalNaziv(),null,null,null));
        gate.setGateName(gateName);

        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(gate);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        } 
        
        gate = new Gate();
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
    
    public void addTerminal()
    {
        if (airportt==null) return;
        int nextId = getNextFreeId("terminalId", "Terminal");
        terminal = new Terminal(nextId, airportt, terminalName, null,null,null);
        terminal.setAirport(airportt);
        terminal.setTerminalId(nextId);
        terminal.setTerminalNaziv(terminalName);
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(terminal);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        }
        terminall=terminal;
        terminal = new Terminal();
    }
}
