import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private static final String indent = "    ";
    private static final String horLine = "___________________________" +
            "_________________________________";

    public static void main(String[] args) throws DukeException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println(indent + horLine);
        System.out.println(indent + "Hello! I'm Duke!");
        System.out.println(indent + "What can I do for you?");
        System.out.println(indent + horLine);

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<Task>();

        while (true) {
            String userInput = sc.nextLine();

            if (userInput.equals("bye")) {
                // Exit Duke
                System.out.println(indent + horLine);
                System.out.println(indent + "Bye! Come back soon!");
                System.out.println(indent + horLine);
                break;
            } else if (userInput.equals("list")) {
                // Print out list of all tasks
                printList(list);
            } else if (userInput.contains("done")) {
                // Mark one task as complete
                try {
                    completeTask(list, userInput);
                } catch (DukeException e) {
                    e.print();
                }
            } else if (userInput.contains("delete")) {
                // Remove task
                try {
                    deleteTask(list, userInput);
                } catch (DukeException e) {
                    e.print();
                }
            } else {
                // Add new task
                try {
                    addTask(list, userInput);
                } catch (DukeException e) {
                    e.print();
                }
            }
        }
    }

    private static void addTask(ArrayList<Task> list, String userInput) throws DukeException {
        Task t;
        if (userInput.contains("todo")) {
            // add Todo task
            if (userInput.equals("todo")) throw new DukeException("insufficient details");
            String taskDescription = userInput.substring(5); // removes todo word
            t = new Todo(taskDescription);
        } else if (userInput.contains("deadline")) {
            // add Deadline task
            if (userInput.equals("deadline")) throw new DukeException("insufficient details");
            String taskDescription = userInput.substring((9)); // removes deadline word
            int slashIdx = taskDescription.indexOf("/");
            if (slashIdx == -1) throw new DukeException("wrong format");

            String taskTitle = taskDescription.substring(0, slashIdx);
            String deadline = taskDescription.substring(slashIdx + 4);
            t = new Deadline(taskTitle, deadline);
        } else if (userInput.contains("event")) {
            // add Event task
            if (userInput.equals("event")) throw new DukeException("insufficient details");
            String taskDescription = userInput.substring(6); // removes event word
            int slashIdx = taskDescription.indexOf("/");
            if (slashIdx == -1) throw new DukeException("wrong format");

            String taskTitle = taskDescription.substring(0, slashIdx);
            String location = taskDescription.substring(slashIdx + 4);
            t = new Event(taskTitle, location);
        } else {
            t = null;
            throw new DukeException("Unrecognized");
        }

        if (t != null) {
            list.add(t);
            System.out.println(indent + horLine);
            System.out.println(indent + "This task has been added successfully:");
            System.out.println(indent + "  " + t);
            System.out.println(indent + "Now you have " + list.size() + " tasks in the list");
            System.out.println(indent + horLine);
        }
    }

    private static void deleteTask(ArrayList<Task> list, String userInput) throws DukeException {
        if (userInput.equals("delete")) {
            throw new DukeException(userInput);
        }
        int taskNumber = Character.getNumericValue(userInput.charAt(7));
        if (taskNumber > list.size()) {
            throw new DukeException("List size");
        }
        Task t = list.get(taskNumber - 1);
        list.remove(taskNumber - 1);
        System.out.println(indent + horLine);
        System.out.println(indent + "This task has successfully been deleted:");
        System.out.println(indent + "  " + t);
        System.out.println(indent + "You have " + list.size() + " tasks remaining.");
        System.out.println(indent + horLine);
    }

    private static void completeTask(ArrayList<Task> list, String userInput) throws DukeException {
        if (userInput.equals("done")) {
            throw new DukeException(userInput);
        }
        int taskNumber = Character.getNumericValue(userInput.charAt(5));
        if (taskNumber > list.size()) {
            throw new DukeException("List size");
        }
        Task t = list.get(taskNumber - 1);
        t.markAsDone();
        System.out.println(indent + horLine);
        System.out.println(indent + "This task is marked as completed:");
        System.out.println(indent + "  " + t);
        System.out.println(indent + horLine);
    }

    private static void printList(ArrayList<Task> list) {
        System.out.println(indent + horLine);
        System.out.println(indent + "This is your list of tasks:");

        if (list.size() == 0) {
            System.out.println(indent + "Your list is currently empty.");
        }
        for (int i = 0; i < list.size(); i++) {
            Task t = list.get(i);
            System.out.println(indent + (i+1) + "." + t);
        }
        System.out.println(indent + horLine);
    }
}
