package main.Classes;


import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;

public class Player {
  
    // Variables 
    private String name; 
    private int score;
    boolean IsIn;

    // objets
    static Scanner sc = new Scanner(System.in);

    // the instance of Arraylists 
    ArrayList<String> Items = new ArrayList<String>(); // Create an ArrayList object
    ArrayList<String> History = new ArrayList<String>(); // Create an ArrayList object


    // Constructors 
    
        // Default Constructor
        public Player() {
            this.name = "Player";
            this.score = 0;
            this.IsIn = true;
        }
        // parametrized Constructor 
        public Player(String name, int score) {
            this.name = name;
            this.score = score;
            this.IsIn = true;
        }


    

    // Getters

    public String getName() {
        return name;
    }
    
    
    protected int getScore() {
        return score;
    }
    
    
    protected boolean getIsIn() {
        return IsIn;
    }
    
    
    protected ArrayList<String> getItems() {
        return Items;
    }
    
    
    protected ArrayList<String> getHistory() {
        return History;
    }


    // Setters 

    protected void setName(String name) {
        this.name = name;
    }

   

    protected void setScore(int score) {
        this.score = score;
    }

    

    protected void setIsIn(boolean IsIn) {
        this.IsIn = IsIn;
    }

   

    protected void setItems(ArrayList<String> Items) {
        this.Items = Items;
    }

    

    protected void setHistory(ArrayList<String> History) {
        this.History = History;
    }

    
    
    
    
    
    
    // Methods 
        public int Calculate_Score(int value , char sign) // a method to calculate the score
        {
        switch(sign) {
        case '+':
            score += value; 
            return score;
        case '-':
            score -= value;
            return score;
        
        case '*':
            score += value; 
            return score;

    
        case '/':    
         score += value; 
         return score;
         
        default:
            return score;
    
}
        }
    

        static void printPlayers(Player[] players,int numOfPlayers) {
            for (int i = 0; i < numOfPlayers; i++) {
                if(players[i].getIsIn()){
                    System.out.println( "-" + players[i].getName() + ": " + players[i].getScore());
                } 
            }
        }
        /* The code above does the following:
1. Declares an array of Player objects with the name players.
2. Declares an int variable with the name numOfPlayers.
3. Creates a for loop that iterates from 0 to numOfPlayers and prints the player number, name, and score for each player. */


        

        static void editPlayers( Player[] players,  int i) {
            System.out.println("to edit (" + players[i].getName() + ") Enter an operation (+, -, * or /)");
            while (true) {
                switch (sc.next().charAt(0)) {
                    case '+': {
                        System.out.println("How much to add?");
                        int edit = sc.nextInt();
                        System.out.println("(" + players[i].getName() + ") Will be " + (players[i].getScore() + edit));
                        System.out.println("To confirm enter (y/n)");
                         char ckEdit = sc.next().charAt(0);
                        if (ckEdit == 'n' || ckEdit == 'N') {
                            return;
                        }
                        if (ckEdit == 'y' || ckEdit == 'Y') {
                           
                            players[i].setScore(players[i].getScore()+edit) ;
                            
                            System.out.println("(" + players[i].getName() + ") score is now: " + players[i].getScore() + "\n");
                            return;
                        }
                        continue;
                    }
                    case '-': {
                        System.out.println("How much to sub?");
                        final int edit = sc.nextInt();
                        System.out.println("(" + players[i].getName() + ") Will be " + (players[i].getScore() - edit));
                        System.out.println("To confirm enter (y/n)");
                        final char ckEdit = sc.next().charAt(0);
                        if (ckEdit == 'n' || ckEdit == 'N') {
                            return;
                        }
                        if (ckEdit == 'y' || ckEdit == 'Y') {
                            
                            players[i].setScore(players[i].getScore()-edit) ;

                            System.out.println("(" + players[i].getName() + ") score is now: " + players[i].getScore() + "\n");
                            return;
                        }
                        continue;
                    }
                    case '*': {
                        System.out.println("How much to multiply?");
                        final int edit = sc.nextInt();
                        System.out.println("(" + players[i].getName() + ") Will be " + players[i].getScore() * edit);
                        System.out.println("To confirm enter (y/n)");
                        final char ckEdit = sc.next().charAt(0);
                        if (ckEdit == 'n' || ckEdit == 'N') {
                            return;
                        }
                        if (ckEdit == 'y' || ckEdit == 'Y') {
                            players[i].setScore(players[i].getScore()*edit) ;
                            
                            System.out.println("(" + players[i].getName() + ") score is now: " + players[i].getScore() + "\n");
                            return;
                        }
                        continue;
                    }
                    case '/': {
                        System.out.println("How much to divide?");
                        final int edit = sc.nextInt();
                        System.out.println("(" + players[i].getName() + ") Will be " + players[i].getScore() / edit);
                        System.out.println("To confirm enter (y/n)");
                        final char ckEdit = sc.next().charAt(0);
                        if (ckEdit == 'n' || ckEdit == 'N') {
                            return;
                        }
                        if (ckEdit == 'y' || ckEdit == 'Y') {
                            players[i].setScore(players[i].getScore()/edit) ;
                            
                            System.out.println("(" + players[i].getName() + ") score is now: " + players[i].getScore() + "\n");
                            return;
                        }
                        continue;
                    }
                    default: {
                        System.out.println("Please make sure to choose from (+, -, * or /)");
                    }
                }
            }
        }
        /* The code above does the following:
1. It lets the user enter the operation they want to do
2. It lets the user enter the value they want to do the operation on 
3. It checks if the user wants to confirm the operation and the value
4. It prints out the new score of the player */
    
        


    

        // // ToString Method To print the information about the player 
        
        @Override
        public String toString() {
            return  name + ", score=" + score +  ", IsIn=" + IsIn ; // TODO: Still missing history of every player and items ;-;
        }
    

}

