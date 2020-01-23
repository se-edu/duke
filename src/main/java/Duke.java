import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke!");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);

        ArrayList<Task> list = new ArrayList<Task>();

        while (true) {
            String userInput = sc.nextLine();

            if (userInput.equals("bye")) {
                System.out.println("Bye! Come back soon!");
                break;
            } else if (userInput.equals("list")) {
                System.out.println("This is your list of tasks");
                for (int i = 0; i < list.size(); i++) {
                    Task t = list.get(i);
                    System.out.print((i+1) + ".[" + t.getStatusIcon() + "] ");
                    System.out.println(t.getDescription());
                }
            } else if (userInput.contains("done")) {
                int taskNumber =  userInput.charAt(5);
                Task t = list.get(taskNumber - 1);
                t.markAsDone();
                System.out.println("This task is mark as completed!");
                System.out.print("[" + t.getStatusIcon() + "] ");
                System.out.println(t.getDescription());
            } else {
                System.out.println("added: " + userInput);
                Task t = new Task(userInput);
                list.add(t);
            }
        }
    }
}
