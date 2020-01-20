import java.util.Scanner;

public class Duke {
    static String space = "     ";
    static String line = space + "_____________________________________________";

    public static void main(String[] args) {
        String[] tasks = new String[100];
        int count = 0;
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
            } else if (next.equals("list")){
                print_list(tasks, count);
            } else {
                respond("added: " + next);
                tasks[count] = next;
                count++;
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
    public static void print_list(String[] t, int count) {
        String output = line;
        for (int i = 0; i < count; i++) {
            int index = i+1;
            output += "\n" + space + index + ". " + t[i];
        }
        output += "\n" + line;
        System.out.println(output);
    }
}
