
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

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
        ArrayList<String> mylist = new ArrayList<>();

        System.out.println("Hello! I'm Duke\n"
                + "     What can I do for you?");

        while (true) {
            String response = sc.nextLine();
            if (response.equals("bye")) {
                System.out.println("     ____________________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("     ____________________________________________________________");
                break;
            } else if (response.equals("list")){
                System.out.println("     ____________________________________________________________");
                for (int i = 0; i < mylist.size(); i++) {
                    System.out.println("     " + (i + 1) + ". " + mylist.get(i));
                }
                System.out.println("     ____________________________________________________________");

            } else {
                mylist.add(response);
                System.out.println("     ____________________________________________________________");
                System.out.println("     added: " + response);
                System.out.println("     ____________________________________________________________");
            }
        }

    }
}
