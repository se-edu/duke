import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_TASK_CAPACITY = 100;
    public static final String EXIT = "bye";
    public static final String PRINT_TASK_LIST = "list";
    public static final String TASK_DONE = "done";


    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[MAX_TASK_CAPACITY];
        String commond;
        int numTask = 0;
        while (true) {
            commond = in.nextLine();
            String[] words = commond.split(" ");
            if (commond.equals(EXIT)) {
                break;
            } else if (commond.equals(PRINT_TASK_LIST)) {
                Task.printTaskList(tasks);
            } else if (words[0].equals(TASK_DONE)) {
                tasks[Integer.parseInt(words[1]) - 1].markAsDone();
            } else {
                System.out.println("added: " + commond);
                tasks[numTask] = new Task(commond);
                numTask++;
            }
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}


