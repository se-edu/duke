import java.util.Scanner;

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
        System.out.println(line + "\nWhat can i do for you?\n" + line);

        while (true) {
            String input = sc.next();
            if (input.equals("bye")) {
                System.out.println("Cya next time!");
                break;
            } else {
                System.out.println(input);
            }
        }
    }
    #Hello this is an edit
}
