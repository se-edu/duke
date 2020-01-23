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
    public boolean parseMessage(String message, TaskTracker tasks) {
        try {
            if (message.equals("bye")) {
                printGoodBye();
                return false;
            } else if (message.equals("i")) {
                botInstruction();
                return true;
            } else if (message.equals("list")) {
                tasks.printStoredTask();
                return true;
            } else if (message.substring(0,4).equals("done")) {
                tasks.doneTask(Integer.parseInt(message.split(" ",2)[1]));
                return true;
            } else if (message.substring(0,4).equals("todo")) {
                tasks.addTask(message, Symbol.T);
                return true;
            } else if (message.substring(0,5).equals("event")) {
                tasks.addTask(message, Symbol.E);
                return true;
            } else if (message.substring(0,8).equals("deadline")) {
                tasks.addTask(message, Symbol.D);
                return true;
            } else if (message.substring(0,6).equals("delete")) {
                tasks.deleteTask(message);
                return true;
            } else {
                throw new IllegalArgumentException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(String.format("%80s",' ').replace(' ','*'));
            System.out.println(String.format("* %-77s*",' '));
            System.out.println(String.format("* %-77s*",e.getMessage()));
            System.out.println(String.format("* %-77s*",' '));
            System.out.println(String.format("%80s",' ').replace(' ','*'));
            return true;
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println(String.format("%80s",' ').replace(' ','*'));
            System.out.println(String.format("* %-77s*",' '));
            System.out.println(String.format("* %-77s*","☹ OOPS!!! I'm sorry, but I don't know what that means :-("));
            System.out.println(String.format("* %-77s*",' '));
            System.out.println(String.format("%80s",' ').replace(' ','*'));
            return true;
        } catch (NullPointerException ex) {
            System.out.println(String.format("%80s",' ').replace(' ','*'));
            System.out.println(String.format("* %-77s*",' '));
            System.out.println(String.format("* %-77s*",ex.getMessage()));
            System.out.println(String.format("* %-77s*",' '));
            System.out.println(String.format("%80s",' ').replace(' ','*'));
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
        botInstruction();
        ArrayList<String> lis = new ArrayList<>();
        TaskTracker tasks = new TaskTracker();
        while (true) {
            if (!parseMessage(scanner.nextLine(), tasks)) {
                break;
            }
        }
    }

    /**
     * Print instruction of the commands in JayZbot.
     */
    public void botInstruction() {
        System.out.println("Use the list command to see your tasks.");
        System.out.println("Set up tasks by using the command shown below:");
        System.out.println("todo {your task}");
        System.out.println("deadline {your task} /by {date/time}");
        System.out.println("event {your task} /at {date/time}");
        System.out.println("Use the bye command to quit.");
    }

    /**
     * Prints a logo of the name Duke.
     * @param args Set up main function
     */
    public static void main(String[] args) {

        new JayZ().runChatBot();


    }
}
