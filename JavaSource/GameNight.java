/**
 * Created by developer on 4/10/2015.
 */
public class GameNight {

    private GameLocation gameLocation;
    private ComponentList attendanceList;
    private ComponentList playList;
    private String date;

    public GameNight(){
        this.gameLocation = null;
        this.attendanceList = null;
        this.date = null;
        this.playList = null;
    }

    public GameNight(GameLocation inLocation, ComponentList inList, String inDate, ComponentList inGames){
        this.gameLocation = inLocation;
        this.attendanceList = inList;
        this.date = inDate;
        this.playList = inGames;
    }

    public void setDate(String inDate){
        System.out.println("Please enter a date in the format of mmddyyyy");
        this.date = inDate;
    }

    public void setGameLocation(GameLocation inLocation){
        this.gameLocation = inLocation;
    }

    public void setAttendanceList(ComponentList inList){
        this.attendanceList = inList;
    }

    public String getAttendanceList(){
        return attendanceList.printInfo();
    }

    public String getGameLocation(){
        return gameLocation.getLocationInfo();
    }
}
