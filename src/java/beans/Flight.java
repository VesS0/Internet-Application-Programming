package beans;
// Generated Sep 14, 2017 1:53:59 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Flight generated by hbm2java
 */
public class Flight  implements java.io.Serializable {


     private int flightId;
     private Airplane airplane;
     private Airport airportByFlightAirportIdFrom;
     private Airport airportByFlightAirportIdTo;
     private Airport airportByFlightExpectedAirportIdTo;
     private Gate gateByFlightGateIdTo;
     private Gate gateByFlightGateIdFrom;
     private Terminal terminalByFlightTerminalIdTo;
     private Terminal terminalByFlightTerminalIdFrom;
     private User userByFlightStewardessId4;
     private User userByFlightCopilotId;
     private User userByFlightStewardessId5;
     private User userByFlightPilotId;
     private User userByFlightStewardessId3;
     private User userByFlightStewardessId2;
     private User userByFlightStewardessId1;
     private String flightNumber;
     private Date flightDuration;
     private Date flightTakeOffTime;
     private Date flightExpectedLandingTime;
     private Date flightLandingTime;
     private int flightAvailableSeatsNumber;
     private boolean flightIsReturnFlight;
     private Boolean flightIsCharter;
     private Set<Flightstate> flightstates = new HashSet<Flightstate>(0);
     private Set<Radarcenter> radarcenters = new HashSet<Radarcenter>(0);

    public Flight() {
    }

	
    public Flight(int flightId, Airplane airplane, Airport airportByFlightAirportIdFrom, Airport airportByFlightAirportIdTo, Airport airportByFlightExpectedAirportIdTo, User userByFlightStewardessId4, User userByFlightCopilotId, User userByFlightStewardessId5, User userByFlightPilotId, User userByFlightStewardessId3, User userByFlightStewardessId2, User userByFlightStewardessId1, String flightNumber, Date flightDuration, Date flightTakeOffTime, Date flightExpectedLandingTime, Date flightLandingTime, int flightAvailableSeatsNumber, boolean flightIsReturnFlight) {
        this.flightId = flightId;
        this.airplane = airplane;
        this.airportByFlightAirportIdFrom = airportByFlightAirportIdFrom;
        this.airportByFlightAirportIdTo = airportByFlightAirportIdTo;
        this.airportByFlightExpectedAirportIdTo = airportByFlightExpectedAirportIdTo;
        this.userByFlightStewardessId4 = userByFlightStewardessId4;
        this.userByFlightCopilotId = userByFlightCopilotId;
        this.userByFlightStewardessId5 = userByFlightStewardessId5;
        this.userByFlightPilotId = userByFlightPilotId;
        this.userByFlightStewardessId3 = userByFlightStewardessId3;
        this.userByFlightStewardessId2 = userByFlightStewardessId2;
        this.userByFlightStewardessId1 = userByFlightStewardessId1;
        this.flightNumber = flightNumber;
        this.flightDuration = flightDuration;
        this.flightTakeOffTime = flightTakeOffTime;
        this.flightExpectedLandingTime = flightExpectedLandingTime;
        this.flightLandingTime = flightLandingTime;
        this.flightAvailableSeatsNumber = flightAvailableSeatsNumber;
        this.flightIsReturnFlight = flightIsReturnFlight;
    }
    public Flight(int flightId, Airplane airplane, Airport airportByFlightAirportIdFrom, Airport airportByFlightAirportIdTo, Airport airportByFlightExpectedAirportIdTo, Gate gateByFlightGateIdTo, Gate gateByFlightGateIdFrom, Terminal terminalByFlightTerminalIdTo, Terminal terminalByFlightTerminalIdFrom, User userByFlightStewardessId4, User userByFlightCopilotId, User userByFlightStewardessId5, User userByFlightPilotId, User userByFlightStewardessId3, User userByFlightStewardessId2, User userByFlightStewardessId1, String flightNumber, Date flightDuration, Date flightTakeOffTime, Date flightExpectedLandingTime, Date flightLandingTime, int flightAvailableSeatsNumber, boolean flightIsReturnFlight, Boolean flightIsCharter, Set<Flightstate> flightstates, Set<Radarcenter> radarcenters) {
       this.flightId = flightId;
       this.airplane = airplane;
       this.airportByFlightAirportIdFrom = airportByFlightAirportIdFrom;
       this.airportByFlightAirportIdTo = airportByFlightAirportIdTo;
       this.airportByFlightExpectedAirportIdTo = airportByFlightExpectedAirportIdTo;
       this.gateByFlightGateIdTo = gateByFlightGateIdTo;
       this.gateByFlightGateIdFrom = gateByFlightGateIdFrom;
       this.terminalByFlightTerminalIdTo = terminalByFlightTerminalIdTo;
       this.terminalByFlightTerminalIdFrom = terminalByFlightTerminalIdFrom;
       this.userByFlightStewardessId4 = userByFlightStewardessId4;
       this.userByFlightCopilotId = userByFlightCopilotId;
       this.userByFlightStewardessId5 = userByFlightStewardessId5;
       this.userByFlightPilotId = userByFlightPilotId;
       this.userByFlightStewardessId3 = userByFlightStewardessId3;
       this.userByFlightStewardessId2 = userByFlightStewardessId2;
       this.userByFlightStewardessId1 = userByFlightStewardessId1;
       this.flightNumber = flightNumber;
       this.flightDuration = flightDuration;
       this.flightTakeOffTime = flightTakeOffTime;
       this.flightExpectedLandingTime = flightExpectedLandingTime;
       this.flightLandingTime = flightLandingTime;
       this.flightAvailableSeatsNumber = flightAvailableSeatsNumber;
       this.flightIsReturnFlight = flightIsReturnFlight;
       this.flightIsCharter = flightIsCharter;
       this.flightstates = flightstates;
       this.radarcenters = radarcenters;
    }
   
    public int getFlightId() {
        return this.flightId;
    }
    
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
    public Airplane getAirplane() {
        return this.airplane;
    }
    
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    public Airport getAirportByFlightAirportIdFrom() {
        return this.airportByFlightAirportIdFrom;
    }
    
    public void setAirportByFlightAirportIdFrom(Airport airportByFlightAirportIdFrom) {
        this.airportByFlightAirportIdFrom = airportByFlightAirportIdFrom;
    }
    public Airport getAirportByFlightAirportIdTo() {
        return this.airportByFlightAirportIdTo;
    }
    
    public void setAirportByFlightAirportIdTo(Airport airportByFlightAirportIdTo) {
        this.airportByFlightAirportIdTo = airportByFlightAirportIdTo;
    }
    public Airport getAirportByFlightExpectedAirportIdTo() {
        return this.airportByFlightExpectedAirportIdTo;
    }
    
    public void setAirportByFlightExpectedAirportIdTo(Airport airportByFlightExpectedAirportIdTo) {
        this.airportByFlightExpectedAirportIdTo = airportByFlightExpectedAirportIdTo;
    }
    public Gate getGateByFlightGateIdTo() {
        return this.gateByFlightGateIdTo;
    }
    
    public void setGateByFlightGateIdTo(Gate gateByFlightGateIdTo) {
        this.gateByFlightGateIdTo = gateByFlightGateIdTo;
    }
    public Gate getGateByFlightGateIdFrom() {
        return this.gateByFlightGateIdFrom;
    }
    
    public void setGateByFlightGateIdFrom(Gate gateByFlightGateIdFrom) {
        this.gateByFlightGateIdFrom = gateByFlightGateIdFrom;
    }
    public Terminal getTerminalByFlightTerminalIdTo() {
        return this.terminalByFlightTerminalIdTo;
    }
    
    public void setTerminalByFlightTerminalIdTo(Terminal terminalByFlightTerminalIdTo) {
        this.terminalByFlightTerminalIdTo = terminalByFlightTerminalIdTo;
    }
    public Terminal getTerminalByFlightTerminalIdFrom() {
        return this.terminalByFlightTerminalIdFrom;
    }
    
    public void setTerminalByFlightTerminalIdFrom(Terminal terminalByFlightTerminalIdFrom) {
        this.terminalByFlightTerminalIdFrom = terminalByFlightTerminalIdFrom;
    }
    public User getUserByFlightStewardessId4() {
        return this.userByFlightStewardessId4;
    }
    
    public void setUserByFlightStewardessId4(User userByFlightStewardessId4) {
        this.userByFlightStewardessId4 = userByFlightStewardessId4;
    }
    public User getUserByFlightCopilotId() {
        return this.userByFlightCopilotId;
    }
    
    public void setUserByFlightCopilotId(User userByFlightCopilotId) {
        this.userByFlightCopilotId = userByFlightCopilotId;
    }
    public User getUserByFlightStewardessId5() {
        return this.userByFlightStewardessId5;
    }
    
    public void setUserByFlightStewardessId5(User userByFlightStewardessId5) {
        this.userByFlightStewardessId5 = userByFlightStewardessId5;
    }
    public User getUserByFlightPilotId() {
        return this.userByFlightPilotId;
    }
    
    public void setUserByFlightPilotId(User userByFlightPilotId) {
        this.userByFlightPilotId = userByFlightPilotId;
    }
    public User getUserByFlightStewardessId3() {
        return this.userByFlightStewardessId3;
    }
    
    public void setUserByFlightStewardessId3(User userByFlightStewardessId3) {
        this.userByFlightStewardessId3 = userByFlightStewardessId3;
    }
    public User getUserByFlightStewardessId2() {
        return this.userByFlightStewardessId2;
    }
    
    public void setUserByFlightStewardessId2(User userByFlightStewardessId2) {
        this.userByFlightStewardessId2 = userByFlightStewardessId2;
    }
    public User getUserByFlightStewardessId1() {
        return this.userByFlightStewardessId1;
    }
    
    public void setUserByFlightStewardessId1(User userByFlightStewardessId1) {
        this.userByFlightStewardessId1 = userByFlightStewardessId1;
    }
    public String getFlightNumber() {
        return this.flightNumber;
    }
    
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public Date getFlightDuration() {
        return this.flightDuration;
    }
    
    public void setFlightDuration(Date flightDuration) {
        this.flightDuration = flightDuration;
    }
    public Date getFlightTakeOffTime() {
        return this.flightTakeOffTime;
    }
    
    public void setFlightTakeOffTime(Date flightTakeOffTime) {
        this.flightTakeOffTime = flightTakeOffTime;
    }
    public Date getFlightExpectedLandingTime() {
        return this.flightExpectedLandingTime;
    }
    
    public void setFlightExpectedLandingTime(Date flightExpectedLandingTime) {
        this.flightExpectedLandingTime = flightExpectedLandingTime;
    }
    public Date getFlightLandingTime() {
        return this.flightLandingTime;
    }
    
    public void setFlightLandingTime(Date flightLandingTime) {
        this.flightLandingTime = flightLandingTime;
    }
    public int getFlightAvailableSeatsNumber() {
        return this.flightAvailableSeatsNumber;
    }
    
    public void setFlightAvailableSeatsNumber(int flightAvailableSeatsNumber) {
        this.flightAvailableSeatsNumber = flightAvailableSeatsNumber;
    }
    public boolean isFlightIsReturnFlight() {
        return this.flightIsReturnFlight;
    }
    
    public void setFlightIsReturnFlight(boolean flightIsReturnFlight) {
        this.flightIsReturnFlight = flightIsReturnFlight;
    }
    public Boolean getFlightIsCharter() {
        return this.flightIsCharter;
    }
    
    public void setFlightIsCharter(Boolean flightIsCharter) {
        this.flightIsCharter = flightIsCharter;
    }
    public Set<Flightstate> getFlightstates() {
        return this.flightstates;
    }
    
    public void setFlightstates(Set<Flightstate> flightstates) {
        this.flightstates = flightstates;
    }
    public Set<Radarcenter> getRadarcenters() {
        return this.radarcenters;
    }
    
    public void setRadarcenters(Set<Radarcenter> radarcenters) {
        this.radarcenters = radarcenters;
    }




}


