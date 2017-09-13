package beans;
// Generated Sep 12, 2017 7:50:39 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Manufacturer generated by hbm2java
 */
public class Manufacturer  implements java.io.Serializable {


     private int manufacturerId;
     private String manufacturerUserName;
     private String manufacturerCity;
     private String manufacturerCountry;
     private Set<Airplanetype> airplanetypes = new HashSet<Airplanetype>(0);
     private Set<Airplane> airplanes = new HashSet<Airplane>(0);

    public Manufacturer() {
    }

	
    public Manufacturer(int manufacturerId, String manufacturerUserName, String manufacturerCity, String manufacturerCountry) {
        this.manufacturerId = manufacturerId;
        this.manufacturerUserName = manufacturerUserName;
        this.manufacturerCity = manufacturerCity;
        this.manufacturerCountry = manufacturerCountry;
    }
    public Manufacturer(int manufacturerId, String manufacturerUserName, String manufacturerCity, String manufacturerCountry, Set<Airplanetype> airplanetypes, Set<Airplane> airplanes) {
       this.manufacturerId = manufacturerId;
       this.manufacturerUserName = manufacturerUserName;
       this.manufacturerCity = manufacturerCity;
       this.manufacturerCountry = manufacturerCountry;
       this.airplanetypes = airplanetypes;
       this.airplanes = airplanes;
    }
   
    public int getManufacturerId() {
        return this.manufacturerId;
    }
    
    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    public String getManufacturerUserName() {
        return this.manufacturerUserName;
    }
    
    public void setManufacturerUserName(String manufacturerUserName) {
        this.manufacturerUserName = manufacturerUserName;
    }
    public String getManufacturerCity() {
        return this.manufacturerCity;
    }
    
    public void setManufacturerCity(String manufacturerCity) {
        this.manufacturerCity = manufacturerCity;
    }
    public String getManufacturerCountry() {
        return this.manufacturerCountry;
    }
    
    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }
    public Set<Airplanetype> getAirplanetypes() {
        return this.airplanetypes;
    }
    
    public void setAirplanetypes(Set<Airplanetype> airplanetypes) {
        this.airplanetypes = airplanetypes;
    }
    public Set<Airplane> getAirplanes() {
        return this.airplanes;
    }
    
    public void setAirplanes(Set<Airplane> airplanes) {
        this.airplanes = airplanes;
    }




}


