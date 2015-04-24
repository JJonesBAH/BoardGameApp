import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;


/**
 * Created by developer on 4/22/2015.
 */

public class CSVInFile {

    public UserList buildUserList(String inPath) throws IOException {

        String path = inPath;
        UserList userList = new UserList();
        BufferedReader br;

        try {
            String line;
            int inNumber;
            int counter = 0;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            line = br.readLine();
            inNumber = Integer.parseInt(line);
            line = br.readLine();
            String inFName;
            String inLName;
            String inSex;
            String inPhone;
            String inEmail;
            int inUnit;
            String inStreet;
            String inCity;
            String inState;
            int inZip;

            User[] user = new User[inNumber];

            while(counter < inNumber){
                String[] lineSplit = line.split(",");
                if(lineSplit.length == 10) {
                    inFName = lineSplit[0];
                    inLName = lineSplit[1];
                    inSex = lineSplit[2];
                    inPhone = lineSplit[3];
                    inEmail = lineSplit[4];
                    inUnit = Integer.parseInt(lineSplit[5]);
                    inStreet = lineSplit[6];
                    inCity = lineSplit[7];
                    inState = lineSplit[8];
                    inZip = Integer.parseInt(lineSplit[9]);

                    user[counter] = new User(inFName, inLName, inSex, inPhone, inEmail, inUnit, inStreet, inCity, inState, inZip);
                    userList.addUser(user[counter]);
                    counter++;
                    line = br.readLine();
                }
                else{
                    System.exit(1);
                }
            }
            br.close();
        }

        catch(IOException ex){
            ex.printStackTrace();
        }
        return userList;
    }

    public GameList buildGameList(String inPath) throws IOException {

        String path = inPath;
        GameList gameList = new GameList();
        BufferedReader br;

        try {
            String line;
            int inNumber;
            int counter = 0;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            line = br.readLine();
            inNumber = Integer.parseInt(line);
            line = br.readLine();

            String inName;
            String inDescription;
            String inOwner;

            OwnedGame[] games = new OwnedGame[inNumber];
            for (int i = 0; i < inNumber; i++) {
                String[] lineSplit = line.split(",");
                if (lineSplit.length == 3) {
                    inName = lineSplit[0];
                    inDescription = lineSplit[1];
                    inOwner = lineSplit[2];

                    games[i] = new OwnedGame(inName, inDescription, inOwner);
                    gameList.addGame(games[i]);

                } else {
                    System.out.println("file not compatible");
                    System.exit(1);
                }
            }
        }

            catch(IOException ex){
                ex.printStackTrace();
            }
        return gameList;
    }

    //method to append to a CSV file while updating the number at beginning of the file.
    public void appendUserCSV(String inPath, UserList inList) throws IOException{
        String path = inPath;
        BufferedWriter bw;
        RandomAccessFile rf;
        try {
            bw = new BufferedWriter(new FileWriter(path, true));
            rf = new RandomAccessFile(new File(path), "rw");
            int inNumber;
            rf.seek(0);
            inNumber = rf.readInt();
            // checks to see if the number at the start of the file is the same as the number of users in userList
            if (inList.getLength() != inNumber) {
                rf.write(inNumber);
                bw.write(inList.appendCSV(inNumber));
            }
        }
            catch (IOException ex){
                ex.printStackTrace();
            }
    }

    public void appendGameCSV(String inPath, GameList inList) throws IOException{
        String path = inPath;
        BufferedWriter bw;
        RandomAccessFile rf;
        try {
            bw = new BufferedWriter(new FileWriter(path, true));
            rf = new RandomAccessFile(new File(path), "rw");
            int inNumber;
            rf.seek(0);
            inNumber = rf.readInt();
            // checks to see if the number at the start of the file is the same as the number of users in userList
            if (inList.getLength() != inNumber) {
                rf.write(inNumber);
                bw.write(inList.appendCSV(inNumber));
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void printUserCSV(String inPath, UserList inList)throws IOException{
        try {
            String path = inPath;
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
            bw.write(inList.printLength() + "\n");
            bw.write(inList.printCSV());
            bw.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public void printGameCSV(String inPath, GameList inList)throws IOException{
        try {
            String path = inPath;
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
            bw.write(inList.printLength() + "\n");
            bw.write(inList.printCSV());
            bw.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
