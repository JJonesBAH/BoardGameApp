import java.io.IOException;
import java.util.Scanner;

/**
 * Created by developer on 4/22/2015.
 */
public class ApplicationDriver {

    private static boolean checkResults(){
        String response;
        Scanner input = new Scanner(System.in);
        boolean output = false;
        do {
            response = input.next();
            if((!response.equalsIgnoreCase("y")) && (!response.equalsIgnoreCase("n")))
                System.out.println("Please enter Y or N");
        } while((!response.equalsIgnoreCase("y")) && (!response.equalsIgnoreCase("n")));
        if(response.equalsIgnoreCase("y")){
            output = true;
        }
        return output;
    }


    public static void main (String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        CSVInFile csv = new CSVInFile();
        //String response = "";
        GameNight gameNight;
        ComponentList<OwnedGame> ourGameList;
        ComponentList<User> ourUserList;
        ComponentList<WantedGame> wantedGameList;
        ourGameList = csv.buildComponentList("C:\\Users\\developer\\Desktop\\gameCSV.txt", "game");
        ourUserList = csv.buildComponentList("C:\\Users\\developer\\Desktop\\examplecsv.txt", "user");
        for(int i = 0; i < 10; i++){
            System.out.print("If you would like to enter more users enter Y for yes or N for no: ");
            if(checkResults()){
                int inputInt = 0;
                String inputFname;
                String inputLname;
                String inputSex;
                System.out.print("Please the number of uesers you wish to enter: ");
                inputInt = input.nextInt();
                User[] inUsers = new User[inputInt];
                for (int j = 0; j < inputInt; j++) {
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
                    ourUserList.add(inUsers[j]);
                }
            }

            //gets input from user to determine if there are more games to enter.
            System.out.print("If you would like to enter more games enter Y for yes or N for no: ");
            if(checkResults()) {
                int inputInt = 0;
                String inputName;
                String inputDescription;
                String inputOwner;
                System.out.print("Please the number of games you wish to enter: ");
                inputInt = input.nextInt();
                OwnedGame[] inGames = new OwnedGame[inputInt];
                for (int j = 0; j < inputInt; j++) {
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
                    ourGameList.add(inGames[j]);
                }
            }

            //used to determine if you data is to be printed to console or a file
            System.out.print("If you would like print information to the console or to a file? \n" +
                    "To print to Console enter Y to print to File enter N: ");
            if(checkResults()) {
                System.out.println("Number for Games on file: " + ourGameList.getLength());
                System.out.println(ourGameList.printInfo());
                System.out.println("Number of Users on file: " + ourUserList.getLength());
                System.out.println(ourUserList.printInfo());
            }
            else {
                csv.printCSV("C:\\Users\\developer\\Desktop\\userOutCSV.txt", ourUserList);
                csv.printCSV("C:\\Users\\developer\\Desktop\\gameOutCSV.txt", ourGameList);
            }

            // more data to be processed to check out if the append to csv file works.
            System.out.print("Is there anymore data to process Enter Y for yes or N for no: ");
            if(checkResults()) {
                csv.printCSV("C:\\Users\\developer\\Desktop\\userOutCSV.txt", ourUserList);
                csv.printCSV("C:\\Users\\developer\\Desktop\\gameOutCSV.txt", ourGameList);
                OwnedGame og = new OwnedGame("gameName", "gameDesc", "GameOwner");
                OwnedGame og2 = new OwnedGame("gameName number2", "gameDescnumber 2", "GameOwner number2");
                OwnedGame og3 = new OwnedGame("gameName", "gameDesc", "GameOwner");
                OwnedGame og4 = new OwnedGame("gameName number2", "gameDescnumber 2", "GameOwner number2");
                OwnedGame og5 = new OwnedGame("gameName", "gameDesc", "GameOwner");
                OwnedGame og6 = new OwnedGame("gameName number2", "gameDescnumber 2", "GameOwner number2");
                OwnedGame og7 = new OwnedGame("gameName", "gameDesc", "GameOwner");
                OwnedGame og8 = new OwnedGame("gameName number2", "gameDescnumber 2", "GameOwner number2");
                OwnedGame og9 = new OwnedGame("gameName", "gameDesc", "GameOwner");
                OwnedGame og10 = new OwnedGame("gameName number2", "gameDescnumber 2", "GameOwner number2");
                OwnedGame og11 = new OwnedGame("gameName", "gameDesc", "GameOwner");
                OwnedGame og12 = new OwnedGame("gameName number2", "gameDescnumber 2", "GameOwner number2");
                ourGameList.add(og);
                ourGameList.add(og2);
                ourGameList.add(og3);
                ourGameList.add(og4);
                ourGameList.add(og5);
                ourGameList.add(og6);
                ourGameList.add(og7);
                ourGameList.add(og8);
                ourGameList.add(og9);
                ourGameList.add(og10);
                ourGameList.add(og11);
                ourGameList.add(og12);

                System.out.println(csv.getFirstLine("C:\\Users\\developer\\Desktop\\gameOutCSV.txt"));
                System.out.println(ourGameList.getLength());

                csv.appendCSV("C:\\Users\\developer\\Desktop\\gameOutCSV.txt", ourGameList);
            }

            //used to break out of the build loop for adding users and games.
            System.out.print("Is there any more data to enter? \n " +
                    "If So enter Y for Yes or N for No: ");
            if(!checkResults()) break;
        }

        // to do
        //Start building the rest of the application need to figure out play list and game night

        System.out.print("Are there any games that you would like to add to the wanted gameList? \n" +
                "If you would like to games to the wanted game list please enter Y for Yes or N for no: ");
        if(checkResults()){
            wantedGameList = new ComponentList<WantedGame>();
            int inputInt;
            String inName;
            String inDes;
            String inSeller;
            String inPrice;
            int price;
            System.out.print("Please enter the number of games you wish to add to the wanted gamelist: ");
            inputInt = input.nextInt();
            WantedGame[] inGames = new WantedGame[inputInt];
            for (int j = 0; j < inputInt; j++) {
                System.out.print("Please enter games name: ");
                inName = input.nextLine();
                input.reset();
                System.out.println("Please enter a description for the game: ");
                inDes = input.nextLine();
                input.reset();
                System.out.print("Please enter the games seller's info: ");
                inSeller = input.nextLine();
                input.reset();
                System.out.print("Please enter the price of the game: ");
                inPrice = input.nextLine();
                input.reset();
                price = Integer.parseInt(inPrice);
                inGames[j] = new WantedGame(inName, inDes, inSeller, price);
                wantedGameList.add(inGames[j]);
            }
        }

        System.out.print("Would you like to set up a new GameNight for the club to meet? \n" +
                "If you would like to set one up now enter Y for yes or N for no: ");
        if(checkResults()){
            //need to get information on setting up a new game night.
        }
    }
}

