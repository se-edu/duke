import java.util.Scanner;

/**
 * Duke is a Personal Assistant Chatbot that helps a person keep track of various things
 */
public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");

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
                System.out.println("  " + tasks[completedTask - 1].obtainTaskInfo() + "\n");
            } else {
                addTask(inputs, tasks, numTasks);
                numTasks++;

                if (numTasks == 1) {
                    System.out.println("Now you have " + numTasks + " task in the list.\n");
                } else {
                    System.out.println("Now you have " + numTasks + " tasks in the list.\n");
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Adds a task to the list of saved tasks
     * @param inputs Components of task to be added
     * @param tasks List of saved tasks
     * @param num Id of task to be added
     */
    private static void addTask(String[] inputs, Task[] tasks, int num) {
        String task = inputs[1];

        if (inputs[0].equals("todo")) {
            for (int i = 2; i < inputs.length; i++) {
                task = task.concat(" " + inputs[i]);
            }

            tasks[num] = new ToDo(task, "T");
        } else {
            int j = 2;

            while (inputs[j].charAt(0) != '/') {
                task = task.concat(" " + inputs[j]);
                j++;
            }

            String timing = "";
            j++;

            while (j < inputs.length) {
                timing = timing.concat(" " + inputs[j]);
                j++;
            }

            if (inputs[0].equals("event")) {
                timing = "(at:" + timing + ")";
                tasks[num] = new Event(task, "E", timing);
            } else {
                timing = "(by:" + timing + ")";
                tasks[num] = new Deadline(task, "D", timing);
            }
        }

        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks[num].obtainTaskInfo());
    }

    /**
     * Prints the list of tasks currently saved
     * @param tasks List of tasks that are saved
     * @param numTasks Number of tasks in the list
     */
    private static void printList(Task[] tasks, int numTasks) {
        System.out.println("Here are the tasks in your list:");

        for (int i = 1; i < numTasks + 1; i++) {
            System.out.println(i + "." + tasks[i - 1].obtainTaskInfo());
        }
        System.out.println();
    }
}