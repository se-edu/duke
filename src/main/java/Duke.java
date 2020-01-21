import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        List<Task> history = new ArrayList<>();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("I am here to help you with anything you need!");
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String userInput = sc.nextLine();
            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
            } else if (userInput.equals("list")) {
                System.out.println("Here are the tasks in your list:\n");
                for (int i = 0; i < history.size(); i++) {
                    System.out.println((i + 1) + "." + history.get(i).toString());
                }
            } else if (userInput.startsWith("done")) {
                int taskNumber = -1 + Integer.parseInt(userInput.split(" ")[1]);
                history.get(taskNumber).markAsDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(history.get(taskNumber));
            } else {
                System.out.println("added: " + userInput);
                history.add(new Task(userInput));
            }
        }
    }
}
