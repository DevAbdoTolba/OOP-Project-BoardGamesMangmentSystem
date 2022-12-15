package main.util;

import java.io.IOException;

public class Output {
    
    public Output(){
    }

    public void cls(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /* The code above does the following:
1. Creates a new process builder
2. Tells the process builder to execute the command "cls" (clear screen) in the command prompt
3. Inherit the output and error streams from the parent process
4. Start the process and wait for it to finish
5. If there is an error, print it to the console */

}
