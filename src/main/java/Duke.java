import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String line = "__________________________";
        ArrayList <Task> lst = new ArrayList <Task>();
        System.out.println(line + "\nWhat can i do for you?\n" + line);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println ("Cya next time!");
                break;
            } else if (input.equals ("list")) {
                System.out.println ("Here are the tasks in your list: ");
                int num = lst.size();
                for (int i = 1; i < num; i++) {
                    Task task = lst.get(i);
                    System.out.println(i + ". " + task.getStatus() + task);
                }
            } else if (input.contains ("done")) {
                int taskNum = sc.nextInt();
                if (taskNum > lst.size()) {
                    System.out.println ("No such task!");
                } else {
                    Task completedTask = lst.get(taskNum);
                    completedTask.markAsDone();
                }
            } else {
                Task task = new Task (input);
                lst.add (task);
                System.out.println ("added: " + input);
            }
        }
    }
}
