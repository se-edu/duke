import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChatBot {
    public static Scanner lineScanner;
    public static Scanner sc;

    protected void run() {
        List<Task> history = new ArrayList<>();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("I am here to help you with anything you need!");
        sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String userInput = sc.nextLine();
                System.out.println("____________________________________________________________");
                if (userInput.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                } else if (userInput.equals("list")) {
                    System.out.println("Here are the tasks in your list: ");
                    for (int i = 0; i < history.size(); i++) {
                        System.out.println((i + 1) + "." + history.get(i).toString());
                    }
                } else if (userInput.startsWith("done")) {
                    int taskNumber = -1 + Integer.parseInt(userInput.split(" ")[1]);
                    history.get(taskNumber).markAsDone();
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println(history.get(taskNumber));
                } else if (userInput.startsWith("todo")) {
                    lineScanner = new Scanner(userInput);
                    lineScanner.next();
                    try {
                        Task task = new Todo(lineScanner.nextLine().substring(1));
                        System.out.println("ab");
                        history.add(new Todo(lineScanner.nextLine().substring(1)));
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(task);
                        System.out.println("Now you have " + history.size() + " tasks in the list.");
                    } catch (NoSuchElementException error) {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                } else if (userInput.startsWith("deadline")) {
                    try {
                        lineScanner = new Scanner(userInput);
                        lineScanner.next();
                        String theRest = lineScanner.nextLine();
                        Task task = new Deadline(theRest.split("/")[0].substring(1), theRest.split("/")[1]);
                        history.add(task);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(task);
                        System.out.println("Now you have " + history.size() + " tasks in the list.");
                    } catch (NoSuchElementException error) {
                        System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                    }
                } else if (userInput.startsWith("event")) {
                    try {
                        lineScanner = new Scanner(userInput);
                        lineScanner.next();
                        String theRest = lineScanner.nextLine();
                        Task task = new Event(theRest.split("/")[0].substring(1), theRest.split("/")[1]);
                        history.add(task);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(task);
                        System.out.println("Now you have " + history.size() + " tasks in the list.");
                    } catch (NoSuchElementException error) {
                        System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
                    }
                } else if (userInput.startsWith("delete")) {
                    int taskNumber = -1 + Integer.parseInt(userInput.split(" ")[1]);
                    System.out.println("Noted. I've removed this task: ");
                    System.out.println(history.get(taskNumber));
                    history.remove(taskNumber);
                    System.out.println("Now you have " + history.size() + " tasks in the list.");
                } else {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
                System.out.println("____________________________________________________________");
            }
    }
}
