package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileStream {
    // public static void main(String[] args) {
    String mainPath ; // storing the main path to the file
    String tempPath ; // storing the temp path to the output file
    String newData ; // new data to be added to the file, should be in the format of a row
        
    //     fileStream fs = new fileStream();
    //     fs.writeToFile(mainPath,tempPath,newData);
    // }

    public fileStream() {
        mainPath = "Data\\games.csv"; 
        tempPath = "Data\\outPut.csv";
        newData = "";
    }

    public fileStream(String newData) {
        this();
        this.newData = newData;
    }

    public fileStream(String mainPath, String tempPath, String newData) {
        this.mainPath = mainPath;
        this.tempPath = tempPath;
        this.newData = newData;
    }

    // setters and getters
    public String getMainPath() {
        return mainPath;
    }

    public void setMainPath(String mainPath) {
        this.mainPath = mainPath;
    }

    public String getTempPath() {
        return tempPath;
    }

    public void setTempPath(String tempPath) {
        this.tempPath = tempPath;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }

    public void writeToFile(String mainPath,String tempPath, String newData) {
        // TODO: write data from old file to temp file with new data which wanted to be added
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(tempPath));
            String currentFileData = readFromFile(mainPath);
            System.out.println("\n\n " + newData + "\n\n");
            writer.write(String.join(",", currentFileData) + newData);

            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // TODO: write data from new temp file to old main
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(mainPath));
            String currentFileData = readFromFile(tempPath);
            System.out.println("\n\n " + newData + "\n\n");
            writer.write(String.join(",", currentFileData) + newData);

            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    public String readFromFile(String mainPath) {
        BufferedReader reader = null; // Reader Object
        String line = ""; // String where will store every line from file
        String currentFileData = "";

        try {

            reader = new BufferedReader(new FileReader(mainPath)); // * instance of BufferedReader
            while ((line = reader.readLine()) != null) { // * assign line to reader.readLine() and check if it's not null to read all file
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

    public String[] returLastRow(){
        /*
         * Return last row
         * a method to return the last row of a file
         */
        String[] lastRow = null;


        BufferedReader reader = null; // Reader Object
        String path = "Data\\games.csv"; // Path to file
        String line = ""; // String where will store every line from file


        try {

            reader = new BufferedReader(new FileReader(path)); // * instance of BufferedReader
            while ((line = reader.readLine()) != null) { // * assign line to reader.readLine() and check if it's not
                                                         // * null to read all file
                String[] row = line.split(","); // * split the line scanned at every "," and assign to row to be
                lastRow = row;
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

        return lastRow;
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