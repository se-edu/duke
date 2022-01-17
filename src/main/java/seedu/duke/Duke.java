package seedu.duke;

import java.util.Scanner;

/**
 * Functions as the chatbot by taking in inputs and giving out specificed outputs.
 */
class Duke {
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

        TaskList taskList = new TaskList();
        String command = in.nextLine();

        while (!command.equals("bye")) {
            if (command.startsWith("list")) {
                //if equal list, print all in commandTracker
                taskList.printTasks();
            } else if (command.startsWith("mark")) {
                //if command mark is used,then we mark the specified task as done
                int indexAfterCommand = 5;
                taskList = taskList
                        .mark(Integer
                                .parseInt(command.substring(indexAfterCommand)) - 1);
                //command.substring(6) cuts out the command "mark "
            } else if (command.startsWith("unmark")) {
                //if command unmark is used,// then we mark the specified task as undone
                int indexAfterCommand = 7;
                taskList = taskList.unmark(Integer
                        .parseInt(command.substring(indexAfterCommand)) - 1);
                //command.substring(6) cuts out the command "unmark "
            } else if (command.startsWith("todo")) { //if not, just add task to taskList
                int indexTaskName = 5;
                String taskName = command.substring(indexTaskName);
                Task newTask = new Task(taskName);

                //command.substring(5) cuts out the command
                taskList = taskList.add(newTask);
                System.out.println(String.format("added: %s", taskName));
            } else {
                System.out.println("Sorry I don't understand! :(");
            }
            command = in.nextLine();
        }
        System.out.println(String.format("Bye %s. See you again soon!", name));
    }
}
