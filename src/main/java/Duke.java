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
        int pendingTask = 0;
        System.out.println(line + "\nWhat can i do for you?\n" + line);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println ("Cya next time!");
                break;
            } else if (input.equals ("list")) {
                System.out.println ("Here are the tasks in your list: ");
                int num = lst.size();
                for (int i = 1; i <= num; i++) {
                    Task task = lst.get(i - 1);
                    System.out.println(i + ". [" + task.getStatus() + "]" + task);
                }
            } else if (input.contains ("done")) {
                try {
                    int taskNum = sc.nextInt() - 1;
                    sc.nextLine();
                    if (taskNum > lst.size()) {
                        System.out.println("No such task!\n");
                    } else {
                        Task completedTask = lst.get(taskNum);
                        if (!completedTask.isItDone()) {
                            completedTask.markAsDone();
                            pendingTask--;
                        } else {
                            System.out.println ("This task has already been done!");
                        }
                        if (pendingTask == 0) {
                            System.out.println("No task remaining! You are free:)\n");
                        }
                    }
                } catch (Exception e){
                    sc.nextLine();
                    System.out.println ("Please type in a task number:(");
                }
            } else {
                Task task = new Task (input);
                lst.add (task);
                pendingTask++;
                System.out.println ("added: " + input);
            }
        }
    }
}
