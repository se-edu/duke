import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        Duke.printGreeting();

        //prompt, parse and respond to input
        String input = "";
        while (!(input = sc.nextLine()).equals("bye")) {
            Duke.respond(input, tasks);
        }

        Duke.printExit();
    }

    // Print a response according to the input, update list of task if necessary
    public static void respond(String input, List<Task> tasks) {
        String[] words = input.split(" ");
        String firstWord = words[0];
        switch (firstWord) {
            case "list":
                Duke.printList(tasks);
                break;
            case "done":
                // complete the task at number given by user
                int taskNumber = Integer.parseInt(words[1]);
                Duke.markAsDone(taskNumber, tasks);
                break;
            default:
                // add a new task to the list
                int newNumber = tasks.size() + 1;
                Task newTask = Task.createTask(newNumber, input, false);
                Duke.addToList(newTask, tasks);
                break;
        }
    }

    // Mark a task as done by substituting the current task with a completed task in the list
    public static void markAsDone(int taskNumber, List<Task> tasks) {
        // the index of a task in the list is one less than the taskNumber
        int index = taskNumber - 1;
        Task currentTask = tasks.get(index);
        Task completedTask = Task.createTask(currentTask.getNumber(), currentTask.getName(), true);
        tasks.set(index, completedTask);
        System.out.println("Nice! I've marked this task as done:\n "
                + currentTask.updatedDetails());
    }

    public static void printList(List<Task> tasks) {
        for (Task entry : tasks) {
            System.out.println(entry);
        }
    }

    public static void addToList(Task newTask, List<Task> tasks) {
        tasks.add(newTask);
        System.out.println("added: " + newTask.getName());
    }

    public static void printGreeting() {
        System.out.println("Hello! I'm Duke\n"
                + "What can I do for you?");
    }

    public static void printExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void printLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }
}
