import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String line = "__________________________";
        ArrayList <String> lst = new ArrayList <String>();
        System.out.println(line + "\nWhat can i do for you?\n" + line);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println("Cya next time!");
                break;
            } else if (input.equals("list")) {
                int num = lst.size();
                for (int i = 1; i < num; i++) {
                    System.out.println(i + ". " + lst.get(i));
                }
            } else {
                lst.add (input);
                System.out.println ("added: " + input);
            }
        }
    }
}
