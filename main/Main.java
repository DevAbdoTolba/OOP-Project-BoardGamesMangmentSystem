package main;

import java.io.IOException;
import java.util.Scanner;
import Data.fileStream;
import main.Classes.Player;

public class Main {
    /*
     * Global Variables
     */
    static int number_of_players; 
    static int value;
    static Scanner sc = new Scanner(System.in);
    static fileStream fs = new fileStream();
    static Main pl1 = new Main();
    static int choice;
    static String mainPath = "Data\\games.txt";
    static String tempPath = "Data\\gamesTemp.txt";
    static String newData = "";
    static Player[] players;

    /*
     * Main Method
     * 
     ! MAIN METHOD
     */
    public static void main(String args[]) {

        // TODO: adding sessions, every session has a folder with seesion key which is int, starts with 1, then goes up depending on number of sessions consumed
        // TODO: sessions are gameName at the very first row, playerName, playerScore,playerStates (in or out)
        int score = 0;

        pl1.mainMenu(); // main menu to chose the game
        String[] currentLine = fs.indexLine(mainPath, choice); // get the current line of the game
        if(Integer.valueOf(currentLine[2]) > 0){
            System.out.println("Number of players : " + currentLine[2]);
            number_of_players = Integer.valueOf(currentLine[2]);
            players = new Player[number_of_players];
            for(int i = 0; i < number_of_players; i++){
                System.out.print("Enter the name of player " + (i + 1) + " : ");
                players[i] = new Player();
                players[i].setName(sc.next());
            }
        } else {
            System.out.println("Enter the number of players");
            number_of_players = sc.nextInt();
            players = new Player[number_of_players];
            for (int i = 0; i < number_of_players; i++) {
                System.out.print("Enter the name of player " + (i + 1) + " : ");
                players[i].setName(sc.next());
                
            }
        }


        

        if(Integer.valueOf(currentLine[1]) >= 0 || Integer.valueOf(currentLine[1]) < 0){
            System.out.println("Players starter score : " + currentLine[1]);
            score = Integer.valueOf(currentLine[1]);
            for (int i = 0; i < number_of_players; i++) {
                players[i].setScore(score);
                
            }    
            
        } else {
            System.out.println("Enter the number of players");
            number_of_players = sc.nextInt();
            for (int i = 0; i < number_of_players; i++) {
                System.out.print("Enter the value of player " + (i + 1) + " : ");
                players[i].setScore(sc.nextInt());
                
            }    
            
        }

        
        // ! STARTING THE GAME
        System.out.println("\nSHALL THE GAME START NOW!\n\n");
        while (true) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            printPlayers(players, number_of_players);
            System.out.println("Which player do you want to edit?\n type in range (1:" + number_of_players + ")");
            int index = sc.nextInt();
            sc.nextLine();
            editPlayers(players, index - 1);
        }

    }

    /*
     * Mathods
     * 
     */


    public void mainMenu() {

        int numOfGames = fs.numberOfRows(mainPath); // instance numOfGames Variable
        
        System.out.println("Choose game number :- "); // print menu list
        for (int i = 1; i <= numOfGames; i++) {
            System.out.println(i + "-" + fs.indexLine(mainPath, i)[0]);
            if ((i+1) > numOfGames) {
                System.out.println((i + 1) + "-" + "Add New Game ");
            }
        }

        choice = sc.nextInt(); // input the user choice of the list of games

        
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
                
                
                newData = GameName + "," + ((scoreOfPlayers != 0)? scoreOfPlayers:"NaN") + "," + ((num_of_players != 0)? num_of_players:"NaN") +","+"0"; // create a new line of data
                fs.writeToFile(mainPath, tempPath, newData,0); // write the new data to the file
                mainMenu(); // call the main menu again to show the new list of games

            } else if (choice <= numOfGames && choice > 0) {
                System.out.println("You have selected " + fs.indexLine(mainPath, choice)[0]); // print the selected game

            } else {
                System.out.println("Invalid input\n\n");
            }
        }

        static void printPlayers(Player[] players,int numOfPlayers) {
            for (int i = 0; i < numOfPlayers; ++i) {
                System.out.println(i + 1 + "-" + players[i].getName() + ": " + players[i].getScore());
            }
        }

        static void editPlayers(final Player[] players, final int i) {
            System.out.println("to edit (" + players[i].getName() + ") Enter an operation (+, -, * or /)");
            while (true) {
                switch (sc.next().charAt(0)) {
                    case '+': {
                        System.out.println("How much to add?");
                        int edit = sc.nextInt();
                        System.out.println("(" + players[i].getName() + ") Will be " + (players[i].getScore() + edit));
                        System.out.println("To confirm enter (y/n)");
                        final char ckEdit = sc.next().charAt(0);
                        if (ckEdit == 'n' || ckEdit == 'N') {
                            return;
                        }
                        if (ckEdit == 'y' || ckEdit == 'Y') {
                           
                            players[i].setScore(players[i].getScore()+edit) ;
                            System.out.println("(" + players[i].getName() + ") score is now: " + players[i].getScore() + "\n");
                            return;
                        }
                        continue;
                    }
                    case '-': {
                        System.out.println("How much to sub?");
                        final int edit = sc.nextInt();
                        System.out.println("(" + players[i].getName() + ") Will be " + (players[i].getScore() - edit));
                        System.out.println("To confirm enter (y/n)");
                        final char ckEdit = sc.next().charAt(0);
                        if (ckEdit == 'n' || ckEdit == 'N') {
                            return;
                        }
                        if (ckEdit == 'y' || ckEdit == 'Y') {
                            
                            players[i].setScore(players[i].getScore()-edit) ;

                            System.out.println("(" + players[i].getName() + ") score is now: " + players[i].getScore() + "\n");
                            return;
                        }
                        continue;
                    }
                    case '*': {
                        System.out.println("How much to multiply?");
                        final int edit = sc.nextInt();
                        System.out.println("(" + players[i].getName() + ") Will be " + players[i].getScore() * edit);
                        System.out.println("To confirm enter (y/n)");
                        final char ckEdit = sc.next().charAt(0);
                        if (ckEdit == 'n' || ckEdit == 'N') {
                            return;
                        }
                        if (ckEdit == 'y' || ckEdit == 'Y') {
                            players[i].setScore(players[i].getScore()*edit) ;
                            
                            System.out.println("(" + players[i].getName() + ") score is now: " + players[i].getScore() + "\n");
                            return;
                        }
                        continue;
                    }
                    case '/': {
                        System.out.println("How much to divide?");
                        final int edit = sc.nextInt();
                        System.out.println("(" + players[i].getName() + ") Will be " + players[i].getScore() / edit);
                        System.out.println("To confirm enter (y/n)");
                        final char ckEdit = sc.next().charAt(0);
                        if (ckEdit == 'n' || ckEdit == 'N') {
                            return;
                        }
                        if (ckEdit == 'y' || ckEdit == 'Y') {
                            players[i].setScore(players[i].getScore()/edit) ;
                            
                            System.out.println("(" + players[i].getName() + ") score is now: " + players[i].getScore() + "\n");
                            return;
                        }
                        continue;
                    }
                    default: {
                        System.out.println("Please make sure to choose from (+, -, * or /)");
                    }
                }
            }
        }
    
    

}