package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileStream {
    public static void main(String[] args) {
        fileStream fs = new fileStream();
        fs.writeToFile();
    }

    public void writeToFile() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("Data\\outPut.csv"));
            String currentFileData = readFromFile();
            String newData = "";
            writer.write(String.join(",", currentFileData) + "\n" + newData);

            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public String readFromFile() {
        BufferedReader reader = null; // Reader Object
        String path = "Data\\games.csv"; // Path to file
        String line = ""; // String where will store every line from file
        String currentFileData = "";

        try {

            reader = new BufferedReader(new FileReader(path)); // * instance of BufferedReader
            while ((line = reader.readLine()) != null) { // * assign line to reader.readLine() and check if it's not
                                                         // * null to read all file
                String[] row = line.split(","); // * split the line scanned at every "," and assign to row to be
                                                // * processed
                for (String index : row) { // * for each index in row
                    System.out.printf("%-10s", index); // * print the index with limit only 10 chars
                }
                currentFileData += convString(row) + "\n"; // * convert the row to string and add to currentFileData
                System.out.println(); // * print new line
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } // * close the reader

        }
        return currentFileData;



        // String fileStr="";
        // String[] strToArray;
        // File file = new File("F:\\Projects\\OTHER\\notepad.txt");
        // try (Scanner sc = new Scanner(file)) {
        // System.out.println("\n\n\n" + file);
        // while(sc.hasNextLine()){
        // fileStr += sc.nextLine();
        // }
        // strToArray = fileStr.split(",", 0);
        // for (String string : strToArray) {
        // System.out.println(string);
        // }
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

    }

    public String convString(String[] str){
        /*
         * Convert to String
         * a method to convert a string array to a string and returns it's value
         */
        String out = "";
        for (String string : str) {
            out += string + ", ";
        }
        return out;
    }
}