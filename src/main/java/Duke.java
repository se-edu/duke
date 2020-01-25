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
                input = sc.nextLine().trim();
                if (input.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    sc.close();
                    return;
                } else if (input.equals("list")) {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + "." + tasks.get(i));
                    }
                } else if (input.split(" ")[0].equals("delete")) {
                    if (input.split(" ").length < 2) {
                        throw new InsufficientInputException();
                    }
                    int idx = Integer.parseInt((input.split(" ")[1])) - 1;
                    if (idx < 0 || idx >= tasks.size()) {
                        String message = "OOPS! Invalid task number. You only have " + tasks.size()
                                + (tasks.size() > 1 ? " tasks" : " task") + " in the list";
                        throw new InvalidIndexException(message);
                    }
                    Task toDelete = tasks.get(idx);
                    tasks.remove(idx);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(toDelete);
                    System.out.println("Now you have " + tasks.size()
                            + " " + (tasks.size() > 1 ? "tasks" : "task") + " in the list");
                } else if (input.split(" ")[0].equals("done")) {
                    if (input.split(" ").length < 2) {
                        throw new InsufficientInputException();
                    }
                    int idx = Integer.parseInt((input.split(" ")[1])) - 1;
                    if (idx < 0 || idx >= tasks.size()) {
                        String message = "OOPS! Invalid task number. You only have " + tasks.size()
                                + (tasks.size() > 1 ? " tasks" : " task") + " in the list";
                        throw new InvalidIndexException(message);
                    }
                    tasks.get(idx).setDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(tasks.get(idx));
                } else if (input.split(" ")[0].equals("todo")) {
                    if (input.split(" ").length < 2) {
                        throw new InvalidTodoException();
                    }
                    input = input.substring(input.split(" ")[0].length() + 1, input.length());
                    Task task = new Task(input);
                    tasks.add(task);
                    addTask(task);
                } else if (input.split(" ")[0].equals("deadline")) {
                    input = input.substring(input.split(" ")[0].length() + 1, input.length()).trim();
                    if (input.split("/by").length == 0) {
                        throw new InvalidDeadlineException("OOPS! The description and time is missing. " +
                                "Format: description /by time");
                    } else if (input.split("/by").length == 1) {
                        if (input.split("/by")[0].equals("")) {
                            throw new InvalidEventException("OOPS! The description and time is missing. " +
                                    "Format: description /by time");
                        } else {
                            throw new InvalidEventException("OOPS! The time is missing. " +
                                    "Format: description /by time");
                        }
                    }else if (input.split("/by").length == 2) {
                        if (input.split("/by")[0].equals("")) {
                            throw new InvalidDeadlineException("OOPS! The description is missing. " +
                                    "Format: description /by time");
                        }
                    }
                    String name = input.split(" /by")[0];
                    String time = input.split(" /by")[1];
                    Deadline deadline = new Deadline(name, time);
                    tasks.add(deadline);
                    addTask(deadline);
                } else if (input.split(" ")[0].equals("event")) {
                    input = input.substring(input.split(" ")[0].length() + 1, input.length()).trim();
                    if (input.split("/at").length == 0) {
                        throw new InvalidEventException("OOPS! The description and time is missing. " +
                                "Format: description /at time");
                    } else if (input.split("/at").length == 1) {
                        if (input.split("/at")[0].equals("")) {
                            throw new InvalidEventException("OOPS! The description and time is missing. " +
                                    "Format: description /at time");
                        } else {
                            throw new InvalidEventException("OOPS! The time is missing. " +
                                    "Format: description /at time");
                        }
                    } else if (input.split("/at").length == 2) {
                        if (input.split("/at")[0].equals("")) {
                            throw new InvalidEventException("OOPS! The description is missing.");
                        }
                    }
                    String name = input.split(" /at")[0];
                    String time = input.split(" /at")[1];
                    Event event = new Event(name, time);
                    tasks.add(event);
                    addTask(event);
                } else {
                    throw new InvalidInputException();
                }
            } catch (InvalidInputException e) {
                System.out.println(e);
            } catch (InsufficientInputException e) {
                System.out.println(e);
            } catch (InvalidIndexException e) {
                System.out.println(e);
            } catch (InvalidTodoException e) {
                System.out.println(e);
            } catch (InvalidDeadlineException e) {
                System.out.println(e);
            } catch (InvalidEventException e) {
                System.out.println(e);
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
