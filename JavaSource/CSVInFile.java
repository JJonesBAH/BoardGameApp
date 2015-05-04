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

    public int getLineCount(String inPath) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inPath)));
        int lines = 1;
        if(br.readLine() == "\n" && br.readLine() == null){
            System.out.println("File contains no data");
            System.exit(1);
        }
        while (br.readLine() != null) lines++;
        br.close();
        return lines;
    }

    public ComponentList buildComponentList(String inPath, String inType) throws IOException {
        String path = inPath;
        BufferedReader br;
        ComponentList componentList;
        if (inType.equalsIgnoreCase("user")) {
            componentList = new ComponentList<User>();
            try {
                String line;
                int inNumber;
                int counter = 0;
                br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
                inNumber = getLineCount(inPath);
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

                while (counter < inNumber) {
                    String[] lineSplit = line.split(",");
                    if (lineSplit.length == 10) {
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
                        componentList.add(user[counter]);
                        counter++;
                        line = br.readLine();
                    } else {
                        System.out.println("Failed building user component list");
                        System.exit(1);
                    }
                }
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return componentList;
        } else if (inType.equalsIgnoreCase("game")) {
            componentList = new ComponentList<Game>();
            try {
                String line;
                int inNumber;
                int counter = 0;
                br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
                inNumber = getLineCount(inPath);
                line = br.readLine();

                String inName;
                String inDescription;
                String inOwner;

                OwnedGame[] games = new OwnedGame[inNumber];
                while (counter < inNumber) {
                    String[] lineSplit = line.split(",");
                    if (lineSplit.length == 3) {
                        inName = lineSplit[0];
                        inDescription = lineSplit[1];
                        inOwner = lineSplit[2];

                        games[counter] = new OwnedGame(inName, inDescription, inOwner);
                        componentList.add(games[counter]);
                        counter++;
                        line = br.readLine();
                    } else {
                        System.out.println("file not compatible");
                        System.exit(1);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return componentList;
        } else {
            System.out.println("Failed building Game Component List");
            System.exit(1);
        }
        //should be unreachable code
        return null;
    }

    public int getFirstLine(String inPath) throws IOException{
        String path = inPath;
        RandomAccessFile rf;
        String inNum;
        int inNumber = 0;
        try {
            rf = new RandomAccessFile(new File(path), "r");
            rf.seek(0);
            inNum = rf.readLine();
            inNumber = Integer.parseInt(inNum);
            rf.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return inNumber;
    }

    public void appendCSV(String inPath, ComponentList inList) throws IOException {
        BufferedWriter bw;
        RandomAccessFile rf;
        try {
            bw = new BufferedWriter(new FileWriter(inPath, true));
            int inNumber;
            //used to get the number at the start of the file.
            inNumber = getFirstLine(inPath);
            // checks to see if the number at the start of the file is the same as the number of users in userList
            if (inNumber == inList.getLength()) {
                System.out.println("no new data to append to file");
                bw.close();
                System.exit(1);
            }
            else {
                bw.write(inList.appendCSV(inNumber));
                bw.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void printCSV(String inPath, ComponentList inList) throws IOException {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(inPath, false));
            bw.write(inList.printCSV());
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
