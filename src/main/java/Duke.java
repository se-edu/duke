import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        int MAX_TASK = 100;
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String HORIZONTAL = "______________________________________";
        String HELLO_GREET =
                " Hello! I'm Duke\n"
                        +" What can I do for you?";
        String GOOD_BYE = " Bye. Hope to see you again soon!";
        System.out.println("Hello from\n" + logo);
        System.out.println(HORIZONTAL);
        System.out.println(HELLO_GREET);
        System.out.println(HORIZONTAL);
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        String[] tasks = new String[MAX_TASK];
        int countTasks = 0;
        while (!line.equalsIgnoreCase("bye")) {
            while (!line.equalsIgnoreCase("list")) {
                System.out.println("\t" + HORIZONTAL);
                System.out.println("\t added: " + line);
                System.out.println("\t" + HORIZONTAL);
                tasks[countTasks] = line;
                countTasks++;
                line = in.nextLine();
            }
            System.out.println("\t" + HORIZONTAL);
            for (int i = 1; i <= countTasks; i++) {
                System.out.println("\t" + i + ". " + tasks[i-1]);
            }
            System.out.println("\t" + HORIZONTAL);
            line = in.nextLine();
        }
        System.out.println("\t"+HORIZONTAL);
        System.out.println("\t"+GOOD_BYE);
        System.out.println("\t"+HORIZONTAL);
    }
}
