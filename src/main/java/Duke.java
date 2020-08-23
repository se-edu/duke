import java.util.Scanner;
public class Duke {
    public static int MAX_TASK = 100;
    public static String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    public static String HORIZONTAL = "--------------------------------------";
    public static String HELLO_GREET =
            " Hello! I'm Duke\n"
                    +" What can I do for you?";
    public static String GOOD_BYE = " Bye. Hope to see you again soon!";
    public static void printWelcomeGreet() {
        System.out.println(logo);
        System.out.println(HORIZONTAL);
        System.out.println(HELLO_GREET);
        System.out.println(HORIZONTAL);
    }
    public static void printGoodbye() {
        System.out.println("\t" +HORIZONTAL);
        System.out.println("\t"+GOOD_BYE);
        System.out.println("\t" +HORIZONTAL);
    }
    public static void parseInput(int countTasks, Task[] tasks) {

        //Input and read inputs from the user
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (!line.equalsIgnoreCase("bye")) {
            while (!line.equalsIgnoreCase("list")) {
                if (line.equalsIgnoreCase("bye"))
                    return;
                if (!(line.indexOf("done ") == 0)) {
                    System.out.println("\t" + HORIZONTAL);
                    System.out.println("\t added: " + line);
                    System.out.println("\t" + HORIZONTAL);
                    tasks[countTasks] = new Task(line);
                    countTasks++;
                }
                else {
                    String taskToBeDone = line.substring(line.indexOf("done ")+ 5);
                    boolean isInt = true;
                    int num = countTasks + 1;
                    try {
                        num = Integer.parseInt(taskToBeDone);
                    } catch (NumberFormatException e) {
                        isInt = false;
                    }
                    if (isInt) {
                        if (num <= countTasks) {
                            System.out.println("\t" + HORIZONTAL);
                            System.out.println("\t Nice! I've marked this task as done: ");
                            tasks[num - 1].markAsDone();
                            System.out.println("\t\t" + tasks[num-1].getStatusIcon() + " " + tasks[num-1].getDescription());
                            System.out.println("\t" + HORIZONTAL);
                        }
                        else {
                            System.out.println("\t" + HORIZONTAL);
                            System.out.println("\t added: " + line);
                            System.out.println("\t" + HORIZONTAL);
                            tasks[countTasks] = new Task(line);
                            countTasks++;
                        }
                    }
                    else {
                        System.out.println("\t" + HORIZONTAL);
                        System.out.println("\t added: " + line);
                        System.out.println("\t" + HORIZONTAL);
                        tasks[countTasks] = new Task(line);
                        countTasks++;
                    }
                }
                line = in.nextLine();
            }
            System.out.println("\t" + HORIZONTAL);
            for (int i = 1; i <= countTasks; i++) {
                System.out.println("\t" + i + "." + tasks[i-1].getStatusIcon() + " " + tasks[i-1].getDescription());
            }
            System.out.println("\t" + HORIZONTAL);
            line = in.nextLine();
        }
        //printGoodbye();
    }
    public static void main(String[] args) {
        printWelcomeGreet();
        //String line;

        //Input and read inputs from the user
        //Scanner in = new Scanner(System.in);
        //line = in.nextLine();

        Task[] tasks = new Task[MAX_TASK];
        int countTasks = 0;
        parseInput(countTasks,tasks);
        printGoodbye();
    }
}
