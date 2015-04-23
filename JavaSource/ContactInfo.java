/**
 * Created by developer on 4/10/2015.
 */
public class ContactInfo {

    private String phoneNumber;
    private String emailAddress;
    private Address address;

    public ContactInfo(String inPhone, String inEmail, int inUnit, String inStreet, String inCity, String inState, int inZip) {
        this.phoneNumber = inPhone;
        this.emailAddress = inEmail;
        address = new Address(inUnit, inStreet, inCity, inState, inZip);
    }

    public ContactInfo(String inPhone, String inEmail){
        this.phoneNumber = inPhone;
        this.emailAddress = inEmail;
        address = new Address();
    }

    public ContactInfo() {
        this.phoneNumber = "(111)-222-3333";
        this.emailAddress = "Default@email.com";
        address = new Address();
    }

    public void setAddress(int inUnit, String inStreet, String inCity, String inState, int inZip){
        address.setUnitNumber(inUnit);
        address.setStreet(inStreet);
        address.setCity(inCity);
        address.setState(inState);
        address.setZipCodee(inZip);
    }

    public Address returnAddress(){
        return address;
    }

    public void setPhoneNumber(String inNumber) {
        this.phoneNumber = inNumber;
    }

    public void setEmailAddress(String inEmail) {
        this.emailAddress = inEmail;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getContactInfo(){
        String output = "";
        output += "Phone Number: " + this.phoneNumber + "\n" +
                "Email Address: " + this.emailAddress + "\n" +
                address.printAddress();
        return output;
    }

    public String printCSV(){
        String output = "";
        output += phoneNumber + "," + emailAddress + "," + address.printCSV();
        return output;
    }
}