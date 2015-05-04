/**
 * Created by developer on 4/10/2015.
 */
public class Game {

    private String name;
    private String description;
    private static int idCounter = 1;
    private int gameId;


    public Game (){
        this.name = "Default Name";
        this.description = "Default Description";
        gameId = idCounter++;
    }

    public Game (String inName, String inDescription){
        this.name = inName;
        this.description = inDescription;
        gameId = idCounter++;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setName(String inName){
        this.name = inName;
    }

    public  void setDescription(String inDescription){
        this.description = inDescription;
    }

    public int getGameId(){
        return this.gameId;
    }

    public String printCSV(){
        String output = "";
        output += name + "," + description + "," + gameId + "\n";
        return output;
    }

    public String printGameInfo(){
        String output = "";
        output += "\nGame Name: " + this.name + "\n" +
                "Game Description: " + this.description + "\n" +
                "Game Id: " + this.gameId + "\n";
        return output;
    }

}
