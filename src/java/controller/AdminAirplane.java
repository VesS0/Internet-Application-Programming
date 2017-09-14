/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Airline;
import beans.Airplane;
import beans.Airplanetype;
import beans.Manufacturer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Jelena
 */
@ManagedBean(name = "adminplane")
@RequestScoped
public class AdminAirplane {
   private List<Manufacturer> manufacturers;
   private List<Airplanetype> types;
   private List<Airline> airlines;
   private int selectedAirline;
   private int selectedAirplaneType;
   private int selectedManufacturer;
   private String airplaneName;
   
   @PostConstruct
   public void LoadData()
   {
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            types = session.createQuery(" from Airplanetype ").list();
            manufacturers= session.createQuery(" from Manufacturer ").list();
            airlines = session.createQuery(" from Airline ").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
   }
   
   public void saveAirplane()
   {
       Airplane airplane = new Airplane();
       Airline air = null;
       Manufacturer manuf = null;
       Airplanetype airtyp = null;
       //  .-->airplaneTypeId-->airlineId
        SessionFactory sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery(" from Airplanetype where airplaneTypeId=:typeId");
            q.setParameter("typeId", selectedAirplaneType);
            airtyp = (Airplanetype) q.list().get(0);
            
            Query q1 =session.createQuery(" from Manufacturer where manufacturerId=:manufId");
            q1.setParameter("manufId", selectedManufacturer);
            manuf =(Manufacturer) q1.list().get(0);
            
            Query q2 = session.createQuery(" from Airline where airlineId=:airId");
            q2.setParameter("airId", selectedAirline);
            air = (Airline) q2.list().get(0);
            
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
        
       airplane.setAirline(air);
       airplane.setAirplanetype(airtyp);
       airplane.setManufacturer(manuf); 
       airplane.setAirplaneName(airplaneName);
       
        Session session2 =  hibernate.HibernateUtil.getSessionFactory().openSession();
        try {
            session2.beginTransaction();
            session2.save(airplane);
            session2.getTransaction().commit();
        } catch (Exception e) {
            if (session2.getTransaction() != null) {
                session2.getTransaction().commit();
            }
        } finally {
            session2.close();
        }
   }
   
    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public List<Airplanetype> getTypes() {
        return types;
    }

    public void setTypes(List<Airplanetype> types) {
        this.types = types;
    }
    
    public void uploadNew(FileUploadEvent event) {
                    
            Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
            int nextId=0;
        try{
            session.beginTransaction();  nextId = (int) session.createQuery("select MAX(M.idairplane) from Airplane M").list().get(0);
            session.getTransaction().commit();
        } catch (Exception e) {
        if (session.getTransaction() != null) {
        session.getTransaction().commit();
        }
        } finally {
            session.close();
        }
        nextId++;
        String filename = FilenameUtils.getName(event.getFile().getFileName());
        String basename = FilenameUtils.getBaseName(filename) + "_";
        String extension = "." + FilenameUtils.getExtension(filename);
        String newFileName = null;

        try {
            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            String fileNameNew = "img"+nextId+extension;
            String fullName = extContext.getRealPath("//img//") + "//" + fileNameNew;
            File file = new File(fullName);
            FileOutputStream output = new FileOutputStream(file);
            InputStream input = event.getFile().getInputstream();
            IOUtils.copy(input, output);
        } catch (Exception e) {

        }
        
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public int getSelectedAirline() {
        return selectedAirline;
    }

    public void setSelectedAirline(int selectedAirline) {
        this.selectedAirline = selectedAirline;
    }

    public int getSelectedAirplaneType() {
        return selectedAirplaneType;
    }

    public void setSelectedAirplaneType(int selectedAirplaneType) {
        this.selectedAirplaneType = selectedAirplaneType;
    }

    public int getSelectedManufacturer() {
        return selectedManufacturer;
    }

    public void setSelectedManufacturer(int selectedManufacturer) {
        this.selectedManufacturer = selectedManufacturer;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }
   
   
}
