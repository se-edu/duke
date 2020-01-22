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
    public boolean parseMessage(String message) {
        if (message.equals("bye")) {
            printGoodBye();
            return false;
        } else {
            printMessageInBox(message);
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
     * Chat bot function, run infinitely until user types "bye".
     */
    public void runChatBot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm JayZ-Bot\nWhat can i do for you?");
        while (true) {
            if (!parseMessage(scanner.nextLine())) {
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
