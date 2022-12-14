package main;

import java.util.ArrayList;
import java.util.Scanner;
import Data.fileStream;

public class Main {
    int value;
    int number_of_players;
    String name_of_players;
    int score = 0;
    String in;

    static Scanner sc = new Scanner(System.in);

    static Main pl1 = new Main();

    public static void main(String args[]) {

        pl1.mainMenu();

        // ArrayList<String> player = new ArrayList<String>();
        // ArrayList<String> games = new ArrayList<String>();
        // ArrayList<String> Items = new ArrayList<String>();
        // pl1.addPlayers();
        // pl1.score();
        // pl1.fixedValue();
    }

    public void mainMenu() {

        int NumGame; // instance NumGame Variable

        ArrayList<String> Games = new ArrayList<>(); // instance ArrayList for storing Game Names
        Games.add("BankElhaz"); // add ArrayList element
        Games.add("Monopoly"); // add ArrayList element

        for(int i = 0; i < Games.size(); i++) {
            System.out.println(Games.get(i));
        }
        
        
        System.out.println("Choose game number"); // print menu list

        for (int i = 0; i < Games.size(); i++) // loop to print game choices
        {
            System.out.println(i + 1 + "-" + Games.get(i)); // print the game number and game name
            if (i == Games.size() - 1) // condition to select last Choice
            {
                System.out.println(i + 2 + "-" + "Add New Game ");
            }
        }

        NumGame = sc.nextInt(); // input the user choice to play

        if (NumGame > Games.size()) // a condition to let user create a new game
        {
            String GameName;
            GameName = sc.next(); // Input The Name of The New Game
            System.out.println("Enter New Game Name: ");
            Games.add(GameName); // Add the new game to the ArrayList

        } else {
            System.out.println("You have selected " + Games.get(NumGame - 1)); // print the selected game
            addPlayers();
            System.out.println("are the values fixed? (1 for yes, 0 for no)");
            if (sc.nextInt() == 1) {
                fixedValue();
            } else if (sc.nextInt() == 0) {
                notFixedValue();
            } else {
                System.out.println("Invalid input");
            }
        }

    }

    public void addPlayers() {
        System.out.println("Enter the number of players");
        number_of_players = sc.nextInt();
        for (int i = 0; i < number_of_players; i++) {
            System.out.println("Enter the name of player " + (i + 1));
            name_of_players = sc.next();
        }

    }

    public void notFixedValue() {
        System.out.println("are the values fixed? (1 for yes, 0 for no)");
        if (sc.nextInt() == 1) {
            System.out.println("Enter the value");
            in = sc.nextLine();
        } else if (sc.nextInt() == 0) {
            for (int i = 0; i < number_of_players; i++) {
                System.out.println("Enter the value of player " + (i + 1));
                in = sc.nextLine();
            }
        } else {
            System.out.println("Invalid input");
        }
    }

    public void fixedValue() {
        System.out.println("Enter the value: ");
        value = sc.nextInt();
        for (int i = 0; i < number_of_players; i++) {
            System.out.println("The value of player " + (i + 1)+ " : " + value);
        }
  }
}