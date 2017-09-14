package beans;
// Generated Sep 14, 2017 1:53:59 AM by Hibernate Tools 4.3.1



/**
 * Flightstate generated by hbm2java
 */
public class Flightstate  implements java.io.Serializable {


     private int flightStateId;
     private Flight flight;
     private Radarcenter radarcenter;
     private String flightStateStatus;

    public Flightstate() {
    }

	
    public Flightstate(int flightStateId) {
        this.flightStateId = flightStateId;
    }
    public Flightstate(int flightStateId, Flight flight, Radarcenter radarcenter, String flightStateStatus) {
       this.flightStateId = flightStateId;
       this.flight = flight;
       this.radarcenter = radarcenter;
       this.flightStateStatus = flightStateStatus;
    }
   
    public int getFlightStateId() {
        return this.flightStateId;
    }
    
    public void setFlightStateId(int flightStateId) {
        this.flightStateId = flightStateId;
    }
    public Flight getFlight() {
        return this.flight;
    }
    
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public Radarcenter getRadarcenter() {
        return this.radarcenter;
    }
    
    public void setRadarcenter(Radarcenter radarcenter) {
        this.radarcenter = radarcenter;
    }
    public String getFlightStateStatus() {
        return this.flightStateStatus;
    }
    
    public void setFlightStateStatus(String flightStateStatus) {
        this.flightStateStatus = flightStateStatus;
    }




}


