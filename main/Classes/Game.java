package main.Classes;

import java.io.IOException;
import java.util.Scanner;
import Data.fileStream;
import main.Classes.Game;
import main.util.Output;

public class Game extends Player {

    // method to sort all games depnding on rate and print all of them after clearing the screen

    

    public void optionsMenu() {
        Output o = new Output();
        o.cls();
        System.out.println("Options: ");
        System.out.println("1- Add a new game");
        System.out.println("2- Print all games");
        System.out.println("3- Delete a game");
        System.out.println("4- Back to main menu");
        System.out.println("5- Exit");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                o.cls();
                addGame();
                break;
            case 2:
                o.cls();
                printAllGames();
                break;
            case 3:
                o.cls();
                deleteGame();
                break;
            case 4:
                o.cls();
                mainMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        o.cls();
    }
    // make a main method and call all methods in this class from there

    // Variables
    public String newData;
    public String mainPath;
    public String tempPath;
    public int gameChoice;
    public int choice;
    public int scoreOfPlayers;
    public int fixed;
    public int numOfGames;
    public int fixedScore;
    public String[] gameInfo;

    // objects
    public fileStream fs = new fileStream(); // instance fileStream class
    public Scanner sc = new Scanner(System.in); // instance Scanner class
    public Player[] players; // instance Player class
    public Output o = new Output(); // instance Output class

    // session variables
    public String gameName;
    public int numOfPlayers;

    // counstrctors
    // public Game() {
    // newData = "";
    // mainPath = "Data\\Games.csv";
    // tempPath = "Data\\temp.csv";
    // gameChoice = 0;
    // gameName = "";
    // numOfPlayers = 0;

    // }

    public Game() {
        this.mainPath = "Data\\Games.txt";
        this.tempPath = "Data\\temp.txt";
        this.gameChoice = 0;
        this.newData = "";
        this.gameInfo = getGameInfo();
        this.gameName = gameInfo[0];
        this.numOfGames = fs.numberOfRows(mainPath);
        this.scoreOfPlayers = 0;
        o.cls();
        mainMenu();
        playerSetting();

    }

    public Game(String mainPath, String tempPath, int gameChoice) {
        this.mainPath = mainPath;
        this.tempPath = tempPath;
        this.gameChoice = gameChoice;
        this.newData = "";
        this.gameInfo = getGameInfo();
        this.gameName = gameInfo[0];
        this.numOfGames = fs.numberOfRows(mainPath);
        this.scoreOfPlayers = 0;
        o.cls();
        mainMenu();
        playerSetting();

    }

    // Methods

    public void rate(int index) {
        o.cls();
        System.out.println("Rate the game (1-5)");
        String[] gameInfo = fs.indexLine(mainPath, index);
        gameInfo[3] = Float.toString((Float.parseFloat(gameInfo[3]) + sc.nextFloat() / 2.0f));
        newData = fs.convString(gameInfo);
        fs.deleteRow(mainPath, tempPath, newData, index, gameInfo[0]);
        for (int i = 0; i < gameInfo.length; i++) {
            if (i == 0)
                newData += gameInfo[i];
            else
                newData += "," + gameInfo[i];
        }
        fs.writeToFile(mainPath, tempPath, newData, index);

        System.out.println("Game rated successfully");
        // print game rate
        System.out.println("Game rate: " + gameInfo[3] + "\n\n");
        System.exit(0);
    }

    public void playerSetting() {
        if (!gameInfo[2].equals("NaN")) {
            System.out.println("Number of players : " + gameInfo[2]);
            numOfPlayers = Integer.valueOf(gameInfo[2]);
            players = new Player[numOfPlayers];
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.print("Enter the name of player " + (i + 1) + " : ");
                players[i] = new Player();
                players[i].setName(sc.next());
            }
        } else {
            System.out.print("Enter the number of players : ");
            numOfPlayers = sc.nextInt();
            players = new Player[numOfPlayers];
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.print("Enter the name of player " + (i + 1) + " : ");
                players[i] = new Player();
                players[i].setName(sc.next());

            }
        }
    }

    public void start() {
        o.cls();
        System.out.println("\nSHALL "+ fs.indexLine(mainPath, gameChoice)[0] +" START NOW!\n\n");
        while (true) {
            // Sorting players by socre which is gameInfo[1]
            System.out.println("Enter -980 to Exit game");

            for (int i = 0; i < numOfPlayers; i++) {
                for (int j = i + 1; j < numOfPlayers; j++) {
                    if (players[i].getScore() < players[j].getScore()) {
                        Player temp = players[i];
                        players[i] = players[j];
                        players[j] = temp;
                    }
                }
            }
            
            printPlayers(players, numOfPlayers);
            System.out.println("Which player do you want to edit?\n type in range (1:" + numOfPlayers + ")");
            int index = sc.nextInt();
            if (index == -980) {
                rate(gameChoice);
            }
            if (index > 0 && index <= numOfPlayers) {
                editPlayers(players, index - 1);
            } else {
                System.out.println("Invalid input");
            }
            o.cls();
        }
    }

    public void mainMenu() {
        System.out.println("Choose game number :- "); // print menu list
        for (int i = 1; i <= numOfGames; i++) {
            System.out.println(i + "-" + fs.indexLine(mainPath, i)[0]);
            if ((i + 1) > numOfGames) {
                System.out.println((i + 1) + "-" + "Options ");
            }
        }

        gameChoice = sc.nextInt(); // input the user gameChoice of the list of games
        gameInfo = fs.indexLine(mainPath, gameChoice); // get the game info from the file
        if (gameChoice == numOfGames + 1) // a condition to let user create a new game
        {
            optionsMenu();   
        } else if (gameChoice <= numOfGames && gameChoice > 0) {
            System.out.println("You have selected " + fs.indexLine(mainPath, gameChoice)[0]); // print the selected game

        } else {
            System.out.println("Invalid input\n\n");
        }
    }

    public void playersSetup() {
        if (!gameInfo[2].equals("NaN")) {
            System.out.println("Number of players : " + gameInfo[2]);
            numOfPlayers = Integer.valueOf(gameInfo[2]);
            players = new Player[numOfPlayers];
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.print("Enter the name of player " + (i + 1) + " : ");
                players[i] = new Player();
                players[i].setName(sc.next());
            }
        } else {
            System.out.print("Enter the number of players : ");
            numOfPlayers = sc.nextInt();
            players = new Player[numOfPlayers];
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.print("Enter the name of player " + (i + 1) + " : ");
                players[i] = new Player();
                players[i].setName(sc.next());

            }
        }

        System.out.println();
        if (!gameInfo[1].equals("NaN")) {
            System.out.println("Players starter score : " + gameInfo[1]);
            scoreOfPlayers = Integer.valueOf(gameInfo[1]);
            for (int i = 0; i < numOfPlayers; i++) {
                players[i].setScore(scoreOfPlayers);

            }

        } else {
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.print("Enter the value of player " + (i + 1) + " : ");
                players[i].setScore(sc.nextInt());

            }

        }
    }

    public String[] getGameInfo() {
        return fs.indexLine(mainPath, gameChoice);
    }

    public void setGameInfo(String[] gameInfo) {
        this.gameInfo = gameInfo;
    }

    public void addGame(){
        scoreOfPlayers = 0;
            numOfPlayers = 0;
            System.out.println("Enter New Game Name (only English liters, no spacing or symbols of any type): ");
            gameName = sc.next(); // Input The Name of The New Game

            System.out.println("Is the number of players fixed always? (1 for yes, 0 for no)");
            fixed = sc.nextInt();
            if (fixed == 1) {
                System.out.print("Number of players : ");
                numOfPlayers = sc.nextInt();

            } else if (fixed == 0) {
            } else {
                System.out.println("Invalid input\n\n");
            }

            System.out.println("Are all players also start with the same score? (1 for yes, 0 for no)");
            fixedScore = sc.nextInt();
            if (fixedScore == 1) {
                System.out.print("Score : ");
                scoreOfPlayers = sc.nextInt();
            } else if (fixedScore == 0) {
            } else {
                System.out.println("Invalid input\n\n");
            }

            newData = gameName + "," + ((scoreOfPlayers != 0) ? scoreOfPlayers : "NaN") + ","
                    + ((numOfPlayers != 0) ? numOfPlayers : "NaN") + "," + "0"; // create a new line of data
            fs.writeToFile(mainPath, tempPath, newData, 0); // write the new data to the file
            o.cls();
            mainMenu(); // call the main menu again to show the new list of games

    }

    public void printAllGames(){
        // array of string which has the name of the games
        String[] games = new String[numOfGames];
        for (int i = 0; i < numOfGames; i++) {
            games[i] = fs.indexLine(mainPath, i + 1)[0];
        }
        // print all games sorted by rating
        for (int i = 0; i < numOfGames; i++) {
            for (int j = i + 1; j < numOfGames; j++) {
                if (Integer.valueOf(fs.indexLine(mainPath, i + 1)[3]) < Integer.valueOf(fs.indexLine(mainPath, j + 1)[3])) {
                    String temp = games[i];
                    games[i] = games[j];
                    games[j] = temp;
                }
            }
        }
    }

    public void deleteGame(){
        newData = "";
        System.out.println("Enter the name of the game you want to delete");
        printAllGames();
        fs.deleteRow(mainPath, tempPath, newData ,0,sc.next());
        o.cls();
        System.out.println("Game Deleted Successfully\n\n");
        mainMenu();
    }
    
}
