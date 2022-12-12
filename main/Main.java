package main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        chosedGameFromN();
    }

    /*
     * The game data has to be stored before, all values are added
     * depending on number of players, so ask first ask how many players are coming
     * to game if the number is fisxed assign it to it's value and asign scores
     * after taking names from players
     */

    static public void chosedGameFromN() {
        ArrayList<String> games = new ArrayList<String>(); // this file is temporary,
                                                           // will be replaced by database
                                                           // TODO: database (json)

        System.out.println("Choose the game you want to play");
        games.add("BankElhaz");
        games.add("Monopoly");

        for (int i = 0; i < games.size(); i++) {
            System.out.println((i + 1) + "-" + games.get(i));
        }
        System.out.println((games.size() + 1) + "-Add new game"); // giving choice to add new game by selecting over the
                                                                  // lenght of the array

        int choosen_game = sc.nextInt();

        if (choosen_game == games.size() + 1) { // if the user chooses to add new game
            // TODO: call askedForCustomGame() method
        } // if the user chooses invalid value it will be handled by the next if statement

        if (choosen_game > games.size() || choosen_game < 1) { // if the user chooses invalid value
            System.out.println("Invalid choice");
            chosedGameFromN();
        } else {
            System.out.println("You have choosen " + games.get(choosen_game - 1));
        }

    }
}