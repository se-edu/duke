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
        ArrayList<Task> tasks = new ArrayList<Task>(100);

        //accepting input
        String input = in.nextLine();

        while(!input.equalsIgnoreCase("Bye")) {

            System.out.println("\t____________________________________________________________");
            //checking input and giving appropriate responses
            if (input.equalsIgnoreCase("list")) {
                int size = tasks.size();
                System.out.println("\tHere are the tasks in your list:");
                for (int i = 0; i < size; ++i) {
                    System.out.println("\t" + (i + 1) + ". " + tasks.get(i));
                }
            } else if(input.startsWith("done")) {
                String[] tempArray = input.split(" ");
                int n = Integer.parseInt(tempArray[1]);
                if(n > tasks.size()) {
                    System.out.println("\tThere is no such task");
                } else {
                    System.out.println("\tNice! I've marked this task as done:");
                    tasks.get(n-1).markAsDone();
                    System.out.println("\t" + tasks.get(n-1));
                }
            } else {
                System.out.println("\tGot it. I've added this task:");
                Task temp;
                if (input.startsWith("todo")) {
                    temp = new ToDo(input.split(" ", 2)[1]);
                    tasks.add(temp);
                } else if (input.startsWith("deadline")) {
                    temp = new Deadline((input.split(" ", 2)[1]).split("/", 2));
                    tasks.add(temp);
                } else {
                    temp = new Event((input.split(" ", 2)[1]).split("/", 2));
                    tasks.add(temp);
                }
                System.out.println("\t" + temp);
                System.out.println("\tNow you have " + tasks.size() + " tasks in your list.");
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
