
package main;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    


    public static void main(String[] args) {
        
        
        Scanner input = new Scanner(System.in);
        int NumGame; // instance NumGame Variable
        ArrayList<String> Games = new ArrayList<>(); // instance ArrayList for storing Game Names
        Games.add("BankElhaz"); // add ArrayList element
        Games.add("Monopoly"); // add ArrayList element
        System.out.println("Choose game number"); // print menu list

        for (int i = 0; i < Games.size(); i++) // loop to print game choices
        {
            System.out.println(i + 1 + "-" + Games.get(i)); // print the game number and game name
            if (i == Games.size() - 1) // condition to select last Choice
            {
                System.out.println(i + 2 + "-" + "Add New Game ");
            }
        }

        NumGame = input.nextInt(); // input the user choice to play
         if(NumGame > Games.size()) // a condition to let user create a new game
         {        
        String GameName;
        GameName = input.next(); // Input The Name of The New Game
        System.out.println("Enter New Game Name: ");
        Games.add(GameName); // Add the new game to the ArrayList 
             
        
         }
       
    
         }}
