import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n\t"
                + "|  _ \\ _   _| | _____ \n\t"
                + "| | | | | | | |/ / _ \\\n\t"
                + "| |_| | |_| |   <  __/\n\t"
                + "|____/ \\__,_|_|\\_\\___|\n\t";
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello from\n\t" + logo);
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while(!input.equalsIgnoreCase("Bye")) {
            System.out.println("\t____________________________________________________________");
            System.out.println("\t" + input);
            System.out.println("\t____________________________________________________________");
            input = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
