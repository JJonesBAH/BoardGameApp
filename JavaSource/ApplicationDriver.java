import java.io.IOException;
import java.util.Scanner;

/**
 * Created by developer on 4/22/2015.
 */
public class ApplicationDriver {

    public static void main (String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        CSVInFile csv = new CSVInFile();
        String response = "";
        UserList userList;
        GameList gameList;
        userList = csv.buildUserList("C:\\Users\\developer\\Desktop\\examplecsv.txt");
        gameList = csv.buildGameList("C:\\Users\\developer\\Desktop\\gameCSV.txt");
        //ComponentList<Game> ourGameList;
        //ComponentList<User> ourUserList;
        //ourGameList = csv.buildGameList("C:\\Users\\developer\\Desktop\\gameCSV.txt");
        //ourUserList = csv.buildUserList("C:\\Users\\developer\\Desktop\\examplecsv.txt");
        System.out.println("If you would like to enter more users enter Y for yes or N for no: ");
        response = input.next();
        if(response.equalsIgnoreCase("y")) {
            int inputInt = 0;
            String inputFname;
            String inputLname;
            String inputSex;
            System.out.print("Please the number of uesers you wish to enter: ");
            inputInt = input.nextInt();
            User[] inUsers = new User[inputInt];
            for (int i = 0; i < inputInt; i++) {
                System.out.print("Please enter users first name: ");
                inputFname = input.nextLine();
                input.reset();
                System.out.print("Please enter users last name: ");
                inputLname = input.nextLine();
                input.reset();
                System.out.print("Please enter users sex: ");
                inputSex = input.nextLine();
                input.reset();
                inUsers[i] = new User(inputFname, inputLname, inputSex);
                userList.addUser(inUsers[i]);
            }
        }

        System.out.println("If you would like to enter more games enter Y for yes or N for no: ");
        response = input.next();
        if(response.equalsIgnoreCase("y")) {
            int inputInt = 0;
            String inputName;
            String inputDescription;
            String inputOwner;
            System.out.print("Please the number of games you wish to enter: ");
            inputInt = input.nextInt();
            OwnedGame[] inGames = new OwnedGame[inputInt];
            for (int i = 0; i < inputInt; i++) {
                System.out.print("Please enter games name: ");
                inputName = input.nextLine();
                input.reset();
                System.out.println("Please enter a description for the game: ");
                inputDescription = input.nextLine();
                input.reset();
                System.out.print("Please enter the games owner: ");
                inputOwner = input.nextLine();
                input.reset();
                inGames[i] = new OwnedGame(inputName, inputDescription, inputOwner);
                gameList.addGame(inGames[i]);
            }
        }

        System.out.println("Number for Games on file: " + gameList.getLength());
        System.out.println("Number of Users on file: " + userList.getLength());
    }

}
