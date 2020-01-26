import java.util.Scanner;

public class Duke {

    //public final static String LINE = "__________________________________";
    //public final static String INDENT = "     ";

    public static void main(String[] args) {

        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo); */
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);
        String user_input = sc.nextLine(); // read in the user input
        while (!user_input.toLowerCase().equals("bye")) {
            System.out.println(user_input);
            user_input = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
