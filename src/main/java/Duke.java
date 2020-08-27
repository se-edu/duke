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
        if (taskAmount == 0) {
            System.out.println("____________________________________________________________");
            System.out.println("list");
            System.out.println("____________________________________________________________");
        }
        else {
            System.out.println("____________________________________________________________");
            for(int i = 0; i< taskAmount; i++) {
                System.out.println( (i+1) +". " + tasks[i].getTask());
            }
            System.out.println("____________________________________________________________");
        }
    }
}
