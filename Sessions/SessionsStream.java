package Sessions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Data.fileStream;
import main.Classes.Game;

public class SessionsStream {

    // Game game = new Game();
    int i;
    fileStream fs = new fileStream();

    public SessionsStream() {
    }

    public int CreateFile(String gameName) {

        File file = null;
        for (i = 0; (new File("Sessions\\" + String.valueOf(i) + ".txt")).exists(); i++)
            ;
        file = new File("Sessions\\" + String.valueOf(i) + ".txt");
        try {
            file.createNewFile();
            file = new File("Sessions\\" + String.valueOf(i) + "Temp.txt");
            file.createNewFile();

        } catch (IOException e) {
            System.out.println("HERE");

        }
        WriteFile(i, gameName);
        return i;
    }
    
    public void WriteFile(int key, String gameName) {
        String mainPath = "Sessions\\" + String.valueOf(key) + ".txt";
        String tempPath = "Sessions\\" + String.valueOf(key) + "Temp.txt";
        String toBeWritten = null;
        toBeWritten = gameName + "\n" + "playerName,score,state";
        
        BufferedWriter w = null;
        try {
            w = new BufferedWriter(new FileWriter(tempPath));
            w.write(toBeWritten);
            
            w.close();
        } catch (IOException e) {
            System.out.println("HERE");
        }
        writeToMain(mainPath, toBeWritten);

    }

    private void writeToMain(String tempPath, String toBeWritten) {
        BufferedWriter w = null;
        try {
            w = new BufferedWriter(new FileWriter(tempPath));
            w.write(toBeWritten);
            w.close();
        } catch (IOException e) {
            System.out.println("HERE");
            // e.printStackTrace();
        }
    }

    public void addToFile(String newData, int key) {
        String mainPath = "Sessions\\" + String.valueOf(key) + ".txt";
        String tempPath = "Sessions\\" + String.valueOf(key) + "Temp.txt";

        fs.writeToFile(mainPath, tempPath, newData, 0);

    }

    public void deleteFromFile(String name, int key){
        String mainPath = "Sessions\\" + String.valueOf(key) + ".txt";
        String tempPath = "Sessions\\" + String.valueOf(key) + "Temp.txt";

        fs.deleteRow(mainPath, tempPath, "", 0 , name);
    }

    public void editPlayerName(String oldName,String newName ,int score, boolean isin, int key){
        String mainPath = "Sessions\\" + String.valueOf(key) + ".txt";
        String tempPath = "Sessions\\" + String.valueOf(key) + "Temp.txt";
        String toSession = newName + "," + score + "," + isin;
        fs.deleteRow(mainPath, tempPath, toSession, 0, oldName);
    }
    public void editPlayerScore(String name ,int score, boolean isin, int key){
        String mainPath = "Sessions\\" + String.valueOf(key) + ".txt";
        String tempPath = "Sessions\\" + String.valueOf(key) + "Temp.txt";
        String toSession = name + "," + score + "," + isin;
        fs.deleteRow(mainPath, tempPath, toSession, 0, name);
    }

    public void deleteFiles(int key){
        String mainPath = "Sessions\\" + String.valueOf(key) + ".txt";
        String tempPath = "Sessions\\" + String.valueOf(key) + "Temp.txt";

        File file = new File(mainPath);
        try {
            file.delete();
        } catch (Exception e) {
            // TODO: handle exception
        }
        file = new File(tempPath);
        try {
            file.delete();
        } catch (Exception e) {
            // TODO: handle exception
        }


    }

}
