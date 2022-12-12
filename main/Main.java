package main;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Scanner input = new Scanner(System.in);

    public void main(String args[]) {

        System.out.println("HelloWOrld");
    }

    public void choosingGameMenu() {

        int NumGame; // instance NumGame Variable
        Vector<String> Games = new Vector<>(); // instance vector for storing Game Names
        Games.add("BankElhaz"); // add vector element
        Games.add("Monopoly"); // add vector element
        System.out.println("Chose game number"); // print menu list

        for (int i = 0; i < Games.size(); i++) // loop to print game choices
        {
            System.out.println(i + 1 + "-" + Games.get(i)); // print the game number and game name
            if (i == Games.size() - 1) // condition to select last Choice
            {
                System.out.println(i + 2 + "-" + "Add New Game ");
            }
        }

        NumGame = input.nextInt(); // input the user choice to play
        // if(NumGame > Games.size()) // a condition to let user create a new game
        // {
        // AddNewGame(); // Add New Game Method //todo: this function must have a Games.add to add the new game which created by the user stored in the vector
        // }
        // else
        // setGame(Games.get(NumGame-1)); // to enter the game ;

    }
}