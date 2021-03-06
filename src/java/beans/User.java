package beans;
// Generated Sep 14, 2017 1:53:59 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private String userUserName;
     private Airline airline;
     private String userPassword;
     private String userName;
     private String userSurname;
     private char userGender;
     private Date userDayOfBirth;
     private String userEmail;
     private String userTypeOfUser;
     private boolean userAccountValid;
     private Set<Flight> flightsForFlightStewardessId4 = new HashSet<Flight>(0);
     private Set<Flight> flightsForFlightCopilotId = new HashSet<Flight>(0);
     private Set<Flight> flightsForFlightStewardessId5 = new HashSet<Flight>(0);
     private Set<Flight> flightsForFlightPilotId = new HashSet<Flight>(0);
     private Set<Pilotlicence> pilotlicences = new HashSet<Pilotlicence>(0);
     private Set<Flight> flightsForFlightStewardessId3 = new HashSet<Flight>(0);
     private Set<Flight> flightsForFlightStewardessId2 = new HashSet<Flight>(0);
     private Set<Flight> flightsForFlightStewardessId1 = new HashSet<Flight>(0);

    public User() {
    }

	
    public User(String userUserName, Airline airline, String userPassword, String userName, String userSurname, char userGender, String userEmail, String userTypeOfUser, boolean userAccountValid) {
        this.userUserName = userUserName;
        this.airline = airline;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userTypeOfUser = userTypeOfUser;
        this.userAccountValid = userAccountValid;
    }
    public User(String userUserName, Airline airline, String userPassword, String userName, String userSurname, char userGender, Date userDayOfBirth, String userEmail, String userTypeOfUser, boolean userAccountValid, Set<Flight> flightsForFlightStewardessId4, Set<Flight> flightsForFlightCopilotId, Set<Flight> flightsForFlightStewardessId5, Set<Flight> flightsForFlightPilotId, Set<Pilotlicence> pilotlicences, Set<Flight> flightsForFlightStewardessId3, Set<Flight> flightsForFlightStewardessId2, Set<Flight> flightsForFlightStewardessId1) {
       this.userUserName = userUserName;
       this.airline = airline;
       this.userPassword = userPassword;
       this.userName = userName;
       this.userSurname = userSurname;
       this.userGender = userGender;
       this.userDayOfBirth = userDayOfBirth;
       this.userEmail = userEmail;
       this.userTypeOfUser = userTypeOfUser;
       this.userAccountValid = userAccountValid;
       this.flightsForFlightStewardessId4 = flightsForFlightStewardessId4;
       this.flightsForFlightCopilotId = flightsForFlightCopilotId;
       this.flightsForFlightStewardessId5 = flightsForFlightStewardessId5;
       this.flightsForFlightPilotId = flightsForFlightPilotId;
       this.pilotlicences = pilotlicences;
       this.flightsForFlightStewardessId3 = flightsForFlightStewardessId3;
       this.flightsForFlightStewardessId2 = flightsForFlightStewardessId2;
       this.flightsForFlightStewardessId1 = flightsForFlightStewardessId1;
    }
   
    public String getUserUserName() {
        return this.userUserName;
    }
    
    public void setUserUserName(String userUserName) {
        this.userUserName = userUserName;
    }
    public Airline getAirline() {
        return this.airline;
    }
    
    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserSurname() {
        return this.userSurname;
    }
    
    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
    public char getUserGender() {
        return this.userGender;
    }
    
    public void setUserGender(char userGender) {
        this.userGender = userGender;
    }
    public Date getUserDayOfBirth() {
        return this.userDayOfBirth;
    }
    
    public void setUserDayOfBirth(Date userDayOfBirth) {
        this.userDayOfBirth = userDayOfBirth;
    }
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserTypeOfUser() {
        return this.userTypeOfUser;
    }
    
    public void setUserTypeOfUser(String userTypeOfUser) {
        this.userTypeOfUser = userTypeOfUser;
    }
    public boolean isUserAccountValid() {
        return this.userAccountValid;
    }
    
    public void setUserAccountValid(boolean userAccountValid) {
        this.userAccountValid = userAccountValid;
    }
    public Set<Flight> getFlightsForFlightStewardessId4() {
        return this.flightsForFlightStewardessId4;
    }
    
    public void setFlightsForFlightStewardessId4(Set<Flight> flightsForFlightStewardessId4) {
        this.flightsForFlightStewardessId4 = flightsForFlightStewardessId4;
    }
    public Set<Flight> getFlightsForFlightCopilotId() {
        return this.flightsForFlightCopilotId;
    }
    
    public void setFlightsForFlightCopilotId(Set<Flight> flightsForFlightCopilotId) {
        this.flightsForFlightCopilotId = flightsForFlightCopilotId;
    }
    public Set<Flight> getFlightsForFlightStewardessId5() {
        return this.flightsForFlightStewardessId5;
    }
    
    public void setFlightsForFlightStewardessId5(Set<Flight> flightsForFlightStewardessId5) {
        this.flightsForFlightStewardessId5 = flightsForFlightStewardessId5;
    }
    public Set<Flight> getFlightsForFlightPilotId() {
        return this.flightsForFlightPilotId;
    }
    
    public void setFlightsForFlightPilotId(Set<Flight> flightsForFlightPilotId) {
        this.flightsForFlightPilotId = flightsForFlightPilotId;
    }
    public Set<Pilotlicence> getPilotlicences() {
        return this.pilotlicences;
    }
    
    public void setPilotlicences(Set<Pilotlicence> pilotlicences) {
        this.pilotlicences = pilotlicences;
    }
    public Set<Flight> getFlightsForFlightStewardessId3() {
        return this.flightsForFlightStewardessId3;
    }
    
    public void setFlightsForFlightStewardessId3(Set<Flight> flightsForFlightStewardessId3) {
        this.flightsForFlightStewardessId3 = flightsForFlightStewardessId3;
    }
    public Set<Flight> getFlightsForFlightStewardessId2() {
        return this.flightsForFlightStewardessId2;
    }
    
    public void setFlightsForFlightStewardessId2(Set<Flight> flightsForFlightStewardessId2) {
        this.flightsForFlightStewardessId2 = flightsForFlightStewardessId2;
    }
    public Set<Flight> getFlightsForFlightStewardessId1() {
        return this.flightsForFlightStewardessId1;
    }
    
    public void setFlightsForFlightStewardessId1(Set<Flight> flightsForFlightStewardessId1) {
        this.flightsForFlightStewardessId1 = flightsForFlightStewardessId1;
    }




}


