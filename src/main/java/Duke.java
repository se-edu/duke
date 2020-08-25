import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String greet = " ____________________________________________________________\n"
                + "  Hello! I'm Duke\n"
                + "  What can I do for you?\n"
                + "\n"
                + " ____________________________________________________________\n";
        System.out.println(greet);
        String line;
        Scanner in = new Scanner(System.in);

        line = in.nextLine();
        while (!(line.equals("bye"))) {
            System.out.println(" ____________________________________________________________");
            System.out.println("  " + line);
            System.out.println(" ____________________________________________________________");
            line = in.nextLine();
        }
        System.out.println(" ____________________________________________________________");
        System.out.println("  Bye. Hope to see you again soon!");
        System.out.println(" ____________________________________________________________");
    }
}