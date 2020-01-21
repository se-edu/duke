import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {

        List<String> history = new ArrayList<>();

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
                for (int i = 0; i < history.size(); i++) {
                    System.out.println((i+1) + ". " + history.get(i));
                }
            } else {
                System.out.println("added: " + userInput);
                history.add(userInput);
            }
        }
    }
}
