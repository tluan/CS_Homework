public class Place  {
    private String zip;
    private String town;
    private String state;
    private String PhoneAreaCode;
    private String County;
    private String TimeZone;
    private String CountyPopulation;

protected Place(String zip,String town, String state,String PhoneAreaCode,String County,String TimeZone,String CountyPopulation) {
    this.zip = zip;
    this.town = town;
    this.state = state;
    this.PhoneAreaCode=PhoneAreaCode;
    this.County=County;
    this.TimeZone=TimeZone;
    this.CountyPopulation=CountyPopulation;
}
public String toString() {
    String str =  "Town:"+town+","+state+" Zip: "+zip+"  (Area Code:"+PhoneAreaCode+", Time Zone:"+TimeZone+")"
    +"\n County: "+County+" population:" +CountyPopulation;
    return str;//return the collective values of the objects
}

    public String  getZip() {
	return zip;

    }
    public String  getCountyPopulation() {
        return CountyPopulation;

    }
    public String  getPhoneAreaCode() {
        return PhoneAreaCode;

    }
    public String  getCounty() {
        return County;

    }

    protected String getTown() {
	return town;

    }
    protected String getTimeZone() {
        return TimeZone;

    }
   
    protected String getState() {
	return state;
    }

   
   

    

    
    
    
}
