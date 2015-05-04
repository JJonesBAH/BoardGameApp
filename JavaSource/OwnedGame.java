/**
 * Created by developer on 4/10/2015.
 */
public class OwnedGame extends Game {
    private String ownerName;


    public OwnedGame(){
        super();
        this.ownerName = "Default Name";
    }

    public OwnedGame(String inName, String inDescription, String inOwner){
        super(inName, inDescription);
        this.ownerName = inOwner;
    }

    public void setOwner(String inOwner){
        this.ownerName = inOwner;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public User getOwner(UserList users){
        return users.returnUserByName(ownerName);
    }

    public String printCSV(){
        String output = "";
        output += super.getName() + "," + super.getDescription() + "," + ownerName + "," + super.getGameId() + "\n";
        return output;
    }

    public String printGameInfo(){
        String output = "";
        output += "\nGame Name: " + super.getName() + "\n" +
                "Game Description: " + super.getDescription() + "\n" +
                "Game Owner: " + this.ownerName + "\n" +
                "Game Id Number: " + super.getGameId() + "\n";
        return output;
    }

    public int getGameID(){
        return super.getGameId();
    }
}
