import java.util.ArrayList;
import java.util.Scanner;

public class JayZ {
    /**
     * Process message and deem if user wants to quit.
     * Print good bye message if user wants to quit.
     * Else echo back the message the user inputted
     * @param message entered by user.
     * @return boolean used to inform other function if user wants to quit
     *     true -> continue using bot, false -> quit bot.
     */
    public boolean parseMessage(String message, ArrayList<String> lis) {
        if (message.equals("bye")) {
            printGoodBye();
            return false;
        } else if (message.equals("list")) {
            printMessagesStored(lis);
            return true;
        } else {
            storeMessageInList(message, lis);
            return true;
        }
    }

    /**
     * Echo message back in a text box.
     * @param message provided by user, prints it.
     */
    public void printMessageInBox(String message) {
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("* %-77s*",message));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("%80s",' ').replace(' ','*'));
    }

    /**
     * Prints goodbye message.
     */
    public void printGoodBye() {
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("* %-77s*","Thank you for using JayZ-Bot! Hope to see you again :D"));
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("%80s",' ').replace(' ','*'));
    }

    /**
     * Store message in arraylist for later use.
     * @param message stored in list.
     * @param lis Used to store message.
     */
    public void storeMessageInList(String message, ArrayList<String> lis) {
        lis.add(message);
        printMessageInBox(String.format("Added: \"%s\" to your history", message));
    }

    /**
     * Loop the arrayList containing all the stored messages and print it out in a text box.
     * @param lis Arraylist containing Strings that the user typed
     */
    public void printMessagesStored(ArrayList<String> lis) {
        int counter = 1;
        System.out.println(String.format("%80s",' ').replace(' ','*'));
        System.out.println(String.format("* %-77s*",' '));
        for (String message:lis) {
            System.out.println(String.format("* %d.%-75s*",counter, message));
            counter++;
        }
        System.out.println(String.format("* %-77s*",' '));
        System.out.println(String.format("%80s",' ').replace(' ','*'));
    }

    /**
     * Chat bot function, run infinitely until user types "bye".
     */
    public void runChatBot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm JayZ-Bot\nWhat can i do for you?");
        System.out.print("All messages typed in this chatbot will be saved,");
        System.out.println("use the \"list\" command to review the Chat History");
        ArrayList<String> lis = new ArrayList<>();
        while (true) {
            if (!parseMessage(scanner.nextLine(), lis)) {
                break;
            }
        }
    }

    /**
     * Prints a logo of the name Duke.
     * @param args Set up main function
     */
    public static void main(String[] args) {

        new JayZ().runChatBot();


    }
}
