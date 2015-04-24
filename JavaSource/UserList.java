import java.util.ArrayList;

/**
 * Created by developer on 4/10/2015.
 */

public class UserList{

    private ArrayList<User> users;

    public UserList(){
        users = new ArrayList<User>();
    }

    public void addUser(User inUser){
        this.users.add(inUser);
    }

    public void removeUser(User inUser){
        this.users.remove(inUser);
    }

    public ArrayList getAttendanceList(){
        return this.users;
    }

    public String printLength(){
      return Integer.toString(getLength());
    }

    public int getLength() {
        int lenght = 0;
        if (users.isEmpty()) {
            return lenght;
        } else {
            for (User u : users) {
                lenght++;
            }
        }
        return lenght;
    }

    public String printUserInfo() {
        String output = "";
        if (users.isEmpty()) {
            return "No users in list";
        } else {
            for(User u : users) {
                output += "\n" + u.printUserInfo() + "\n";
            }
        }
        return output;
    }

    public boolean doesUserExistById(int inUserId){
        int searchId = inUserId;
        boolean isFound = false;
        if(users.isEmpty()){
            return isFound;
        }
        else {
            for (User u : users) {
                if (searchId == u.getUserId()) {
                    isFound = true;
                    return isFound;

                } else {
                    continue;
                }
            }
        }
        return isFound;
    }

    public boolean doesUserExistByName(String inName){
        boolean isFound = false;
        String search = inName;
        if(users.isEmpty()){
           isFound = false;
        }
        else if(search.contains(" ")){
            for(User u: users){
                if(search.equalsIgnoreCase(u.getFullName())){
                    isFound = true;
                }
                else{
                    continue;
                }
            }
        }
        else {
            for (User u : users) {
                if (search.equalsIgnoreCase(u.getfName()) || search.equalsIgnoreCase(u.getlName())) {
                    isFound = true;
                } else {
                    continue;
                }
            }
        }
        return isFound;
    }

    public User returnUserByName(String inName){
        String search = inName;
        if(users.isEmpty()){
            return null;
        }
        else if(search.contains(" ")){
            for(User u: users){
                if(search.equalsIgnoreCase(u.getFullName())){
                    return u;
                }
                else{
                    continue;
                }
            }
        }
        else {
            for(User u: users){
                if(search.equalsIgnoreCase(u.getfName()) || search.equalsIgnoreCase(u.getlName())){
                    return u;
                }
                else{
                    continue;
                }
            }
        }
        return null;
    }

    public User returnUserById(int inId){
        if(users.isEmpty()){
            return null;
        }
        else{
            for(User u: users){
                if(inId == u.getUserId()){
                    return u;
                }
                else{
                    continue;
                }
            }
        }
        return null;
    }

    public String printCSV(){
        String output = "";
        for(User u: users){
            output += u.printCSV() + "\n";
        }
        return output;
    }

    public String appendCSV(int inNumber){
        int start = inNumber;
        User temp;
        String output = "";
        for(; start < getLength(); start++){
            temp = users.get(start);
            output += temp.printCSV() + "\n";
        }
        return output;
    }

}
