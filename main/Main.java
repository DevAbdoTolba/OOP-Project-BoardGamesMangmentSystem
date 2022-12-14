package main;

import java.util.Scanner;
import Data.fileStream;
import main.Classes.Player;

public class Main {
    /*
     * Global Variables
     */
    int value;
    String name_of_players;
    static Scanner sc = new Scanner(System.in);
    static Main pl1 = new Main();

    String mainPath = "Data\\games.txt";
    String tempPath = "Data\\gamesTemp.txt";
    String newData = "";

    /*
     * Main Method
     * 
     * ! MAIN METHOD
     */
    public static void main(String args[]) {
        int score = 0;

        pl1.mainMenu(); // main menu to chose the game

        System.out.println("Enter the number of players");
        int number_of_players;
        number_of_players = sc.nextInt();
        Player[] players = new Player[number_of_players];

        for (int i = 0; i < number_of_players; i++) {
            System.out.print("Enter the name of player " + (i + 1) + " : ");
            players[i].setName(sc.next());

        }
        System.out.println("are the values fixed? (1 for yes, 0 for no)");
        while(true){
        if (sc.nextInt() == 1) {
            System.out.println("Enter the value");
            score = sc.nextInt();
            for (int i = 0; i < number_of_players; i++) {
                players[i].setScore(score);
            }
            break;
        } else if (sc.nextInt() == 0) {
            for (int i = 0; i < number_of_players; i++) {
                System.out.println("Enter the value of player " + (i + 1));
                score = sc.nextInt();
                players[i].setScore(score);

            }
            break;
        } else {
            System.out.println("Invalid input\n\n");

        }
    }

        // ArrayList<String> player = new ArrayList<String>();
        // ArrayList<String> games = new ArrayList<String>();
        // ArrayList<String> Items = new ArrayList<String>();
        // pl1.addPlayers();
        // pl1.score();
        // pl1.fixedValue();
    }

    /*
     * Mathods
     * 
     */

    public void mainMenu() {

        fileStream fs = new fileStream();
        int numOfGames = fs.numberOfRows(mainPath); // instance numOfGames Variable
        
        System.out.println("Choose game number :- "); // print menu list
        for (int i = 1; i <= numOfGames; i++) {
            System.out.println(i + "-" + fs.indexLine(mainPath, i)[0]);
            if ((i+1) > numOfGames) {
                System.out.println((i + 1) + "-" + "Add New Game ");
            }
        }

        int choice = sc.nextInt(); // input the user choice of the list of games

        
            if (choice == numOfGames+1) // a condition to let user create a new game
            {
                String GameName;
                int scoreOfPlayers = 0;
                int num_of_players = 0;
                System.out.println("Enter New Game Name: ");
                GameName = sc.next(); // Input The Name of The New Game
                
                
                System.out.println("Is the number of players fixed always? (1 for yes, 0 for no)");
                int fixed = sc.nextInt();
                if (fixed == 1) {
                    System.out.print("Number of players : ");
                    num_of_players = sc.nextInt();

                } else if (fixed == 0) {
                } else {
                    System.out.println("Invalid input\n\n");
                }

                    System.out.println("Are all players also start with the same score? (1 for yes, 0 for no)");
                    int fixedScore = sc.nextInt();
                    if (fixedScore == 1) {
                        System.out.print("Score : ");
                        scoreOfPlayers = sc.nextInt();
                    } else if (fixedScore == 0) {
                    } else {
                        System.out.println("Invalid input\n\n");
                    }
                
                
                newData = GameName + "," + ((num_of_players != 0)? num_of_players:"NaN") + "," + ((scoreOfPlayers != 0)? scoreOfPlayers:"NaN") +","+"0"; // create a new line of data
                fs.writeToFile(mainPath, tempPath, newData,0); // write the new data to the file

            } else if (choice <= numOfGames && choice > 0) {
                System.out.println("You have selected " + fs.indexLine(mainPath, choice)[0]); // print the selected game

            } else {
                System.out.println("Invalid input\n\n");
            }
        }


}