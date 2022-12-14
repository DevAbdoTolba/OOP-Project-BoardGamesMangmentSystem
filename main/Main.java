package main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner pl = new Scanner(System.in);
    static Scanner inp = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        ArrayList<String> player = new ArrayList<String>();
        ArrayList<String> games = new ArrayList<String>();
        ArrayList<String> Items = new ArrayList<String>();
    }

    static public void addPlayers(int number_of_players) {
        System.out.println("Enter the number of players");
        number_of_players = pl.nextInt();
        for (int i = 0; i < number_of_players; i++) {
            System.out.println("Enter the name of player " + (i + 1));

        }

    }

    static public void score(int number_of_players) {
        int score = 0;
        for (int i = 0; i < number_of_players; i++) {
            System.out.println("Enter the score of player " + (i + 1));
            score = pl.nextInt();
        }

    }

    static public void fixedValue(int number_of_players) {
        String in;
        System.out.println("are the values fixed? (1 for yes, 0 for no)");
        if(pl.nextInt() == 1){
        System.out.println("Enter the value");    
        in = inp.nextLine();}
        else{   
        for(int i = 0; i < number_of_players; i++){
            System.out.println("Enter the value of player " + (i+1));
            in = inp.nextLine();
        }
    }
        
    }



    static public void checkIfThereIsItems() {
        System.out.println("Do you want to add items? (1 for yes, 0 for no)");
        int choice = sc.nextInt();
        
            if (choice == 1) {
                
                    System.out.println("Enter the number of items");
                    int number_of_items = sc.nextInt();

                        System.out.println("Enter the value of item " + (i + 1));
                        int value = sc.nextInt();
                        Items.add( value);
                    }
                }
             else {
                System.out.println("There is no items in the game");
            }
        }
        
    
        
    

   

// /*
// * The game data has to be stored before, all values are added
// * depending on number of players, so ask first ask how many players are
// coming
// * to game if the number is fisxed assign it to it's value and asign scores
// * after taking names from players
// */

// static public void chosedGameFromN() {
// ArrayList<String> games = new ArrayList<String>(); // this file is temporary,
// // will be replaced by database
// // TODO: database (json)

// System.out.println("Choose the game you want to play");
// games.add("BankElhaz");
// games.add("Monopoly");

// for (int i = 0; i < games.size(); i++) {
// System.out.println((i + 1) + "-" + games.get(i));
// }
// System.out.println((games.size() + 1) + "-Add new game"); // giving choice to
// add new game by selecting over the
// // lenght of the array

// int choosen_game = sc.nextInt();

// if (choosen_game == games.size() + 1) { // if the user chooses to add new
// game
// // TODO: call askedForCustomGame() method

// } // if the user chooses invalid value it will be handled by the next if
// statement

// if (choosen_game > games.size() || choosen_game < 1) { // if the user chooses
// invalid value
// System.out.println("Invalid choice");
// chosedGameFromN();
// } else {
// System.out.println("You have choosen " + games.get(choosen_game - 1));
// }

// }
// temporary file
