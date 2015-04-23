/**
 * Created by developer on 4/10/2015.
 */
public class GameLocation {

    private String locationName;
    User holder;

    public GameLocation() {
        this.locationName = "Default";
    }

    public void getLocationOwner(UserList users){
        holder =  users.returnUserByName(locationName);
    }

    public String getLocationInfo(){
        return holder.printUserInfo();
    }

}
