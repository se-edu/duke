import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String greet = " ____________________________________________________________\n"
                + "  Hello! I'm Duke\n"
                + "  What can I do for you?\n"
                + "\n"
                + " ____________________________________________________________\n";
        System.out.println(greet);
        
        Task currentTask;
        Task[] storeTasks = new Task[100];
        int numOfTasks = 0;
        String line;
        Scanner in = new Scanner(System.in);

        while (true) {
            line = in.nextLine();
            if (line.equals("bye")) {
                break;
            }

            if (line.equals("list")) {
                System.out.println(" ____________________________________________________________");
                System.out.println("  Here are the tasks in your list:");
                for (int i = 0; i < numOfTasks; i++) {
                    System.out.print("  " + (i + 1) + ".[" + storeTasks[i].getStatusIcon() + "] ");
                    System.out.println(storeTasks[i].getDescription());
                }
                System.out.println(" ____________________________________________________________");
                continue;
            }

            if (line.contains("done")) {
                String[] word = line.split(" ");
                int taskNum = Integer.parseInt(word[1]);
                if (taskNum >= 1 || taskNum <= numOfTasks) {
                    storeTasks[taskNum - 1].setDone();
                    System.out.println(" ____________________________________________________________");
                    System.out.println("  Nice! I've marked this task as done:");
                    System.out.print("   " + taskNum + ".[" + storeTasks[taskNum - 1].getStatusIcon() + "] ");
                    System.out.println(storeTasks[taskNum - 1].getDescription());
                    System.out.println(" ____________________________________________________________");
                }
                continue;
            }

            storeTasks[numOfTasks] = new Task(line);
            numOfTasks++;
            System.out.println(" ____________________________________________________________");
            System.out.println("  added: " + line);
            System.out.println(" ____________________________________________________________");
        }
        System.out.println(" ____________________________________________________________");
        System.out.println("  Bye. Hope to see you again soon!");
        System.out.println(" ____________________________________________________________");
    }
}