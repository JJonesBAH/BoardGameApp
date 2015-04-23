/**
 * Created by developer on 4/10/2015.
 */
public class GameNight {

    private GameLocation gameLocation;
    private UserList attendanceList;
    private String date;

    public GameNight(){
        this.gameLocation = null;
        this.attendanceList = null;
        this.date = null;
    }

    public GameNight(GameLocation inLocation, UserList inList, String inDate){
        this.gameLocation = inLocation;
        this.attendanceList = inList;
        this.date = inDate;
    }

    public void setDate(String inDate){
        System.out.println("Please enter a date in the format of mmddyyyy");
        this.date = inDate;
    }

    public void setGameLocation(GameLocation inLocation){
        this.gameLocation = inLocation;
    }

    public void setAttendanceList(UserList inList){
        this.attendanceList = inList;
    }

    public String getAttendanceList(){
        return attendanceList.printUserInfo();
    }

    public String getGameLocation(){
        return gameLocation.getLocationInfo();
    }
}
