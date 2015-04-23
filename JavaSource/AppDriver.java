/**
 * Created by developer on 4/11/2015.
 */

import java.util.Scanner;
public class AppDriver {

    public static void main(String[] args) throws Exception{
        UserList clubMembers = new UserList();
        GameList gameList = new GameList();
        String inputData;

        Scanner input = new Scanner(System.in);
        int inputInt = 0;
        System.out.print("Please enter your first name: ");
        inputData =  input.next();
        User u = new User();
        u.setfName(inputData);
        System.out.print("Please enter your last name: ");
        inputData = input.next();
        u.setlName(inputData);

        u.setContactInfo("775-2005", "notinghamCourt@domain.com");
        u.setAddress(101, "haywood dr.", "charleston", "south caronlina", 29407);

        clubMembers.addUser(u);

        String inputFname;
        String inputLname;
        String inputSex;

        System.out.print("Please the number of uesers you wish to enter: ");
        inputInt = input.nextInt();
        User[] userList = new User[inputInt];
        for(int i = 0; i < inputInt; i++){
            userList[i] = new User();
            System.out.print("Please enter users first name: ");
            inputFname = input.nextLine();
            input.reset();
            System.out.print("Please enter users last name: ");
            inputLname = input.nextLine();
            input.reset();
            System.out.print("Please enter users sex: ");
            inputSex = input.nextLine();
            input.reset();
            userList[i].setfName(inputFname);
            userList[i].setlName(inputLname);
            userList[i].setUserSex(inputSex);
            clubMembers.addUser(userList[i]);
        }

        String inGameName;
        String inOwnerName;
        String inDescription;

        System.out.print("Please enter the number of games you would like to add to the Gamelist: ");
        inputInt = input.nextInt();
        OwnedGame[] games = new OwnedGame[inputInt];
        for(int i = 0; i < inputInt; i++){
            // for some reason the input.next() and the input.nextLine() is not working properly.
            System.out.print("Please enter name of the game: ");
            inGameName = input.next();
            System.out.print("Please enter owner of the game: ");
            inOwnerName = input.next();
            System.out.print("Please enter a description for the game: ");
            inDescription = input.next();
            games[i] = new OwnedGame();
            games[i].setName(inGameName);
            games[i].setOwner(inOwnerName);
            games[i].setDescription(inDescription);
            gameList.addGame(games[i]);
        }

        System.out.println(gameList.printGameList());
        System.out.println(clubMembers.printUserInfo());
    }
}
