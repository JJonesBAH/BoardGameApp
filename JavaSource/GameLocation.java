/**
 * Created by developer on 4/10/2015.
 */
public class GameLocation {

    private String locationName;
    User holder;

    public GameLocation() {
        this.locationName = "Default";
    }


    public void getLocationOwner(ComponentList users){
        holder =  User.class.cast(users.returnItemByName(locationName));
    }

    public String getLocationInfo(){
        return holder.printUserInfo();
    }

}
