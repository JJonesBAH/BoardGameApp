/**
 * Created by developer on 4/10/2015.
 */
public class User {

    private String fName;
    private String lName;
    private String usersSex;
    private ContactInfo contact;
    private static int idCounter = 1;
    private int userId;

    public User(){
        this.fName = "Default";
        this.lName = "Holder";
        this.usersSex = "Unknown";
        contact = new ContactInfo();
        userId = idCounter++;
    }

    public User(String inFname, String inLname, String inSex){
        this.fName = inFname;
        this.lName = inLname;
        this.usersSex = inSex;
        contact = new ContactInfo();
        userId = idCounter++;
    }

    public User(String inFname, String inLname, String inSex, String inEmail, String inPhone, int inUnit, String inStreet, String inCity, String inState, int inZip){
        this.fName = inFname;
        this.lName = inLname;
        this.usersSex = inSex;
        contact = new ContactInfo(inEmail, inPhone, inUnit, inStreet, inCity, inState, inZip);
        userId = idCounter++;
    }

    public void setUserSex(String inSex){
        this.usersSex = inSex;
    }

    public void setfName(String infName) {
        this.fName = infName;
    }

    public void setlName(String inlName) {
        this.lName = inlName;
    }

    public void setContactInfo(String inEmail, String inPhone){
        this.contact = new ContactInfo(inEmail, inPhone);
    }

    public String getUsersSex(){
        return this.usersSex;
    }

    public void setAddress(int inUnit, String inStreet, String inCity, String inState, int inZip){
        this.contact.setAddress(inUnit, inStreet, inCity, inState, inZip);
    }

    public String getfName() {
        return this.fName;
    }

    public String getlName() {
        return this.lName;
    }

    public String getFullName() {
        return this.fName + " " + this.lName;
    }

    public int getUserId(){
        return userId;
    }

    public String printUserInfo(){
        return "\nUsers Full Name: " + this.getFullName() + "\nUsers contact Info: \n" + contact.getContactInfo() + "\n";
    }

    public Address getAddress(){
        return contact.returnAddress();
    }

    public String printCSV(){
        String output = "";
        output += fName + "," + lName + "," + usersSex  + "," + contact.printCSV() + "," + userId + "\n";
        return output;
    }
}
