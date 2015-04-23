/**
 * Created by developer on 4/10/2015.
 */
public class OwnedGame extends Game {
    private String ownerName;

    public void setOwner(String inOwner){
        this.ownerName = inOwner;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public User getOwner(UserList users){
        return users.returnUserByName(ownerName);
    }

    public OwnedGame(){
        super();
        this.ownerName = "Default Name";
    }

    public OwnedGame(String inName, String inDescription, String inOwner){
        super(inName, inDescription);
        this.ownerName = inOwner;
    }

}
