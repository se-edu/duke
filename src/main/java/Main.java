import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_TASK_CAPACITY = 100;


    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[MAX_TASK_CAPACITY];
        String line;
        int numTask = 0;
        while (true) {
            line = in.nextLine();
            String[] words = line.split(" ");
            if (line.equals("bye")) {
                break;
            } else if (line.equals("list")) {
                Task.printTaskList(tasks);
            } else if (words[0].equals("done")) {
                tasks[Integer.parseInt(words[1]) - 1].markAsDone();
            } else {
                System.out.println("added: " + line);
                tasks[numTask] = new Task(line);
                numTask++;
            }
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}


