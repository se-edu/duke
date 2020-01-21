import java.util.Scanner;
import java.util.StringTokenizer;

public class Duke {
    static String space = "     ";
    static String line = space + "_____________________________________________";
    static Task[] tasks = new Task[100];
    static int count = 0;

    public static void main(String[] args) {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        introduce();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String next = scanner.nextLine();
            if (next.equals("bye")) {
                respond("Bye. Hope to see you again soon!");
                break;
            } else {
                try {
                    process(next);
                } catch (DukeException dd) {
                    System.out.println(dd.getMessage());
                }
            }
        }
    }




    public static void process(String next) throws DukeException {
        StringTokenizer st = new StringTokenizer(next);
        String first_token = st.nextToken();

        if (next.equals("list")){
            print_list(tasks, count);
        } else if (first_token.equals("done")) {
            int index = Integer.parseInt(st.nextToken()) - 1;
            Task temp = tasks[index];
            markDone(temp);

        } else {
            Task itemToAdd = null;

            if (first_token.equals("deadline")) {
                try {
                    next = next.substring(9);
                    String[] temp = next.split(" /by ");
                    itemToAdd = new Deadline(temp[0], temp[1]);
                } catch (IndexOutOfBoundsException e) {
                    throw new DukeException("OOPS!!! Wrong input format for deadline");
                }


            } else if (first_token.equals("event")) {
                try {
                    next = next.substring(6);
                    String[] temp = next.split(" /at ");
                    itemToAdd = new Event(temp[0], temp[1]);
                } catch (IndexOutOfBoundsException e) {
                    throw new DukeException("OOPS!!! Wrong input format for event");
                }

            } else if (first_token.equals("todo")) {
                try {
                    next = next.substring(5);
                    itemToAdd = new Todo(next);
                    if (next.equals("")) {
                        throw new Exception("empty todo");
                    }
                } catch (Exception e) {
                    throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                }
            }

            if (itemToAdd != null) {
                tasks[count] = itemToAdd;
                String out = line + "\n" + space + "Got it. I've added this task: " + "\n" + space
                        + "  " + itemToAdd + "\n" + space + "Now you have " + (count+1) +
                        " tasks in your list." + "\n" + line;
                System.out.println(out);
                count++;
            } else {
                throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }

    public static void respond(String in) {
        String output = line + "\n" + space + in + "\n" + line;
        System.out.println(output);
    }

    public static void introduce() {
        String intro_message = "Hello! I'm Duke" + "\n" + space + "What can I do for you?";
        respond(intro_message);
    }
    public static void print_list(Task[] t, int count) {
        String output = line + "\n" + space + "Here are the tasks in your list: ";
        for (int i = 0; i < count; i++) {
            int index = i+1;
            output += "\n" + space + index + ". " + t[i];
        }
        output += "\n" + line;
        System.out.println(output);
    }

    public static void markDone(Task t) {
        t.markAsDone();
        String output = line + "\n" + space + "Nice! I've marked this task as done: "
                + "\n" + space + t + "\n" + line;
        System.out.println(output);
    }
}
