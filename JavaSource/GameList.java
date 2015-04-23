import java.util.ArrayList;

/**
 * Created by developer on 4/10/2015.
 */
public class GameList {

    ArrayList<Game> gameList;

    public GameList(){
        this.gameList = new ArrayList<Game>();
    }

    public void addGame(Game inGame){
        this.gameList.add(inGame);
    }

    public void removeGame(Game inGame){
       this.gameList.remove(inGame);
    }

    public String printGameList(){
        String output = "";
        for(Game g: gameList){
            output += "Game Name: " +  g.getName() + "\n" +
                    "Game Description: " + g.getDescription() + " \n";
        }
        return output;
    }



}
