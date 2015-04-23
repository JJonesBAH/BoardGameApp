/**
 * Created by developer on 4/20/2015.
 */
public class Address {
    private int unitNumber;
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public Address(){
        this.unitNumber = 0;
        this.street = "Default";
        this.city = "Default";
        this.state = "Default";
        this.zipCode = 00000;
    }

    public Address(int inUnit, String inStreet, String inCity, String inState, int inZip){
        this.unitNumber = inUnit;
        this.street = inStreet;
        this.city = inCity;
        this.state = inState;
        this.zipCode = inZip;
    }

    public void  setUnitNumber(int inUnit){
        this.unitNumber = inUnit;
    }

    public void setStreet(String inStreet){
        this.street = inStreet;
    }

    public void setCity(String inCity){
        this.city = inCity;
    }

    public void setState(String inState){
        this.state = inState;
    }

    public void setZipCodee(int inZip){
        this.zipCode = inZip;
    }

    public int getUnitNumber(){
        return this.unitNumber;
    }

    public String getStreet(){
        return this.street;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public int getZipCode(){
        return this.zipCode;
    }

    public String printAddress(){
        String output = "";
        output += "Address: " + unitNumber + " " + street + ", " + city + " " + state + " " + zipCode;
        return output;
    }

    public String printCSV(){
        String output = "";
        output += unitNumber + "," + street + "," + city + "," + state + "," + zipCode;
        return output;
    }

}
