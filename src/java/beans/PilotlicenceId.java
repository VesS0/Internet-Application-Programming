package beans;
// Generated Sep 12, 2017 7:50:39 PM by Hibernate Tools 4.3.1



/**
 * PilotlicenceId generated by hbm2java
 */
public class PilotlicenceId  implements java.io.Serializable {


     private String pilotLicenceUserName;
     private String pilotLicenceLicence;

    public PilotlicenceId() {
    }

    public PilotlicenceId(String pilotLicenceUserName, String pilotLicenceLicence) {
       this.pilotLicenceUserName = pilotLicenceUserName;
       this.pilotLicenceLicence = pilotLicenceLicence;
    }
   
    public String getPilotLicenceUserName() {
        return this.pilotLicenceUserName;
    }
    
    public void setPilotLicenceUserName(String pilotLicenceUserName) {
        this.pilotLicenceUserName = pilotLicenceUserName;
    }
    public String getPilotLicenceLicence() {
        return this.pilotLicenceLicence;
    }
    
    public void setPilotLicenceLicence(String pilotLicenceLicence) {
        this.pilotLicenceLicence = pilotLicenceLicence;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PilotlicenceId) ) return false;
		 PilotlicenceId castOther = ( PilotlicenceId ) other; 
         
		 return ( (this.getPilotLicenceUserName()==castOther.getPilotLicenceUserName()) || ( this.getPilotLicenceUserName()!=null && castOther.getPilotLicenceUserName()!=null && this.getPilotLicenceUserName().equals(castOther.getPilotLicenceUserName()) ) )
 && ( (this.getPilotLicenceLicence()==castOther.getPilotLicenceLicence()) || ( this.getPilotLicenceLicence()!=null && castOther.getPilotLicenceLicence()!=null && this.getPilotLicenceLicence().equals(castOther.getPilotLicenceLicence()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPilotLicenceUserName() == null ? 0 : this.getPilotLicenceUserName().hashCode() );
         result = 37 * result + ( getPilotLicenceLicence() == null ? 0 : this.getPilotLicenceLicence().hashCode() );
         return result;
   }   


}


