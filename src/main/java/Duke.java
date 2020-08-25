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
        String[] storeTask = new String[100];
        int numOfTasks = 0;
        Scanner in = new Scanner(System.in);

        line = in.nextLine();
        while (!(line.equals("bye"))) {
            storeTask[numOfTasks] = line;
            numOfTasks++;
            System.out.println(" ____________________________________________________________");
            System.out.println("  added: " + line);
            System.out.println(" ____________________________________________________________");
            line = in.nextLine();
            if (line.equals("list")) {
                System.out.println(" ____________________________________________________________");
                for (int i = 0; i < numOfTasks; i++) {
                    System.out.println(" " + (i + 1) + ". " + storeTask[i]);
                }
                System.out.println(" ____________________________________________________________");
                line = in.nextLine();
            }
        }
        System.out.println(" ____________________________________________________________");
        System.out.println("  Bye. Hope to see you again soon!");
        System.out.println(" ____________________________________________________________");
    }
}