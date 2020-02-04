package Utils;

import java.util.Scanner;

public class Ui {

    public Scanner sc;

    public Ui(){
        this.sc = new Scanner(System.in);
    }

    /**
     * prints line
     */
    public static void printDivider(){
        System.out.println("-------------------------------------------------------------");
    }

    /**
     * Checks if user is done.
     * @param input
     * @return whether input is bye
     */
    public static boolean isFinished(String input){
        return input.equals("bye");
    }

    /**
     * Says farewell to user
     */
    public void exit(){
        System.out.println("It was a pleasure to serve you my lord. Check in again anytime.");
    }

    /**
     * Greets user.
     */
    public void enter(){
        System.out.println("Good day master. How may I be of service today?");
    }
}
