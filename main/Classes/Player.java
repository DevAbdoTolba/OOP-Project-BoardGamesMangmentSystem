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
        }
        // parametrized Constructor 
        public Player(String name, int score, boolean IsIn) {
            this.name = name;
            this.score = score;
            this.IsIn = IsIn;
        }


    

    // Getters

    protected String getName() {
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
            for (int i = 0; i < numOfPlayers; ++i) {
                System.out.println(i + 1 + "-" + players[i].getName() + ": " + players[i].getScore());
            }
        }


        

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
    
        


    

        // // ToString Method To print the information about the player 
        
        // @Override
        // public String toString() {
        //     return "Player{" + "name=" + name + ", score=" + score + ", IsIn=" + IsIn + ", Items=" + Items + ", History=" + History + '}';
        // }
    

}

