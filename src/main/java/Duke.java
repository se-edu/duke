import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {

    public static Scanner lineScanner;
    public static void main(String[] args) {
        List<Task> history = new ArrayList<>();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("I am here to help you with anything you need!");
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String userInput = sc.nextLine();
            System.out.println("---------------");
            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
            } else if (userInput.equals("list")) {
                System.out.println("Here are the tasks in your list:\n");
                for (int i = 0; i < history.size(); i++) {
                    System.out.println((i + 1) + "." + history.get(i).toString());
                }
            } else if (userInput.startsWith("done")) {
                int taskNumber = -1 + Integer.parseInt(userInput.split(" ")[1]);
                history.get(taskNumber).markAsDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(history.get(taskNumber));
            } else if (userInput.startsWith("todo")) {
                System.out.println("Got it. I've added this task: ");
                lineScanner = new Scanner(userInput);
                lineScanner.next();
                Task task = new Todo(lineScanner.nextLine());
                history.add(task);
                System.out.println(task);
                System.out.println("Now you have " + history.size() +  " tasks in the list.");
            } else if (userInput.startsWith("deadline")) {
                System.out.println("Got it. I've added this task: ");
                lineScanner = new Scanner(userInput);
                lineScanner.next();
                String theRest = lineScanner.nextLine();
                System.out.println(theRest);
                Task task = new Deadline(theRest.split("/")[0].substring(1), theRest.split("/")[1]);
                history.add(task);
                System.out.println(task);
                System.out.println("Now you have " + history.size() +  " tasks in the list.");
            } else if (userInput.startsWith("event")) {
                System.out.println("Got it. I've added this task: ");
                lineScanner = new Scanner(userInput);
                lineScanner.next();
                String theRest = lineScanner.nextLine();
                Task task = new Event(theRest.split("/")[0].substring(1), theRest.split("/")[1]);
                history.add(task);
                System.out.println(task);
                System.out.println("Now you have " + history.size() +  " tasks in the list.");
            }
            System.out.println("---------------");
        }
    }
}
