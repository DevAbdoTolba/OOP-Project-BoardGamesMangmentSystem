package main.Classes;


import java.util.ArrayList; // import the ArrayList class

public class Player {
  
    // Variables 
    private String name; 
    private int score;
    boolean IsIn;


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

    public String getName() {
        return name;
    }
    
    
    public int getScore() {
        return score;
    }
    
    
    public boolean getisIsIn() {
        return IsIn;
    }
    
    
    public ArrayList<String> getItems() {
        return Items;
    }
    
    
    public ArrayList<String> getHistory() {
        return History;
    }


    // Setters 

    public void setName(String name) {
        this.name = name;
    }

   

    public void setScore(int score) {
        this.score = score;
    }

    

    public void setIsIn(boolean IsIn) {
        this.IsIn = IsIn;
    }

   

    public void setItems(ArrayList<String> Items) {
        this.Items = Items;
    }

    

    public void setHistory(ArrayList<String> History) {
        this.History = History;
    }

    
    
    
    
    // the instance of Arraylists 
    ArrayList<String> Items = new ArrayList<String>(); // Create an ArrayList object
    ArrayList<String> History = new ArrayList<String>(); // Create an ArrayList object

    
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
    
    

        // // ToString Method To print the information about the player 
        
        // @Override
        // public String toString() {
        //     return "Player{" + "name=" + name + ", score=" + score + ", IsIn=" + IsIn + ", Items=" + Items + ", History=" + History + '}';
        // }
    

}

