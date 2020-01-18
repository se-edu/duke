import java.util.Scanner;

/**
 * Duke is a Personal Assistant Chatbot that helps a person keep track of various things
 */
public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] tasks = new String[100];
        int numTasks = 0;

        while (!input.equals("bye")) {
            if (input.equals("list")) {
                printList(tasks, numTasks);
            } else {
                tasks[numTasks] = input;
                numTasks++;

                System.out.println("added: " + input);
            }

            input = scanner.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints the list of tasks currently saved
     * @param tasks List of tasks that are saved
     * @param numTasks Number of tasks in the list
     */
    private static void printList(String[] tasks, int numTasks) {
        for (int i = 1; i < numTasks + 1; i++) {
            System.out.println(i + ". " + tasks[i - 1]);
        }
    }
}
