package main;

import Data.fileStream;

public class Main{
    public static void main(String args[]){
        fileStream fs = new fileStream();
        // ! TO ADD NEW DATA TO THE FILE, String newData = "gameName,score,playersNum,....";
        String mainPath = "Data\\games.txt";
        String tempPath = "Data\\gamesTemp.txt";
        int printOrNot = 1; 
        String newData = "";
        // fs.writeToFile("Data\\games.txt","Data\\gamesTemp.txt","",1);
        fs.deleteRow(mainPath, tempPath, newData, 0,"ticTac");
    }
}