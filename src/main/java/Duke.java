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
        ArrayList <Task> lst = new ArrayList <>();
        int pendingTask = 0;
        System.out.println(line + "\nWhat can i do for you?\n" + line);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println("Cya next time!");
                break;
            } else if (input.equals("list")) {
                int num = lst.size();
                for (int i = 0; i < num; i++) {
                    System.out.println((i + 1) + ". " + lst.get(i));
                }
            } else if (input.contains ("done")) {
                try {
                    int taskNum = Integer.parseInt(input.substring(5));
                    if (taskNum <= lst.size()) {
                        Task completedTask = lst.get(taskNum - 1);
                        if (completedTask.getStatus().equals("Done")) {
                            System.out.println ("You have already completed this task!");
                        } else {
                            completedTask.markAsDone();
                            pendingTask--;
                        }
                        if (pendingTask == 0) {
                            System.out.println ("Yay! You have no more task remaining!");
                        } else {
                            System.out.println ("You have " + pendingTask + " tasks remaining!");
                        }
                    } else {
                        System.out.println ("There is no such task!");
                    }
                } catch (Exception e){
                    System.out.println ("Sorry, I dont understand you request!");
                }
            } else {
                Task task = new Task (input);
                lst.add (task);
                pendingTask++;
                System.out.println ("added: " + task);
            }
        }
    }
}