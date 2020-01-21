import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {

    static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        run();
    }

    public static void run() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (true) {
            try {
                input = sc.nextLine();
                if (input.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    sc.close();
                    return;
                } else if (input.equals("list")) {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + "." + tasks.get(i));
                    }
                } else if (input.split(" ")[0].equals("delete")) {
                    int idx = Integer.parseInt((input.split(" ")[1])) - 1;
                    Task toDelete = tasks.get(idx);
                    tasks.remove(idx);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(toDelete);
                    System.out.println("Now you have " + tasks.size()
                            + " " + (tasks.size() > 1 ? "tasks" : "task") + " in the list");
                } else if (input.split(" ")[0].equals("done")) {
                    int idx = Integer.parseInt((input.split(" ")[1])) - 1;
                    tasks.get(idx).setDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(tasks.get(idx));
                } else if (input.split(" ")[0].equals("todo")) {
                    input = input.substring(input.split(" ")[0].length() + 1, input.length());
                    Task task = new Task(input);
                    tasks.add(task);
                    addTask(task);
                } else if (input.split(" ")[0].equals("deadline")) {
                    input = input.substring(input.split(" ")[0].length() + 1, input.length());
                    String name = input.split(" /by")[0];
                    String time = input.split(" /by")[1];
                    Deadline deadline = new Deadline(name, time);
                    tasks.add(deadline);
                    addTask(deadline);
                } else if (input.split(" ")[0].equals("event")) {
                    input = input.substring(input.split(" ")[0].length() + 1, input.length());
                    String name = input.split(" /at")[0];
                    String time = input.split(" /at")[1];
                    Event event = new Event(name, time);
                    tasks.add(event);
                    addTask(event);
                } else {
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (StringIndexOutOfBoundsException e) {
                if (input.split(" ")[0].equals("todo")) {
                    System.out.println("OOPS! The description of a task cannot be empty.");
                } else if (input.split(" ")[0].equals("event")) {
                    System.out.println("OOPS! The description of an event cannot be empty.");
                } else if (input.split(" ")[0].equals("deadline")) {
                    System.out.println("OOPS! The description of a deadline cannot be empty.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("OOPS! The time of this event is invalid");
            } catch (IndexOutOfBoundsException e) {
                if (tasks.size() == 0) {
                    System.out.println("No tasks. Why not create one?");
                } else {
                    System.out.println("OOPS! Invalid task number. You only have " + tasks.size()
                            + (tasks.size() > 1 ? " tasks" : " task") + " in the list");
                }
            }
        }
    }

    static void addDeadline(Deadline deadline) {
        System.out.println("Got it. I've added this task:");
        System.out.println(deadline);
        System.out.println("Now you have " + tasks.size()
                + (tasks.size() > 1 ? "tasks" : "task") + " in the list");
    }

    static void addEvent(Event event) {
        System.out.println("Got it. I've added this task:");
        System.out.println(event);
        System.out.println("Now you have " + tasks.size()
                + (tasks.size() > 1 ? "tasks" : "task") + " in the list");
    }
    static void addTask(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + tasks.size()
                + " " + (tasks.size() > 1 ? "tasks" : "task") + " in the list");
    }
}
