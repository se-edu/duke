import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static int counter = 0;

    public static void main(String[] args) {
        ArrayList<Task> tasklist = new ArrayList<>();
        System.out.println("Hey, I'm Duke");
        System.out.println("What's up");

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String nextString = scanner.nextLine();
            if (nextString.equals("bye")) {
                System.out.println("Bye.");
            } else if (nextString.equals("list")){
                System.out.println("Here are the tasks in your list: ");
                for (Task t: tasklist) {
                    System.out.println((tasklist.indexOf(t) + 1) + ". " + t.toString());
                }
            } else if (nextString.contains("done")){
                String[] temp = nextString.split(" ");
                int index = Integer.parseInt(temp[1]) - 1;
                System.out.println("Nice! I've marked this task as done: ");
                Task current = tasklist.get(index);
                current.isDone = true;
                System.out.println(current.toString());
            } else if (nextString.contains("todo")){
                try {
                    if(nextString.equals("todo")) {
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty :(");
                    }
                    String name = nextString.substring(5);
                    Task task = new Todo(name);
                    tasklist.add(counter, task);
                    counter++;
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + task.toString());
                    System.out.println("Now you have " + (counter) + " tasks in your list.");
                } catch(DukeException ex) {
                    ex.printStackTrace();
                }
            } else if (nextString.contains("deadline")) {
                try {
                    if (nextString.equals("deadline")) {
                        throw new DukeException("OOPS!!! The description of a deadline cannot be empty :(");
                    }
                    String name = nextString.substring(9);
                    String[] temp = name.split(" /by ");
                    Task task = new Deadline(temp[0], temp[1]);
                    tasklist.add(counter, task);
                    counter++;
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + task.toString());
                    System.out.println("Now you have " + (counter) + " tasks in your list.");
                } catch (DukeException ex) {
                    ex.printStackTrace();
                }
            } else if (nextString.contains("event")){
                try {
                    if (nextString.equals("event")) {
                        throw new DukeException("OOPS!!! The description of an event cannot be empty :(");
                    }
                    String name = nextString.substring(5);
                    String[] temp = name.split(" /at ");
                    Task task = new Event(temp[0], temp[1]);
                    tasklist.add(counter, task);
                    counter++;
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + task.toString());
                    System.out.println("Now you have " + (counter) + " tasks in your list.");
                } catch (DukeException ex) {
                    ex.printStackTrace();
                }
            } else if (nextString.contains("delete")) {
                try {
                    if (nextString.equals("delete")) {
                        throw new DukeException("OOPS!!! There's no event to be deleted :(");
                    }
                    String[] temp = nextString.split(" ");
                    int index = Integer.parseInt(temp[1]) - 1;
                    System.out.println("Noted! I've removed this task: ");
                    Task current = tasklist.get(index);
                    tasklist.remove(index);
                    System.out.println(current.toString());
                    counter--;
                    System.out.println("Now you have " + (counter) + " tasks in your list.");
                } catch (DukeException ex) {
                    ex.printStackTrace();
                }
            } else {
                try {
                    throw new DukeException("I'm sorry, I don't understand :(");
                } catch (DukeException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}