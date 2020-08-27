import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        boolean exit = false;
        String line;
        Scanner in = new Scanner(System.in);
        List[] tasks = new List[100];
        int taskAmount = 0;

        //the logo and greet
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greet();

        //main chat box
        while(!exit) {
            line = in.nextLine();
            if(line.equals("list")) {
                list(taskAmount, tasks);
            }
            else if(line.equals("bye")) {
                exit = true;
            }
            else if(line.contains("done")) {
                done(line, tasks, taskAmount);
            }
            else {
                tasks[taskAmount] = new List(line);
                taskAmount++;
            }
        }
        exit();
    }

    public static void greet() {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void echo(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(message);
        System.out.println("____________________________________________________________");}

    public static void exit() {
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    public static void list(int taskAmount, List[] tasks) {
        String isDone;
        if (taskAmount == 0) {
            System.out.println("____________________________________________________________");
            System.out.println("list");
            System.out.println("____________________________________________________________");
        }
        else {
            System.out.println("____________________________________________________________");
            for(int i = 0; i< taskAmount; i++) {
                System.out.print((i+1) +".");
                System.out.print(tasks[i].getStatusIcon() + " ");
                System.out.println(tasks[i].getTask());
            }
            System.out.println("____________________________________________________________");
        }
    }

    public static void done(String line, List[] tasks, int taskAmount) {
        String[] words = line.split(" ");
        int taskIndex = (Integer.parseInt(words[1])) - 1;
        if(taskIndex < 0 || taskIndex > taskAmount) {
            System.out.println("____________________________________________________________");
            System.out.println("Task index cannot be identified, please enter again");
            System.out.println("____________________________________________________________");
            return;
        }
        tasks[taskIndex].markAsDone();
        System.out.println("____________________________________________________________");
        System.out.println("Nice! I've marked this task as done: ");
        System.out.print(tasks[taskIndex].getStatusIcon() + " ");
        System.out.println(tasks[taskIndex].getTask());
        System.out.println("____________________________________________________________");
    }
}
