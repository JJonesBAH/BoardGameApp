/**
 * Created by developer on 4/10/2015.
 */
public class Game {

    private String name;
    private String description;


    public Game (){
        this.name = "Default Name";
        this.description = "Default Description";
    }

    public Game(String inName){
        this.name = inName;
        this.description = "Default Description";
    }

    public Game (String inName, String inDescription){
        this.name = inName;
        this.description = inDescription;
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

    public String printCSV(){
        String output = "";
        output += name + "," + description;
        return output;
    }

}
