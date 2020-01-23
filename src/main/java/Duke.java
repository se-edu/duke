import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        Duke.printGreeting();

        String input = "";
        while (!(input = sc.nextLine()).equals("bye")) {
            Duke.respond(input, list);
        }

        Duke.printExit();
    }

    public static void respond(String input, List<String> list) {
        if (input.equals("list")) {
            Duke.printList(list);
        } else {
            Duke.addToList(input, list);
        }
    }

    public static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public static void addToList(String input, List<String> list) {
        list.add(input);
        System.out.println("added: " + input);
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
