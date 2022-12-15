package main;

import java.io.IOException;
import java.util.Scanner;
import Data.fileStream;
import main.Classes.Game;
import main.Classes.Player;

public class Main {
    /*
     * Global Variables
     */

    // static int number_of_players; 
    // static int value;
    // static Scanner sc = new Scanner(System.in);
    // static fileStream fs = new fileStream();
    // static Main pl1 = new Main();
    
    static int choice;
    
    static String mainPath = "Data\\games.txt";
    static String tempPath = "Data\\gamesTemp.txt";
    static String newData = "";

    /*
     * Main Method
     * 
     ! MAIN METHOD
     */
    public static void main(String args[]) {

        // TODO: adding sessions, every session has a file with seesion key which is int, starts with 1, then goes up depending on number of sessions consumed
        // TODO: sessions are gameName at the very first row, playerName, playerScore,playerStates (in or out)

        // TODO: add extra option after custom game for other methods like delete and print all games sorted depnding on rate
        // TODO: is numaric in testingForZiad score checks if the score is numaric or not IS NOT WORKING
        cls();

        Game game = new Game(mainPath,tempPath,choice); // constructor of Game class which also starts the manMenu method
        // game.mainMenu(); is already called in the constructor
        // game.playerSetting(); is already called in the constructor

        String[] gameInfo = game.getGameInfo();
//      GameName    score   players rate
//        0           1       2       3

      

        
        // ! STARTING THE GAME
        game.start(true);

    }

    /*
     * Mathods
     * 
     */

    
    static void cls(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    


}