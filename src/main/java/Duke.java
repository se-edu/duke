import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static final String horizontalLine = "____________________________________________________________";
    private static TaskManager taskManager = new TaskManager();

    public static void printMessage(String message) {
        printWithIndentation(horizontalLine);
        printWithIndentation(message);
        printWithIndentation(horizontalLine);
    }

    public static void printIntroduction() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        printMessage("Hello! I'm Duke\n" + "\tWhat can I do for you?");
    }

    public static void printGoodBye() {
        printMessage("Bye. Hope to see you again soon!");
    }

    public static void printWithIndentation(String string) {
        System.out.println("\t" + string);
    }

    public static void printTasks() {
        printWithIndentation(horizontalLine);
        ArrayList<Task> taskArrayList = taskManager.getTasksList();
        for (int i = 0; i < taskArrayList.size(); i++) {
            printWithIndentation((i + 1) + ". [" + taskArrayList.get(i).getStatusIcon() + "] "
                + taskArrayList.get(i).description);
        }
        printWithIndentation(horizontalLine);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printIntroduction();

        String input = sc.nextLine();
        while (true) {
            String[] inputSplit = input.split(" ");
            if (inputSplit.length == 2 && inputSplit[0].toLowerCase().equals("done")) {
                try {
                    int indexOfTask = Integer.parseInt(inputSplit[1]) - 1;
                    if (taskManager.markTaskAsDone(indexOfTask)) {
                        Task taskMarkedAsDone = taskManager.getTasksList().get(indexOfTask);
                        printMessage("Nice! I've marked this task as done:\n" +
                        "\t[" + taskMarkedAsDone.getStatusIcon() + "] " + taskMarkedAsDone.description);
                    } else {
                        printMessage("Index out of bounds!");
                    }
                } catch (NumberFormatException e) {
                    printMessage("Invalid index of task!");
                }
            } else {
                if (input.toLowerCase().trim().equals("bye")) {
                    break;
                } else if (input.toLowerCase().trim().equals("list")) {
                    printTasks();
                } else {
                    taskManager.addTask(input);
                    printMessage("added: " + input);
                }
            }

            input = sc.nextLine();
        }

        printGoodBye();
    }
}
