package main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    int value;
    int  number_of_players;
    String name_of_players;
    int score = 0;
    String in;
    static Scanner pl = new Scanner(System.in);
    static Main pl1=new Main();

    public static void main(String args[]) {

        ArrayList<String> player = new ArrayList<String>();
        ArrayList<String> games = new ArrayList<String>();
        ArrayList<String> Items = new ArrayList<String>();
        pl1.addPlayers();
          pl1.score();
          pl1.fixedValue();
    }

    public void addPlayers() {
        System.out.println("Enter the number of players");
        number_of_players = pl.nextInt();
        for (int i = 0; i < number_of_players; i++) {
            System.out.println("Enter the name of player " + (i + 1));
            name_of_players  = pl.next();
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
        if(pl.nextInt() == 1){
        System.out.println("Enter the value");    
        in = pl.nextLine();}
        else{   
        for(int i = 0; i < number_of_players; i++){
            System.out.println("Enter the value of player " + (i+1));
            in = pl.nextLine();
        }
    }
        
    }}