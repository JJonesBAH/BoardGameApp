import java.util.ArrayList;

/**
 * Created by developer on 4/10/2015.
 */
public class GameList {

    private ArrayList<Game> gameList;

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

    public String printCSV(){
        String output = "";

        for(Game g: gameList){
            output += g.printCSV();
        }
        return output;
    }

    public int getLength(){
        int counter = 0;
        for(Game g: gameList){
            counter++;
        }
        return counter;
    }

    public String printLength(){
        return Integer.toString(getLength());
    }

    public String appendCSV(int inNumber){
        int start = inNumber;
        Game temp;
        String output = "";
        for(; start < getLength(); start++){
            temp = gameList.get(start);
            output += temp.printCSV() + "\n";
        }
        return output;
    }
}
