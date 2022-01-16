package seedu.duke;

import java.util.HashMap;
import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Hello " + name);

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Hello " + name);

        String[] commandTracker = new String[100];
        int index = 0;
        String lineToEcho = in.nextLine();

        //keeps taking in inputs - while loop stops when "bye" is input
        while (!lineToEcho.equals("bye")) {
            if (lineToEcho.equals("list")) { //if equal list, print all in commandTracker
                for (int i = 0; i < index; i++) {
                    //label = index + 1 because array is 0 indexed
                    System.out.println(String.format("%d . %s",i + 1, commandTracker[i]));
                }
            } else { //if not, just add to list
                commandTracker[index++] = lineToEcho;
                System.out.println(String.format("added: %s", lineToEcho));
            }
            lineToEcho = in.nextLine();
        }

        System.out.println(String.format("Bye %s. See you again soon!", name));

    }
}
