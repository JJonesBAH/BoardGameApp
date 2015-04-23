import java.io.*;

/**
 * Created by developer on 4/22/2015.
 */

public class CSVInFile {

    public UserList runInput(String inPath) throws IOException {

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

            User u = new User("first", "last", "female", "email@email.com", "9876543212", 101, "ray Street", "willie city", "ca" , 21456);
            userList.addUser(u);
            User u2 = new User("second", "jones", "female", "jonesemail@email.com", "1235698741", 2501, "ray terris Street", "joens city", "ma" , 21566);
            userList.addUser(u2);
            System.out.println(userList.getListLength());
            System.out.println(userList.printCSV());
            br.close();
        }

        catch(IOException ex){
            ex.printStackTrace();
        }
        return userList;
    }


    //method to append to a CSV file while updating the number at beginning of the file.
    public void appendCSVFile(String inPath, UserList inList) throws IOException{
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
            if (inList.getListLength() != inNumber) {
                rf.write(inNumber);
                bw.write(inList.appendCSV(inNumber));
            }
        }
            catch (IOException ex){
                ex.printStackTrace();
            }
    }

    public void printCSVFile(String inPath, UserList inList)throws IOException{
        try {
            String path = inPath;
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
            bw.write(inList.printListLength() + "\n");
            bw.write(inList.printCSV());
            bw.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }


    public static void main(String args[]) throws IOException {
        CSVInFile in = new CSVInFile();
        UserList userList;
        userList = in.runInput ("C:\\Users\\developer\\Desktop\\examplecsv.txt");
        in.printCSVFile("C:\\Users\\developer\\Desktop\\CSVOut.txt", userList);
        in.appendCSVFile("C:\\Users\\developer\\Desktop\\CSVOut.txt", userList);
    }
}
