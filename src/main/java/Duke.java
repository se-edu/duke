
import java.util.Scanner;

/**
 * For level-1 Greet, Echo, Exit.
 */
public class Duke {

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke\n"
                + "     What can I do for you?");

        while (true) {
            String response = sc.nextLine();
            if (response.equals("bye")) {
                System.out.println("     ____________________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("     ____________________________________________________________");
                break;
            } else {
                System.out.println("     ____________________________________________________________");
                System.out.println("     " + response);
                System.out.println("     ____________________________________________________________");
            }
        }

    }
}
