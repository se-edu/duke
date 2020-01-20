import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {

    static List<String> strings = new ArrayList<>();

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
        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                sc.close();
                return;
            } else if (input.equals("list")) {
                for (int i = 0; i < strings.size(); i++) {
                    System.out.println((i + 1) + ". " + strings.get(i));
                }
            } else {
                strings.add(input);
                System.out.println("added: " + input);
            }
        }
    }
}
