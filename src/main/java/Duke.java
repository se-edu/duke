import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n\t"
                + "|  _ \\ _   _| | _____ \n\t"
                + "| | | | | | | |/ / _ \\\n\t"
                + "| |_| | |_| |   <  __/\n\t"
                + "|____/ \\__,_|_|\\_\\___|\n\t";

        //Greeting
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello from\n\t" + logo);
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");

        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>(100);

        //accepting input
        String input = in.nextLine();

        while(!input.equalsIgnoreCase("Bye")) {

            System.out.println("\t____________________________________________________________");
            //checking input and giving appropriate responses
            if (input.equalsIgnoreCase("list")) {
                int size = list.size();
                for (int i = 0; i < size; ++i) {
                    System.out.println("\t" + (i + 1) + ". " + list.get(i));
                }
            } else {
                System.out.println("\tadded: " + input);
                list.add(input);
            }
            System.out.println("\t____________________________________________________________");

            input = in.nextLine();

        }

        //Exit
        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");

    }
}
