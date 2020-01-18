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
        Task[] tasks = new Task[100];
        int numTasks = 0;

        while (!input.equals("bye")) {
            String[] inputs = input.split(" ");

            if (input.equals("list")) {
                printList(tasks, numTasks);
            } else if (inputs[0].equals("done")) {
                int completedTask = Integer.valueOf(inputs[1]);

                tasks[completedTask - 1].markAsDone();

                System.out.println("Nice! I've marked this task as done:");
                System.out.println(" [" + tasks[completedTask - 1].getStatusIcon() + "] "
                        + tasks[completedTask - 1].getDescription());
            } else {
                tasks[numTasks] = new Task(input);
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
    private static void printList(Task[] tasks, int numTasks) {
        System.out.println("Here are the tasks in your list:");

        for (int i = 1; i < numTasks + 1; i++) {
            System.out.println(i + ".[" + tasks[i - 1].getStatusIcon() + "] "
                    + tasks[i - 1].getDescription());
        }
    }
}

/**
 * Each object of class Task represents a task to be saved
 */
class Task {
    private String description;
    private boolean isDone;

    /**
     * Class constructor
     * @param description Task description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns symbol representing status of task
     * @return If task is done, return tick symbol, else return X symbol
     */
    public String getStatusIcon() {
        if (isDone) {
            return ("\u2713");
        } else {
            return ("\u2718");
        }
    }

    /**
     * Returns description of task
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mark task as done
     */
    public void markAsDone() {
        isDone = true;
    }
}
