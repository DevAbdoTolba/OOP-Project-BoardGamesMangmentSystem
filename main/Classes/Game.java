package main.Classes;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import Data.fileStream;
import Sessions.SessionsStream;
import main.Classes.Game;
import main.util.Output;

public class Game extends Player {

    // // TODO: fix print all players

    // TODO: If only player remaning PRINT WINNER and exit

    // // TODO: add option to out/in a player

    // TODO: adding history for every player and every player can show his history,
    // histoyry is lost after every session

    // method to sort all games depnding on rate and print all of them after
    // clearing the screen

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
    public int sessionKey;

    public String[] gameInfo;

    int numberOfPlayersGaming = 0;

    // objects
    public fileStream fs = new fileStream(); // instance fileStream class
    public Scanner sc = new Scanner(System.in); // instance Scanner class
    public Player[] players; // instance Player class
    public Output o = new Output(); // instance Output class
    public SessionsStream ss = new SessionsStream();

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
        playersSetup();

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
        playersSetup();

    }

    // Methods

    public void rate(int index) {

        while (true) {
            System.out.println("Rate the game (1-5)");
            String[] gameInfo = fs.indexLine(this.mainPath, index);
            float rating = sc.nextFloat();
            if (rating > 5 || rating < 0) {
                o.cls();
                System.out.println("Invalid rating");
                continue;
            }
            float mean = ((Float.valueOf(gameInfo[3]) + rating)) / 2;
            gameInfo[3] = String.valueOf(mean);
            newData = fs.convString(gameInfo);
            fs.deleteRow(mainPath, tempPath, newData, 0, gameInfo[0]);
            for (int i = 0; i < gameInfo.length; i++) {
                if (i == 0)
                newData += gameInfo[i];
                else
                newData += "," + gameInfo[i];
            }

            System.out.println("Game rated successfully");
            // print game rate
            System.out.println(gameInfo[0] + " rate: " + gameInfo[3] + "\n\n");
            System.exit(0);
        }
    }

    public void start(boolean sessionWriteOrNot) {

        String toSession = "";

        for (int i = 0; (i < numOfPlayers) && sessionWriteOrNot; i++) {
            toSession = players[i].getName() + "," + players[i].getScore() + "," + players[i].getIsIn() + "\n";
            ss.addToFile(toSession, sessionKey);
        }

        o.cls();
        System.out.println("\nSHALL " + fs.indexLine(this.mainPath, gameChoice)[0] + " START NOW!\n");


        while (!(numberOfPlayersGaming == 1)) {
            // numberOfPlayersGaming = 0;
            // for(int i = 0; i < numOfPlayers; i++){
            // if(players[i].getIsIn()){
            // numberOfPlayersGaming++;
            // }
            // }

            System.out.println(numberOfPlayersGaming);
            // Sorting players by socre which is gameInfo[1]
            System.out.println("Enter -980 to Exit game");

            for (int i = 0; i < numOfPlayers; i++) {
                for (int j = i + 1; j < numOfPlayers; j++) {
                    if (!players[i].getIsIn()) {
                        Player temp = players[i];
                        players[i] = players[numOfPlayers - 1];
                        players[numOfPlayers - 1] = temp;
                    } else if ((players[i].getScore() < players[j].getScore())) {

                        Player temp = players[i];
                        players[i] = players[j];
                        players[j] = temp;

                    }
                }
            }

            printPlayers(players, numOfPlayers);
            System.out.println("Which player do you want to edit?\n type in range (1:" + numOfPlayers
                    + ")\nType -1 for more options");
            int index = sc.nextInt();
            if (index == -980) {
                o.cls();
                System.out.println("Session secret key:  ==> " + sessionKey
                        + " <==\nYou won't be able to countinue the game without it!!");
                rate(gameChoice);
            }
            if (index > 0 && index <= numOfPlayers) {
                editPlayers(players, index - 1);
                ss.editPlayerScore(players[index - 1].getName(), players[index - 1].getScore(), IsIn, sessionKey);
            } else if (index == -1) {
                moreOptionsForPlayers();
            } else {
                System.out.println("Invalid input");
            }
            o.cls();
            numberOfPlayersGaming = 0;
            for (int i = 0; i < numOfPlayers; i++) {
                if (players[i].getIsIn()) {
                    numberOfPlayersGaming++;
                }
            }
        }
        o.cls();
        System.out.println("Game finished");
        // Print the winner name with score
        for (int i = 0; i < numOfPlayers; i++) {
            if (players[i].getIsIn()) {
                System.out.println("The winner is ==> " + players[i].getName() + " <== with score " + players[i].getScore());
                break;
            }
        }
        ss.deleteFiles(sessionKey);
        rate(gameChoice);
    }

    public void optionsMenu() {
        o.cls();
        System.out.println("Options: ");
        System.out.println("1- Add a new game");
        System.out.println("2- Print all games");
        System.out.println("3- Delete a game");
        System.out.println("4- Back to main menu");
        System.out.println("5- Continue a session ");
        System.out.println("6- Exit program");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                o.cls();
                addGame();
                mainMenu();
                break;
            case 2:
                o.cls();
                printAllGames();
                mainMenu();
                break;
            case 3:
                o.cls();
                deleteGame();
                mainMenu();
                break;
            case 4:
                o.cls();
                mainMenu();
                break;
            case 5:
                int numberOfSessions ;
                numberOfSessions = ss.numberOfSessions();
                if(numberOfSessions == 0){
                    o.cls();
                    System.out.println("No sessions to continue");
                    mainMenu();
                    break;
                }
                o.cls();
                continueSession();
                start(false);
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        o.cls();
    }
    // make a main method and call all methods in this class from there

    public void newSession() {
        String toBeWritten = "";
        for (int i = 0; i < numOfPlayers; i++) {
            toBeWritten = (players[i].getName() + "," + players[i].getScore() + "," + players[i].getIsIn() + "\n");
            ss.addToFile(toBeWritten, sessionKey);
        }

    }

    public void continueSession() {
        gameChoice = 0;
        System.out.print("Type -2 to go Back\nInsert secret session key : ");
        sessionKey = sc.nextInt();
        if (sessionKey == -2) {
            mainMenu();
        }
        String mainPath = "Sessions\\" + String.valueOf(sessionKey) + ".txt";
        File file = new File(mainPath);
        if (!file.exists()) {
            o.cls();
            System.out.println("invalid key no open session with this key");
            continueSession();
        }
        numOfPlayers = fs.numberOfRows(mainPath) - 1;
        players = new Player[numOfPlayers];
        // System.out.println(fs.indexLine(this.mainPath, 12));
        for(int i = 0; i < numOfGames+1; i++){

            if(fs.indexLine(mainPath, 0)[0].equals(fs.indexLine(this.mainPath, i)[0])){
                gameChoice = i;
                break;
            }
        }
        gameInfo = getGameInfo();
        gameInfo = fs.indexLine(mainPath, gameChoice); // get the game info from the file

        for (int i = 0; i < numOfPlayers; i++) {
            players[i] = new Player();

            String[] line = fs.indexLine(mainPath, i + 2);

            players[i].setName(line[0]);
            players[i].setScore(Integer.valueOf(line[1]));
            players[i].setIsIn(Boolean.valueOf(line[2]));
        }
        for (int i = 0; i < numOfPlayers; i++) {
            if (players[i].getIsIn()) {
                numberOfPlayersGaming++;
            }
        }

        
    }

    public void moreOptionsForPlayers() {
        System.out.println("1- Add new player");
        System.out.println("2- Delete player");
        System.out.println("3- Edit player");
        System.out.println("4- In/Out player");
        System.out.println("5- Back to game");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addPlayer();
                break;
            case 2:
                deletePlayer();
                break;
            case 3:
                editPlayer();
                break;
            case 4:
                inOutPlayer();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public void inOutPlayer() {
        o.cls();
        int ck = 1;
        String name = "";

        System.out.println("Enter player name");
        System.out.println("type -2 to go Back");

        while (!name.equals("-2")) {
            o.cls();
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.println("- " + players[i].toString());
            }
            System.out.println("Enter player name");
            if (ck == 0) {
                System.out.println("Player not found");
            }
            // print all players
            System.out.println("type -2 to go Back");
            name = sc.next();
            if (!name.equals("-2")) {
                for (int i = 0; i < numOfPlayers; i++) {
                    if (players[i].getName().equals(name)) {
                        if (players[i].getIsIn()) {
                            players[i].setIsIn(false);
                            ss.editPlayerScore(name, players[i].getScore(), false, sessionKey); // ! SESSION ISIN
                                                                                                // UPDATEING
                            System.out.println("Player " + name + " is out");

                        } else {
                            players[i].setIsIn(true);
                            ss.editPlayerScore(name, players[i].getScore(), true, sessionKey); // ! SESSION ISIN
                                                                                               // UPDATEING

                            System.out.println("Player " + name + " is in");
                        }
                        ck = 1;
                        return;
                    } // nothing found

                }
                ck = 1;
            }

        }
    }

    public void addPlayer() {
        String toSession = "";
        int score = 0;
        String name;
        o.cls();
        System.out.println("Enter player name");
        System.out.println("type -2 to go Back");
        name = sc.next();
        if (!name.equals("-2")) {
            System.out.println("Enter player score");
            score = sc.nextInt();
            System.out.println("type -2 to go Back");
            if (!(score == -2)) {
                Player[] temp = new Player[numOfPlayers + 1];
                for (int i = 0; i < numOfPlayers; i++) {
                    temp[i] = players[i];
                }
                temp[numOfPlayers] = new Player(name, score);
                players = temp;
                numOfPlayers++;
                o.cls();
            }
        }
        toSession = name + "," + score + "," + true; // ! UPDATE SESSION
        ss.addToFile(toSession, sessionKey);
    }

    public void deletePlayer() {
        o.cls();
        String toSession = "";
        // print all players names
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println(players[i].getName());
        }
        System.out.println("Enter player name");
        System.out.println("type -2 to go Back");
        String name = sc.next();
        if (!name.equals("-2")) {
            for (int i = 0; i < numOfPlayers; i++) {
                if (players[i].getName().equals(name)) {
                    Player[] temp = new Player[numOfPlayers - 1];
                    for (int j = 0; j < i; j++) {
                        temp[j] = players[j];
                    }
                    for (int j = i; j < numOfPlayers - 1; j++) {
                        temp[j] = players[j + 1];
                    }
                    players = temp;
                    numOfPlayers--;
                    ss.deleteFromFile(name, sessionKey);
                    o.cls();
                }

            }
            System.out.println("Player not found");
        }
    }

    public void editPlayer() {
        o.cls();

        System.out.println("Enter player name");

        int index = 0;
        printPlayers(players, numOfPlayers);
        System.out.println("type -2 to go Back");

        String name = sc.next();
        if (!name.equals("-2")) {
            for (int i = 0; players[i].getName().equals(name); i++) {
                index = i;
            }
            System.out.println("\n1- Edit player name");
            System.out.println("2- Edit player score");
            System.out.println("3- Back");
            int choice = sc.nextInt();
            int score = 0;
            switch (choice) {
                case 1:
                    System.out.println("Enter new name");
                    String newName = sc.next();
                    players[index].setName(newName);
                    ss.editPlayerName(name, players[index].getName(), players[index].getScore(), IsIn, sessionKey);
                    break;
                case 2:
                    System.out.println("Enter new score");
                    score = sc.nextInt();
                    players[index].setScore(score);
                    ss.editPlayerScore(players[index].getName(), players[index].getScore(), IsIn, sessionKey);

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            o.cls();
        }
    }

    public void mainMenu() {

        gameInfo = getGameInfo();
        System.out.println("Choose game number :- \n"); // print menu list
        for (int i = 1; i <= numOfGames; i++) {
            System.out.println(i + "-" + fs.indexLine(mainPath, i)[0]);
            if ((i + 1) > numOfGames) {
                System.out.println();
                System.out.println((i + 1) + "-" + "Options ");
            }
        }

        gameChoice = sc.nextInt(); // input the user gameChoice of the list of games
        // check if gameChoice out or range
        if (gameChoice > numOfGames + 1 || gameChoice < 0) {
            System.out.println("Invalid input\n");
            mainMenu();
        }
        gameInfo = fs.indexLine(mainPath, gameChoice); // get the game info from the file
        if (gameChoice == numOfGames + 1) // a condition to let user create a new game
        {
            optionsMenu();
        } else if (gameChoice <= numOfGames && gameChoice > 0) {
            System.out.println("You have selected " + fs.indexLine(mainPath, gameChoice)[0]); // print the selected game
            sessionKey = ss.CreateFile(fs.indexLine(mainPath, gameChoice)[0]); // ! CREATING NEW SESSION
        } else {
            System.out.println("Invalid input\n");
        }
    }

    public void playersNames() {

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
            // must be more than 1 player
            while (numOfPlayers < 1) {
                System.out.println("Invalid input");
                System.out.print("Enter the number of players : ");
                numOfPlayers = sc.nextInt();
            }
            players = new Player[numOfPlayers];
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.print("Enter the name of player " + (i + 1) + " : ");
                players[i] = new Player();
                players[i].setName(sc.next());

            }
        }
    }

    public void playersScores() {
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

    public void playersSetup() {
        playersNames();
        playersScores();

    }

    public String[] getGameInfo() {
        return fs.indexLine(mainPath, gameChoice);
    }

    public void setGameInfo(String[] gameInfo) {
        this.gameInfo = gameInfo;
    }

    public void addGame() {
        scoreOfPlayers = 0;
        numOfPlayers = 0;
        System.out.println("Enter New Game Name (only English liters, no spacing or symbols of any type): ");
        gameName = sc.next(); // Input The Name of The New Game

        System.out.println("Is the number of players fixed always? (1 for yes, 0 for no)");
        fixed = sc.nextInt();
        if (fixed == 1) {
            System.out.print("Number of players : ");
            // must be more than 1 player

            numOfPlayers = sc.nextInt();
            while (numOfPlayers < 1) {
                System.out.println("Invalid input");
                System.out.print("Enter the number of players : ");
                numOfPlayers = sc.nextInt();
            }

        } else if (fixed == 0) {
        } else {
            System.out.println("Invalid input\n");
        }

        System.out.println("Are all players also start with the same score? (1 for yes, 0 for no)");
        fixedScore = sc.nextInt();
        if (fixedScore == 1) {
            System.out.print("Score : ");
            scoreOfPlayers = sc.nextInt();
        } else if (fixedScore == 0) {
        } else {
            System.out.println("Invalid input\n");
        }

        newData = gameName + "," + ((scoreOfPlayers != 0) ? scoreOfPlayers : "NaN") + ","
                + ((numOfPlayers != 0) ? numOfPlayers : "NaN") + "," + "0"; // create a new line of data
        fs.writeToFile(mainPath, tempPath, newData, 0); // write the new data to the file
        o.cls();
        numOfGames = fs.numberOfRows(mainPath); // update the number of games
    }

    public void printAllGames() {
        o.cls();
        // Print the header of the table
        // array of string which has the name of the games
        String[][] games = new String[numOfGames][4];
        // instianciate the array of string with the name of the games

        for (int i = 0; i < numOfGames; i++) {
            games[i] = fs.indexLine(mainPath, i + 1);
        }
        // Sort by rating
        Arrays.sort(games, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return Float.valueOf(b[3]).compareTo(Float.valueOf(a[3]));
            }
        });

        // print the table
        System.out.println();
        System.out.printf("%-32s%-32s%-32s%-32s", "Game Name", "Starter Score", "Number of Players", "Rating");
        for (int i = 0; i < numOfGames; i++) {
            System.out.println();
            System.out.printf("%-32s%-32s%-32s%-32s", games[i][0], games[i][1], games[i][2], games[i][3]);
        }
        System.out.println();

    }

    public void deleteGame() {
        newData = "";
        printAllGames();
        System.out.print("\nEnter the name of the game you want to delete : ");
        String gameName = sc.next();
        fs.deleteRow(mainPath, tempPath, newData, 0, gameName);
        o.cls();
        int checkDelete = numOfGames;
        numOfGames = fs.numberOfRows(mainPath);
        if (checkDelete != numOfGames) {
            System.out.println("\nGame Deleted Successfully\n\n");
        } else {
            System.out.println("\nGame Not Found\n\n");
        }
    }

}
