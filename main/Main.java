package main;


import Data.fileStream;

public class Main{
    public static void main(String args[]){



import java.util.ArrayList;
import java.util.Vector;

public class Main {
  /*
          fileStream fs = new fileStream();
        // ! TO ADD NEW DATA TO THE FILE, String newData = "gameName,score,playersNum,....";
        String mainPath = "Data\\games.txt";
        String tempPath = "Data\\gamesTemp.txt";
        int printOrNot = 1; 
        String newData = "";

        // fs.writeToFile("Data\\games.txt","Data\\gamesTemp.txt","",1);  // write
        // fs.deleteRow(mainPath, tempPath, newData, 0,"ticTac"); // delete
        // String[] row = fs.indexLine(mainPath, 1); // ! INDEX 0 IS THE TITLES START FROM 1
        // TODO: print all data
  */
  
    int value;
    int number_of_players;
    String name_of_players;
    int score = 0;
    String in;
    static Scanner pl = new Scanner(System.in);
    static Main pl1 = new Main();

    public static void main(String args[]) {

        ArrayList<String> player = new ArrayList<String>();
        ArrayList<String> games = new ArrayList<String>();
        ArrayList<String> Items = new ArrayList<String>();
        pl1.addPlayers();
        pl1.score();
        pl1.fixedValue();
    }

    public void mainMenu() {

        Scanner input = new Scanner(System.in);
        int NumGame; // instance NumGame Variable
        ArrayList<String> Games = new ArrayList<>(); // instance ArrayList for storing Game Names
        Games.add("BankElhaz"); // add ArrayList element
        Games.add("Monopoly"); // add ArrayList element
        System.out.println("Choose game number"); // print menu list

        for (int i = 0; i < Games.size(); i++) // loop to print game choices
        {
            System.out.println(i + 1 + "-" + Games.get(i)); // print the game number and game name
            if (i == Games.size() - 1) // condition to select last Choice
            {
                System.out.println(i + 2 + "-" + "Add New Game ");
            }
        }

        NumGame = input.nextInt(); // input the user choice to play
        if (NumGame > Games.size()) // a condition to let user create a new game
        {
            String GameName;
            GameName = input.next(); // Input The Name of The New Game
            System.out.println("Enter New Game Name: ");
            Games.add(GameName); // Add the new game to the ArrayList

        }

    }

    public void addPlayers() {
        System.out.println("Enter the number of players");
        number_of_players = pl.nextInt();
        for (int i = 0; i < number_of_players; i++) {
            System.out.println("Enter the name of player " + (i + 1));
            name_of_players = pl.next();
        }

    }

    public void score() {
        int score = 0;
        for (int i = 0; i < number_of_players; i++) {
            System.out.println("Enter the score of player " + (i + 1));
            score = pl.nextInt();
        }

    }

    public void fixedValue() {

        System.out.println("are the values fixed? (1 for yes, 0 for no)");
        if (pl.nextInt() == 1) {
            System.out.println("Enter the value");
            in = pl.nextLine();
        } else {
            for (int i = 0; i < number_of_players; i++) {
                System.out.println("Enter the value of player " + (i + 1));
                in = pl.nextLine();
            }
        }

    }
}