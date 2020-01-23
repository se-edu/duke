import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke!");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);

        ArrayList<Task> list = new ArrayList<Task>();

        while (true) {
            String userInput = sc.nextLine();

            if (userInput.equals("bye")) {
                // Exit Duke
                System.out.println("Bye! Come back soon!");
                break;
            } else if (userInput.equals("list")) {
                // Print out list of all tasks
                System.out.println("This is your list of tasks");
                for (int i = 0; i < list.size(); i++) {
                    Task t = list.get(i);
                    System.out.println((i+1) + "." + t);
                }
            } else if (userInput.contains("done")) {
                // Mark one task as complete
                int taskNumber =  userInput.charAt(5);
                Task t = list.get(taskNumber - 1);
                t.markAsDone();
                System.out.println("This task is mark as completed!");
                System.out.println(t);
            } else {
                // Add new task
                String taskDescription = "";
                Task t;
                if (userInput.contains("todo")) {
                    // add Todo task
                    taskDescription = userInput.substring(5); // removes todo word
                    t = new Todo(taskDescription);
                } else if (userInput.contains("deadline")) {
                    // add Deadline task
                    taskDescription = userInput.substring((9)); // removes deadline word
                    int slashIdx = taskDescription.indexOf("/");
                    String taskTitle = taskDescription.substring(0, slashIdx);
                    String deadline = taskDescription.substring(slashIdx + 4);
                    t = new Deadline(taskTitle, deadline);
                } else {
                    // add Event task
                    taskDescription = userInput.substring(6); // removes event word
                    int slashIdx = taskDescription.indexOf("/");
                    String taskTitle = taskDescription.substring(0, slashIdx);
                    String location = taskDescription.substring(slashIdx + 4);
                    t = new Event(taskTitle, location);
                }

                //Task t = new Task(taskDescription);
                list.add(t);
                System.out.println("This task has been added successfully:");
                System.out.println(t);
                System.out.println("Now you have " + list.size() + " tasks in the list");

            }
        }
    }
}
