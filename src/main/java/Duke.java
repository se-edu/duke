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
            case "todo":
                Task newTodo = Todo.createTodo(input, false);
                Duke.addToList(newTodo, tasks);
                break;
            case "deadline":
                String[] deadlineParts = combine(words).split(" /by ");
                Task newDeadline = Deadline.createDeadline(deadlineParts[0], false, deadlineParts[1]);
                Duke.addToList(newDeadline, tasks);
                break;
            case "event":
                String[] eventParts = combine(words).split(" /at ");
                Task newEvent = Event.createEvent(eventParts[0], false, eventParts[1]);
                Duke.addToList(newEvent, tasks);
                break;
            default:
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                break;
        }
    }
    public static String combine(String[] parts) {
        String result = parts[1];
        for (int i = 2; i < parts.length; i++) {
            result += " " + parts[i];
        }
        return result;
    }
    // Mark a task as done by substituting the current task with a completed task in the list
    public static void markAsDone(int taskNumber, List<Task> tasks) {
        // the index of a task in the list is one less than the taskNumber
        int index = taskNumber - 1;
        Task currentTask = tasks.get(index);
        Task completedTask = currentTask.complete();
        tasks.set(index, completedTask);
        System.out.println("Nice! I've marked this task as done:\n "
                + completedTask);
    }

    public static void printList(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            int taskNumber = i + 1;
            System.out.println(taskNumber + ". " + currentTask);
        }
    }

    public static void addToList(Task newTask, List<Task> tasks) {
        tasks.add(newTask);
        System.out.println("Got it. I've added this task:\n"
                + newTask + "\n"
                + "Now you have " + tasks.size() + " tasks in the list.");
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
