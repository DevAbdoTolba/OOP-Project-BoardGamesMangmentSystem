package main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner pl = new Scanner(System.in);
   

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
        in = pl.nextLine();}
        else{   
        for(int i = 0; i < number_of_players; i++){
            System.out.println("Enter the value of player " + (i+1));
            in = pl.nextLine();
        }
    }
        
    }



    static public void checkIfThereIsItems() {
        System.out.println("Do you want to add items? (1 for yes, 0 for no)");
        int choice = sc.nextInt();
        
            if (choice == 1) {
                
                    System.out.println("Enter the number of items");
                    int number_of_items = pl.nextInt();

                        System.out.println("Enter the value of item " + (i + 1));
                        int value = pl.nextInt();
                        Items.add( value);
                    }
                }
             else {
                System.out.println("There is no items in the game");
            }
        }
        
