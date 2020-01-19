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
                try {
                    addTask(inputs, tasks, numTasks);
                    numTasks++;

                    if (numTasks == 1) {
                        System.out.println("Now you have " + numTasks + " task in the list.\n");
                    } else {
                        System.out.println("Now you have " + numTasks + " tasks in the list.\n");
                    }
                } catch (DukeException exception) {
                    System.out.println(exception);
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
    private static void addTask(String[] inputs, Task[] tasks, int num) throws DukeException {
        String task;

        if (inputs[0].equals("todo")) {
            if (inputs.length == 1) {
                throw new DukeException("\u2639" + " OOPS!!! The description of a todo cannot be empty\n");
            }

            task = inputs[1];
            for (int i = 2; i < inputs.length; i++) {
                task = task.concat(" " + inputs[i]);
            }

            tasks[num] = new ToDo(task, "T");
        } else if (inputs[0].equals("event") || inputs[0].equals("deadline")) {
            if (inputs.length == 1) {
                throw new DukeException("\u2639" + " OOPS!!! The description of a "
                        + inputs[0] + " cannot be empty\n");
            }

            int j = 2;

            task = inputs[1];
            while (j != inputs.length && inputs[j].charAt(0) != '/') {
                task = task.concat(" " + inputs[j]);
                j++;
            }

            String timing = "";
            j++;

            while (j < inputs.length) {
                timing = timing.concat(" " + inputs[j]);
                j++;
            }

            if (timing.equals("")) {
                throw new DukeException("\u2639" + " OOPS!!! This task requires a timing\n");
            }

            if (inputs[0].equals("event")) {
                timing = "(at:" + timing + ")";
                tasks[num] = new Event(task, "E", timing);
            } else {
                timing = "(by:" + timing + ")";
                tasks[num] = new Deadline(task, "D", timing);
            }
        } else {
            throw new DukeException("\u2639" + " OOPS!!! I'm sorry, but I don't know what that means :-(\n");
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